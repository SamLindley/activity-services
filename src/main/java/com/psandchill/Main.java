package com.psandchill;

import com.psandchill.model.Activity;
import com.psandchill.repository.ActivityRepository;
import com.psandchill.repository.ActivityRepositoryStub;
import com.psandchill.repository.HibernateUtilities;

public class Main {
    public static void main(String[] args) {
        ActivityRepository repo = new ActivityRepositoryStub();

       /* Activity activity = new Activity();
        activity.setDuration(95);
        activity.setDescription("Pool");
        repo.create(activity);*/

        Activity myActivity = repo.findActivity(1);
        System.out.println(myActivity.getDuration());
        System.exit(0);
    }
}
