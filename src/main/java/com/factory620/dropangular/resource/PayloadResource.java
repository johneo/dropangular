package com.factory620.dropangular.resource;

import com.factory620.dropangular.core.Payload;
import com.factory620.dropangular.jdbi.PayloadDao;
import com.yammer.metrics.annotation.Timed;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import java.util.concurrent.atomic.AtomicLong;

/**
 * User: johneo
 * Date: 3/6/13
 * Time: 11:04 PM
 */

@Path("/payload")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class PayloadResource {

    private final PayloadDao dao;
    private final AtomicLong seq = new AtomicLong();

    public PayloadResource(PayloadDao dao) {
        this.dao = dao;
    }

    @POST
    @Timed
    public Response create(Payload p) {
        p.setId(seq.getAndDecrement());
        dao.insert(p);
        return Response.created(UriBuilder.fromResource(PayloadResource.class)
                .build(p.getId())).build();
    }

    @GET
    @Timed
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Payload find(@PathParam("id") long id) {
        return dao.findById(id);
    }
}
