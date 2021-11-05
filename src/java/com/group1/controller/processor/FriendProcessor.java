/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group1.controller.processor;

import com.group1.misc.Secret;
import com.group1.model.dao.FriendDAO;
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
@WebServlet("/process/friend/*")
public class FriendProcessor  extends BaseProcessor {
    @ServeAt(value = "/insertFriend", method = ServeMethod.POST)
    public void serveInsertFriend(HttpServletRequest request, HttpServletResponse response) throws SQLException {
         int A = (int) request.getSession().getAttribute("uid");
        String B = Secret.decode2(request.getParameter("B"));
        FriendDAO.insertFriend(A, Integer.parseInt(B));
    }
    
}