package io.github.jcagarcia.proof.tests.repository;
import io.github.jcagarcia.proof.tests.domain.Book;
import org.springframework.roo.addon.layers.repository.jpa.annotations.RooJpaRepository;

/**
 * = BookRepository
 *
 * TODO Auto-generated class documentation
 *
 */
@RooJpaRepository(entity = Book.class)
public interface BookRepository {
}
