package br.com.meridius.junit5.petclinic.fauxspring;

import br.com.meridius.junit5.petclinic.entity.PetType;

import java.text.ParseException;
import java.util.Locale;

/**
 * 
 * @author meridius
 *
 * @param <T>
 */
public interface Formatter<T> {

    String print(PetType petType, Locale locale);

    PetType parse(String text, Locale locale) throws ParseException;
}
