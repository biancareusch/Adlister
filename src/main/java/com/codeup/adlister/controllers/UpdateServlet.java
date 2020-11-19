package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

    @WebServlet(name = "controllers.UpdateServlet", urlPatterns = "/update")
    public class UpdateServlet extends HttpServlet{
        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            request.getRequestDispatcher("/WEB-INF/update.jsp").forward(request, response);
            User currentUser = (User) request.getSession().getAttribute("user");
        }

        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
            User currentUser = (User) request.getSession().getAttribute("user");

            String username = request.getParameter("username");
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            String passwordConfirmation = request.getParameter("confirm_password");
            String firstName = request.getParameter("first_name");
            String lastName = request.getParameter("last_name");
            HttpSession session = request.getSession();
            long userID = (long) session.getAttribute("userID");


            boolean inputHasErrors = username.isEmpty()
                    || email.isEmpty()
                    || password.isEmpty()
                    || (! password.equals(passwordConfirmation));

            if (inputHasErrors) {
                response.sendRedirect("/update");
                return;
            }

            // create and save a new user
            User user = new User(userID, username, email, password, firstName, lastName);
            DaoFactory.getUsersDao().update(user);
            response.sendRedirect("/profile");
        }
    }
