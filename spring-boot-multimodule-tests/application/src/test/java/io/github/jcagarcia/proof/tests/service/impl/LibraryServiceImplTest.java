package io.github.jcagarcia.proof.tests.service.impl;

import io.github.jcagarcia.proof.tests.AbstractBaseIT;
import io.github.jcagarcia.proof.tests.model.domain.Library;
import io.github.jcagarcia.proof.tests.service.api.LibraryService;
import org.assertj.core.api.Condition;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Test class that includes all the necessary methods to test
 * the Library Service.
 */
public class LibraryServiceImplTest extends AbstractBaseIT {

    @Autowired
    private LibraryService libraryService;

    /**
     * Test that checks a complete CRUD operations of the
     * {@link Library} entity
     */
    @Test
    public void completeLibraryIntegration() {

        // Create new Library
        Library newLibrary = new Library();
        // Set the necessary values
        newLibrary.setName("PROOF 1");
        newLibrary.setAddress("ADDRESS 1");

        // Save the new library using the save method service
        Library savedLibrary = libraryService.save(newLibrary);

        // Obtain the library identifier
        Long libraryId = savedLibrary.getId();

        // Find the created Library by the saved id
        Library obtainedLibrary = libraryService.findOneForUpdate(libraryId);

        // Check that the obtained library has the same values as the saved library
        assertThat(obtainedLibrary).as("Check that the obtained library has the same values as the saved library")
                .isNotNull().is(new Condition<Library>() {
            @Override
            public boolean matches(Library library) {
                return library.getName().equals(newLibrary.getName()) && library.getAddress().equals(newLibrary.getAddress());
            }
        });

        // Update the obtained library
        obtainedLibrary.setName("PROOF 1 UPDATED");
        Library updatedLibrary = libraryService.save(obtainedLibrary);

        // Check that the updated library has increase his version
        assertThat(updatedLibrary).as("Check that the updated library has increase his version")
                .isNotNull().is(new Condition<Library>() {
            @Override
            public boolean matches(Library library) {
                return library.getName().equals(obtainedLibrary.getName()) && library.getVersion().equals(obtainedLibrary.getVersion() + 1);
            }
        });

        // Delete the current library
        libraryService.delete(updatedLibrary);

        // Check that the deleted library doesn't exists yet
        Library deletedLibrary = libraryService.findOne(libraryId);

        assertThat(deletedLibrary).as("Check that the deleted library doesn't exists yet").isNull();

    }

}