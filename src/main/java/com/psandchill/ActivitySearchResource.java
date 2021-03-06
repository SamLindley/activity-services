package com.psandchill;

import com.psandchill.model.Activity;
import com.psandchill.repository.ActivityRepository;
import com.psandchill.repository.ActivityRepositoryStub;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("search/activities")
public class ActivitySearchResource {

    private ActivityRepository activityRepository = new ActivityRepositoryStub();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response searchForActivities(@QueryParam(value = "description")List<String> descriptions){
        System.out.println(descriptions);

        List<Activity> activities = activityRepository.findByDescription(descriptions);

        if (activities == null || activities.size() <= 0){
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        return Response.ok().entity(new GenericEntity<List<Activity>>(activities){}).build();
    }

}
