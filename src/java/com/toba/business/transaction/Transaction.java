package com.toba.business.transaction;

import com.toba.bll.user.Account;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



@Entity
public class Transaction implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long tranactionID;        
    private Account startingBal;
    private double transAmount;
    private double totalBal;
    private String type;
    
    public Transaction(){
        
    }
    
    public Transaction(Account startingBal, double transAmount, String type){
        this.tranactionID = tranactionID;
        this.startingBal = startingBal;
        this.transAmount = transAmount;
        this.type = type;
    }
    
    public long getTranactionID() {
        return tranactionID;
    }

    public void setTranactionID(int tranactionID) {
        this.tranactionID = tranactionID;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Account getStartingBal() {
        return startingBal;
    }

    public void setStartingBal(Account startingBal) {
        this.startingBal = startingBal;
    }

    public double getTransAmount() {
        return transAmount;
    }

    public void setTransAmount(double transAmount) {
        this.transAmount = transAmount;
    }

    public double getTotalBal() {
        return totalBal;
    }

    public void setTotalBal(double totalBal) {
        this.totalBal = totalBal;
    }
    
}
