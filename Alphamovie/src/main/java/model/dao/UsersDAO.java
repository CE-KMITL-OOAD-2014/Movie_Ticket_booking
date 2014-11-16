/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.util.List;
import model.pojo.Users;
import model.ulti.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author TRathC
 */
public class UsersDAO {

    public static List<Users> listUser() {
        List<Users> lstusers = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Query query = session.createQuery("from Users");
            lstusers = query.list();
            session.close();
        } catch (Exception e) {
            throw e;
        }
        return lstusers;
    }

    public static Users addorupdateUser(Users user) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.saveOrUpdate(user);
            session.getTransaction().commit();
            Users useradd = (Users) session.load(Users.class, user.getUsername());
            session.close();
            return useradd;
        } catch (Exception e) {
            throw e;
        }
    }

    public static void deleteUser(Users user) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Users deleteuser = (Users) session.get(Users.class, user.getUsername());
            session.delete(deleteuser);
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            throw e;
        }
    }

    public static Users getUserbyName(String username) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Users user = (Users) session.get(Users.class, username);
            session.getTransaction().commit();
            session.close();
            return user;
        } catch (Exception e) {
            throw e;
        }
    }
}
