package com.gitgud.api;

import java.util.UUID;

import com.gitgud.api.dto.TaskDTO;
import com.gitgud.business.TaskManager;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.PATCH;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@ApplicationScoped
@Path("/task")
public class TaskResource {

    @Inject
    TaskManager manager;

    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listTasks() {
        return Response.ok(manager.listTasks()).build();
    }

    @GET
    @Path("/get")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getTask(@QueryParam("id") UUID id) {
        return Response.ok(manager.getTask(id)).build();
    } 

    @POST
    @Path("/create")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createTask(TaskDTO dto) {
        manager.create(dto);
        return Response.status(Response.Status.CREATED).build();
    }

    @POST
    @Path("/complete")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response completeTask(UUID id) {
        manager.complete(id);
        return Response.status(Response.Status.OK).build();
    }

    @PUT
    @Path("/update")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateTask(TaskDTO dto) {
        manager.update(dto);
        return Response.status(Response.Status.OK).build();
    }
}
