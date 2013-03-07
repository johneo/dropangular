package com.factory620.dropangular.resource;

import com.factory620.dropangular.core.Payload;
import com.factory620.dropangular.jdbi.PayloadDao;
import com.yammer.metrics.annotation.Timed;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * User: johneo
 * Date: 3/6/13
 * Time: 11:04 PM
 */

@Path("/payload")
@Produces(MediaType.APPLICATION_JSON)
public class PayloadResource {

    private final PayloadDao dao;

    public PayloadResource(PayloadDao dao) {
        this.dao = dao;
    }

    @POST
    @Timed
    @Consumes(MediaType.APPLICATION_JSON)
    public void create(Payload p) {
        dao.insert(p);
    }

    @GET
    @Timed
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Payload find(@PathParam("id") long id) {
        return dao.findById(id);
    }
}
