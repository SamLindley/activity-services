/*
package com.psandchill.client;

import com.psandchill.model.Activity;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ActivityClientTest {

    @Test
    public void testDelete(){
        ActivityClient client = new ActivityClient();
        client.delete("1234");
    }

    @Test
    public void testPut(){
        Activity activity = new Activity();
        activity.setId(34);
        activity.setDescription("Yoga");
        activity.setDuration(90);

        ActivityClient client = new ActivityClient();

        activity = client.update(activity);

        assertNotNull(activity);
    }

    @Test
    public void testCreate(){
        ActivityClient client = new ActivityClient();
        Activity activity = new Activity();
        activity.setDescription("swimming");
        activity.setDuration(90);

        activity = client.create(activity);

        assertNotNull(activity);
    }

    @Test
    public void testGet() throws Exception {
        ActivityClient client = new ActivityClient();

        Activity activity = client.get("1");

        System.out.println(activity);

        assertNotNull(activity);
    }

    @Test
    public void testGetList(){
        ActivityClient client = new ActivityClient();

        List<Activity> activities = client.get();

        System.out.println(activities);

        assertNotNull(activities);
    }

    @Test(expected = RuntimeException.class)
    public void testGetWithBadRequest(){
        ActivityClient client = new ActivityClient();

        client.get("22");
    }

    @Test(expected = RuntimeException.class)
    public void testGetWithNotFound(){
        ActivityClient client = new ActivityClient();

        client.get("22");
    }

    @Test
    public void testSearch(){
        ActivitySearchClient activitySearchClient = new ActivitySearchClient();
        String param = "description";
        List<String> searchValues = new ArrayList<String>();
        searchValues.add("swimming");
        searchValues.add("whhhahtshdf");
        List<Activity> activities = activitySearchClient.search(param, searchValues);

        System.out.println(activities);
        assertNotNull(activities);
    }

}*/
