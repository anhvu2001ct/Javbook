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
 * @author Dang Minh Canh
 */
@WebServlet("/searchFriend")
public class SearchFriendPage extends BaseServlet {

    @Override
    protected void processGET(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/process/searchFriend/index").forward(request, response);
    }

    @Override
    protected void processPOST(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
