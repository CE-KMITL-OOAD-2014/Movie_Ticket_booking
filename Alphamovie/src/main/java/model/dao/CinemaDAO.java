/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.util.List;
import model.pojo.Cinema;
import model.ulti.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Art
 */
public class CinemaDAO {
    public static List<Cinema> listCinema() {
        List<Cinema> lst = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
                Query query = session.createQuery("from Cinema");
            lst = query.list();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lst;
    }

    public static Cinema addCinema(Cinema cinema) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(cinema);
            session.getTransaction().commit();
            Cinema cinemaadd = (Cinema) session.load(Cinema.class, cinema.getCinema());
            session.close();
            return cinemaadd;
        } catch (Exception e) {
            throw e;
        }
    }

    public static void updateCinema(Cinema cinema) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(cinema);
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void deleteCinema(Cinema cinema) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.getTransaction();
            Cinema dcinema = (Cinema) session.load(Cinema.class, cinema.getCinema());
            session.delete(dcinema);
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Cinema getCinemabyNum(int cinema) {
        try {
            List<Cinema> lst = listCinema();
            for(Cinema  c : lst){
                if(c.getCinema()== (cinema))return c;
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
