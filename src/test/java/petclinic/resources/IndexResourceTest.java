package petclinic.resources;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.*;

import br.com.meridius.junit5.petclinic.exception.ValueNotFoundException;
import br.com.meridius.junit5.petclinic.resource.IndexResource;

import java.time.Duration;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

@Tag("resources")
class IndexResourceTest {

    private IndexResource indexResource;

    @BeforeEach
    void setUp() {
        indexResource = new IndexResource();
    }

    @DisplayName("Test Proper View name is returned for index page")
    @Test
    void index() {
        assertEquals("index", indexResource.index());
        assertEquals("index", indexResource.index(), "Wrong View Returned");

        assertEquals("index", indexResource.index(), () -> "Another Expensive Message " +
                "Make me only if you have to");

        assertThat(indexResource.index()).isEqualTo("index");
    }

    @Test
    @DisplayName("Test exception")
    void oupsHandler() {
        assertThrows(ValueNotFoundException.class, () -> {
            indexResource.oopsHandler();
        });
    }

    @Disabled("First Scenario for Timeout on JUnit5")
    @Test
    void testTimeOut() {

        assertTimeout(Duration.ofMillis(100), () -> {
            Thread.sleep(5000);
            System.out.println("I got here");
        });
    }

    @Disabled("Second Scenario for Timeout on JUnit5")
    @Test
    void testTimeOutPrempt() {

        assertTimeoutPreemptively(Duration.ofMillis(100), () -> {
            Thread.sleep(5000);

            System.out.println("I got here 2342342342342");
        });
    }

    @Test
    void testAssumptionTrue() {

        assumeTrue("GURU".equalsIgnoreCase(System.getenv("GURU_RUNTIME")));
    }

    @Test
    void testAssumptionTrueAssumptionIsTrue() {

        assumeTrue("GURU".equalsIgnoreCase("GURU"));
    }

    @EnabledOnOs(OS.MAC)
    @Test
    void testMeOnMacOS() {
    }

    @EnabledOnOs(OS.WINDOWS)
    @Test
    void testMeOnWindows() {
    }

    @EnabledOnJre(JRE.JAVA_8)
    @Test
    void testMeOnJava8() {
    }

    @EnabledOnJre(JRE.JAVA_11)
    @Test
    void testMeOnJava11() {
    }

    @EnabledIfEnvironmentVariable(named = "USER", matches = "jt")
    @Test
    void testIfUserJT() {
    }

    @EnabledIfEnvironmentVariable(named = "USER", matches = "fred")
    @Test
    void testIfUserFred() {
    }
}