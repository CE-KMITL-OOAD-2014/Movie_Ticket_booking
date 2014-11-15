/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.util.List;
import model.pojo.Code;
import model.ulti.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Art
 */
public class CodeDAO {
    
    public static List<Code> listCode() {
        List<Code> lst = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Query query = session.createQuery("from Code");
            lst = query.list();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lst;
    }

    public static Code addorupdateCode(Code code){
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.saveOrUpdate(code);
            session.getTransaction().commit();
            Code codeadd = (Code) session.load(Code.class, code.getCode());
            session.close();
            return codeadd;
        } catch (Exception e) {
            throw e;
        }
    }
    
    public static void deleteCode(Code code){
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Code dcode = (Code) session.get(Code.class, code.getCode());
            session.delete(dcode);
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static Code getCodebyName(String codename) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Code code = (Code) session.get(Code.class, codename);
            session.getTransaction().commit();
            session.close();
            return code;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public static void deleteCodebyMovie(String mname) {
        try {
            List<Code> lstc = listCode();
            for(Code c : lstc){
                if(mname.equals(c.getMname())){
                    deleteCode(c);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
