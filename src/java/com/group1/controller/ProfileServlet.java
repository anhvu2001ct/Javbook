/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group1.controller;

import com.group1.misc.PathInfo;
import com.group1.misc.Secret;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Mr Khang
 */
@WebServlet("/profile/*")
public class ProfileServlet extends BaseServlet {

    @Override
    protected void processGET(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int userId = (int) request.getSession().getAttribute("uid");
        PathInfo path = (PathInfo) request.getAttribute("pathInfo");
        if (Secret.decode2(path.path[0]).equals(String.valueOf(userId))) {
            request.getRequestDispatcher("/client/profile/profile.jsp").forward(request, response);
        } else {

        }

    }

    @Override
    protected void processPOST(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
