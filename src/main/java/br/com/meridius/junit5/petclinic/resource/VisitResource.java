package br.com.meridius.junit5.petclinic.resource;

import java.util.Map;

import javax.validation.Valid;

import br.com.meridius.junit5.petclinic.entity.Pet;
import br.com.meridius.junit5.petclinic.entity.Visit;
import br.com.meridius.junit5.petclinic.fauxspring.BindingResult;
import br.com.meridius.junit5.petclinic.fauxspring.WebDataBinder;
import br.com.meridius.junit5.petclinic.services.PetService;
import br.com.meridius.junit5.petclinic.services.VisitService;

/**
 * <strong>Descricao:</strong>
 * Classe responsavel pela camada de resource dos<br>
 * Visitantes
 * 
 * @author Julivan Silva
 *
 */
public class VisitResource {

    private final VisitService visitService;
    private final PetService petService;

    public VisitResource(VisitService visitService, PetService petService) {
        this.visitService = visitService;
        this.petService = petService;
    }

    public void setAllowedFields(WebDataBinder dataBinder) {
        dataBinder.setDisallowedFields("id");
    }

    public Visit loadPetWithVisit(Long petId, Map<String, Object> model) {
        Pet pet = petService.findById(petId);
        model.put("pet", pet);
        Visit visit = new Visit();
        pet.getVisits().add(visit);
        visit.setPet(pet);
        return visit;
    }

    public String initNewVisitForm(Long petId, Map<String, Object> model) {
        return "pets/createOrUpdateVisitForm";
    }

    public String processNewVisitForm(@Valid Visit visit, BindingResult result) {
        if (result.hasErrors()) {
            return "pets/createOrUpdateVisitForm";
        } else {
            visitService.save(visit);

            return "redirect:/owners/{ownerId}";
        }
    }
}
