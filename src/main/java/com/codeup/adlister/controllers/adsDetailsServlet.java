package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.Ads;
import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.Ad;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "adsDetailsServlet.java", urlPatterns = "/ads/detail")
public class adsDetailsServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        checks for logged in user
//        if (request.getSession().getAttribute("user") == null) {
//            response.sendRedirect("/login");
//            return;
//        }


        System.out.println("request.getAttribute(\"adID\") = " + request.getAttribute("adID"));
        Ads adsDao = DaoFactory.getAdsDao();
//        String adIDString = request.getParameter("adID");
//        Long adID = Long.parseLong(adIDString);
        Ad foundAD = adsDao.findAd((long) 5);

        request.setAttribute("ad",foundAD);
        request.getRequestDispatcher("/WEB-INF/ads/adsDetail.jsp")
                .forward(request, response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }
}
