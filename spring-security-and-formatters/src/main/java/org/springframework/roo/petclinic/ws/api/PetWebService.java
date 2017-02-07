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
import org.springframework.roo.petclinic.domain.Pet;
import org.springframework.roo.petclinic.domain.PetNameAndWeightFormBean;
import org.springframework.roo.petclinic.domain.reference.PetType;

import io.springlets.data.domain.GlobalSearch;
import io.springlets.data.domain.jaxb.GlobalSearchAdapter;
import io.springlets.data.domain.jaxb.IterableAdapter;
import io.springlets.data.domain.jaxb.PageAdapter;
import io.springlets.data.domain.jaxb.PageableAdapter;

/**
 * = PetWebService
 *
 * TODO Auto-generated class documentation
 *
 */
@WebService(name = "PetWebService", targetNamespace = "http://ws.petclinic.roo.springframework.org/")
@WSDLDocumentation(value = "TODO Auto-generated documentation for PetWebService", placement = WSDLDocumentation.Placement.TOP)
public interface PetWebService {

    /**
     * TODO Auto-generated method documentation
     *
     * @param id
     * @return Pet
     */
    @RequestWrapper(className = "org.springframework.roo.petclinic.ws.api.FindOneByLongRequest", localName = "FindOneByLongRequest", targetNamespace = "http://ws.petclinic.roo.springframework.org/")
    @ResponseWrapper(className = "org.springframework.roo.petclinic.ws.api.FindOneByLongResponse", localName = "FindOneByLongResponse", targetNamespace = "http://ws.petclinic.roo.springframework.org/")
    @WebMethod(action = "urn:FindOneByLong")
    @WebResult(name = "pet", targetNamespace = "")
    @WSDLDocumentationCollection({ @WSDLDocumentation(value = "TODO Auto-generated documentation for PetWebService", placement = WSDLDocumentation.Placement.DEFAULT), @WSDLDocumentation(value = "TODO Auto-generated documentation for PetWebService", placement = WSDLDocumentation.Placement.PORT_TYPE_OPERATION_OUTPUT) })
    public abstract Pet findOneByLong(@WebParam(name = "id", targetNamespace = "") Long id);

    /**
     * TODO Auto-generated method documentation
     *
     * @param pet
     */
    @RequestWrapper(className = "org.springframework.roo.petclinic.ws.api.DeleteByPetRequest", localName = "DeleteByPetRequest", targetNamespace = "http://ws.petclinic.roo.springframework.org/")
    @ResponseWrapper(className = "org.springframework.roo.petclinic.ws.api.DeleteByPetResponse", localName = "DeleteByPetResponse", targetNamespace = "http://ws.petclinic.roo.springframework.org/")
    @WebMethod(action = "urn:DeleteByPet")
    @WebResult(name = "void", targetNamespace = "")
    @WSDLDocumentationCollection({ @WSDLDocumentation(value = "TODO Auto-generated documentation for PetWebService", placement = WSDLDocumentation.Placement.DEFAULT), @WSDLDocumentation(value = "TODO Auto-generated documentation for PetWebService", placement = WSDLDocumentation.Placement.PORT_TYPE_OPERATION_OUTPUT) })
    public abstract void deleteByPet(@WebParam(name = "pet", targetNamespace = "") Pet pet);

    /**
     * TODO Auto-generated method documentation
     *
     * @param entities
     * @return List
     */
    @RequestWrapper(className = "org.springframework.roo.petclinic.ws.api.SaveByIterableRequest", localName = "SaveByIterableRequest", targetNamespace = "http://ws.petclinic.roo.springframework.org/")
    @ResponseWrapper(className = "org.springframework.roo.petclinic.ws.api.SaveByIterableResponse", localName = "SaveByIterableResponse", targetNamespace = "http://ws.petclinic.roo.springframework.org/")
    @WebMethod(action = "urn:SaveByIterable")
    @WebResult(name = "pet", targetNamespace = "")
    @WSDLDocumentationCollection({ @WSDLDocumentation(value = "TODO Auto-generated documentation for PetWebService", placement = WSDLDocumentation.Placement.DEFAULT), @WSDLDocumentation(value = "TODO Auto-generated documentation for PetWebService", placement = WSDLDocumentation.Placement.PORT_TYPE_OPERATION_OUTPUT) })
    public abstract List<Pet> saveByIterable(@WebParam(name = "entities", targetNamespace = "") @XmlJavaTypeAdapter(IterableAdapter.class) Iterable<Pet> entities);

