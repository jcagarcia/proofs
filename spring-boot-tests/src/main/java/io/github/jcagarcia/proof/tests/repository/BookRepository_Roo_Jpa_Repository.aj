// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package io.github.jcagarcia.proof.tests.repository;

import io.github.jcagarcia.proof.tests.domain.Book;
import io.github.jcagarcia.proof.tests.repository.BookRepository;
import io.github.jcagarcia.proof.tests.repository.BookRepositoryCustom;
import io.springlets.data.jpa.repository.DetachableJpaRepository;
import org.springframework.transaction.annotation.Transactional;

privileged aspect BookRepository_Roo_Jpa_Repository {
    
    declare parents: BookRepository extends DetachableJpaRepository<Book, Long>;
    
    declare parents: BookRepository extends BookRepositoryCustom;
    
    declare @type: BookRepository: @Transactional(readOnly = true);
    
}