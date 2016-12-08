package com.toba.dl.data;

import com.toba.bll.user.Account;
import com.toba.bll.user.User;
import com.toba.business.transaction.Transaction;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

public class AccountDB {

    public static void insert(Account account) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();
        try {
            em.persist(account);
            trans.commit();
        } catch (Exception e) {
            System.out.println(e);
            trans.rollback();
        } finally {
            em.close();
        }
    }
    
    public static void update(Account account) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();
        try {
            em.merge(account);
            trans.commit();
        } catch (Exception e) {
            System.out.println(e);
            trans.rollback();
        } finally {
            em.close();
        }
    }
    
     public static Account selectSavAccount(long UserID) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        String query = "SELECT a FROM Account a " +
                "WHERE a.acctOwner.userID = :userID and a.accountType = 'Savings'";
        
        TypedQuery<Account> q = em.createQuery(query, Account.class);
        q.setParameter("userID", UserID);
        
        try {
            Account savInfo = q.getSingleResult();
            return savInfo;
        }
        catch (NoResultException e) {
            return null;
        }
        finally {
            em.close();
        }
        
    }

    public static Account selectChkAccount(long UserID) {
        
      
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        String query = "SELECT a FROM Account a " +
                "WHERE a.acctOwner.userID = :userID and a.accountType = 'Checking'";
        
        TypedQuery<Account> q = em.createQuery(query, Account.class);
        q.setParameter("userID", UserID);
        
        try {
            Account savInfo = q.getSingleResult();
            return savInfo;
        }
        catch (NoResultException e) {
            return null;
        }
        finally {
            em.close();
        }
        
    }
    
   
}
