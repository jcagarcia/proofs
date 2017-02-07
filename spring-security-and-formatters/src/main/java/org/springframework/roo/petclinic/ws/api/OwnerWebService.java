package org.springframework.roo.petclinic.ws.api;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

import org.apache.cxf.annotations.WSDLDocumentation;
import org.apache.cxf.annotations.WSDLDocumentationCollection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.roo.petclinic.domain.Owner;
import org.springframework.roo.petclinic.domain.OwnerCityFormBean;
import org.springframework.roo.petclinic.domain.OwnerFirstNameFormBean;
import org.springframework.roo.petclinic.domain.OwnerInfo;

import io.springlets.data.domain.GlobalSearch;
import io.springlets.data.domain.jaxb.GlobalSearchAdapter;
import io.springlets.data.domain.jaxb.IterableAdapter;
import io.springlets.data.domain.jaxb.PageAdapter;
import io.springlets.data.domain.jaxb.PageableAdapter;

/**
 * = OwnerWebService
 *
 * TODO Auto-generated class documentation
 *
 */
@WebService(name = "OwnerWebService", targetNamespace = "http://ws.petclinic.roo.springframework.org/")
@WSDLDocumentation(value = "TODO Auto-generated documentation for OwnerWebService", placement = WSDLDocumentation.Placement.TOP)
public interface OwnerWebService {

    /**
     * TODO Auto-generated method documentation
     *
     * @param id
     * @return Owner
     */
    @RequestWrapper(className = "org.springframework.roo.petclinic.ws.api.FindOneByLongRequest", localName = "FindOneByLongRequest", targetNamespace = "http://ws.petclinic.roo.springframework.org/")
    @ResponseWrapper(className = "org.springframework.roo.petclinic.ws.api.FindOneByLongResponse", localName = "FindOneByLongResponse", targetNamespace = "http://ws.petclinic.roo.springframework.org/")
    @WebMethod(action = "urn:FindOneByLong")
    @WebResult(name = "owner", targetNamespace = "")
    @WSDLDocumentationCollection({ @WSDLDocumentation(value = "TODO Auto-generated documentation for OwnerWebService", placement = WSDLDocumentation.Placement.DEFAULT), @WSDLDocumentation(value = "TODO Auto-generated documentation for OwnerWebService", placement = WSDLDocumentation.Placement.PORT_TYPE_OPERATION_OUTPUT) })
    public abstract Owner findOneByLong(@WebParam(name = "id", targetNamespace = "") Long id);

    /**
     * TODO Auto-generated method documentation
     *
     * @param owner
     */
    @RequestWrapper(className = "org.springframework.roo.petclinic.ws.api.DeleteByOwnerRequest", localName = "DeleteByOwnerRequest", targetNamespace = "http://ws.petclinic.roo.springframework.org/")
    @ResponseWrapper(className = "org.springframework.roo.petclinic.ws.api.DeleteByOwnerResponse", localName = "DeleteByOwnerResponse", targetNamespace = "http://ws.petclinic.roo.springframework.org/")
    @WebMethod(action = "urn:DeleteByOwner")
    @WebResult(name = "void", targetNamespace = "")
    @WSDLDocumentationCollection({ @WSDLDocumentation(value = "TODO Auto-generated documentation for OwnerWebService", placement = WSDLDocumentation.Placement.DEFAULT), @WSDLDocumentation(value = "TODO Auto-generated documentation for OwnerWebService", placement = WSDLDocumentation.Placement.PORT_TYPE_OPERATION_OUTPUT) })
    public abstract void deleteByOwner(@WebParam(name = "owner", targetNamespace = "") Owner owner);

