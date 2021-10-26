/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group1.controller;

import com.group1.model.Status;
import com.group1.model.dao.StatusDAO;
import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Mr Khang
 */
@WebServlet("/profile")
public class ProfileServlet extends BaseServlet {

    @Override
    protected void processGET(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int accountId = (int) request.getSession().getAttribute("uid");
        List<Status> status = StatusDAO.getListStatusUser(accountId);
        if (status != null) {
            Collections.sort(status, new Comparator<Status>() {
                @Override
                public int compare(Status a, Status b) {
                    return b.getStatusId() - a.getStatusId();
                }
            });
            System.out.println(status.size());
        }

        request.setAttribute("statusUser", status);
        request.getRequestDispatcher("/client/profile/profile.jsp").forward(request, response);
    }

    @Override
    protected void processPOST(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
