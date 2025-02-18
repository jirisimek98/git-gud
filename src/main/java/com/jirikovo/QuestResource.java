package com.jirikovo;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("/quest")
public class QuestResource {
    @Inject
    QuestStorage storage;

    @GET
    @Path("/list")
    @Produces(MediaType.TEXT_PLAIN)
    public String listQuests() {
        List<Quest> quests = storage.list();
        StringBuilder sb = new StringBuilder();
        quests.forEach(quest -> {
            sb.append(quest.getName()).append("/n").append(quest.getDescription()).append("/n").append("Status: ").append(quest.isCompleted()?"COMPLETED":"NOT COMPLETED").append("/n");
        });
        return sb.toString();
    }

    @POST
    @Path("/create")
    @Produces(MediaType.TEXT_PLAIN)
    public String create() {
        storage.create("New Quest", "A quest I just crearted from scratch", 10);
        return "all good";
    }
}
