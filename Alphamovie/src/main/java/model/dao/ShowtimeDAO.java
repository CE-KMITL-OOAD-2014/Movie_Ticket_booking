/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.util.ArrayList;
import java.util.List;
import static model.dao.MovieDAO.listMovie;
import model.pojo.Movie;
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
        List<Showtime> lst = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Query query = session.createQuery("from Showtime");
            lst = query.list();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lst;
    }

    public static List<Showtime> listMovieinCinema(int cinema) {
        List<Showtime> lsts = listShowtime();
        List<Showtime> lstshow = new ArrayList<Showtime>();
        try {
            for (Showtime s : lsts) {
                if (s.getId().getCinema() == cinema) {
                    lstshow.add(s);
                }
            }
            return lstshow;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
     public static List<Showtime> listShowtimebyMovie(String mname) {
        List<Showtime> lsts = listShowtime();
        List<Showtime> lstshow = new ArrayList<Showtime>();
        try {
            for (Showtime s : lsts) {
                if (s.getMname().equals(mname)) {
                    lstshow.add(s);
                }
            }
            return lstshow;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    

    public static Showtime addShowtime(Showtime showtime) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(showtime);
            session.getTransaction().commit();
            Showtime showtimeadd = (Showtime) session.load(Showtime.class, showtime.getShowtime());
            session.close();
            return showtimeadd;
        } catch (Exception e) {
            throw e;
        }
    }

    public static void updateShowtime(Showtime showtime) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(showtime);
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void deleteShowtime(Showtime showtime) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.getTransaction();
            Showtime dshowtime = (Showtime) session.load(Showtime.class, showtime.getShowtime());
            session.delete(dshowtime);
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Showtime getShowtimebyId(String time, int cinema) {
        ShowtimeId id = new ShowtimeId(time, cinema);
        try {
            List<Showtime> lst = listShowtime();
            for (Showtime s : lst) {
                ShowtimeId id1 = s.getId();
                if (id.equals(id1)) {
                    return s;
                }
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
