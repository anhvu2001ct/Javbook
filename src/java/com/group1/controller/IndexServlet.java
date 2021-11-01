/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group1.controller;

import com.group1.misc.Secret;
import com.group1.model.HeaderNotification;
import com.group1.model.ProfileUserAbout;
import com.group1.model.dao.HeaderNotificationDAO;
import com.group1.model.dao.ProfileUserAboutDAO;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ASUS
 */
@WebServlet("")
public class IndexServlet extends BaseServlet {

    @Override
    protected void processGET(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int accountId = (int) request.getSession().getAttribute("uid");
        List<HeaderNotification> notifications = HeaderNotificationDAO.getListEmotionNotification(accountId);
        List<HeaderNotification> notificomments = HeaderNotificationDAO.getListCommentNotification(accountId);
        ProfileUserAbout userinfo = ProfileUserAboutDAO.getProfileUser(accountId);
        request.setAttribute("notificomments", notificomments);
        request.setAttribute("notifications", notifications);
        request.setAttribute("userinfo", userinfo);
        request.setAttribute("uid2", Secret.encode2(String.valueOf(accountId)));
        request.getRequestDispatcher("/client/home/homePage.jsp").forward(request, response);
    }

    @Override
    protected void processPOST(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
