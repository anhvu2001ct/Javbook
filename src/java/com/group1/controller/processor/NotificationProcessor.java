/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group1.controller.processor;

import com.group1.model.Notification;
import com.group1.model.dao.NotificationDAO;
import com.group1.rest.BaseProcessor;
import com.group1.rest.ServeAt;
import com.group1.rest.ServeMethod;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ASUS
 */
@WebServlet("/process/notification/*")
public class NotificationProcessor extends BaseProcessor {

    @ServeAt(value = "/isSeenNotification", method = ServeMethod.POST)
    public void serveIsSeenNotification(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        String notificationid = request.getParameter("notificationid");
        NotificationDAO.isSeenNotification(Integer.parseInt(notificationid));
    }
}
