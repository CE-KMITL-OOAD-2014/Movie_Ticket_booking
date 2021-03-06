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
        List<Code> lstcode = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Query query = session.createQuery("from Code");
            lstcode = query.list();
            session.close();
        } catch (Exception e) {
            throw e;
        }
        return lstcode;
    }

    public static Code addorupdateCode(Code code) {
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

    public static void deleteCode(Code code) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Code deletecode = (Code) session.get(Code.class, code.getCode());
            session.delete(deletecode);
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            throw e;
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
            return null;
        }
    }

    public static void deleteCodebyMovie(String mname) {
        try {
            List<Code> lstcode = listCode();
            for (Code code : lstcode) {
                if (mname.equals(code.getMname())) {
                    deleteCode(code);
                }
            }
        } catch (Exception e) {
            throw e;
        }
    }
}
