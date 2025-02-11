package edu.eci.arep.webserver;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GreetingControllerTest {

    private GreetingController controller;

    @BeforeEach
    void setUp() {
        controller = new GreetingController();
    }

    @Test
    void testGreetingDefault() {
        String response = GreetingController.greeting("World");
        assertEquals("Hola World", response);
    }

    @Test
    void testGreetingWithName() {
        String response = GreetingController.greeting("Juan");
        assertEquals("Hola Juan", response);
    }

    @Test
    void testPi() {
        String response = GreetingController.pi();
        assertEquals(Double.toString(Math.PI), response);
    }

    @Test
    void testIndex() {
        String response = GreetingController.index();
        assertEquals("Greetings from Spring Boot!", response);
    }

    @Test
    void testCountChars() {
        String response = GreetingController.countChars("Hola");
        assertEquals("La palabra 'Hola' tiene 4 caracteres.", response);
    }

    @Test
    void testConcat() {
        String response = GreetingController.concat("Hola", "Mundo");
        assertEquals("Resultado: Hola Mundo", response);
    }

    @Test
    void testMax() {
        String response = GreetingController.max("3", "8", "5");
        assertEquals("El número mayor es: 8", response);
    }

    @Test
    void testMaxWithNegativeNumbers() {
        String response = GreetingController.max("-1", "-3", "-5");
        assertEquals("El número mayor es: -1", response);
    }
}
