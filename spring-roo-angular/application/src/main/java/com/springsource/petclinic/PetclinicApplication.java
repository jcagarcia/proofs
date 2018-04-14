package com.springsource.petclinic;

import com.springsource.petclinic.model.Pet;
import com.springsource.petclinic.model.reference.PetType;
import com.springsource.petclinic.repository.PetRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Random;
import java.util.stream.Stream;

/**
 * = PetclinicApplication
 * <p>
 * TODO Auto-generated class documentation
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
     *
     * @param repository
     * @return
     */
    @Bean
    public ApplicationRunner init(PetRepository repository) {
        return args -> {
            Stream.of("Moyo", "Bruce", "Max", "Marte", "Riu",
                    "Brand", "Mosck", "Trell", "Under", "Arty", "Homer", "Clust",
                    "Puerl", "Hellene", "Kitty", "Misi", "Andu", "Arto").forEach(name -> {
                Pet pet = new Pet();
                pet.setName(name);
                pet.setType(PetType.Cat);
                int randomWeight = new Random().nextInt(15);
                pet.setWeight(new Float(randomWeight));
                repository.save(pet);
            });
            repository.findAll().forEach(System.out::println);
        };
    }
}