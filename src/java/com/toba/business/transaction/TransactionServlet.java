package com.toba.business.transaction;

import com.toba.bll.user.Account;
import com.toba.bll.user.User;
import com.toba.dl.data.AccountDB;
import com.toba.dl.data.TransactionDB;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
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
        String url = "/transfer.jsp";
        String from = request.getParameter("from");
        String checkingFrom = request.getParameter("checkingFrom");
        String savingsFrom = request.getParameter("savingsFrom");
        String checkingTo = request.getParameter("checkingTo");
        String savingsTo = request.getParameter("savingsTo");
        String transferAmount = request.getParameter("amount");
        String message;

        double amount = Double.parseDouble(transferAmount);

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        Account checking = AccountDB.selectChkAccount(user.getUserID());
        Account savings = AccountDB.selectSavAccount(user.getUserID());
        /*Account checking = (Account) session.getAttribute("checking");
        Account savings = (Account) session.getAttribute("savings");*/

        switch (from) {
            case "Savings":
                savings.Debit(amount);
                checking.Credit(amount);
                List<Transaction> savingsList = new ArrayList<>();
                Transaction savingsTrans = new Transaction(savings, amount, "Debit");
                session.setAttribute("savingsTrans", savingsTrans);
                savingsList.add(savingsTrans);
                request.setAttribute("savingsList", savingsList);
                TransactionDB.insert(savingsTrans);
                AccountDB.update(savings);
                AccountDB.update(checking);
                url = "/account_activity.jsp";
                break;
            case "Checking":
                savings.Credit(amount);
                checking.Debit(amount);
                List<Transaction> checkingList = new ArrayList<>();
                Transaction checkingTrans = new Transaction(checking, amount, "Debit");
                session.setAttribute("checkingTrans", checkingTrans);
                checkingList.add(checkingTrans);
                request.setAttribute("checkingList", checkingList);
                TransactionDB.insert(checkingTrans);
                AccountDB.update(savings);
                AccountDB.update(checking);
                url = "/account_activity.jsp";
                break;
            default:
                message = "Please select an account to transfer.";
                break;
        }

        session.setAttribute("savings", savings);
        session.setAttribute("checking", checking);

        getServletContext()
                .getRequestDispatcher(url)
                .forward(request, response);

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
