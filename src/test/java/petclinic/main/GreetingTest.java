package petclinic.main;

import org.junit.jupiter.api.*;

import br.com.meridius.junit5.initial.Greeting;

class GreetingTest {

    private Greeting greeting;

    @BeforeAll
    public static void beforeClass(){
        System.out.println("Annotation @BeforeAll can be called Just Once!");
    }

    @BeforeEach
    void setUp() {
        System.out.println("Annotation @BeforeEach is going to be called before every Test Case...");
        greeting = new Greeting();
    }

    @Test
    void helloWorld() {
        System.out.println(greeting.helloWorld());

    }

    @Test
    void helloWorld1() {
        System.out.println(greeting.helloWorld("Meridius"));
    }

    @Test
    void helloWorld2() {
       System.out.println(greeting.helloWorld("Sinclair"));
    }

    @AfterEach
    void tearDown() {
        System.out.println("Annotation @AfterEach is going to be called after every Test Case...");
    }

    @AfterAll
    public static void afterClass(){
        System.out.println("Like Annotation @BeforeAll, @AfterAllis going to be called Just Once!");
    }
}