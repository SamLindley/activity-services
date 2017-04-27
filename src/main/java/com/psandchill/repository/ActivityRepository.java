package com.psandchill.repository;

import com.psandchill.model.Activity;

import java.util.List;

public interface ActivityRepository {
    List<Activity> findAllActivities();

    Activity findActivity(int activityId);

    void create(Activity activity);

    Activity update(Activity activity);

    void delete(String activityId);

    List<Activity> findByDescription(List<String> descriptions);
}
