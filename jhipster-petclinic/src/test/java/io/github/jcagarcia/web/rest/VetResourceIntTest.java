package io.github.jcagarcia.web.rest;

import io.github.jcagarcia.ClinicApp;

import io.github.jcagarcia.domain.Vet;
import io.github.jcagarcia.repository.VetRepository;
import io.github.jcagarcia.service.VetService;
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

import io.github.jcagarcia.domain.enumeration.Speciality;
/**
 * Test class for the VetResource REST controller.
 *
 * @see VetResource
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ClinicApp.class)
public class VetResourceIntTest {

    private static final String DEFAULT_FIRST_NAME = "AAAAAAAAAA";
    private static final String UPDATED_FIRST_NAME = "BBBBBBBBBB";

    private static final String DEFAULT_LAST_NAME = "AAAAAAAAAA";
    private static final String UPDATED_LAST_NAME = "BBBBBBBBBB";

    private static final String DEFAULT_ADDRESS = "AAAAAAAAAA";
    private static final String UPDATED_ADDRESS = "BBBBBBBBBB";

    private static final String DEFAULT_CITY = "AAAAAAAAAA";
    private static final String UPDATED_CITY = "BBBBBBBBBB";

    private static final String DEFAULT_TELEPHONE = "AAAAAAAAAA";
    private static final String UPDATED_TELEPHONE = "BBBBBBBBBB";

    private static final String DEFAULT_HOME_PAGE = "AAAAAAAAAA";
    private static final String UPDATED_HOME_PAGE = "BBBBBBBBBB";

    private static final String DEFAULT_EMAIL = "AAAAAAAAAA";
    private static final String UPDATED_EMAIL = "BBBBBBBBBB";

    private static final String DEFAULT_BIRTH_DATE = "AAAAAAAAAA";
    private static final String UPDATED_BIRTH_DATE = "BBBBBBBBBB";

    private static final String DEFAULT_EMPLOYEE_SINCE = "AAAAAAAAAA";
    private static final String UPDATED_EMPLOYEE_SINCE = "BBBBBBBBBB";

    private static final Speciality DEFAULT_SPECIALITY = Speciality.CARDIOLOGY;
    private static final Speciality UPDATED_SPECIALITY = Speciality.DENTISTRY;

    @Autowired
    private VetRepository vetRepository;

    @Autowired
    private VetService vetService;

    @Autowired
    private MappingJackson2HttpMessageConverter jacksonMessageConverter;

    @Autowired
    private PageableHandlerMethodArgumentResolver pageableArgumentResolver;

    @Autowired
    private ExceptionTranslator exceptionTranslator;

    @Autowired
    private EntityManager em;

    private MockMvc restVetMockMvc;

    private Vet vet;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        final VetResource vetResource = new VetResource(vetService);
        this.restVetMockMvc = MockMvcBuilders.standaloneSetup(vetResource)
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
    public static Vet createEntity(EntityManager em) {
        Vet vet = new Vet()
            .firstName(DEFAULT_FIRST_NAME)
            .lastName(DEFAULT_LAST_NAME)
            .address(DEFAULT_ADDRESS)
            .city(DEFAULT_CITY)
            .telephone(DEFAULT_TELEPHONE)
            .homePage(DEFAULT_HOME_PAGE)
            .email(DEFAULT_EMAIL)
            .birthDate(DEFAULT_BIRTH_DATE)
            .employeeSince(DEFAULT_EMPLOYEE_SINCE)
            .speciality(DEFAULT_SPECIALITY);
        return vet;
    }

    @Before
    public void initTest() {
        vet = createEntity(em);
    }

    @Test
    @Transactional
    public void createVet() throws Exception {
        int databaseSizeBeforeCreate = vetRepository.findAll().size();

        // Create the Vet
        restVetMockMvc.perform(post("/api/vets")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(vet)))
            .andExpect(status().isCreated());

        // Validate the Vet in the database
        List<Vet> vetList = vetRepository.findAll();
        assertThat(vetList).hasSize(databaseSizeBeforeCreate + 1);
        Vet testVet = vetList.get(vetList.size() - 1);
        assertThat(testVet.getFirstName()).isEqualTo(DEFAULT_FIRST_NAME);
        assertThat(testVet.getLastName()).isEqualTo(DEFAULT_LAST_NAME);
        assertThat(testVet.getAddress()).isEqualTo(DEFAULT_ADDRESS);
        assertThat(testVet.getCity()).isEqualTo(DEFAULT_CITY);
        assertThat(testVet.getTelephone()).isEqualTo(DEFAULT_TELEPHONE);
        assertThat(testVet.getHomePage()).isEqualTo(DEFAULT_HOME_PAGE);
        assertThat(testVet.getEmail()).isEqualTo(DEFAULT_EMAIL);
        assertThat(testVet.getBirthDate()).isEqualTo(DEFAULT_BIRTH_DATE);
        assertThat(testVet.getEmployeeSince()).isEqualTo(DEFAULT_EMPLOYEE_SINCE);
        assertThat(testVet.getSpeciality()).isEqualTo(DEFAULT_SPECIALITY);
    }

    @Test
    @Transactional
    public void createVetWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = vetRepository.findAll().size();

        // Create the Vet with an existing ID
        vet.setId(1L);

        // An entity with an existing ID cannot be created, so this API call must fail
        restVetMockMvc.perform(post("/api/vets")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(vet)))
            .andExpect(status().isBadRequest());

        // Validate the Vet in the database
        List<Vet> vetList = vetRepository.findAll();
        assertThat(vetList).hasSize(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    public void getAllVets() throws Exception {
        // Initialize the database
        vetRepository.saveAndFlush(vet);

        // Get all the vetList
        restVetMockMvc.perform(get("/api/vets?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(vet.getId().intValue())))
            .andExpect(jsonPath("$.[*].firstName").value(hasItem(DEFAULT_FIRST_NAME.toString())))
            .andExpect(jsonPath("$.[*].lastName").value(hasItem(DEFAULT_LAST_NAME.toString())))
            .andExpect(jsonPath("$.[*].address").value(hasItem(DEFAULT_ADDRESS.toString())))
            .andExpect(jsonPath("$.[*].city").value(hasItem(DEFAULT_CITY.toString())))
            .andExpect(jsonPath("$.[*].telephone").value(hasItem(DEFAULT_TELEPHONE.toString())))
            .andExpect(jsonPath("$.[*].homePage").value(hasItem(DEFAULT_HOME_PAGE.toString())))
            .andExpect(jsonPath("$.[*].email").value(hasItem(DEFAULT_EMAIL.toString())))
            .andExpect(jsonPath("$.[*].birthDate").value(hasItem(DEFAULT_BIRTH_DATE.toString())))
            .andExpect(jsonPath("$.[*].employeeSince").value(hasItem(DEFAULT_EMPLOYEE_SINCE.toString())))
            .andExpect(jsonPath("$.[*].speciality").value(hasItem(DEFAULT_SPECIALITY.toString())));
    }

    @Test
    @Transactional
    public void getVet() throws Exception {
        // Initialize the database
        vetRepository.saveAndFlush(vet);

        // Get the vet
        restVetMockMvc.perform(get("/api/vets/{id}", vet.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.id").value(vet.getId().intValue()))
            .andExpect(jsonPath("$.firstName").value(DEFAULT_FIRST_NAME.toString()))
            .andExpect(jsonPath("$.lastName").value(DEFAULT_LAST_NAME.toString()))
            .andExpect(jsonPath("$.address").value(DEFAULT_ADDRESS.toString()))
            .andExpect(jsonPath("$.city").value(DEFAULT_CITY.toString()))
            .andExpect(jsonPath("$.telephone").value(DEFAULT_TELEPHONE.toString()))
            .andExpect(jsonPath("$.homePage").value(DEFAULT_HOME_PAGE.toString()))
            .andExpect(jsonPath("$.email").value(DEFAULT_EMAIL.toString()))
            .andExpect(jsonPath("$.birthDate").value(DEFAULT_BIRTH_DATE.toString()))
            .andExpect(jsonPath("$.employeeSince").value(DEFAULT_EMPLOYEE_SINCE.toString()))
            .andExpect(jsonPath("$.speciality").value(DEFAULT_SPECIALITY.toString()));
    }

    @Test
    @Transactional
    public void getNonExistingVet() throws Exception {
        // Get the vet
        restVetMockMvc.perform(get("/api/vets/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateVet() throws Exception {
        // Initialize the database
        vetService.save(vet);

        int databaseSizeBeforeUpdate = vetRepository.findAll().size();

        // Update the vet
        Vet updatedVet = vetRepository.findOne(vet.getId());
        // Disconnect from session so that the updates on updatedVet are not directly saved in db
        em.detach(updatedVet);
        updatedVet
            .firstName(UPDATED_FIRST_NAME)
            .lastName(UPDATED_LAST_NAME)
            .address(UPDATED_ADDRESS)
            .city(UPDATED_CITY)
            .telephone(UPDATED_TELEPHONE)
            .homePage(UPDATED_HOME_PAGE)
            .email(UPDATED_EMAIL)
            .birthDate(UPDATED_BIRTH_DATE)
            .employeeSince(UPDATED_EMPLOYEE_SINCE)
            .speciality(UPDATED_SPECIALITY);

        restVetMockMvc.perform(put("/api/vets")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(updatedVet)))
            .andExpect(status().isOk());

        // Validate the Vet in the database
        List<Vet> vetList = vetRepository.findAll();
        assertThat(vetList).hasSize(databaseSizeBeforeUpdate);
        Vet testVet = vetList.get(vetList.size() - 1);
        assertThat(testVet.getFirstName()).isEqualTo(UPDATED_FIRST_NAME);
        assertThat(testVet.getLastName()).isEqualTo(UPDATED_LAST_NAME);
        assertThat(testVet.getAddress()).isEqualTo(UPDATED_ADDRESS);
        assertThat(testVet.getCity()).isEqualTo(UPDATED_CITY);
        assertThat(testVet.getTelephone()).isEqualTo(UPDATED_TELEPHONE);
        assertThat(testVet.getHomePage()).isEqualTo(UPDATED_HOME_PAGE);
        assertThat(testVet.getEmail()).isEqualTo(UPDATED_EMAIL);
        assertThat(testVet.getBirthDate()).isEqualTo(UPDATED_BIRTH_DATE);
        assertThat(testVet.getEmployeeSince()).isEqualTo(UPDATED_EMPLOYEE_SINCE);
        assertThat(testVet.getSpeciality()).isEqualTo(UPDATED_SPECIALITY);
    }

    @Test
    @Transactional
    public void updateNonExistingVet() throws Exception {
        int databaseSizeBeforeUpdate = vetRepository.findAll().size();

        // Create the Vet

        // If the entity doesn't have an ID, it will be created instead of just being updated
        restVetMockMvc.perform(put("/api/vets")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(vet)))
            .andExpect(status().isCreated());

        // Validate the Vet in the database
        List<Vet> vetList = vetRepository.findAll();
        assertThat(vetList).hasSize(databaseSizeBeforeUpdate + 1);
    }

    @Test
    @Transactional
    public void deleteVet() throws Exception {
        // Initialize the database
        vetService.save(vet);

        int databaseSizeBeforeDelete = vetRepository.findAll().size();

        // Get the vet
        restVetMockMvc.perform(delete("/api/vets/{id}", vet.getId())
            .accept(TestUtil.APPLICATION_JSON_UTF8))
            .andExpect(status().isOk());

        // Validate the database is empty
        List<Vet> vetList = vetRepository.findAll();
        assertThat(vetList).hasSize(databaseSizeBeforeDelete - 1);
    }

    @Test
    @Transactional
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(Vet.class);
        Vet vet1 = new Vet();
        vet1.setId(1L);
        Vet vet2 = new Vet();
        vet2.setId(vet1.getId());
        assertThat(vet1).isEqualTo(vet2);
        vet2.setId(2L);
        assertThat(vet1).isNotEqualTo(vet2);
        vet1.setId(null);
        assertThat(vet1).isNotEqualTo(vet2);
    }
}
