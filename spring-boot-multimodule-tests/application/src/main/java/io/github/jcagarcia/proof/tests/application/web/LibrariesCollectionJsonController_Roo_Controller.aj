// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package io.github.jcagarcia.proof.tests.application.web;

import io.github.jcagarcia.proof.tests.application.web.LibrariesCollectionJsonController;
import io.github.jcagarcia.proof.tests.service.api.LibraryService;

privileged aspect LibrariesCollectionJsonController_Roo_Controller {
    
    /**
     * TODO Auto-generated attribute documentation
     * 
     */
    private LibraryService LibrariesCollectionJsonController.libraryService;
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @return LibraryService
     */
    public LibraryService LibrariesCollectionJsonController.getLibraryService() {
        return libraryService;
    }
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @param libraryService
     */
    public void LibrariesCollectionJsonController.setLibraryService(LibraryService libraryService) {
        this.libraryService = libraryService;
    }
    
}
