package io.github.jcagarcia.springbootgraphql.service.impl;

import io.github.jcagarcia.springbootgraphql.model.Travel;
import io.github.jcagarcia.springbootgraphql.repository.TravelRepository;
import io.github.jcagarcia.springbootgraphql.service.api.TravelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
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

    /**
     * {@inheritDoc}
     * @param urlCode
     * @return
     */
    @Override
    public Travel findByUrlCode(String urlCode) {
        return travelRepository.findAllByUrlCode(urlCode);
    }

    /**
     * {@inheritDoc}
     * @param travel
     * @return
     */
    @Override
    public Travel save(Travel travel) {
        return travelRepository.save(travel);
    }

    /**
     *
     * {@inheritDoc}
     *
     * @param startDate
     * @param endDate
     * @param country
     * @return
     */
    @Override
    public Travel create(Date startDate, Date endDate, String country) {
        return travelRepository.save(new Travel(startDate, endDate, country));
    }

}
