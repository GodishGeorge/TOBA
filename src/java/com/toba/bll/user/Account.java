package com.toba.bll.user;

import com.toba.bll.user.User;
import com.toba.business.transaction.transaction;
import com.toba.dl.data.AccountDB;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

public class Account {

    private String accountType;
    private double startingBal;
    private User user;
    @OneToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
      private List<transaction> transactions;

    public Account() {
        accountType = "";
        startingBal = 0.0;
        user = new User();
    }

    public Account(String accountType, double startingBal, User acctOwner) {
        this.accountType = accountType;
        this.startingBal = startingBal;
        this.user = acctOwner;
        transactions = new ArrayList<>();
    }

    public List<transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<transaction> transactions) {
        this.transactions = transactions;
    }

    public double Credit(double amount) {
        startingBal = startingBal + amount;
        return startingBal;
    }

    public double Debit(double amount) {
        startingBal = startingBal - amount;
        return startingBal;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public double getStartingBal() {
        return startingBal;
    }

    public void setStartingBal(double startingBal) {
        this.startingBal = startingBal;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    
    public void saveTransactions(transaction trans){
        transactions.add(trans);
    }

}
