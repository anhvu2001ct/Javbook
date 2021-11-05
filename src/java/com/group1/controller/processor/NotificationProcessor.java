/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group1.controller.processor;

import com.group1.misc.Secret;
import com.group1.model.dao.NotificationDAO;
import com.group1.rest.BaseProcessor;
import com.group1.rest.ServeAt;
import com.group1.rest.ServeMethod;
import java.sql.SQLException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author nhat quynh
 */
@WebServlet("/process/notification/*")
public class NotificationProcessor extends BaseProcessor {

    @ServeAt(value = "/isSeenNotification", method = ServeMethod.POST)
    public void serveIsSeenNotification(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        String notificationid = request.getParameter("notificationid");
        NotificationDAO.isSeenNotification(Integer.parseInt(notificationid));
    }

    @ServeAt(value = "/insertNotification", method = ServeMethod.POST)
    public void serveInsertNotification(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        int senderid = (int) request.getSession().getAttribute("uid");
        String emojiid = request.getParameter("emojiid");
        String reference = request.getParameter("reference");
        String statusid = request.getParameter("statusid");  
        NotificationDAO.insertNotification(String.valueOf(senderid), emojiid, reference, statusid);
    }

    @ServeAt(value = "/deleteNotification", method = ServeMethod.POST)
    public void serveDeleteNotification(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        int senderid = (int) request.getSession().getAttribute("uid");
        String emojiid = request.getParameter("emojiid");
        String reference = request.getParameter("reference");
        NotificationDAO.deleteNotification(String.valueOf(senderid), emojiid, reference);
    }

    @ServeAt(value = "/deleteAllNotificationOfStatus", method = ServeMethod.POST)
    public void serveDeleteAllNotification(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        String reference = request.getParameter("reference");
        NotificationDAO.deleteAllNotificationOfStatus(reference);
    }
    
    @ServeAt(value = "/deleteFriendRequest", method = ServeMethod.POST)
    public void serveDeleteFriendRequest(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        int receiver = (int) request.getSession().getAttribute("uid");
        String sender = Secret.decode2(request.getParameter("sender"));
        NotificationDAO.deleteFriendRequest(receiver, Integer.parseInt(sender));
    }
}
