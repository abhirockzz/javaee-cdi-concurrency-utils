package com.wordpress.abhirockzz.cdi.concutils;

import com.wordpress.abhirockzz.cdi.concutils.pojo.AllTasks;
import java.util.UUID;
import javax.annotation.Resource;
import javax.enterprise.concurrent.ManagedExecutorService;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("tasks")
public class TasksResource {

    @Resource
    private ManagedExecutorService mes;

    @Inject
    private BackgroundTask ht;

    @POST
    public void postTask(@Suspended final AsyncResponse resp) {
        String taskid = UUID.randomUUID().toString();
        ht.setTaskID(taskid);

        mes.submit(ht);
        System.out.println("submitted task " + taskid);
        resp.resume(Response.accepted(taskid).build());
    }

    @Inject
    private TaskStore ts;

    @Path("{taskid}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getTask(@PathParam("taskid") String taskid) {
        return Response.ok(ts.getTask(taskid)).build();
    }

    @GET
    @Path("all")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllTasks() {
        return Response.ok(new AllTasks(ts.getAllTasks())).build();
    }
}
