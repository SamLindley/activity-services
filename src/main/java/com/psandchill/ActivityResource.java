package com.psandchill;

import com.psandchill.model.Activity;
import com.psandchill.model.User;
import com.psandchill.repository.ActivityRepository;
import com.psandchill.repository.ActivityRepositoryStub;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("activities")
public class ActivityResource {

    private ActivityRepository activityRepository = new ActivityRepositoryStub();

    //get all activities
    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<Activity> getAllActivities(){
        return activityRepository.findAllActivities();
    }

    //get a specific activity by Id
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    @Path("{activityId}")
    public Response getActivity(@PathParam("activityId") String Id){
        int activityId = Integer.parseInt(Id);
        if (activityId < 0 || activityId > 99){
            return Response.status(Response.Status.BAD_REQUEST).build();
        }

        Activity activity = activityRepository.findActivity(activityId);

        if (activity == null){
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok().entity(activity).build();
    }

    //get a user
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    @Path("{activityId}/user")
    public User getActivityUser(@PathParam("activityId") int activityId){
        return activityRepository.findActivity(activityId).getUser();
    }

    @POST
    @Path("activity")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Activity createActivityParams(MultivaluedMap<String, String> formParams){

        System.out.println(formParams.getFirst("description"));
        System.out.println(formParams.getFirst("duration"));

        Activity activity = new Activity();
        activity.setDescription(formParams.getFirst("description"));
        activity.setDuration(Integer.parseInt(formParams.getFirst("duration")));

        activityRepository.create(activity);

        return activity;
    }

    @POST
    @Path("activity")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Activity createActivity(Activity activity){

       /* System.out.println(activity.getDescription());
        System.out.println(activity.getDuration());*/

       if (activity.getDescription() != null && activity.getDuration() > 0){
           activityRepository.create(activity);
       }


        return activity;
    }

    @PUT
    @Path("{activityId}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response update(Activity activity){

        System.out.println(activity.getId());

        activity = activityRepository.update(activity);

        return Response.ok().entity(activity).build();
    }

    @DELETE
    @Path("{activityId}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response delete(@PathParam("activityId") String activityId){
        System.out.println(activityId);

        activityRepository.delete(activityId);
        return Response.ok().build();
    }


}
