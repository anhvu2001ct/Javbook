/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group1.controller;

import com.group1.misc.PathInfo;
import com.group1.misc.Secret;
import com.group1.model.ProfileUserAbout;
import com.group1.model.dao.ProfileUserAboutDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Mr Khang
 */
@WebServlet("/profile/*")
public class ProfileServlet extends BaseServlet {

    @Override
    protected void processGET(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession ses = request.getSession();
        int uid = (Integer) ses.getAttribute("uid");

        ProfileUserAbout profileUser = ProfileUserAboutDAO.getProfileUser(uid);

        request.setAttribute("profileUser", profileUser);

        PathInfo path = (PathInfo) request.getAttribute("pathInfo");
        IndexServlet.setInfoHeader(request);
        String curID = Secret.decode2(path.path[0]);
        if (curID.equals(String.valueOf(uid))) {
            request.getRequestDispatcher("/client/profile/profile.jsp").forward(request, response);
        } else {

        }

        request.setAttribute("profileUser", profileUser);
        request.getRequestDispatcher("/client/profile/profile.jsp").forward(request, response);

    }

    @Override
    protected void processPOST(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
