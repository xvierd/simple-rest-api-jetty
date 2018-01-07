package org.example.services;

import org.example.dto.User;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

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

    @GET
    @Path("/user/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response userInfo(@PathParam("name") String name)  {
        User user = new User("i-sldaksd","Miranda");

        user.setName(name);

        return Response.status(Response.Status.OK).entity(user).build();
    }


    @PUT
    @Path("/user?=name")
    @Produces(MediaType.APPLICATION_JSON)
    public Response userModify(@QueryParam("name") String name)  {
        User user = new User("i-sldaksd","PUT");
        user.setName(name);
        return Response.status(Response.Status.OK).entity(user).build();
    }


    @POST
    @Path("/user")
    @Produces(MediaType.APPLICATION_JSON)
    public Response userSave()  {
        User user = new User("i-sldaksd","POST");

        return Response.status(Response.Status.OK).entity(user).build();
    }


    @DELETE
    @Path("/user")
    @Produces(MediaType.APPLICATION_JSON)
    public Response userDelete()  {
        return Response.status(Response.Status.NO_CONTENT).build();
    }
}
