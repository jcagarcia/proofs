package io.github.jcagarcia.springbootgraphql.service.impl;

import io.github.jcagarcia.springbootgraphql.model.City;
import io.github.jcagarcia.springbootgraphql.repository.CityRepository;
import io.github.jcagarcia.springbootgraphql.service.api.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Implementation of the {@link CityService} API
 */
@Service
public class CityServiceImpl implements CityService {

    /**
     * Repository to manage cities
     */
    @Autowired
    private CityRepository cityRepository;

    /**
     * {@inheritDoc}
     * @return
     */
    @Override
    public List<City> findAll() {
        return cityRepository.findAll();
    }

    /**
     * {@inheritDoc}
     * @param id
     * @return
     */
    @Override
    public City findOne(Long id) {
        return cityRepository.findOne(id);
    }
}
