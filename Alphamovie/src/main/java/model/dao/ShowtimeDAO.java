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
            Showtime dshowtime = (Showtime) session.get(Showtime.class, showtime.getId());
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
    
     public static Showtime deleteShowtimebyMovie(String mname) {
         Showtime showtime = new Showtime();
        try {
            
            List<Showtime> lsts = listShowtime();
            for(Showtime s : lsts){
                if(mname.equals(s.getMname())){
                    deleteShowtime(s);
                    showtime = s;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return showtime;
    }
}
