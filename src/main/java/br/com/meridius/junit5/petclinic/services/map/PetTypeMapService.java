package br.com.meridius.junit5.petclinic.services.map;

import java.util.Set;

import br.com.meridius.junit5.petclinic.entity.PetType;
import br.com.meridius.junit5.petclinic.services.PetTypeService;

public class PetTypeMapService extends AbstractMapService<PetType, Long> implements PetTypeService {

    @Override
    public Set<PetType> findAll() {
        return super.findAll();
    }

    @Override
    public PetType findById(Long id) {
        return super.findById(id);
    }

    @Override
    public PetType save(PetType object) {
        return super.save(object);
    }

    @Override
    public void delete(PetType object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }
}
