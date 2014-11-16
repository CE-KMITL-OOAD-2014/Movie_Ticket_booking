/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.util.ArrayList;
import java.util.List;
import model.pojo.Cinema;
import model.pojo.Movie;
import model.pojo.Showtime;
import model.ulti.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Art
 */
public class CinemaDAO {

    public static List<Cinema> listCinema() {
        List<Cinema> lstcinema = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Query query = session.createQuery("from Cinema");
            lstcinema = query.list();
            session.close();
        } catch (Exception e) {
            throw e;
        }
        return lstcinema;
    }

    public static List<Movie> listMovieinCinema(int cinema) {
        List<Showtime> lstshowtime = ShowtimeDAO.listShowtime();
        List<String> lstmname = new ArrayList<String>();
        List<Movie> lstmovie = new ArrayList<Movie>();
        try {
            for (Showtime showtime : lstshowtime) {
                if (!lstmname.contains(showtime.getMname()) && showtime.getId().getCinema() == cinema) {
                    lstmname.add(showtime.getMname());
                }
            }
            for (String mname : lstmname) {
                Movie movie = MovieDAO.getMoviebyName(mname);
                lstmovie.add(movie);
            }
            return lstmovie;
        } catch (Exception e) {
            throw e;
        }
    }

    public static List<Showtime> listShowtimeinCinema(int cinema) {
        List<Showtime> lstshowtime = ShowtimeDAO.listShowtime();
        List<Showtime> lstshowtimeincinema = new ArrayList<Showtime>();
        try {
            for (Showtime showtime : lstshowtime) {
                if (showtime.getId().getCinema() == cinema) {
                    lstshowtimeincinema.add(showtime);
                }
            }
            return lstshowtimeincinema;
        } catch (Exception e) {
            throw e;
        }
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
            throw e;
        }
    }

    public static void deleteCinema(Cinema cinema) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.getTransaction();
            Cinema deletecinema = (Cinema) session.load(Cinema.class, cinema.getCinema());
            session.delete(deletecinema);
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            throw e;
        }
    }

    public static Cinema getCinemabyNum(int cinema) {
        try {
            List<Cinema> lstcinema = listCinema();
            for (Cinema cinemacheck : lstcinema) {
                if (cinemacheck.getCinema() == (cinema)) {
                    return cinemacheck;
                }
            }
            return null;
        } catch (Exception e) {
            throw e;
        }
    }
}
