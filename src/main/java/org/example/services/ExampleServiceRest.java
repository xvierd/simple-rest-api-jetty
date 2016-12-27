package org.example.services;

import org.example.dto.User;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Date;

/**
 * @author Xavier Guti&#233;rrez
 *         27/12/16.
 */
@Path("/example")
public class ExampleServiceRest  {

    @GET
    @Path("/user")
    @Produces(MediaType.APPLICATION_JSON)
    public Response userInfo()  {
        User user = new User("i-sldaksd","Miranda");

        return Response.status(Response.Status.OK).entity(user).build();
    }
}
