/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.util.ArrayList;
import java.util.List;
import model.pojo.Seat;
import model.pojo.SeatId;
import model.ulti.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Art
 */
public class SeatDAO {

    public static List<Seat> listSeat() {
        List<Seat> lstseat = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Query query = session.createQuery("from Seat");
            lstseat = query.list();
            session.close();
        } catch (Exception e) {
            throw e;
        }
        return lstseat;
    }

    public static List<Seat> listSeatbyShowtime(String time, int cinema) {
        List<Seat> lstseat = listSeat();
        List<Seat> lstseatinshowtime = new ArrayList<Seat>();
        try {
            for (Seat seat : lstseat) {
                if (cinema == seat.getId().getCinema() && time.equals(seat.getId().getTime())) {
                    lstseatinshowtime.add(seat);
                }
            }
            return lstseatinshowtime;
        } catch (Exception e) {
            throw e;
        }
    }

    public static Seat addorupdateSeat(Seat seat) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.saveOrUpdate(seat);
            Seat seatadd = (Seat) session.load(Seat.class, seat.getId());
            session.getTransaction().commit();
            session.close();
            return seatadd;
        } catch (Exception e) {
            throw e;
        }
    }

    public static void deleteSeat(Seat seat) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Seat deleteseat = (Seat) session.get(Seat.class, seat.getId());
            session.delete(deleteseat);
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            throw e;
        }
    }

    public static Seat getSeatbyId(String time, int cinema, String seatname) {
        SeatId id = new SeatId(time, cinema, seatname);
        try {
            List<Seat> lstseat = listSeat();
            for (Seat seat : lstseat) {
                SeatId id1 = seat.getId();
                if (id.equals(id1)) {
                    return seat;
                }
            }
            return null;
        } catch (Exception e) {
            throw e;
        }
    }

    public static void deleteSeatbyShowtime(String time) {
        try {
            List<Seat> lstseat = listSeat();
            for (Seat seat : lstseat) {
                if (time.equals(seat.getId().getTime())) {
                    deleteSeat(seat);
                }
            }
        } catch (Exception e) {
            throw e;
        }
    }
}
