package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
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
public class addUserPictureServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//        request.getSession().getAttribute("userPic");
//        request.setAttribute("userPic", DaoFactory.getGetUserPicDao().findByPicUserID(1).getImgURL());
//
//        System.out.println("DaoFactory.getGetUserPicDao().findByPicUserID(1).getImage = " + DaoFactory.getGetUserPicDao().findByPicUserID(1).getImgURL());
//        request.getRequestDispatcher("/WEB-INF/profile.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }
}