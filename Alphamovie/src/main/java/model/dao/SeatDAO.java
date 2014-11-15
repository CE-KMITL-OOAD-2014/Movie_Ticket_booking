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
        List<Seat> lst = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Query query = session.createQuery("from Seat");
            lst = query.list();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lst;
    }
    
    public static List<Seat> listSeatbyShowtime(String time, int c) {
        List<Seat> lsts = listSeat();
        List<Seat> lstshow = new ArrayList<Seat>();
        try {
            for (Seat s : lsts) {
                if (c == s.getId().getCinema() && time.equals(s.getId().getTime())) {
                    lstshow.add(s);
                }
            }
            return lstshow;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
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
            Seat dseat = (Seat) session.get(Seat.class, seat.getId());
            session.delete(dseat);
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Seat getSeatbyId(String time, int cinema,String seat) {
        SeatId id = new SeatId(time, cinema,seat);
        try {
            List<Seat> lst = listSeat();
            for (Seat s : lst) {
                SeatId id1 = s.getId();
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
    
    public static void deleteSeatbyShowtime(String time) {
        try {
            List<Seat> lsts = listSeat();
            for(Seat s : lsts){
                if(time.equals(s.getId().getTime())){
                    deleteSeat(s);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
