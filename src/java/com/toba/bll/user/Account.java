package com.toba.bll.user;

import com.toba.bll.user.User;
import com.toba.business.transaction.Transaction;
import com.toba.dl.data.AccountDB;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Account implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long accountID;
    private double startBal;
    private String accountType;
    private double balance;
    private User acctOwner;
    @OneToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
      private List<Transaction> transactions;

    public Account() {
    }

    public Account(String accountType, double balance, User acctOwner) {
        this.accountID = accountID;
        this.accountType = accountType;
        this.balance = balance;
        this.acctOwner = acctOwner;
        transactions = new ArrayList<>();
    }

    public long getAccountID() {
        return accountID;
    }

    public void setAccountID(int accountID) {
        this.accountID = accountID;
    }
    

    public List<Transaction> getTransaction() {
        return transactions;
    }

    public void setTransaction(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    public double Credit(double amount) {
        return balance += amount;
    }

    public double Debit(double amount) {
        return balance -= amount;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public User getAcctOwner() {
        return this.acctOwner;
    }

    public void setAcctOwner(User acctOwner) {
        this.acctOwner = acctOwner;
    }
    
    public void saveTransaction(Transaction trans){
        transactions.add(trans);
    }

}
