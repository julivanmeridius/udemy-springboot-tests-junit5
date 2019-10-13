package br.com.meridius.junit5.petclinic.fauxspring;

/**
 * 
 * @author Julivan Silva
 *
 */
public interface BindingResult {
    
	void rejectValue(String lastName, String notFound, String not_found);

    boolean hasErrors();
}
