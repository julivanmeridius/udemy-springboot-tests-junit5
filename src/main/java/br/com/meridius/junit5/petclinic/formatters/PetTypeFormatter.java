package br.com.meridius.junit5.petclinic.formatters;

import java.text.ParseException;
import java.util.Collection;
import java.util.Locale;

import br.com.meridius.junit5.petclinic.entity.PetType;
import br.com.meridius.junit5.petclinic.fauxspring.Formatter;
import br.com.meridius.junit5.petclinic.services.PetTypeService;

/**
 * 
 * @author Julivan Silva
 *
 */
@SuppressWarnings("rawtypes")
public class PetTypeFormatter implements Formatter {

    private final PetTypeService petTypeService;

    public PetTypeFormatter(PetTypeService petTypeService) {
        this.petTypeService = petTypeService;
    }

    @Override
    public String print(PetType petType, Locale locale) {
        return petType.getName();
    }

    @Override
    public PetType parse(String text, Locale locale) throws ParseException {
        Collection<PetType> findPetTypes = petTypeService.findAll();

        for (PetType type : findPetTypes) {
            if (type.getName().equals(text)) {
                return type;
            }
        }

        throw new ParseException("type not found: " + text, 0);
    }
}
