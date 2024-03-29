package br.com.meridius.junit5.petclinic.services.springdatajpa;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import br.com.meridius.junit5.petclinic.entity.Owner;
import br.com.meridius.junit5.petclinic.repositories.OwnerRepository;
import br.com.meridius.junit5.petclinic.repositories.PetRepository;
import br.com.meridius.junit5.petclinic.repositories.PetTypeRepository;
import br.com.meridius.junit5.petclinic.services.OwnerService;

public class OwnerSDJpaService implements OwnerService {

    private final OwnerRepository 	ownerRepository;
    @SuppressWarnings("unused")
	private final PetRepository 	petRepository;
    @SuppressWarnings("unused")
	private final PetTypeRepository petTypeRepository;

    public OwnerSDJpaService(	OwnerRepository 	ownerRepository, 
    							PetRepository 		petRepository,
    							PetTypeRepository 	petTypeRepository) 
    {
        this.ownerRepository = ownerRepository;
        this.petRepository = petRepository;
        this.petTypeRepository = petTypeRepository;
    }

    @Override
    public Owner findByLastName(String lastName) {
        return (Owner) ownerRepository.findByLastName(lastName);
    }

    @Override
    public List<Owner> findAllByLastNameLike(String lastName) {
        return ownerRepository.findAllByLastNameLike(lastName);
    }

    @Override
    public Set<Owner> findAll() {
        Set<Owner> owners = new HashSet<>();
        ownerRepository.findAll().forEach(owners::add);
        return owners;
    }

    @Override
    public Owner findById(Long aLong) {
        return ownerRepository.findById(aLong).orElse(null);
    }

    @Override
    public Owner save(Owner object) {
        return ownerRepository.save(object);
    }

    @Override
    public void delete(Owner object) {
        ownerRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        ownerRepository.deleteById(aLong);
    }
}