    /**
     * TODO Auto-generated method documentation
     *
     * @param ids
     */
    @RequestWrapper(className = "org.springframework.roo.petclinic.ws.api.DeleteByIterableRequest", localName = "DeleteByIterableRequest", targetNamespace = "http://ws.petclinic.roo.springframework.org/")
    @ResponseWrapper(className = "org.springframework.roo.petclinic.ws.api.DeleteByIterableResponse", localName = "DeleteByIterableResponse", targetNamespace = "http://ws.petclinic.roo.springframework.org/")
    @WebMethod(action = "urn:DeleteByIterable")
    @WebResult(name = "void", targetNamespace = "")
    @WSDLDocumentationCollection({ @WSDLDocumentation(value = "TODO Auto-generated documentation for PetWebService", placement = WSDLDocumentation.Placement.DEFAULT), @WSDLDocumentation(value = "TODO Auto-generated documentation for PetWebService", placement = WSDLDocumentation.Placement.PORT_TYPE_OPERATION_OUTPUT) })
    public abstract void deleteByIterable(@WebParam(name = "ids", targetNamespace = "") @XmlJavaTypeAdapter(IterableAdapter.class) Iterable<Long> ids);

    /**
     * TODO Auto-generated method documentation
     *
     * @param entity
     * @return Pet
     */
    @RequestWrapper(className = "org.springframework.roo.petclinic.ws.api.SaveByPetRequest", localName = "SaveByPetRequest", targetNamespace = "http://ws.petclinic.roo.springframework.org/")
    @ResponseWrapper(className = "org.springframework.roo.petclinic.ws.api.SaveByPetResponse", localName = "SaveByPetResponse", targetNamespace = "http://ws.petclinic.roo.springframework.org/")
    @WebMethod(action = "urn:SaveByPet")
    @WebResult(name = "pet", targetNamespace = "")
    @WSDLDocumentationCollection({ @WSDLDocumentation(value = "TODO Auto-generated documentation for PetWebService", placement = WSDLDocumentation.Placement.DEFAULT), @WSDLDocumentation(value = "TODO Auto-generated documentation for PetWebService", placement = WSDLDocumentation.Placement.PORT_TYPE_OPERATION_OUTPUT) })
    public abstract Pet saveByPet(@WebParam(name = "entity", targetNamespace = "") Pet entity);

    /**
     * TODO Auto-generated method documentation
     *
     * @param id
     * @return Pet
     */
    @RequestWrapper(className = "org.springframework.roo.petclinic.ws.api.FindOneForUpdateByLongRequest", localName = "FindOneForUpdateByLongRequest", targetNamespace = "http://ws.petclinic.roo.springframework.org/")
    @ResponseWrapper(className = "org.springframework.roo.petclinic.ws.api.FindOneForUpdateByLongResponse", localName = "FindOneForUpdateByLongResponse", targetNamespace = "http://ws.petclinic.roo.springframework.org/")
    @WebMethod(action = "urn:FindOneForUpdateByLong")
    @WebResult(name = "pet", targetNamespace = "")
    @WSDLDocumentationCollection({ @WSDLDocumentation(value = "TODO Auto-generated documentation for PetWebService", placement = WSDLDocumentation.Placement.DEFAULT), @WSDLDocumentation(value = "TODO Auto-generated documentation for PetWebService", placement = WSDLDocumentation.Placement.PORT_TYPE_OPERATION_OUTPUT) })
    public abstract Pet findOneForUpdateByLong(@WebParam(name = "id", targetNamespace = "") Long id);