    /**
     * TODO Auto-generated method documentation
     *
     * @param entities
     * @return List
     */
    @RequestWrapper(className = "org.springframework.roo.petclinic.ws.api.SaveByIterableRequest", localName = "SaveByIterableRequest", targetNamespace = "http://ws.petclinic.roo.springframework.org/")
    @ResponseWrapper(className = "org.springframework.roo.petclinic.ws.api.SaveByIterableResponse", localName = "SaveByIterableResponse", targetNamespace = "http://ws.petclinic.roo.springframework.org/")
    @WebMethod(action = "urn:SaveByIterable")
    @WebResult(name = "owner", targetNamespace = "")
    @WSDLDocumentationCollection({ @WSDLDocumentation(value = "TODO Auto-generated documentation for OwnerWebService", placement = WSDLDocumentation.Placement.DEFAULT), @WSDLDocumentation(value = "TODO Auto-generated documentation for OwnerWebService", placement = WSDLDocumentation.Placement.PORT_TYPE_OPERATION_OUTPUT) })
    public abstract List<Owner> saveByIterable(@WebParam(name = "entities", targetNamespace = "") @XmlJavaTypeAdapter(IterableAdapter.class) Iterable<Owner> entities);

    /**
     * TODO Auto-generated method documentation
     *
     * @param ids
     */
    @RequestWrapper(className = "org.springframework.roo.petclinic.ws.api.DeleteByIterableRequest", localName = "DeleteByIterableRequest", targetNamespace = "http://ws.petclinic.roo.springframework.org/")
    @ResponseWrapper(className = "org.springframework.roo.petclinic.ws.api.DeleteByIterableResponse", localName = "DeleteByIterableResponse", targetNamespace = "http://ws.petclinic.roo.springframework.org/")
    @WebMethod(action = "urn:DeleteByIterable")
    @WebResult(name = "void", targetNamespace = "")
    @WSDLDocumentationCollection({ @WSDLDocumentation(value = "TODO Auto-generated documentation for OwnerWebService", placement = WSDLDocumentation.Placement.DEFAULT), @WSDLDocumentation(value = "TODO Auto-generated documentation for OwnerWebService", placement = WSDLDocumentation.Placement.PORT_TYPE_OPERATION_OUTPUT) })
    public abstract void deleteByIterable(@WebParam(name = "ids", targetNamespace = "") @XmlJavaTypeAdapter(IterableAdapter.class) Iterable<Long> ids);

    /**
     * TODO Auto-generated method documentation
     *
     * @param entity
     * @return Owner
     */
    @RequestWrapper(className = "org.springframework.roo.petclinic.ws.api.SaveByOwnerRequest", localName = "SaveByOwnerRequest", targetNamespace = "http://ws.petclinic.roo.springframework.org/")
    @ResponseWrapper(className = "org.springframework.roo.petclinic.ws.api.SaveByOwnerResponse", localName = "SaveByOwnerResponse", targetNamespace = "http://ws.petclinic.roo.springframework.org/")
    @WebMethod(action = "urn:SaveByOwner")
    @WebResult(name = "owner", targetNamespace = "")
    @WSDLDocumentationCollection({ @WSDLDocumentation(value = "TODO Auto-generated documentation for OwnerWebService", placement = WSDLDocumentation.Placement.DEFAULT), @WSDLDocumentation(value = "TODO Auto-generated documentation for OwnerWebService", placement = WSDLDocumentation.Placement.PORT_TYPE_OPERATION_OUTPUT) })
    public abstract Owner saveByOwner(@WebParam(name = "entity", targetNamespace = "") Owner entity);

    /**
     * TODO Auto-generated method documentation
     *
     * @param id
     * @return Owner
     */
    @RequestWrapper(className = "org.springframework.roo.petclinic.ws.api.FindOneForUpdateByLongRequest", localName = "FindOneForUpdateByLongRequest", targetNamespace = "http://ws.petclinic.roo.springframework.org/")
    @ResponseWrapper(className = "org.springframework.roo.petclinic.ws.api.FindOneForUpdateByLongResponse", localName = "FindOneForUpdateByLongResponse", targetNamespace = "http://ws.petclinic.roo.springframework.org/")
    @WebMethod(action = "urn:FindOneForUpdateByLong")
    @WebResult(name = "owner", targetNamespace = "")
    @WSDLDocumentationCollection({ @WSDLDocumentation(value = "TODO Auto-generated documentation for OwnerWebService", placement = WSDLDocumentation.Placement.DEFAULT), @WSDLDocumentation(value = "TODO Auto-generated documentation for OwnerWebService", placement = WSDLDocumentation.Placement.PORT_TYPE_OPERATION_OUTPUT) })
    public abstract Owner findOneForUpdateByLong(@WebParam(name = "id", targetNamespace = "") Long id);

