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
        List<ReviewRating> lstreviewrating = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Query query = session.createQuery("from ReviewRating");
            lstreviewrating = query.list();
            session.close();
        } catch (Exception e) {
            throw e;
        }
        return lstreviewrating;
    }

    public static List<ReviewRating> listReviewRatingbyMovie(String mname) {
        List<ReviewRating> lstreviewrating = listReviewRating();
        List<ReviewRating> lstreviewratinginmovie = new ArrayList<ReviewRating>();
        try {
            for (ReviewRating reviewrating : lstreviewrating) {
                if (reviewrating.getMname().equals(mname)) {
                    lstreviewratinginmovie.add(reviewrating);
                }
            }
            return lstreviewratinginmovie;
        } catch (Exception e) {
            throw e;
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
            session.beginTransaction();
            ReviewRating deletereviewrating = (ReviewRating) session.get(ReviewRating.class, reviewrating.getId());
            session.delete(deletereviewrating);
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            throw e;
        }
    }

    public static void deleteReviewRatingbyMovie(String mname) {
        try {
            List<ReviewRating> lstreviewrating = listReviewRating();
            for (ReviewRating reviewrating : lstreviewrating) {
                if (mname.equals(reviewrating.getMname())) {
                    deleteReviewRating(reviewrating);
                }
            }
        } catch (Exception e) {
            throw e;
        }
    }
}