    /**
     * TODO Auto-generated method documentation
     *
     * @param ids
     * @return List
     */
    @RequestWrapper(className = "org.springframework.roo.petclinic.ws.api.FindAllByIterableRequest", localName = "FindAllByIterableRequest", targetNamespace = "http://ws.petclinic.roo.springframework.org/")
    @ResponseWrapper(className = "org.springframework.roo.petclinic.ws.api.FindAllByIterableResponse", localName = "FindAllByIterableResponse", targetNamespace = "http://ws.petclinic.roo.springframework.org/")
    @WebMethod(action = "urn:FindAllByIterable")
    @WebResult(name = "pet", targetNamespace = "")
    @WSDLDocumentationCollection({ @WSDLDocumentation(value = "TODO Auto-generated documentation for PetWebService", placement = WSDLDocumentation.Placement.DEFAULT), @WSDLDocumentation(value = "TODO Auto-generated documentation for PetWebService", placement = WSDLDocumentation.Placement.PORT_TYPE_OPERATION_OUTPUT) })
    public abstract List<Pet> findAllByIterable(@WebParam(name = "ids", targetNamespace = "") @XmlJavaTypeAdapter(IterableAdapter.class) Iterable<Long> ids);

    /**
     * TODO Auto-generated method documentation
     *
     * @return List
     */
    @RequestWrapper(className = "org.springframework.roo.petclinic.ws.api.FindAllRequest", localName = "FindAllRequest", targetNamespace = "http://ws.petclinic.roo.springframework.org/")
    @ResponseWrapper(className = "org.springframework.roo.petclinic.ws.api.FindAllResponse", localName = "FindAllResponse", targetNamespace = "http://ws.petclinic.roo.springframework.org/")
    @WebMethod(action = "urn:FindAll")
    @WebResult(name = "pet", targetNamespace = "")
    @WSDLDocumentationCollection({ @WSDLDocumentation(value = "TODO Auto-generated documentation for PetWebService", placement = WSDLDocumentation.Placement.DEFAULT), @WSDLDocumentation(value = "TODO Auto-generated documentation for PetWebService", placement = WSDLDocumentation.Placement.PORT_TYPE_OPERATION_OUTPUT) })
    public abstract List<Pet> findAll();

    /**
     * TODO Auto-generated method documentation
     *
     * @return Long
     */
    @RequestWrapper(className = "org.springframework.roo.petclinic.ws.api.CountRequest", localName = "CountRequest", targetNamespace = "http://ws.petclinic.roo.springframework.org/")
    @ResponseWrapper(className = "org.springframework.roo.petclinic.ws.api.CountResponse", localName = "CountResponse", targetNamespace = "http://ws.petclinic.roo.springframework.org/")
    @WebMethod(action = "urn:Count")
    @WebResult(name = "long", targetNamespace = "")
    @WSDLDocumentationCollection({ @WSDLDocumentation(value = "TODO Auto-generated documentation for PetWebService", placement = WSDLDocumentation.Placement.DEFAULT), @WSDLDocumentation(value = "TODO Auto-generated documentation for PetWebService", placement = WSDLDocumentation.Placement.PORT_TYPE_OPERATION_OUTPUT) })
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
    @WSDLDocumentationCollection({ @WSDLDocumentation(value = "TODO Auto-generated documentation for PetWebService", placement = WSDLDocumentation.Placement.DEFAULT), @WSDLDocumentation(value = "TODO Auto-generated documentation for PetWebService", placement = WSDLDocumentation.Placement.PORT_TYPE_OPERATION_OUTPUT) })
    public abstract Page<Pet> findAllByGlobalSearchAndPageable(@WebParam(name = "globalSearch", targetNamespace = "") @XmlJavaTypeAdapter(GlobalSearchAdapter.class) GlobalSearch globalSearch, @WebParam(name = "pageable", targetNamespace = "") @XmlJavaTypeAdapter(PageableAdapter.class) Pageable pageable);

