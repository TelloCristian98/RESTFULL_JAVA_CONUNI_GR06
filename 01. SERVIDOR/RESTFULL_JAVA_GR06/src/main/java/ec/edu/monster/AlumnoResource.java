package ec.edu.monster;

import ec.edu.monster.model.Alumno;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/alumnos")
public class AlumnoResource {
    private static final List<Alumno> alumnos = new ArrayList<>();

    // Inicializar con datos de ejemplo
    static {
        alumnos.add(new Alumno("1", "Ana", 20));
        alumnos.add(new Alumno("2", "Luis", 21));
    }

    // GET: Obtener todos los alumnos
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Alumno> getAlumnos() {
        return alumnos;
    }

    // GET: Obtener un alumno por ID
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Alumno getAlumno(@PathParam("id") String id) {
        for (Alumno alumno : alumnos) {
            if (alumno.getId().equals(id)) {
                return alumno;
            }
        }
        throw new WebApplicationException("Alumno no encontrado", Response.Status.NOT_FOUND);
    }

    // POST: Crear un nuevo alumno
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createAlumno(Alumno alumno) {
        if (alumno.getNombre() == null || alumno.getEdad() <= 0) {
            throw new WebApplicationException("Datos inválidos", Response.Status.BAD_REQUEST);
        }
        String id = UUID.randomUUID().toString();
        alumno.setId(id);
        alumnos.add(alumno);
        URI location = URI.create("/api/alumnos/" + id);
        return Response.created(location).entity(alumno).build();
    }

    // PUT: Actualizar un alumno existente
    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Alumno updateAlumno(@PathParam("id") String id, Alumno alumno) {
        if (alumno.getNombre() == null || alumno.getEdad() <= 0) {
            throw new WebApplicationException("Datos inválidos", Response.Status.BAD_REQUEST);
        }
        for (int i = 0; i < alumnos.size(); i++) {
            if (alumnos.get(i).getId().equals(id)) {
                alumno.setId(id);
                alumnos.set(i, alumno);
                return alumno;
            }
        }
        throw new WebApplicationException("Alumno no encontrado", Response.Status.NOT_FOUND);
    }

    // DELETE: Eliminar un alumno
    @DELETE
    @Path("/{id}")
    public Response deleteAlumno(@PathParam("id") String id) {
        for (int i = 0; i < alumnos.size(); i++) {
            if (alumnos.get(i).getId().equals(id)) {
                alumnos.remove(i);
                return Response.noContent().build();
            }
        }
        throw new WebApplicationException("Alumno no encontrado", Response.Status.NOT_FOUND);
    }
}