package br.com.meridius.junit5.petclinic.repositories;

import br.com.meridius.junit5.petclinic.entity.Pet;

public interface PetRepository extends CrudRepository<Pet, Long> {
}