    /**
     * TODO Auto-generated method documentation
     *
     * @param pet
     * @param visitsToAdd
     * @return Pet
     */
    @RequestWrapper(className = "org.springframework.roo.petclinic.ws.api.AddToVisitsByPetAndIterableRequest", localName = "AddToVisitsByPetAndIterableRequest", targetNamespace = "http://ws.petclinic.roo.springframework.org/")
    @ResponseWrapper(className = "org.springframework.roo.petclinic.ws.api.AddToVisitsByPetAndIterableResponse", localName = "AddToVisitsByPetAndIterableResponse", targetNamespace = "http://ws.petclinic.roo.springframework.org/")
    @WebMethod(action = "urn:AddToVisitsByPetAndIterable")
    @WebResult(name = "pet", targetNamespace = "")
    @WSDLDocumentationCollection({ @WSDLDocumentation(value = "TODO Auto-generated documentation for PetWebService", placement = WSDLDocumentation.Placement.DEFAULT), @WSDLDocumentation(value = "TODO Auto-generated documentation for PetWebService", placement = WSDLDocumentation.Placement.PORT_TYPE_OPERATION_OUTPUT) })
    public abstract Pet addToVisitsByPetAndIterable(@WebParam(name = "pet", targetNamespace = "") Pet pet, @WebParam(name = "visitsToAdd", targetNamespace = "") @XmlJavaTypeAdapter(IterableAdapter.class) Iterable<Long> visitsToAdd);

    /**
     * TODO Auto-generated method documentation
     *
     * @param pet
     * @param visitsToRemove
     * @return Pet
     */
    @RequestWrapper(className = "org.springframework.roo.petclinic.ws.api.RemoveFromVisitsByPetAndIterableRequest", localName = "RemoveFromVisitsByPetAndIterableRequest", targetNamespace = "http://ws.petclinic.roo.springframework.org/")
    @ResponseWrapper(className = "org.springframework.roo.petclinic.ws.api.RemoveFromVisitsByPetAndIterableResponse", localName = "RemoveFromVisitsByPetAndIterableResponse", targetNamespace = "http://ws.petclinic.roo.springframework.org/")
    @WebMethod(action = "urn:RemoveFromVisitsByPetAndIterable")
    @WebResult(name = "pet", targetNamespace = "")
    @WSDLDocumentationCollection({ @WSDLDocumentation(value = "TODO Auto-generated documentation for PetWebService", placement = WSDLDocumentation.Placement.DEFAULT), @WSDLDocumentation(value = "TODO Auto-generated documentation for PetWebService", placement = WSDLDocumentation.Placement.PORT_TYPE_OPERATION_OUTPUT) })
    public abstract Pet removeFromVisitsByPetAndIterable(@WebParam(name = "pet", targetNamespace = "") Pet pet, @WebParam(name = "visitsToRemove", targetNamespace = "") @XmlJavaTypeAdapter(IterableAdapter.class) Iterable<Long> visitsToRemove);

    /**
     * TODO Auto-generated method documentation
     *
     * @param pet
     * @param visits
     * @return Pet
     */
    @RequestWrapper(className = "org.springframework.roo.petclinic.ws.api.SetVisitsByPetAndIterableRequest", localName = "SetVisitsByPetAndIterableRequest", targetNamespace = "http://ws.petclinic.roo.springframework.org/")
    @ResponseWrapper(className = "org.springframework.roo.petclinic.ws.api.SetVisitsByPetAndIterableResponse", localName = "SetVisitsByPetAndIterableResponse", targetNamespace = "http://ws.petclinic.roo.springframework.org/")
    @WebMethod(action = "urn:SetVisitsByPetAndIterable")
    @WebResult(name = "pet", targetNamespace = "")
    @WSDLDocumentationCollection({ @WSDLDocumentation(value = "TODO Auto-generated documentation for PetWebService", placement = WSDLDocumentation.Placement.DEFAULT), @WSDLDocumentation(value = "TODO Auto-generated documentation for PetWebService", placement = WSDLDocumentation.Placement.PORT_TYPE_OPERATION_OUTPUT) })
    public abstract Pet setVisitsByPetAndIterable(@WebParam(name = "pet", targetNamespace = "") Pet pet, @WebParam(name = "visits", targetNamespace = "") @XmlJavaTypeAdapter(IterableAdapter.class) Iterable<Long> visits);

