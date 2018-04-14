package com.springsource.petclinic;

import com.springsource.petclinic.model.Owner;
import com.springsource.petclinic.model.Pet;
import com.springsource.petclinic.model.reference.PetType;
import com.springsource.petclinic.repository.OwnerRepository;
import com.springsource.petclinic.repository.PetRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
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
     * @param petRepository
     * @param ownerRepository
     * @return
     */
    @Bean
    public ApplicationRunner init(PetRepository petRepository, OwnerRepository ownerRepository) {
        return args -> {
            registerSamplePets(petRepository);
            registerSampleOwners(ownerRepository);
        };
    }

    /**
     * Register sample pets in the system
     *
     * @param repository
     */
    private void registerSamplePets(PetRepository repository) {
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
    }

    /**
     * Register sample owners in the system
     * @param repository
     */
    private void registerSampleOwners(OwnerRepository repository) {
        Stream.of("Hellen", "Tom", "Christian", "Rose", "Stuart", "Steward", "John", "Josh",
                "Luck", "Leia", "Tony", "Andrew", "Rick").forEach(name -> {
            Owner owner = new Owner();
            owner.setFirstName(name);
            owner.setLastName("J. " + name);
            int randomNumber = new Random().nextInt(15);
            owner.setAddress("C/ Falsa " + randomNumber);
            owner.setCity("Valencia");
            owner.setHomePage("www.disid.com");
            owner.setBirthDay(new Date());
            int randomLastPhone = new Random().nextInt(9);
            owner.setTelephone("666 777 44" + randomLastPhone);
            repository.save(owner);
        });
    }

}