package com.psandchill.repository;

import com.psandchill.model.Activity;
import com.psandchill.model.User;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

public class ActivityRepositoryStub implements ActivityRepository {

    @Override
    public List<Activity> findAllActivities(){


        Session session = HibernateUtilities.getSessionFactory().openSession();
        session.beginTransaction();
        Query query = session.createQuery("from Activity");
        List<Activity> activities = query.list();
        session.getTransaction().commit();
        session.close();

        return activities;
    }

    @Override
    public Activity findActivity(int activityId) {

        Session session = HibernateUtilities.getSessionFactory().openSession();
        session.beginTransaction();
        Activity activity = (Activity) session.get(Activity.class, activityId);
        session.getTransaction().commit();
        session.close();
        return activity;
    }

    @Override
    public void create(Activity activity) {
        Session session = HibernateUtilities.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(activity);
        session.getTransaction().commit();
        session.close();

    }

    @Override
    public Activity update(Activity activity) {
        //should update DB entry, or add if ID does not exist

        return activity;
    }

    @Override
    public void delete(String activityId) {
        //delete from avtivity where avtivityid=?
    }

    @Override
    public List<Activity> findByDescription(List<String> descriptions) {
        //select * from activity where description in (???)

        List<Activity> activities = new ArrayList<Activity>();

        Activity activity = new Activity();
        activity.setDescription("Jumping around the house");
        activity.setDuration(100);

        Activity activity1 = new Activity();
        activity1.setDescription("Hopping over cats");
        activity1.setDuration(200);
        activities.add(activity1);
        activities.add(activity);

        return activities;
    }

}
