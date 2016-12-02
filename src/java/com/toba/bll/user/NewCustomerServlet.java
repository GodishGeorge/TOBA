package com.toba.bll.user;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.toba.bll.user.User;
import com.toba.dl.data.AccountDB;
import com.toba.dl.data.UserDB;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns = {"/NewCustomerServlet"})
public class NewCustomerServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url = "/new_customer.jsp";

        HttpSession session = request.getSession();

        String action = request.getParameter("action");
        if (action == null) {
            action = "join";
        }

        if (action.equals("join")) {
            url = "/success.jsp";
        } else if (action.equals("add")) {
            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            String phone = request.getParameter("phone");
            String address = request.getParameter("address");
            String city = request.getParameter("city");
            String state = request.getParameter("state");
            String zipcode = request.getParameter("zipcode");
            String email = request.getParameter("email");
            String userName = lastName + zipcode;
            String password = "welcome1";

            User user = new User(firstName, lastName, phone, address, city,
                    state, zipcode, email, userName, password);

            Account checking = new Account("checking", 0.0, user);
            Account savings = new Account("savings", 25.00, user);

            String message;
            if (firstName == null || firstName.isEmpty()
                    || lastName == null || lastName.isEmpty()
                    || phone == null || phone.isEmpty()
                    || address == null || address.isEmpty()
                    || city == null || city.isEmpty()
                    || state == null || state.isEmpty()
                    || zipcode == null || zipcode.isEmpty()
                    || email == null || email.isEmpty()) {
                message = "Please fill out all the form fields.";
                url = "/new_customer.jsp";
                request.setAttribute("message", message);
            } else {
                message = "";
                url = "/success.jsp";
                UserDB.insert(user);
                AccountDB.insert(checking);
                AccountDB.insert(savings);
            }
            session.setAttribute("user", user);

            session.setAttribute("message", message);
            session.setAttribute("fName", firstName);
            session.setAttribute("lName", lastName);
            session.setAttribute("eMail", email);
            session.setAttribute("phone", phone);
            session.setAttribute("address", address);
            session.setAttribute("city", city);
            session.setAttribute("state", state);
            session.setAttribute("zip", zipcode);

        }
        getServletContext()
                .getRequestDispatcher(url)
                .forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
