/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group1.controller.processor;

import com.group1.controller.ServerInit;
import static com.group1.controller.ServerInit.gson;
import com.group1.model.Status;
import com.group1.model.dao.CommentDAO;
import com.group1.model.dao.StatusDAO;
import com.group1.model.db.IO;
import com.group1.rest.BaseProcessor;
import com.group1.rest.ServeAt;
import com.group1.rest.ServeMethod;
import java.io.IOException;
import java.sql.SQLException;
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
@WebServlet("/process/status/*")
public class StatusProcessor extends BaseProcessor {

    @ServeAt(value = "/crateStatus", method = ServeMethod.POST)
    public void serveCreateStatus(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        String content = request.getParameter("content");
        String link = request.getParameter("link");
        String audience = request.getParameter("audience");
        int accountId = (int) request.getSession().getAttribute("uid");
        StatusDAO.createStatus(accountId, content, link, audience);

    }

    @ServeAt(value = "/editStatus", method = ServeMethod.POST)
    public void serveEditStatus(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        String text = request.getParameter("text");
        String mood = request.getParameter("mood");
        String statusId = request.getParameter("id");
        StatusDAO.editStatus(statusId, text, mood);
    }

    @ServeAt(value = "/deleteStatus", method = ServeMethod.POST)
    public void serveDeleteStatus(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        String statusId = request.getParameter("id");
        StatusDAO.deleteStatus(statusId);
    }

    @ServeAt(value = "/createComment", method = ServeMethod.POST)
    public void serveCreateComment(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        String statusId = request.getParameter("id");
        int accountId = (int) request.getSession().getAttribute("uid");
        String text = request.getParameter("text");
        CommentDAO.createComment(statusId, accountId, text);

    }

    @ServeAt(value = "/createComment2", method = ServeMethod.POST)
    public void serveCreateComment2(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        String commentId = request.getParameter("commnetId");
        String statusId = request.getParameter("statusId");
        int accountId = (int) request.getSession().getAttribute("uid");
        String text = request.getParameter("text");
        CommentDAO.createComment2(commentId, statusId, accountId, text);

    }
}
