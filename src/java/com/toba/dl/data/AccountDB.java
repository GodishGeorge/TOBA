package com.toba.dl.data;

import com.toba.bll.user.Account;
import com.toba.bll.user.User;
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

    public static Account selectAccount(User user, String account) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        String qString = "SELECT u FROM account_type u "
                + "WHERE u.user = :UserID AND u.account_type = :AccountType";
        TypedQuery<Account> q = em.createQuery(qString, Account.class);
        q.setParameter("UserID", user);
        q.setParameter("AccountType", account);
        try {
            Account accnt = q.getSingleResult();
            return accnt;
        } catch (NoResultException e) {
            return null;
        } finally {
            em.close();
        }
    }
}
