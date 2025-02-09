package edu.eci.arep.webserver;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MicroServerTest {

    private MicroServer server;

    @BeforeEach
    void setUp() {
        server = new MicroServer();
        server.registerRoutes();  // Registra rutas sin iniciar el servidor
    }

    @Test
    void testRoutesAreRegistered() {
        Map<String, Method> routes = server.getRoutes();
        assertNotNull(routes);
        assertFalse(routes.isEmpty(), "Las rutas deben estar registradas");
        assertTrue(routes.containsKey("/app/greeting"), "Debe existir la ruta '/app/greeting'");
    }

    @Test
    void testInvokeControllerMethod() {
        String response = server.invokeControllerMethod("/app/greeting", "name=Juan");
        assertEquals("Hola Juan", response, "La respuesta del controlador debe ser correcta");
    }

    @Test
    void testInvokeNonExistentRoute() {
        String response = server.invokeControllerMethod("/app/notfound", "");
        assertEquals("{\"error\": \"Ruta no encontrada\"}", response, "Debe indicar que la ruta no existe");
    }

    @Test
    void testParseQueryParameters() {
        Map<String, String> params = MicroServer.parseQuery("name=Juan&age=25");
        assertEquals("Juan", params.get("name"), "El valor de 'name' debe ser 'Juan'");
        assertEquals("25", params.get("age"), "El valor de 'age' debe ser '25'");
    }

    @Test
    void testSendResponse() throws IOException {
        OutputStream mockOut = new ByteArrayOutputStream();
        server.sendResponse(mockOut, "200 OK", "text/plain", "Hello Test");

        String result = mockOut.toString();
        assertTrue(result.contains("HTTP/1.1 200 OK"), "Debe incluir el código de respuesta");
        assertTrue(result.contains("Content-Type: text/plain"), "Debe incluir el tipo de contenido");
        assertTrue(result.contains("Hello Test"), "Debe incluir el cuerpo de la respuesta");
    }
}
