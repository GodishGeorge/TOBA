package com.toba.dl.data;

import com.toba.bll.user.User;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

public class UserDB {

    public static void insert(User user) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();
        try {
            em.persist(user);
            trans.commit();
        } catch (Exception e) {
            System.out.println(e);
            trans.rollback();
        } finally {
            em.close();
        }
    }

    public static void update(User user) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();
        try {
            em.merge(user);
            trans.commit();
        } catch (Exception e) {
            System.out.println(e);
            trans.rollback();
        } finally {
            em.close();
        }
    }

    public static void delete(User user) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();
        try {
            em.remove(em.merge(user));
            trans.commit();
        } catch (Exception e) {
            System.out.println(e);
            trans.rollback();
        } finally {
            em.close();
        }
    }

    public static User selectUser(String email) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        String qString = "SELECT u FROM User u "
                + "WHERE u.email = :email";
        TypedQuery<User> q = em.createQuery(qString, User.class);
        q.setParameter("email", email);
        try {
            User user = q.getSingleResult();
            return user;
        } catch (NoResultException e) {
            return null;
        } finally {
            em.close();
        }
    }

      public static List<User> selectUserMonthReport(String regiDate) {
        
        //
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        String query = "SELECT u FROM User u " +
                "WHERE u.regiDate = :REGIDATE";
        
        TypedQuery<User> q = em.createQuery(query, User.class);
        q.setParameter("REGIDATE", regiDate);
        
        List<User> userReport;
        
        try {
            userReport = q.getResultList();
            
            if(userReport == null || userReport.isEmpty())
                userReport = null;
        }
        finally {
            em.close();
        }
        
        return userReport;
      }
      
    public static boolean emailExists(String email) {
        User u = selectUser(email);
        return u != null;
    }

  
}
