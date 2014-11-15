/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.util.ArrayList;
import java.util.List;
import model.pojo.ReviewRating;
import model.ulti.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Art
 */
public class ReviewRatingDAO {

    public static List<ReviewRating> listReviewRating() {
        List<ReviewRating> lst = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Query query = session.createQuery("from ReviewRating");
            lst = query.list();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lst;
    }

    public static List<ReviewRating> listReviewRatingbyMovie(String mname) {
        List<ReviewRating> lstr = listReviewRating();
        List<ReviewRating> lstshow = new ArrayList<ReviewRating>();
        try {
            for (ReviewRating r : lstr) {
                if (r.getMname().equals(mname)) {
                    lstshow.add(r);
                }
            }
            return lstshow;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static ReviewRating addReviewRating(ReviewRating reviewrating) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.saveOrUpdate(reviewrating);
            session.getTransaction().commit();
            ReviewRating reviewratingadd = (ReviewRating) session.load(ReviewRating.class, reviewrating.getId());
            session.close();
            return reviewratingadd;
        } catch (Exception e) {
            throw e;
        }
    }

    public static void deleteReviewRating(ReviewRating reviewrating) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.getTransaction();
            ReviewRating dreviewrating = (ReviewRating) session.load(ReviewRating.class, reviewrating.getId());
            session.delete(dreviewrating);
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
