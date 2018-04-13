'use strict';

// tag::vars[]
const React = require('react');
const ReactDOM = require('react-dom');
const client = require('rest');
// end::vars[]

// tag::app[]
class App extends React.Component {

    constructor(props) {
        super(props);
        this.state = {pets: []};
    }

    componentDidMount() {
        client({method: 'GET', path: '/api/pets'}).then(response => {
            this.setState({pets: JSON.parse(response.entity).content});
        });
    }

    render() {
        return (
            <PetList pets={this.state.pets} />
        )
    }
}

// end::app[]

// tag::pet-list[]
class PetList extends React.Component {
    render() {
        var pets = this.props.pets.map(pet =>
            <Pet key={pet.id} pet={pet}/>
        );
        return (
            <table>
                <tbody>
                <tr>
                    <th>Name</th>
                    <th>Type</th>
                    <th>Weight</th>
                </tr>
                {pets}
                </tbody>
            </table>
        )
    }
}

// end::pet-list[]

// tag::pet[]
class Pet extends React.Component {
    render() {
        return (
            <tr>
                <td>{this.props.pet.name}</td>
                <td>{this.props.pet.type}</td>
                <td>{this.props.pet.weight}</td>
            </tr>
        )
    }
}

// end::pet[]

// tag::render[]
ReactDOM.render(
    <App/>,
    document.getElementById('react')
)
// end::render[]