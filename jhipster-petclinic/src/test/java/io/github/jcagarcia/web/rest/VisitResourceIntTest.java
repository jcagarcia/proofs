package io.github.jcagarcia.web.rest;

import io.github.jcagarcia.ClinicApp;

import io.github.jcagarcia.domain.Visit;
import io.github.jcagarcia.repository.VisitRepository;
import io.github.jcagarcia.service.VisitService;
import io.github.jcagarcia.web.rest.errors.ExceptionTranslator;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

import static io.github.jcagarcia.web.rest.TestUtil.createFormattingConversionService;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Test class for the VisitResource REST controller.
 *
 * @see VisitResource
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ClinicApp.class)
public class VisitResourceIntTest {

    private static final String DEFAULT_DESCRIPTION = "AAAAAAAAAA";
    private static final String UPDATED_DESCRIPTION = "BBBBBBBBBB";

    private static final String DEFAULT_VISIT_DATE = "AAAAAAAAAA";
    private static final String UPDATED_VISIT_DATE = "BBBBBBBBBB";

    @Autowired
    private VisitRepository visitRepository;

    @Autowired
    private VisitService visitService;

    @Autowired
    private MappingJackson2HttpMessageConverter jacksonMessageConverter;

    @Autowired
    private PageableHandlerMethodArgumentResolver pageableArgumentResolver;

    @Autowired
    private ExceptionTranslator exceptionTranslator;

    @Autowired
    private EntityManager em;

    private MockMvc restVisitMockMvc;

    private Visit visit;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        final VisitResource visitResource = new VisitResource(visitService);
        this.restVisitMockMvc = MockMvcBuilders.standaloneSetup(visitResource)
            .setCustomArgumentResolvers(pageableArgumentResolver)
            .setControllerAdvice(exceptionTranslator)
            .setConversionService(createFormattingConversionService())
            .setMessageConverters(jacksonMessageConverter).build();
    }

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Visit createEntity(EntityManager em) {
        Visit visit = new Visit()
            .description(DEFAULT_DESCRIPTION)
            .visitDate(DEFAULT_VISIT_DATE);
        return visit;
    }

    @Before
    public void initTest() {
        visit = createEntity(em);
    }

    @Test
    @Transactional
    public void createVisit() throws Exception {
        int databaseSizeBeforeCreate = visitRepository.findAll().size();

        // Create the Visit
        restVisitMockMvc.perform(post("/api/visits")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(visit)))
            .andExpect(status().isCreated());

        // Validate the Visit in the database
        List<Visit> visitList = visitRepository.findAll();
        assertThat(visitList).hasSize(databaseSizeBeforeCreate + 1);
        Visit testVisit = visitList.get(visitList.size() - 1);
        assertThat(testVisit.getDescription()).isEqualTo(DEFAULT_DESCRIPTION);
        assertThat(testVisit.getVisitDate()).isEqualTo(DEFAULT_VISIT_DATE);
    }

    @Test
    @Transactional
    public void createVisitWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = visitRepository.findAll().size();

        // Create the Visit with an existing ID
        visit.setId(1L);

        // An entity with an existing ID cannot be created, so this API call must fail
        restVisitMockMvc.perform(post("/api/visits")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(visit)))
            .andExpect(status().isBadRequest());

        // Validate the Visit in the database
        List<Visit> visitList = visitRepository.findAll();
        assertThat(visitList).hasSize(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    public void getAllVisits() throws Exception {
        // Initialize the database
        visitRepository.saveAndFlush(visit);

        // Get all the visitList
        restVisitMockMvc.perform(get("/api/visits?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(visit.getId().intValue())))
            .andExpect(jsonPath("$.[*].description").value(hasItem(DEFAULT_DESCRIPTION.toString())))
            .andExpect(jsonPath("$.[*].visitDate").value(hasItem(DEFAULT_VISIT_DATE.toString())));
    }

    @Test
    @Transactional
    public void getVisit() throws Exception {
        // Initialize the database
        visitRepository.saveAndFlush(visit);

        // Get the visit
        restVisitMockMvc.perform(get("/api/visits/{id}", visit.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.id").value(visit.getId().intValue()))
            .andExpect(jsonPath("$.description").value(DEFAULT_DESCRIPTION.toString()))
            .andExpect(jsonPath("$.visitDate").value(DEFAULT_VISIT_DATE.toString()));
    }

    @Test
    @Transactional
    public void getNonExistingVisit() throws Exception {
        // Get the visit
        restVisitMockMvc.perform(get("/api/visits/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateVisit() throws Exception {
        // Initialize the database
        visitService.save(visit);

        int databaseSizeBeforeUpdate = visitRepository.findAll().size();

        // Update the visit
        Visit updatedVisit = visitRepository.findOne(visit.getId());
        // Disconnect from session so that the updates on updatedVisit are not directly saved in db
        em.detach(updatedVisit);
        updatedVisit
            .description(UPDATED_DESCRIPTION)
            .visitDate(UPDATED_VISIT_DATE);

        restVisitMockMvc.perform(put("/api/visits")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(updatedVisit)))
            .andExpect(status().isOk());

        // Validate the Visit in the database
        List<Visit> visitList = visitRepository.findAll();
        assertThat(visitList).hasSize(databaseSizeBeforeUpdate);
        Visit testVisit = visitList.get(visitList.size() - 1);
        assertThat(testVisit.getDescription()).isEqualTo(UPDATED_DESCRIPTION);
        assertThat(testVisit.getVisitDate()).isEqualTo(UPDATED_VISIT_DATE);
    }

    @Test
    @Transactional
    public void updateNonExistingVisit() throws Exception {
        int databaseSizeBeforeUpdate = visitRepository.findAll().size();

        // Create the Visit

        // If the entity doesn't have an ID, it will be created instead of just being updated
        restVisitMockMvc.perform(put("/api/visits")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(visit)))
            .andExpect(status().isCreated());

        // Validate the Visit in the database
        List<Visit> visitList = visitRepository.findAll();
        assertThat(visitList).hasSize(databaseSizeBeforeUpdate + 1);
    }

    @Test
    @Transactional
    public void deleteVisit() throws Exception {
        // Initialize the database
        visitService.save(visit);

        int databaseSizeBeforeDelete = visitRepository.findAll().size();

        // Get the visit
        restVisitMockMvc.perform(delete("/api/visits/{id}", visit.getId())
            .accept(TestUtil.APPLICATION_JSON_UTF8))
            .andExpect(status().isOk());

        // Validate the database is empty
        List<Visit> visitList = visitRepository.findAll();
        assertThat(visitList).hasSize(databaseSizeBeforeDelete - 1);
    }

    @Test
    @Transactional
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(Visit.class);
        Visit visit1 = new Visit();
        visit1.setId(1L);
        Visit visit2 = new Visit();
        visit2.setId(visit1.getId());
        assertThat(visit1).isEqualTo(visit2);
        visit2.setId(2L);
        assertThat(visit1).isNotEqualTo(visit2);
        visit1.setId(null);
        assertThat(visit1).isNotEqualTo(visit2);
    }
}
