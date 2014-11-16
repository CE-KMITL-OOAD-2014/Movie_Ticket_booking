/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.util.List;
import model.pojo.Showtime;
import model.pojo.ShowtimeId;
import model.ulti.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Art
 */
public class ShowtimeDAO {

    public static List<Showtime> listShowtime() {
        List<Showtime> lstshowtime = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Query query = session.createQuery("from Showtime");
            lstshowtime = query.list();
            session.close();
        } catch (Exception e) {
            throw e;
        }
        return lstshowtime;
    }

    public static Showtime addorupdateShowtime(Showtime showtime) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.saveOrUpdate(showtime);
            Showtime showtimeadd = (Showtime) session.load(Showtime.class, showtime.getId());
            session.getTransaction().commit();
            session.close();
            return showtimeadd;
        } catch (Exception e) {
            throw e;
        }
    }

    public static void deleteShowtime(Showtime showtime) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Showtime deleteshowtime = (Showtime) session.get(Showtime.class, showtime.getId());
            session.delete(deleteshowtime);
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            throw e;
        }
    }

    public static Showtime getShowtimebyId(String time, int cinema) {
        ShowtimeId id = new ShowtimeId(time, cinema);
        try {
            List<Showtime> lstshowtime = listShowtime();
            for (Showtime showtime : lstshowtime) {
                ShowtimeId id1 = showtime.getId();
                if (id.equals(id1)) {
                    return showtime;
                }
            }
            return null;
        } catch (Exception e) {
            throw e;
        }
    }

    public static Showtime deleteShowtimebyMovie(String mname) {
        Showtime showtimeinmovie = new Showtime();
        try {

            List<Showtime> lstshowtime = listShowtime();
            for (Showtime showtime : lstshowtime) {
                if (mname.equals(showtime.getMname())) {
                    deleteShowtime(showtime);
                    showtimeinmovie = showtime;
                }
            }
        } catch (Exception e) {
            throw e;
        }
        return showtimeinmovie;
    }
}
