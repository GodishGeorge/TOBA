package com.toba.business.transaction;

import com.toba.bll.user.Account;
import com.toba.bll.user.User;
import com.toba.dl.data.AccountDB;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class TransactionServlet extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }
  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        String amount = request.getParameter("amount");
        String checkingFrom = request.getParameter("checking1");
        String savingsFrom = request.getParameter("savings1");
        String checkingTo = request.getParameter("checking2");
        String savingsTo = request.getParameter("savings2");
        String message;
      
                
        Account checking = AccountDB.selectAccount(user, "checking");
        Account savings = AccountDB.selectAccount(user, "savings");
        
        double checkingBal = checking.getStartingBal();
        double savingsBal = savings.getStartingBal();
        
        if(checkingFrom != null && savingsTo != null){
            checking.Debit(Double.parseDouble(amount));
            savings.Credit(Double.parseDouble(amount));
            transaction trans = new transaction(savings, 
                    Double.parseDouble(amount), savingsBal, "Savings");
            savings.saveTransactions(trans);
        } else if(savingsFrom != null && checkingTo != null){
            savings.Debit(Double.parseDouble(amount));
            checking.Credit(Double.parseDouble(amount));
            transaction trans = new transaction(checking, 
                    Double.parseDouble(amount), checkingBal, "Checking");
            checking.saveTransactions(trans);
        }else{
            message = "Please checks account to be transfered.";
        }
        
        AccountDB.update(savings);
        AccountDB.update(checking);
        
        session.setAttribute("checking", checking);
        session.setAttribute("Savings", savings);
        
       getServletContext()
               .getRequestDispatcher("/account_activity.jsp")
               .forward(request, response);
    }

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
