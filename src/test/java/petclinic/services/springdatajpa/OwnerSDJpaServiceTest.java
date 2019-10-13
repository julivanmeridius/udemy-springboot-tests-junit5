package petclinic.services.springdatajpa;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import br.com.meridius.junit5.petclinic.entity.Owner;
import br.com.meridius.junit5.petclinic.services.springdatajpa.OwnerSDJpaService;

@Disabled(value = "Test Disabled until properly settings are properly done...")
class OwnerSDJpaServiceTest {

    private OwnerSDJpaService service;

    @BeforeEach
    void setUp() {
        service = new OwnerSDJpaService(null, null, null);

    }

    @Disabled
    @Test
    void findByLastName() {
        @SuppressWarnings("unused")
		Owner foundOwner = service.findByLastName("Logan");
    }

    @Test
    void findAllByLastNameLike() {
    }

    @Test
    void findAll() {
    }

    @Test
    void findById() {
    }

    @Test
    void save() {
    }

    @Test
    void delete() {
    }

    @Test
    void deleteById() {
    }
}