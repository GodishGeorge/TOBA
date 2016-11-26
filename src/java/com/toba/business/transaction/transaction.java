package com.toba.business.transaction;

import com.toba.bll.user.Account;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



@Entity
public class transaction implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Account startingBal;
    double transAmount;
    double totalBal;
    String type;
    
    public transaction(){
        
    }
    
    public transaction(Account startingBal, double transAmount, double totalBal, 
            String type){
        this.startingBal = startingBal;
        this.transAmount = transAmount;
        this.totalBal = totalBal;
        this.type = type;
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
