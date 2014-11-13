/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.util.ArrayList;
import java.util.List;
import static model.dao.ShowtimeDAO.listShowtime;
import model.pojo.Cinema;
import model.pojo.Movie;
import model.pojo.Showtime;
import model.ulti.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author TRathC
 */
public class MovieDAO {

    public static List<Movie> listMovie() {
        List<Movie> lst = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Query query = session.createQuery("from Movie");
            lst = query.list();
            for (Movie m : lst) {
                m.setB64str();
            }
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lst;
    }

    public static List<Showtime> listShowtimeinMovie(String mname, int c) {
        List<Showtime> lsts = listShowtime();
        List<Showtime> lstshow = new ArrayList<Showtime>();
        try {
            for (Showtime s : lsts) {
                if (c == s.getId().getCinema() && mname.equals(s.getMname())) {
                    lstshow.add(s);
                }
            }
            return lstshow;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Movie addorupdateMovie(Movie movie) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.saveOrUpdate(movie);
            Movie movieadd = (Movie) session.load(Movie.class, movie.getMname());
            session.getTransaction().commit();
            session.close();
            return movieadd;
        } catch (Exception e) {
            throw e;
        }
    }

    public static void deleteMovie(Movie movie) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.getTransaction();
            Movie dmovie = (Movie) session.load(Movie.class, movie.getMname());
            session.delete(dmovie);
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Movie getMoviebyName(String mname) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Movie movie = (Movie) session.get(Movie.class, mname);
            session.getTransaction().commit();
            session.close();
            movie.setB64str();
            return movie;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
