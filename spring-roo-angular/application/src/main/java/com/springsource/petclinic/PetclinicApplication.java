package com.springsource.petclinic;

import com.springsource.petclinic.model.Pet;
import com.springsource.petclinic.model.reference.PetType;
import com.springsource.petclinic.repository.PetRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.stream.Stream;

/**
 * = PetclinicApplication
 *
 * TODO Auto-generated class documentation
 *
 */
@SpringBootApplication
public class PetclinicApplication {

    /**
     * TODO Auto-generated method documentation
     *
     * @param args
     */
    public static void main(String[] args) {
        SpringApplication.run(PetclinicApplication.class, args);
    }

    /**
     * Create sample data
     * @param repository
     * @return
     */
    @Bean
    public ApplicationRunner init(PetRepository repository) {
        return args -> {
            Stream.of("Cat 1", "Cat 2", "Cat 3", "Cat 4", "Cat 5",
                    "Cat 6", "Cat 7", "Cat 8", "Cat 9").forEach(name -> {
                Pet pet = new Pet();
                pet.setName(name);
                pet.setType(PetType.Cat);
                pet.setWeight(8f);
                repository.save(pet);
            });
            repository.findAll().forEach(System.out::println);
        };
    }
}