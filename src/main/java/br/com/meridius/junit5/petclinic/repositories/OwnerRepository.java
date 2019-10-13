package br.com.meridius.junit5.petclinic.repositories;

import java.util.List;

import br.com.meridius.junit5.petclinic.entity.Owner;

public interface OwnerRepository extends CrudRepository<Owner, Long> {

    Owner findByLastName(String lastName);

    List<br.com.meridius.junit5.petclinic.entity.Owner> findAllByLastNameLike(String lastName);
}
