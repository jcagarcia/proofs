// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package io.github.jcagarcia.proof.tests.service.impl;

import io.github.jcagarcia.proof.tests.model.domain.Book;
import io.github.jcagarcia.proof.tests.repository.BookRepository;
import io.github.jcagarcia.proof.tests.service.impl.BookServiceImpl;
import io.springlets.data.domain.GlobalSearch;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

privileged aspect BookServiceImpl_Roo_Service_Impl {
    
    declare @type: BookServiceImpl: @Service;
    
    declare @type: BookServiceImpl: @Transactional(readOnly = true);
    
    /**
     * TODO Auto-generated attribute documentation
     * 
     */
    private BookRepository BookServiceImpl.bookRepository;
    
    /**
     * TODO Auto-generated constructor documentation
     * 
     * @param bookRepository
     */
    @Autowired
    public BookServiceImpl.new(BookRepository bookRepository) {
        setBookRepository(bookRepository);
    }

    /**
     * TODO Auto-generated method documentation
     * 
     * @return BookRepository
     */
    public BookRepository BookServiceImpl.getBookRepository() {
        return bookRepository;
    }
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @param bookRepository
     */
    public void BookServiceImpl.setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @param book
     */
    @Transactional
    public void BookServiceImpl.delete(Book book) {
        getBookRepository().delete(book);
    }
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @param entities
     * @return List
     */
    @Transactional
    public List<Book> BookServiceImpl.save(Iterable<Book> entities) {
        return getBookRepository().save(entities);
    }
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @param ids
     */
    @Transactional
    public void BookServiceImpl.delete(Iterable<Long> ids) {
        List<Book> toDelete = getBookRepository().findAll(ids);
        getBookRepository().deleteInBatch(toDelete);
    }
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @param entity
     * @return Book
     */
    @Transactional
    public Book BookServiceImpl.save(Book entity) {
        return getBookRepository().save(entity);
    }
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @param id
     * @return Book
     */
    public Book BookServiceImpl.findOne(Long id) {
        return getBookRepository().findOne(id);
    }
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @param id
     * @return Book
     */
    public Book BookServiceImpl.findOneForUpdate(Long id) {
        return getBookRepository().findOneDetached(id);
    }
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @param ids
     * @return List
     */
    public List<Book> BookServiceImpl.findAll(Iterable<Long> ids) {
        return getBookRepository().findAll(ids);
    }
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @return List
     */
    public List<Book> BookServiceImpl.findAll() {
        return getBookRepository().findAll();
    }
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @return Long
     */
    public long BookServiceImpl.count() {
        return getBookRepository().count();
    }
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public Page<Book> BookServiceImpl.findAll(GlobalSearch globalSearch, Pageable pageable) {
        return getBookRepository().findAll(globalSearch, pageable);
    }
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @param ids
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public Page<Book> BookServiceImpl.findAllByIdsIn(List<Long> ids, GlobalSearch globalSearch, Pageable pageable) {
        return getBookRepository().findAllByIdsIn(ids, globalSearch, pageable);
    }
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @return Class
     */
    public Class<Book> BookServiceImpl.getEntityType() {
        return Book.class;
    }
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @return Class
     */
    public Class<Long> BookServiceImpl.getIdType() {
        return Long.class;
    }
    
}
