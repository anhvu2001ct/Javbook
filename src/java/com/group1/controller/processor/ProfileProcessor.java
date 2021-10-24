/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group1.controller.processor;

import com.group1.model.Status;
import com.group1.model.dao.StatusDAO;
import com.group1.rest.BaseProcessor;
import com.group1.rest.ServeAt;
import com.group1.rest.ServeMethod;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Mr Khang
 */
@WebServlet("/process/profile/*")
public class ProfileProcessor extends BaseProcessor {

    @ServeAt("/changeItem")
    public void changeTimeline(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String value = request.getParameter("key");
        request.getRequestDispatcher("/test/nhkhang/Profile/profilepost.jsp").forward(request, response);

    }

    @ServeAt(value = "/crateStatus", method = ServeMethod.POST)
    public void serveCreateStatus(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        String content = request.getParameter("content");
        String link = request.getParameter("link");
        String audience = request.getParameter("audience");
        System.out.println(audience);
        StatusDAO.createStatus("1", "1", content, link, audience);

    }

    @ServeAt(value = "/editStatus", method = ServeMethod.POST)
    public void serveEditStatus(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        String statusId = request.getParameter("StatusId");
        StatusDAO.editStatus(statusId);

    }

    @ServeAt(value = "/getStatusUser")
    public void serveGetStatusUser(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        List<Status> status = StatusDAO.getListStatusUser("1");
        request.setAttribute("statususer", status);

    }

    @ServeAt(value = "/getAllStatus")
    public void serveGetAllStatus(HttpServletRequest request, HttpServletResponse response) throws SQLException {

        List<Status> status = StatusDAO.getListStatus();
        request.setAttribute("status", status);

    }
}
