package ec.edu.monster;

import ec.edu.monster.model.LoginRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/login")
public class LoginResource {

    private static final String VALID_USERNAME = "monster";
    private static final String VALID_PASSWORD = "monster";

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response login(LoginRequest loginRequest) {
        if (loginRequest == null || loginRequest.getUsuario() == null || loginRequest.getContrasena() == null) {
            throw new WebApplicationException("Usuario y contraseña son requeridos", Response.Status.BAD_REQUEST);
        }

        if (VALID_USERNAME.equals(loginRequest.getUsuario()) && VALID_PASSWORD.equals(loginRequest.getContrasena())) {
            return Response.ok("{\"mensaje\": \"Login exitoso\"}").build();
        } else {
            throw new WebApplicationException("Usuario o contraseña incorrectos", Response.Status.UNAUTHORIZED);
        }
    }
}