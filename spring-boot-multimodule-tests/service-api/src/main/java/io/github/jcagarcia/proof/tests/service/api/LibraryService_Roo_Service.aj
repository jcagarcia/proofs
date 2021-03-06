// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package io.github.jcagarcia.proof.tests.service.api;

import io.github.jcagarcia.proof.tests.model.domain.Library;
import io.github.jcagarcia.proof.tests.service.api.LibraryService;
import io.springlets.data.domain.GlobalSearch;
import io.springlets.format.EntityResolver;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

privileged aspect LibraryService_Roo_Service {
    
    declare parents: LibraryService extends EntityResolver<Library, Long>;
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @param id
     * @return Library
     */
    public abstract Library LibraryService.findOne(Long id);
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @param library
     */
    public abstract void LibraryService.delete(Library library);
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @param entities
     * @return List
     */
    public abstract List<Library> LibraryService.save(Iterable<Library> entities);
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @param ids
     */
    public abstract void LibraryService.delete(Iterable<Long> ids);
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @param entity
     * @return Library
     */
    public abstract Library LibraryService.save(Library entity);
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @param id
     * @return Library
     */
    public abstract Library LibraryService.findOneForUpdate(Long id);
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @param ids
     * @return List
     */
    public abstract List<Library> LibraryService.findAll(Iterable<Long> ids);
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @return List
     */
    public abstract List<Library> LibraryService.findAll();
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @return Long
     */
    public abstract long LibraryService.count();
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public abstract Page<Library> LibraryService.findAll(GlobalSearch globalSearch, Pageable pageable);
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @param ids
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public abstract Page<Library> LibraryService.findAllByIdsIn(List<Long> ids, GlobalSearch globalSearch, Pageable pageable);
    
}
