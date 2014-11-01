/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;
import java.io.Serializable;
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
        List<Users> lst = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            String hql = "from Users";
            Query query = session.createQuery(hql);
            lst = query.list();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lst;
    }

    public static String addUser(Users user){
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(user);
            session.getTransaction().commit();
            Users useradd = (Users) session.load(Users.class, user.getUsername());
            session.close();
            return useradd.getUsername();
        } catch (Exception e) {
            throw e;
        }
    }

    public static String updateUser(Users user) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(user);
            session.getTransaction().commit();
            session.close();
            return "User Update!";
        } catch (Exception e) {
            throw e;
        }
    }
    
    public static void deleteUser(Users user){
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Users duser = (Users) session.load(Users.class, user.getUsername());
            session.delete(duser);
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static Users getMoviebyName(String username) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.getTransaction();
            Users user = (Users) session.load(Users.class, username);
            session.getTransaction().commit();
            session.close();
            return user;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