    /**
     * TODO Auto-generated method documentation
     *
     * @param owner
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    @XmlJavaTypeAdapter(PageAdapter.class)
    @RequestWrapper(className = "org.springframework.roo.petclinic.ws.api.FindByOwnerAndGlobalSearchAndPageableRequest", localName = "FindByOwnerAndGlobalSearchAndPageableRequest", targetNamespace = "http://ws.petclinic.roo.springframework.org/")
    @ResponseWrapper(className = "org.springframework.roo.petclinic.ws.api.FindByOwnerAndGlobalSearchAndPageableResponse", localName = "FindByOwnerAndGlobalSearchAndPageableResponse", targetNamespace = "http://ws.petclinic.roo.springframework.org/")
    @WebMethod(action = "urn:FindByOwnerAndGlobalSearchAndPageable")
    @WebResult(name = "page", targetNamespace = "")
    @WSDLDocumentationCollection({ @WSDLDocumentation(value = "TODO Auto-generated documentation for PetWebService", placement = WSDLDocumentation.Placement.DEFAULT), @WSDLDocumentation(value = "TODO Auto-generated documentation for PetWebService", placement = WSDLDocumentation.Placement.PORT_TYPE_OPERATION_OUTPUT) })
    public abstract Page<Pet> findByOwnerAndGlobalSearchAndPageable(@WebParam(name = "owner", targetNamespace = "") Owner owner, @WebParam(name = "globalSearch", targetNamespace = "") @XmlJavaTypeAdapter(GlobalSearchAdapter.class) GlobalSearch globalSearch, @WebParam(name = "pageable", targetNamespace = "") @XmlJavaTypeAdapter(PageableAdapter.class) Pageable pageable);

    /**
     * TODO Auto-generated method documentation
     *
     * @param owner
     * @return Long
     */
    @RequestWrapper(className = "org.springframework.roo.petclinic.ws.api.CountByOwnerRequest", localName = "CountByOwnerRequest", targetNamespace = "http://ws.petclinic.roo.springframework.org/")
    @ResponseWrapper(className = "org.springframework.roo.petclinic.ws.api.CountByOwnerResponse", localName = "CountByOwnerResponse", targetNamespace = "http://ws.petclinic.roo.springframework.org/")
    @WebMethod(action = "urn:CountByOwner")
    @WebResult(name = "long", targetNamespace = "")
    @WSDLDocumentationCollection({ @WSDLDocumentation(value = "TODO Auto-generated documentation for PetWebService", placement = WSDLDocumentation.Placement.DEFAULT), @WSDLDocumentation(value = "TODO Auto-generated documentation for PetWebService", placement = WSDLDocumentation.Placement.PORT_TYPE_OPERATION_OUTPUT) })
    public abstract long countByOwner(@WebParam(name = "owner", targetNamespace = "") Owner owner);

    /**
     * TODO Auto-generated method documentation
     *
     * @param owner
     * @param pageable
     * @return Page
     */
    @XmlJavaTypeAdapter(PageAdapter.class)
    @RequestWrapper(className = "org.springframework.roo.petclinic.ws.api.FindByOwnerAndPageableRequest", localName = "FindByOwnerAndPageableRequest", targetNamespace = "http://ws.petclinic.roo.springframework.org/")
    @ResponseWrapper(className = "org.springframework.roo.petclinic.ws.api.FindByOwnerAndPageableResponse", localName = "FindByOwnerAndPageableResponse", targetNamespace = "http://ws.petclinic.roo.springframework.org/")
    @WebMethod(action = "urn:FindByOwnerAndPageable")
    @WebResult(name = "page", targetNamespace = "")
    @WSDLDocumentationCollection({ @WSDLDocumentation(value = "TODO Auto-generated documentation for PetWebService", placement = WSDLDocumentation.Placement.DEFAULT), @WSDLDocumentation(value = "TODO Auto-generated documentation for PetWebService", placement = WSDLDocumentation.Placement.PORT_TYPE_OPERATION_OUTPUT) })
    public abstract Page<Pet> findByOwnerAndPageable(@WebParam(name = "owner", targetNamespace = "") Owner owner, @WebParam(name = "pageable", targetNamespace = "") @XmlJavaTypeAdapter(PageableAdapter.class) Pageable pageable);

