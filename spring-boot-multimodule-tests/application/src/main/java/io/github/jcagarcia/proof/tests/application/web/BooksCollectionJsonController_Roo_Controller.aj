// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package io.github.jcagarcia.proof.tests.application.web;

import io.github.jcagarcia.proof.tests.application.web.BooksCollectionJsonController;
import io.github.jcagarcia.proof.tests.service.api.BookService;

privileged aspect BooksCollectionJsonController_Roo_Controller {
    
    /**
     * TODO Auto-generated attribute documentation
     * 
     */
    private BookService BooksCollectionJsonController.bookService;
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @return BookService
     */
    public BookService BooksCollectionJsonController.getBookService() {
        return bookService;
    }
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @param bookService
     */
    public void BooksCollectionJsonController.setBookService(BookService bookService) {
        this.bookService = bookService;
    }
    
}
