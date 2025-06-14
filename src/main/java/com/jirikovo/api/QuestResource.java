package com.jirikovo.api;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;
import java.util.stream.Collectors;

import org.jboss.logging.Logger;

import com.jirikovo.business.Quest;
import com.jirikovo.business.QuestLog;
import com.jirikovo.business.mappers.ApiMapper;

@Path("/quest")
public class QuestResource {
    @Inject
    QuestLog log;

    private static final Logger LOG = Logger.getLogger(QuestResource.class);

    @GET
    @Path("/list")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listQuests() {
        List<Quest> quests = log.listQuests();
        List<QuestDTO> dtoList = quests.stream()
            .map(quest -> ApiMapper.map(quest)) 
            .collect(Collectors.toList());
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