    /**
     * TODO Auto-generated method documentation
     *
     * @param sendReminders
     * @param weight
     * @param pageable
     * @return Page
     */
    @XmlJavaTypeAdapter(PageAdapter.class)
    @RequestWrapper(className = "org.springframework.roo.petclinic.ws.api.FindByBooleanAndFloatAndPageableRequest", localName = "FindByBooleanAndFloatAndPageableRequest", targetNamespace = "http://ws.petclinic.roo.springframework.org/")
    @ResponseWrapper(className = "org.springframework.roo.petclinic.ws.api.FindByBooleanAndFloatAndPageableResponse", localName = "FindByBooleanAndFloatAndPageableResponse", targetNamespace = "http://ws.petclinic.roo.springframework.org/")
    @WebMethod(action = "urn:FindByBooleanAndFloatAndPageable")
    @WebResult(name = "page", targetNamespace = "")
    @WSDLDocumentationCollection({ @WSDLDocumentation(value = "TODO Auto-generated documentation for PetWebService", placement = WSDLDocumentation.Placement.DEFAULT), @WSDLDocumentation(value = "TODO Auto-generated documentation for PetWebService", placement = WSDLDocumentation.Placement.PORT_TYPE_OPERATION_OUTPUT) })
    public abstract Page<Pet> findByBooleanAndFloatAndPageable(@WebParam(name = "sendReminders", targetNamespace = "") boolean sendReminders, @WebParam(name = "weight", targetNamespace = "") Float weight, @WebParam(name = "pageable", targetNamespace = "") @XmlJavaTypeAdapter(PageableAdapter.class) Pageable pageable);

    /**
     * TODO Auto-generated method documentation
     *
     * @param type
     * @param name
     * @param pageable
     * @return Page
     */
    @XmlJavaTypeAdapter(PageAdapter.class)
    @RequestWrapper(className = "org.springframework.roo.petclinic.ws.api.FindByPetTypeAndStringAndPageableRequest", localName = "FindByPetTypeAndStringAndPageableRequest", targetNamespace = "http://ws.petclinic.roo.springframework.org/")
    @ResponseWrapper(className = "org.springframework.roo.petclinic.ws.api.FindByPetTypeAndStringAndPageableResponse", localName = "FindByPetTypeAndStringAndPageableResponse", targetNamespace = "http://ws.petclinic.roo.springframework.org/")
    @WebMethod(action = "urn:FindByPetTypeAndStringAndPageable")
    @WebResult(name = "page", targetNamespace = "")
    @WSDLDocumentationCollection({ @WSDLDocumentation(value = "TODO Auto-generated documentation for PetWebService", placement = WSDLDocumentation.Placement.DEFAULT), @WSDLDocumentation(value = "TODO Auto-generated documentation for PetWebService", placement = WSDLDocumentation.Placement.PORT_TYPE_OPERATION_OUTPUT) })
    public abstract Page<Pet> findByPetTypeAndStringAndPageable(@WebParam(name = "type", targetNamespace = "") PetType type, @WebParam(name = "name", targetNamespace = "") String name, @WebParam(name = "pageable", targetNamespace = "") @XmlJavaTypeAdapter(PageableAdapter.class) Pageable pageable);

