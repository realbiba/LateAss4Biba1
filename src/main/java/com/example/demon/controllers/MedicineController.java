package com.example.demon.controllers;

import entities.Medicine;
import repositories.interfaces.IMedicineRepositories;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("medicine")
public class MedicineController {
    @Inject
    private IMedicineRepositories repo;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllMedicine() {
        List<Medicine> meds;
        try {
            meds = repo.getAllMedicine();
        } catch (ServerErrorException ex) {
            return Response
                    .status(500).entity(ex.getMessage()).build();
        }

        return Response
                .status(Response.Status.OK)
                .entity(meds)
                .build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createMedicine(Medicine med) {
        boolean created;
        try {
            created = repo.createMedicine(med);
        } catch (ServerErrorException ex) {
            return Response.serverError().entity(ex.getMessage()).build();
        }

        if (!created) {
            return Response
                    .status(Response.Status.BAD_REQUEST)
                    .entity("Medicine cannot be created!")
                    .build();
        }

        return Response
                .status(Response.Status.CREATED)
                .entity("Medicine created successfully!")
                .build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getMedicine(@PathParam("id") int id) {
        Medicine med;
        try {
            med = repo.getMedicine(id);
        } catch (ServerErrorException ex) {
            return Response
                    .status(500).entity(ex.getMessage()).build();
        }

        if (med == null) {
            return Response
                    .status(Response.Status.NOT_FOUND)
                    .entity("Medicine does not exist!")
                    .build();
        }

        return Response
                .status(Response.Status.OK)
                .entity(med)
                .build();
    }
}