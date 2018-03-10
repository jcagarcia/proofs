package io.github.jcagarcia.springbootgraphql.service.impl;

import io.github.jcagarcia.springbootgraphql.model.Layer;
import io.github.jcagarcia.springbootgraphql.model.Travel;
import io.github.jcagarcia.springbootgraphql.repository.LayerRepository;
import io.github.jcagarcia.springbootgraphql.repository.TravelRepository;
import io.github.jcagarcia.springbootgraphql.service.api.LayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Implements the {@link LayerService} API
 */
@Service
public class LayerServiceImpl implements LayerService {

    /**
     * Repository to manage Layers
     */
    @Autowired
    private LayerRepository layerRepository;

    /**
     * Repository to manage travels
     */
    @Autowired
    private TravelRepository travelRepository;

    /**
     * {@inheritDoc}
     *
     * @return
     */
    @Override
    public List<Layer> findAll() {
        return layerRepository.findAll();
    }

    /**
     * {@inheritDoc}
     *
     * @param travelId
     * @param name
     * @return
     */
    @Override
    public Layer create(Long travelId, String name) {
        // Obtain the travel using the provided travel code
        Travel travel = travelRepository.findOne(travelId);
        return layerRepository.save(new Layer(name, travel));
    }
}
