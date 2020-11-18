package com.codeup.adlister.controllers;

import com.codeup.adlister.models.UserPicture;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.sql.Blob;

@WebServlet(name = "UploadServlet")
public class UploadServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/profile.jsp").forward(request, response);
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        Boolean isMultipart = request.getParameter("multipart");
//        String filePath = request.getParameter("filePath");
//        Image file = request.getParameter("file");


//        UserPicture userPic = new UserPicture(isMultipart, filePath, (Blob) file);

    }
}