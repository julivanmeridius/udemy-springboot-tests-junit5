package br.com.meridius.junit5.petclinic.resource;

import br.com.meridius.junit5.petclinic.fauxspring.Model;
import br.com.meridius.junit5.petclinic.services.VetService;

public class VetResource {

    private final VetService vetService;

    public VetResource(VetService vetService) {
        this.vetService = vetService;
    }

    public String listVets(Model model){

        model.addAttribute("vets", vetService.findAll());

        return "vets/index";
    }
}
