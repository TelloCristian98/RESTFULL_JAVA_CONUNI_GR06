/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.monster.servicio;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author Juanr
 */
@Path("/conversion")
public class ConversorUnidades {

    @GET
    @Path("/pulgadas-a-cm/{pulgadas}")
    @Produces(MediaType.TEXT_PLAIN)
    public double plugadasACentimetros(@PathParam("pulgadas") double pulgadas) {
        return pulgadas * 2.54;
    }

    @GET
    @Path("/cm-a-pulgadas/{cm}")
    @Produces(MediaType.TEXT_PLAIN)
    public double centimetrosAPulgadas(@PathParam("cm") double cm) {
        return cm / 2.54;
    }

    @GET
    @Path("/login/{usuario}/{clave}")
    @Produces(MediaType.TEXT_PLAIN)
    public boolean login(@PathParam("usuario") String usuario, @PathParam("clave") String clave) {
        return "monster".equals(usuario) && "monster9".equals(clave);
    }
}
