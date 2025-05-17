package ec.edu.monster;

import ec.edu.monster.model.ConversionRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/conversion")
public class ConversionResource {

    private static final double CM_TO_INCHES = 0.393701;
    private static final double INCHES_TO_CM = 2.54;

    @POST
    @Path("/cmToInches")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response cmToInches(ConversionRequest request) {
        if (request == null || request.getValor() < 0) {
            throw new WebApplicationException("Valor inválido", Response.Status.BAD_REQUEST);
        }
        double inches = request.getValor() * CM_TO_INCHES;
        return Response.ok("{\"resultado\": " + inches + " pulgadas}").build();
    }

    @POST
    @Path("/inchesToCm")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response inchesToCm(ConversionRequest request) {
        if (request == null || request.getValor() < 0) {
            throw new WebApplicationException("Valor inválido", Response.Status.BAD_REQUEST);
        }
        double cm = request.getValor() * INCHES_TO_CM;
        return Response.ok("{\"resultado\": " + cm + " cm}").build();
    }
}