    /**
     * TODO Auto-generated method documentation
     *
     * @param formBean
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    @XmlJavaTypeAdapter(PageAdapter.class)
    @RequestWrapper(className = "org.springframework.roo.petclinic.ws.api.FindByPetNameAndWeightFormBeanAndGlobalSearchAndPageableRequest", localName = "FindByPetNameAndWeightFormBeanAndGlobalSearchAndPageableRequest", targetNamespace = "http://ws.petclinic.roo.springframework.org/")
    @ResponseWrapper(className = "org.springframework.roo.petclinic.ws.api.FindByPetNameAndWeightFormBeanAndGlobalSearchAndPageableResponse", localName = "FindByPetNameAndWeightFormBeanAndGlobalSearchAndPageableResponse", targetNamespace = "http://ws.petclinic.roo.springframework.org/")
    @WebMethod(action = "urn:FindByPetNameAndWeightFormBeanAndGlobalSearchAndPageable")
    @WebResult(name = "page", targetNamespace = "")
    @WSDLDocumentationCollection({ @WSDLDocumentation(value = "TODO Auto-generated documentation for PetWebService", placement = WSDLDocumentation.Placement.DEFAULT), @WSDLDocumentation(value = "TODO Auto-generated documentation for PetWebService", placement = WSDLDocumentation.Placement.PORT_TYPE_OPERATION_OUTPUT) })
    public abstract Page<Pet> findByPetNameAndWeightFormBeanAndGlobalSearchAndPageable(@WebParam(name = "formBean", targetNamespace = "") PetNameAndWeightFormBean formBean, @WebParam(name = "globalSearch", targetNamespace = "") @XmlJavaTypeAdapter(GlobalSearchAdapter.class) GlobalSearch globalSearch, @WebParam(name = "pageable", targetNamespace = "") @XmlJavaTypeAdapter(PageableAdapter.class) Pageable pageable);

    /**
     * TODO Auto-generated method documentation
     *
     * @param sendReminders
     * @param weight
     * @return Long
     */
    @RequestWrapper(className = "org.springframework.roo.petclinic.ws.api.CountByBooleanAndFloatRequest", localName = "CountByBooleanAndFloatRequest", targetNamespace = "http://ws.petclinic.roo.springframework.org/")
    @ResponseWrapper(className = "org.springframework.roo.petclinic.ws.api.CountByBooleanAndFloatResponse", localName = "CountByBooleanAndFloatResponse", targetNamespace = "http://ws.petclinic.roo.springframework.org/")
    @WebMethod(action = "urn:CountByBooleanAndFloat")
    @WebResult(name = "long", targetNamespace = "")
    @WSDLDocumentationCollection({ @WSDLDocumentation(value = "TODO Auto-generated documentation for PetWebService", placement = WSDLDocumentation.Placement.DEFAULT), @WSDLDocumentation(value = "TODO Auto-generated documentation for PetWebService", placement = WSDLDocumentation.Placement.PORT_TYPE_OPERATION_OUTPUT) })
    public abstract long countByBooleanAndFloat(@WebParam(name = "sendReminders", targetNamespace = "") boolean sendReminders, @WebParam(name = "weight", targetNamespace = "") Float weight);

    /**
     * TODO Auto-generated method documentation
     *
     * @param type
     * @param name
     * @return Long
     */
    @RequestWrapper(className = "org.springframework.roo.petclinic.ws.api.CountByPetTypeAndStringRequest", localName = "CountByPetTypeAndStringRequest", targetNamespace = "http://ws.petclinic.roo.springframework.org/")
    @ResponseWrapper(className = "org.springframework.roo.petclinic.ws.api.CountByPetTypeAndStringResponse", localName = "CountByPetTypeAndStringResponse", targetNamespace = "http://ws.petclinic.roo.springframework.org/")
    @WebMethod(action = "urn:CountByPetTypeAndString")
    @WebResult(name = "long", targetNamespace = "")
    @WSDLDocumentationCollection({ @WSDLDocumentation(value = "TODO Auto-generated documentation for PetWebService", placement = WSDLDocumentation.Placement.DEFAULT), @WSDLDocumentation(value = "TODO Auto-generated documentation for PetWebService", placement = WSDLDocumentation.Placement.PORT_TYPE_OPERATION_OUTPUT) })
    public abstract long countByPetTypeAndString(@WebParam(name = "type", targetNamespace = "") PetType type, @WebParam(name = "name", targetNamespace = "") String name);

    /**
     * TODO Auto-generated method documentation
     *
     * @param formBean
     * @return Long
     */
    @RequestWrapper(className = "org.springframework.roo.petclinic.ws.api.CountByPetNameAndWeightFormBeanRequest", localName = "CountByPetNameAndWeightFormBeanRequest", targetNamespace = "http://ws.petclinic.roo.springframework.org/")
    @ResponseWrapper(className = "org.springframework.roo.petclinic.ws.api.CountByPetNameAndWeightFormBeanResponse", localName = "CountByPetNameAndWeightFormBeanResponse", targetNamespace = "http://ws.petclinic.roo.springframework.org/")
    @WebMethod(action = "urn:CountByPetNameAndWeightFormBean")
    @WebResult(name = "long", targetNamespace = "")
    @WSDLDocumentationCollection({ @WSDLDocumentation(value = "TODO Auto-generated documentation for PetWebService", placement = WSDLDocumentation.Placement.DEFAULT), @WSDLDocumentation(value = "TODO Auto-generated documentation for PetWebService", placement = WSDLDocumentation.Placement.PORT_TYPE_OPERATION_OUTPUT) })
    public abstract long countByPetNameAndWeightFormBean(@WebParam(name = "formBean", targetNamespace = "") PetNameAndWeightFormBean formBean);
}
