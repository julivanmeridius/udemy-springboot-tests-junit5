package br.com.meridius.junit5.petclinic.resource;

import java.util.List;

import javax.validation.Valid;

import br.com.meridius.junit5.petclinic.entity.Owner;
import br.com.meridius.junit5.petclinic.fauxspring.BindingResult;
import br.com.meridius.junit5.petclinic.fauxspring.Model;
import br.com.meridius.junit5.petclinic.fauxspring.ModelAndView;
import br.com.meridius.junit5.petclinic.fauxspring.WebDataBinder;
import br.com.meridius.junit5.petclinic.services.OwnerService;

/**
 * 
 * @author meridius
 *
 */
public class OwnerResource {
    private static final String VIEWS_OWNER_CREATE_OR_UPDATE_FORM = "owners/createOrUpdateOwnerForm";

    private final OwnerService ownerService;

    public OwnerResource(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    public void setAllowedFields(WebDataBinder dataBinder) {
        dataBinder.setDisallowedFields("id");
    }

    public String findOwners(Model model){
        model.addAttribute("owner", new Owner(null, null, null));
        return "owners/findOwners";
    }

    public String processFindForm(Owner owner, BindingResult result, Model model){
        // allow parameterless GET request for /owners to return all records
        if (owner.getLastName() == null) {
            owner.setLastName(""); // empty string signifies broadest possible search
        }

        // find owners by last name
        List<Owner> results = ownerService.findAllByLastNameLike("%"+ owner.getLastName() + "%");

        if (results.isEmpty()) {
            // no owners found
            result.rejectValue("lastName", "notFound", "not found");
            return "owners/findOwners";
        } else if (results.size() == 1) {
            // 1 owner found
            owner = results.get(0);
            return "redirect:/owners/" + owner.getId();
        } else {
            // multiple owners found
            model.addAttribute("selections", results);
            return "owners/ownersList";
        }
    }

    public ModelAndView showOwner(Long ownerId) {
        ModelAndView mav = new ModelAndView("owners/ownerDetails");
        mav.addObject(ownerService.findById(ownerId));
        return mav;
    }

    public String initCreationForm(Model model) {
        model.addAttribute("owner", new Owner(null, null, null));
        return VIEWS_OWNER_CREATE_OR_UPDATE_FORM;
    }

    public String processCreationForm(@Valid Owner owner, BindingResult result) {
        if (result.hasErrors()) {
            return VIEWS_OWNER_CREATE_OR_UPDATE_FORM;
        } else {
            Owner savedOwner =  ownerService.save(owner);
            return "redirect:/owners/" + savedOwner.getId();
        }
    }

    public String initUpdateOwnerForm(Long ownerId, Model model) {
        model.addAttribute(ownerService.findById(ownerId));
        return VIEWS_OWNER_CREATE_OR_UPDATE_FORM;
    }

    public String processUpdateOwnerForm(@Valid Owner owner, BindingResult result, Long ownerId) {
        if (result.hasErrors()) {
            return VIEWS_OWNER_CREATE_OR_UPDATE_FORM;
        } else {
            owner.setId(ownerId);
            Owner savedOwner = ownerService.save(owner);
            return "redirect:/owners/" + savedOwner.getId();
        }
    }

}