    /**
     * TODO Auto-generated method documentation
     *
     * @param ids
     * @return List
     */
    @RequestWrapper(className = "org.springframework.roo.petclinic.ws.api.FindAllByIterableRequest", localName = "FindAllByIterableRequest", targetNamespace = "http://ws.petclinic.roo.springframework.org/")
    @ResponseWrapper(className = "org.springframework.roo.petclinic.ws.api.FindAllByIterableResponse", localName = "FindAllByIterableResponse", targetNamespace = "http://ws.petclinic.roo.springframework.org/")
    @WebMethod(action = "urn:FindAllByIterable")
    @WebResult(name = "owner", targetNamespace = "")
    @WSDLDocumentationCollection({ @WSDLDocumentation(value = "TODO Auto-generated documentation for OwnerWebService", placement = WSDLDocumentation.Placement.DEFAULT), @WSDLDocumentation(value = "TODO Auto-generated documentation for OwnerWebService", placement = WSDLDocumentation.Placement.PORT_TYPE_OPERATION_OUTPUT) })
    public abstract List<Owner> findAllByIterable(@WebParam(name = "ids", targetNamespace = "") @XmlJavaTypeAdapter(IterableAdapter.class) Iterable<Long> ids);

    /**
     * TODO Auto-generated method documentation
     *
     * @return List
     */
    @RequestWrapper(className = "org.springframework.roo.petclinic.ws.api.FindAllRequest", localName = "FindAllRequest", targetNamespace = "http://ws.petclinic.roo.springframework.org/")
    @ResponseWrapper(className = "org.springframework.roo.petclinic.ws.api.FindAllResponse", localName = "FindAllResponse", targetNamespace = "http://ws.petclinic.roo.springframework.org/")
    @WebMethod(action = "urn:FindAll")
    @WebResult(name = "owner", targetNamespace = "")
    @WSDLDocumentationCollection({ @WSDLDocumentation(value = "TODO Auto-generated documentation for OwnerWebService", placement = WSDLDocumentation.Placement.DEFAULT), @WSDLDocumentation(value = "TODO Auto-generated documentation for OwnerWebService", placement = WSDLDocumentation.Placement.PORT_TYPE_OPERATION_OUTPUT) })
    public abstract List<Owner> findAll();

    /**
     * TODO Auto-generated method documentation
     *
     * @return Long
     */
    @RequestWrapper(className = "org.springframework.roo.petclinic.ws.api.CountRequest", localName = "CountRequest", targetNamespace = "http://ws.petclinic.roo.springframework.org/")
    @ResponseWrapper(className = "org.springframework.roo.petclinic.ws.api.CountResponse", localName = "CountResponse", targetNamespace = "http://ws.petclinic.roo.springframework.org/")
    @WebMethod(action = "urn:Count")
    @WebResult(name = "long", targetNamespace = "")
    @WSDLDocumentationCollection({ @WSDLDocumentation(value = "TODO Auto-generated documentation for OwnerWebService", placement = WSDLDocumentation.Placement.DEFAULT), @WSDLDocumentation(value = "TODO Auto-generated documentation for OwnerWebService", placement = WSDLDocumentation.Placement.PORT_TYPE_OPERATION_OUTPUT) })
    public abstract long count();

