package io.github.jcagarcia.springbootgraphql.service.impl;

import io.github.jcagarcia.springbootgraphql.model.Travel;
import io.github.jcagarcia.springbootgraphql.repository.TravelRepository;
import io.github.jcagarcia.springbootgraphql.service.api.TravelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Implements the {@link TravelService} API
 */
@Service
public class TravelServiceImpl implements TravelService {

    /**
     * The autowired repository
     */
    @Autowired
    private TravelRepository travelRepository;

    /**
     * Obtains all the registered Travels
     *
     * @return
     */
    @Override
    public List<Travel> findAll() {
        return travelRepository.findAll();
    }
}
