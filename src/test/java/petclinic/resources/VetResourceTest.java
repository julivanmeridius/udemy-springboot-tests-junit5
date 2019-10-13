package petclinic.resources;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.meridius.junit5.petclinic.entity.Vet;
import br.com.meridius.junit5.petclinic.fauxspring.Model;
import br.com.meridius.junit5.petclinic.resource.VetResource;
import br.com.meridius.junit5.petclinic.services.SpecialtyService;
import br.com.meridius.junit5.petclinic.services.VetService;
import br.com.meridius.junit5.petclinic.services.map.SpecialityMapService;
import br.com.meridius.junit5.petclinic.services.map.VetMapService;
import petclinic.mapping.ModelMapImpl;

class VetResourceTest {

    private VetService vetService;
    
    private SpecialtyService specialtyService;
    
    private VetResource vetResource;

    @BeforeEach
    void setUp() {
        
    	specialtyService = new SpecialityMapService();
        vetService = new VetMapService(specialtyService);

        vetResource = new VetResource(vetService);

        Vet vet1 = new Vet(1L, "Hector", "Finder", null);
        Vet vet2 = new Vet(2L, "Logan", "Sanders", null);

        vetService.save(vet1);
        vetService.save(vet2);
    }

    @Test
    void listVets() {
        Model model = new ModelMapImpl();

        String view = vetResource.listVets(model);

        assertThat("vets/index").isEqualTo(view);

        Set<?> modelAttribute = (Set<?>) ((ModelMapImpl) model).getMap().get("vets");

        assertThat(modelAttribute.size()).isEqualTo(2);
    }
}