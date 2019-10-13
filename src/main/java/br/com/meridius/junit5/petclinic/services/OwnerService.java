package br.com.meridius.junit5.petclinic.services;

import java.util.List;

import br.com.meridius.junit5.petclinic.entity.Owner;

/**
 * <strong>Descricao:</strong>
 * Interface responsavel pelas funcionalidades do servico<br>
 * de Owner. 
 *  
 * @author Julivan Silva
 */
public interface OwnerService extends CrudService<Owner, Long> {

    Owner findByLastName(String lastName);

    List<Owner> findAllByLastNameLike(String lastName);
 }
