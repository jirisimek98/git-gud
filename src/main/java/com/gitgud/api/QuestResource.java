package com.gitgud.api;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

import org.jboss.logging.Logger;

import com.gitgud.api.dto.QuestDTO;
import com.gitgud.business.QuestLog;

@Path("/quest")
public class QuestResource {
    @Inject
    QuestLog log;

    private static final Logger LOG = Logger.getLogger(QuestResource.class);

    @GET
    @Path("/list")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listQuests() {
        List<QuestDTO> dtoList = log.listQuests();
        return Response.ok(dtoList).build();
    }

    @POST
    @Path("/create")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(QuestDTO dto) {
        log.addQuest(dto);
        return Response.status(Response.Status.CREATED).build();
    }
}
