/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.toba.dl.data;


import com.toba.business.transaction.Transaction;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;


/**
 *
 * @author George
 */
public class TransactionDB {
    
     public static void insert(Transaction transactions) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();
        try {
            em.persist(transactions);
            trans.commit();
        } catch (Exception e) {
            System.out.println(e);
            trans.rollback();
        } finally {
            em.close();
        }
    }
    
}
