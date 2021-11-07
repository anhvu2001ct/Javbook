/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group1.test.poiminhcanh;

import com.group1.controller.BaseServlet;
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
 * @author Dang Minh Canh
 */
@WebServlet("/test/poiminhcanh/ProfileAbout")
public class TestProfileAbout extends BaseServlet {

    @Override
    protected void processGET(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession ses = request.getSession();
        int uid = (Integer)ses.getAttribute("uid");
        System.out.println("uid: " + uid);
        ProfileUserAbout profileUser = ProfileUserAboutDAO.getProfileUser(uid);
        System.out.println(profileUser.toString());
        request.setAttribute("profileUser", profileUser);
        System.out.println("");
        request.getRequestDispatcher("/client/profile/profileAbout.jsp").include(request, response);

    }

    @Override
    protected void processPOST(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
