// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package io.github.jcagarcia.proof.tests.model.domain;

import io.github.jcagarcia.proof.tests.model.domain.Book;

privileged aspect Book_Roo_JavaBean {
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @return Long
     */
    public Long Book.getId() {
        return this.id;
    }
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @param id
     */
    public void Book.setId(Long id) {
        this.id = id;
    }
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @return Integer
     */
    public Integer Book.getVersion() {
        return this.version;
    }
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @param version
     */
    public void Book.setVersion(Integer version) {
        this.version = version;
    }
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @return String
     */
    public String Book.getName() {
        return this.name;
    }
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @param name
     */
    public void Book.setName(String name) {
        this.name = name;
    }
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @return String
     */
    public String Book.getIsbn() {
        return this.isbn;
    }
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @param isbn
     */
    public void Book.setIsbn(String isbn) {
        this.isbn = isbn;
    }
    
}