    /**
     * TODO Auto-generated method documentation
     *
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    @XmlJavaTypeAdapter(PageAdapter.class)
    @RequestWrapper(className = "org.springframework.roo.petclinic.ws.api.FindAllByGlobalSearchAndPageableRequest", localName = "FindAllByGlobalSearchAndPageableRequest", targetNamespace = "http://ws.petclinic.roo.springframework.org/")
    @ResponseWrapper(className = "org.springframework.roo.petclinic.ws.api.FindAllByGlobalSearchAndPageableResponse", localName = "FindAllByGlobalSearchAndPageableResponse", targetNamespace = "http://ws.petclinic.roo.springframework.org/")
    @WebMethod(action = "urn:FindAllByGlobalSearchAndPageable")
    @WebResult(name = "page", targetNamespace = "")
    @WSDLDocumentationCollection({ @WSDLDocumentation(value = "TODO Auto-generated documentation for OwnerWebService", placement = WSDLDocumentation.Placement.DEFAULT), @WSDLDocumentation(value = "TODO Auto-generated documentation for OwnerWebService", placement = WSDLDocumentation.Placement.PORT_TYPE_OPERATION_OUTPUT) })
    public abstract Page<Owner> findAllByGlobalSearchAndPageable(@WebParam(name = "globalSearch", targetNamespace = "") @XmlJavaTypeAdapter(GlobalSearchAdapter.class) GlobalSearch globalSearch, @WebParam(name = "pageable", targetNamespace = "") @XmlJavaTypeAdapter(PageableAdapter.class) Pageable pageable);

    /**
     * TODO Auto-generated method documentation
     *
     * @param owner
     * @param petsToAdd
     * @return Owner
     */
    @RequestWrapper(className = "org.springframework.roo.petclinic.ws.api.AddToPetsByOwnerAndIterableRequest", localName = "AddToPetsByOwnerAndIterableRequest", targetNamespace = "http://ws.petclinic.roo.springframework.org/")
    @ResponseWrapper(className = "org.springframework.roo.petclinic.ws.api.AddToPetsByOwnerAndIterableResponse", localName = "AddToPetsByOwnerAndIterableResponse", targetNamespace = "http://ws.petclinic.roo.springframework.org/")
    @WebMethod(action = "urn:AddToPetsByOwnerAndIterable")
    @WebResult(name = "owner", targetNamespace = "")
    @WSDLDocumentationCollection({ @WSDLDocumentation(value = "TODO Auto-generated documentation for OwnerWebService", placement = WSDLDocumentation.Placement.DEFAULT), @WSDLDocumentation(value = "TODO Auto-generated documentation for OwnerWebService", placement = WSDLDocumentation.Placement.PORT_TYPE_OPERATION_OUTPUT) })
    public abstract Owner addToPetsByOwnerAndIterable(@WebParam(name = "owner", targetNamespace = "") Owner owner, @WebParam(name = "petsToAdd", targetNamespace = "") @XmlJavaTypeAdapter(IterableAdapter.class) Iterable<Long> petsToAdd);

    /**
     * TODO Auto-generated method documentation
     *
     * @param owner
     * @param petsToRemove
     * @return Owner
     */
    @RequestWrapper(className = "org.springframework.roo.petclinic.ws.api.RemoveFromPetsByOwnerAndIterableRequest", localName = "RemoveFromPetsByOwnerAndIterableRequest", targetNamespace = "http://ws.petclinic.roo.springframework.org/")
    @ResponseWrapper(className = "org.springframework.roo.petclinic.ws.api.RemoveFromPetsByOwnerAndIterableResponse", localName = "RemoveFromPetsByOwnerAndIterableResponse", targetNamespace = "http://ws.petclinic.roo.springframework.org/")
    @WebMethod(action = "urn:RemoveFromPetsByOwnerAndIterable")
    @WebResult(name = "owner", targetNamespace = "")
    @WSDLDocumentationCollection({ @WSDLDocumentation(value = "TODO Auto-generated documentation for OwnerWebService", placement = WSDLDocumentation.Placement.DEFAULT), @WSDLDocumentation(value = "TODO Auto-generated documentation for OwnerWebService", placement = WSDLDocumentation.Placement.PORT_TYPE_OPERATION_OUTPUT) })
    public abstract Owner removeFromPetsByOwnerAndIterable(@WebParam(name = "owner", targetNamespace = "") Owner owner, @WebParam(name = "petsToRemove", targetNamespace = "") @XmlJavaTypeAdapter(IterableAdapter.class) Iterable<Long> petsToRemove);

