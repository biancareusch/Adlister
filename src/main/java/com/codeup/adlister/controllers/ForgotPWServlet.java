package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.User;
import com.codeup.adlister.util.Password;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "controllers.ForgotPWServlet", urlPatterns = "/forgotpassword")
public class ForgotPWServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/forgot_password.jsp").forward(request, response);
	}
/*
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String email = request.getParameter("email");
		*//*String securityQuestionQ = request.getParameter("securityQuestionQ"); securityQuestionQ = null need value
		String securityQuestionA = request.getParameter("securityQuestionA");*//*
		String newPassword = request.getParameter("new_password");
		String newPasswordConfirmation = request.getParameter("confirm_new_password");


		User user = DaoFactory.getUsersDao().findByUsername(username);
		boolean inputHasError = email.equals(user.getEmail())
*//*		                     || securityQuestionQ.equals(user.getSecurityQuestionQ())
		                       || securityQuestionA.equals(user.getSecurityQuestionA())*//*
						|| newPassword.equals(newPasswordConfirmation);
		boolean duplicatePw = Password.check(newPassword, user.getPassword());


		if (duplicatePw || !inputHasError) {
			response.sendRedirect("/forgotpassword");
			return;
		}
		user.setPassword(newPassword);
		response.sendRedirect("/login");
	}*/
}