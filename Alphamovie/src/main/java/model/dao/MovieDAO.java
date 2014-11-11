/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.util.List;
import model.pojo.Movie;
import model.pojo.Showtime;
import model.ulti.HibernateUtil;
import org.apache.commons.codec.binary.Base64;
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
            for(Movie m:lst){
                m.setB64str();
            }
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lst;
    }

    public static Movie addMovie(Movie movie) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(movie);
            Movie movieadd = (Movie) session.load(Movie.class, movie.getMname());
            session.getTransaction().commit();
            session.close();
            return movieadd;
        } catch (Exception e) {
            throw e;
        }
    }

    public static void updateMovie(Movie movie) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(movie);
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
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
