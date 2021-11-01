/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group1.controller.processor;

import com.group1.model.HeaderNotification;
import com.group1.model.dao.HeaderNotificationDAO;
import com.group1.rest.BaseProcessor;
import com.group1.rest.ServeAt;
import com.group1.rest.ServeMethod;
import java.io.IOException;
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
//
//    @ServeAt(value = "/header", method = ServeMethod.GET)
//    public void serveHeaderNotification(HttpServletRequest request, HttpServletResponse response) {
//        try {
//
//            int accountId = (int) request.getSession().getAttribute("uid");
//            List<HeaderNotification> notifications = HeaderNotificationDAO.getListEmotionNotification(accountId);
//            request.setAttribute("notifications", notifications);
//            request.getRequestDispatcher("/client/common/header.jsp").forward(request, response);
//
//        } catch (ServletException ex) {
//            Logger.getLogger(NotificationProcessor.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (IOException ex) {
//            Logger.getLogger(NotificationProcessor.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
//    }
}