    /**
     * TODO Auto-generated method documentation
     *
     * @param owner
     * @param pets
     * @return Owner
     */
    @RequestWrapper(className = "org.springframework.roo.petclinic.ws.api.SetPetsByOwnerAndIterableRequest", localName = "SetPetsByOwnerAndIterableRequest", targetNamespace = "http://ws.petclinic.roo.springframework.org/")
    @ResponseWrapper(className = "org.springframework.roo.petclinic.ws.api.SetPetsByOwnerAndIterableResponse", localName = "SetPetsByOwnerAndIterableResponse", targetNamespace = "http://ws.petclinic.roo.springframework.org/")
    @WebMethod(action = "urn:SetPetsByOwnerAndIterable")
    @WebResult(name = "owner", targetNamespace = "")
    @WSDLDocumentationCollection({ @WSDLDocumentation(value = "TODO Auto-generated documentation for OwnerWebService", placement = WSDLDocumentation.Placement.DEFAULT), @WSDLDocumentation(value = "TODO Auto-generated documentation for OwnerWebService", placement = WSDLDocumentation.Placement.PORT_TYPE_OPERATION_OUTPUT) })
    public abstract Owner setPetsByOwnerAndIterable(@WebParam(name = "owner", targetNamespace = "") Owner owner, @WebParam(name = "pets", targetNamespace = "") @XmlJavaTypeAdapter(IterableAdapter.class) Iterable<Long> pets);

