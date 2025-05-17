package ec.edu.monster;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.lang.reflect.Method;
import javax.ws.rs.Path;
import org.glassfish.jersey.jackson.internal.jackson.jaxrs.json.JacksonJaxbJsonProvider;
import org.glassfish.jersey.server.ResourceConfig;

public class RestApplication extends ResourceConfig {
    public RestApplication() {
        // Registrar clases REST y características
        register(ConversionResource.class);
        register(LoginResource.class);
        register(GenericExceptionMapper.class);

        // Configurar Jackson con un ObjectMapper personalizado
        JacksonJaxbJsonProvider provider = new JacksonJaxbJsonProvider();
        provider.setMapper(new ObjectMapper());
        register(provider);

        // Imprimir rutas API
        printApiRoutes();
    }

    private void printApiRoutes() {
        System.out.println("=== Rutas API Disponibles ===");
        Class<?>[] resources = { ConversionResource.class, LoginResource.class }; // Lista de clases REST
        for (Class<?> resource : resources) {
            Path classPath = resource.getAnnotation(Path.class);
            if (classPath != null) {
                String basePath = "/api" + (classPath.value().startsWith("/") ? classPath.value() : "/" + classPath.value());
                for (Method method : resource.getMethods()) {
                    Path methodPath = method.getAnnotation(Path.class);
                    String fullPath = basePath;
                    if (methodPath != null) {
                        fullPath += (methodPath.value().startsWith("/") ? methodPath.value() : "/" + methodPath.value());
                    }
                    if (method.isAnnotationPresent(javax.ws.rs.GET.class)) {
                        System.out.println("GET: " + fullPath);
                    }
                    if (method.isAnnotationPresent(javax.ws.rs.POST.class)) {
                        System.out.println("POST: " + fullPath);
                    }
                    if (method.isAnnotationPresent(javax.ws.rs.PUT.class)) {
                        System.out.println("PUT: " + fullPath);
                    }
                    if (method.isAnnotationPresent(javax.ws.rs.DELETE.class)) {
                        System.out.println("DELETE: " + fullPath);
                    }
                }
            }
        }
        System.out.println("============================");
    }
}