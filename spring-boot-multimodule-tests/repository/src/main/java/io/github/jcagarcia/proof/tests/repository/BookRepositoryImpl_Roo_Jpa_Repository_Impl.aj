// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package io.github.jcagarcia.proof.tests.repository;

import com.querydsl.core.types.Path;
import com.querydsl.jpa.JPQLQuery;
import io.github.jcagarcia.proof.tests.model.domain.Book;
import io.github.jcagarcia.proof.tests.model.domain.QBook;
import io.github.jcagarcia.proof.tests.repository.BookRepositoryCustom;
import io.github.jcagarcia.proof.tests.repository.BookRepositoryImpl;
import io.springlets.data.domain.GlobalSearch;
import io.springlets.data.jpa.repository.support.QueryDslRepositorySupportExt.AttributeMappingBuilder;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

privileged aspect BookRepositoryImpl_Roo_Jpa_Repository_Impl {
    
    declare parents: BookRepositoryImpl implements BookRepositoryCustom;
    
    declare @type: BookRepositoryImpl: @Transactional(readOnly = true);
    
    /**
     * TODO Auto-generated attribute documentation
     * 
     */
    public static final String BookRepositoryImpl.NAME = "name";
    
    /**
     * TODO Auto-generated attribute documentation
     * 
     */
    public static final String BookRepositoryImpl.ISBN = "isbn";
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public Page<Book> BookRepositoryImpl.findAll(GlobalSearch globalSearch, Pageable pageable) {
        
        QBook book = QBook.book;
        
        JPQLQuery<Book> query = from(book);
        
        Path<?>[] paths = new Path<?>[] {book.name,book.isbn};        
        applyGlobalSearch(globalSearch, query, paths);
        
        AttributeMappingBuilder mapping = buildMapper()
			.map(NAME, book.name)
			.map(ISBN, book.isbn);
        
        applyPagination(pageable, query, mapping);
        applyOrderById(query);
        
        return loadPage(query, pageable, book);
    }
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @param ids
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public Page<Book> BookRepositoryImpl.findAllByIdsIn(List<Long> ids, GlobalSearch globalSearch, Pageable pageable) {
        
        QBook book = QBook.book;
        
        JPQLQuery<Book> query = from(book);
        
        Path<?>[] paths = new Path<?>[] {book.name,book.isbn};        
        applyGlobalSearch(globalSearch, query, paths);
        
        // Also, filter by the provided ids
        query.where(book.id.in(ids));
        
        AttributeMappingBuilder mapping = buildMapper()
			.map(NAME, book.name)
			.map(ISBN, book.isbn);
        
        applyPagination(pageable, query, mapping);
        applyOrderById(query);
        
        return loadPage(query, pageable, book);
    }
    
}
