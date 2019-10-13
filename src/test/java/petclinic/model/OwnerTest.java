package petclinic.model;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import br.com.meridius.junit5.petclinic.entity.Owner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;

@Tag("entity")
class OwnerTest {

    @Test
    void dependentAssertions() {

        Owner owner = new Owner(1l, "Logan", "Meridius");
        owner.setCity("Sao Paulo");
        owner.setTelephone("11996142020");

        assertAll("Properties Test",
                () -> assertAll("Person Properties",
                        () -> assertEquals("Logan", owner.getFirstName(), "First Name Did not Match"),
                        () -> assertEquals("Meridius", owner.getLastName())),
                () -> assertAll("Owner Properties",
                        () -> assertEquals("Sao Paulo", owner.getCity(), "City Did Not Match"),
                        () -> assertEquals("11996142020", owner.getTelephone())
                ));

        assertThat(owner.getCity(), is("Sao Paulo"));
    }
}