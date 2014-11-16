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
        List<Movie> lstmovie = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Query query = session.createQuery("from Movie");
            lstmovie = query.list();
            for (Movie movie : lstmovie) {
                movie.setB64str();
            }
            session.close();
        } catch (Exception e) {
            throw e;
        }
        return lstmovie;
    }

    public static List<Showtime> listShowtimeinMovie(String mname, int cinema) {
        List<Showtime> lstshowtime = listShowtime();
        List<Showtime> lstshowtimeinmovie = new ArrayList<Showtime>();
        try {
            for (Showtime showtime : lstshowtime) {
                if (cinema == showtime.getId().getCinema() && mname.equals(showtime.getMname())) {
                    lstshowtimeinmovie.add(showtime);
                }
            }
            return lstshowtimeinmovie;
        } catch (Exception e) {
            throw e;
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

    public static void deleteMovie(String mname) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Movie deletemovie = (Movie) session.get(Movie.class, mname);
            session.delete(deletemovie);
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            throw e;
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
            throw e;
        }
    }
}
