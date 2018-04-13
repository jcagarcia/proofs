package io.github.jcagarcia.springbootgraphql.web;

import io.github.jcagarcia.springbootgraphql.model.City;
import io.github.jcagarcia.springbootgraphql.model.Travel;
import io.github.jcagarcia.springbootgraphql.service.api.CityService;
import io.github.jcagarcia.springbootgraphql.service.api.TravelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/travels")
public class TravelsController {

    /**
     * Service to manage travels
     */
    @Autowired
    private TravelService travelService;

    /**
     * Service to manage cities
     */
    @Autowired
    private CityService cityService;

    /**
     * Returns an specific travel usign the provided code
     *
     * @param urlCode
     * @return
     */
    @GetMapping("/{urlCode}")
    public Travel findByCode(@PathVariable("urlCode") String urlCode){
        return travelService.findByUrlCode(urlCode);
    }

    /**
     * Method to create new Travels
     *
     * @param travel
     * @return The code of the new travel
     */
    @PostMapping
    public String create(@RequestBody Travel travel){
        if(travel.getEndDate() == null || travel.getStartDate() == null || travel.getCountry() == null){
            throw new NullPointerException("You must provide endDate, startDate and country");
        }
        Travel savedTravel = travelService.create(travel.getStartDate(), travel.getEndDate(), travel.getCountry());
        return savedTravel.getUrlCode();
    }

    /**
     * Method to include new city to a travel
     * @param urlCode
     * @param cityId
     * @return
     */
    @PutMapping("/{urlCode}/addCity/{cityId}")
    public Travel addCity(@PathVariable("urlCode") String urlCode, @PathVariable("cityId") Long cityId){
        // Obtain the travel
        Travel travel = travelService.findByUrlCode(urlCode);
        City city = cityService.findOne(cityId);
        travel.addCity(city);
        return travelService.save(travel);
    }

}