    /**
     * TODO Auto-generated method documentation
     *
     * @param formBean
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    @XmlJavaTypeAdapter(PageAdapter.class)
    @RequestWrapper(className = "org.springframework.roo.petclinic.ws.api.FindByOwnerFirstNameFormBeanAndGlobalSearchAndPageableRequest", localName = "FindByOwnerFirstNameFormBeanAndGlobalSearchAndPageableRequest", targetNamespace = "http://ws.petclinic.roo.springframework.org/")
    @ResponseWrapper(className = "org.springframework.roo.petclinic.ws.api.FindByOwnerFirstNameFormBeanAndGlobalSearchAndPageableResponse", localName = "FindByOwnerFirstNameFormBeanAndGlobalSearchAndPageableResponse", targetNamespace = "http://ws.petclinic.roo.springframework.org/")
    @WebMethod(action = "urn:FindByOwnerFirstNameFormBeanAndGlobalSearchAndPageable")
    @WebResult(name = "page", targetNamespace = "")
    @WSDLDocumentationCollection({ @WSDLDocumentation(value = "TODO Auto-generated documentation for OwnerWebService", placement = WSDLDocumentation.Placement.DEFAULT), @WSDLDocumentation(value = "TODO Auto-generated documentation for OwnerWebService", placement = WSDLDocumentation.Placement.PORT_TYPE_OPERATION_OUTPUT) })
    public abstract Page<Owner> findByOwnerFirstNameFormBeanAndGlobalSearchAndPageable(@WebParam(name = "formBean", targetNamespace = "") OwnerFirstNameFormBean formBean, @WebParam(name = "globalSearch", targetNamespace = "") @XmlJavaTypeAdapter(GlobalSearchAdapter.class) GlobalSearch globalSearch, @WebParam(name = "pageable", targetNamespace = "") @XmlJavaTypeAdapter(PageableAdapter.class) Pageable pageable);

    /**
     * TODO Auto-generated method documentation
     *
     * @param formBean
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    @XmlJavaTypeAdapter(PageAdapter.class)
    @RequestWrapper(className = "org.springframework.roo.petclinic.ws.api.FindByOwnerCityFormBeanAndGlobalSearchAndPageableRequest", localName = "FindByOwnerCityFormBeanAndGlobalSearchAndPageableRequest", targetNamespace = "http://ws.petclinic.roo.springframework.org/")
    @ResponseWrapper(className = "org.springframework.roo.petclinic.ws.api.FindByOwnerCityFormBeanAndGlobalSearchAndPageableResponse", localName = "FindByOwnerCityFormBeanAndGlobalSearchAndPageableResponse", targetNamespace = "http://ws.petclinic.roo.springframework.org/")
    @WebMethod(action = "urn:FindByOwnerCityFormBeanAndGlobalSearchAndPageable")
    @WebResult(name = "page", targetNamespace = "")
    @WSDLDocumentationCollection({ @WSDLDocumentation(value = "TODO Auto-generated documentation for OwnerWebService", placement = WSDLDocumentation.Placement.DEFAULT), @WSDLDocumentation(value = "TODO Auto-generated documentation for OwnerWebService", placement = WSDLDocumentation.Placement.PORT_TYPE_OPERATION_OUTPUT) })
    public abstract Page<OwnerInfo> findByOwnerCityFormBeanAndGlobalSearchAndPageable(@WebParam(name = "formBean", targetNamespace = "") OwnerCityFormBean formBean, @WebParam(name = "globalSearch", targetNamespace = "") @XmlJavaTypeAdapter(GlobalSearchAdapter.class) GlobalSearch globalSearch, @WebParam(name = "pageable", targetNamespace = "") @XmlJavaTypeAdapter(PageableAdapter.class) Pageable pageable);

    /**
     * TODO Auto-generated method documentation
     *
     * @param formBean
     * @return Long
     */
    @RequestWrapper(className = "org.springframework.roo.petclinic.ws.api.CountByOwnerFirstNameFormBeanRequest", localName = "CountByOwnerFirstNameFormBeanRequest", targetNamespace = "http://ws.petclinic.roo.springframework.org/")
    @ResponseWrapper(className = "org.springframework.roo.petclinic.ws.api.CountByOwnerFirstNameFormBeanResponse", localName = "CountByOwnerFirstNameFormBeanResponse", targetNamespace = "http://ws.petclinic.roo.springframework.org/")
    @WebMethod(action = "urn:CountByOwnerFirstNameFormBean")
    @WebResult(name = "long", targetNamespace = "")
    @WSDLDocumentationCollection({ @WSDLDocumentation(value = "TODO Auto-generated documentation for OwnerWebService", placement = WSDLDocumentation.Placement.DEFAULT), @WSDLDocumentation(value = "TODO Auto-generated documentation for OwnerWebService", placement = WSDLDocumentation.Placement.PORT_TYPE_OPERATION_OUTPUT) })
    public abstract long countByOwnerFirstNameFormBean(@WebParam(name = "formBean", targetNamespace = "") OwnerFirstNameFormBean formBean);

    /**
     * TODO Auto-generated method documentation
     *
     * @param formBean
     * @return Long
     */
    @RequestWrapper(className = "org.springframework.roo.petclinic.ws.api.CountByOwnerCityFormBeanRequest", localName = "CountByOwnerCityFormBeanRequest", targetNamespace = "http://ws.petclinic.roo.springframework.org/")
    @ResponseWrapper(className = "org.springframework.roo.petclinic.ws.api.CountByOwnerCityFormBeanResponse", localName = "CountByOwnerCityFormBeanResponse", targetNamespace = "http://ws.petclinic.roo.springframework.org/")
    @WebMethod(action = "urn:CountByOwnerCityFormBean")
    @WebResult(name = "long", targetNamespace = "")
    @WSDLDocumentationCollection({ @WSDLDocumentation(value = "TODO Auto-generated documentation for OwnerWebService", placement = WSDLDocumentation.Placement.DEFAULT), @WSDLDocumentation(value = "TODO Auto-generated documentation for OwnerWebService", placement = WSDLDocumentation.Placement.PORT_TYPE_OPERATION_OUTPUT) })
    public abstract long countByOwnerCityFormBean(@WebParam(name = "formBean", targetNamespace = "") OwnerCityFormBean formBean);
}
