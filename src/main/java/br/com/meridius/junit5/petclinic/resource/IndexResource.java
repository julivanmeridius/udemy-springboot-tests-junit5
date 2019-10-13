package br.com.meridius.junit5.petclinic.resource;

import br.com.meridius.junit5.petclinic.exception.ValueNotFoundException;

/**
 * <strong>Descricao:</strong>
 * Resource responsavel da pagina principal. 
 * 
 * @author Julivan Silva
 *
 */
public class IndexResource {

    public String index(){
        return "index";
    }

    public String oopsHandler() {
        throw new ValueNotFoundException();
    }
}
