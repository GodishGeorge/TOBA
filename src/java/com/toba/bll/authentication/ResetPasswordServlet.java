/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.toba.bll.authentication;

import com.toba.bll.user.User;
import com.toba.dl.data.UserDB;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author George
 */
public class ResetPasswordServlet extends HttpServlet {

   
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
        String userName = request.getParameter("userName");
        String oldPassword = request.getParameter("oldPassword");
        String newPassword = request.getParameter("newPassword");
        String confirmPassword = request.getParameter("confirmPassword");
        String message;
        String url;
        
        user.setPassword(newPassword);
        
        if (userName.equals(userName) && oldPassword.equals(oldPassword)) {
            if (newPassword.equals(confirmPassword)) {
                message = "Password successfully changed";
                url = "/account_activity.jsp";
                request.setAttribute("message", message);
                session.setAttribute("user", user);
                UserDB.update(user);
            } else {
                message = "Passwords do not match, please try again.";
                url = "/password_reset.jsp";
                request.setAttribute("message", message);
            }
        } else {
            message = "Please enter a valid User Name and Password.";
            url = "/password_reset.jsp";
            request.setAttribute("message", message);
        }
        getServletContext()
                .getRequestDispatcher(url)
                .forward(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
