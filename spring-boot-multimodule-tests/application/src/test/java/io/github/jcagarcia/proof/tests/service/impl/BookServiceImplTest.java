package io.github.jcagarcia.proof.tests.service.impl;

import io.github.jcagarcia.proof.tests.AbstractBaseIT;
import io.github.jcagarcia.proof.tests.model.domain.Book;
import io.github.jcagarcia.proof.tests.service.api.BookService;
import org.assertj.core.api.Condition;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;

/**
 * Test class that includes all the necessary methods to test
 * the Book Service.
 */
public class BookServiceImplTest extends AbstractBaseIT {

    @Autowired
    private BookService bookService;

    /**
     * Test that checks a complete CRUD operations of the
     * {@link Book} entity
     */
    @Test
    public void completeBookIntegration() {

        // Create new book
        Book newBook = new Book();
        // Set the necessary values
        newBook.setName("PROOF 1");
        newBook.setIsbn("000000000Z");

        // Save the new book using the save method service
        Book savedBook = bookService.save(newBook);

        // Verify that the book service saves a Book instance
        verify(bookService).save(any(Book.class));

        // Obtain the book identifier
        Long bookId = savedBook.getId();

        // Find the created book by the saved id
        Book obtainedBook = bookService.findOneForUpdate(bookId);

        // Check that the obtained book has the same values as the saved book
        assertThat(obtainedBook).as("Check that the obtained book has the same values as the saved book")
                .isNotNull().is(new Condition<Book>() {
            @Override
            public boolean matches(Book book) {
                return book.getName().equals(newBook.getName()) && book.getIsbn().equals(newBook.getIsbn());
            }
        });

        // Update the obtained book
        obtainedBook.setName("PROOF 1 UPDATED");
        Book updatedBook = bookService.save(obtainedBook);

        // Check that the updated book has increase his version
        assertThat(updatedBook).as("Check that the updated book has increase his version")
                .isNotNull().is(new Condition<Book>() {
            @Override
            public boolean matches(Book book) {
                return book.getName().equals(obtainedBook.getName()) && book.getVersion().equals(obtainedBook.getVersion() + 1);
            }
        });

        // Delete the current book
        bookService.delete(updatedBook);

        // Check that the deleted book doesn't exists yet
        Book deletedBook = bookService.findOne(bookId);

        assertThat(deletedBook).as("Check that the deleted book doesn't exists yet").isNull();

    }

}