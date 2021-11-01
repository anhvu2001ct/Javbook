/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group1.controller.processor;

import com.group1.misc.Pair;
import com.group1.model.Comment;
import com.group1.model.Comment2;
import com.group1.model.Post;
import com.group1.model.Status;
import com.group1.model.dao.CommentDAO;
import com.group1.model.dao.EmojiDAO;
import com.group1.model.dao.StatusDAO;
import com.group1.rest.BaseProcessor;
import com.group1.rest.ServeAt;
import com.group1.rest.ServeMethod;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
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
        try {
            String content = request.getParameter("content");
            String link = request.getParameter("link");
            String audience = request.getParameter("audience");
            int accountId = (int) request.getSession().getAttribute("uid");
            response.getWriter().print(StatusDAO.createStatus(accountId, content, link, audience));
        } catch (IOException ex) {
            System.out.println("Create Status Erorr");
        }

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
        try {
            String statusId = request.getParameter("id");
            int accountId = (int) request.getSession().getAttribute("uid");
            String text = request.getParameter("text");
            response.getWriter().print(CommentDAO.createComment(statusId, accountId, text));

        } catch (IOException ex) {
            System.out.println("Save Comment Data Erorr");
        }

    }

    @ServeAt(value = "/createComment2", method = ServeMethod.POST)
    public void serveCreateComment2(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        try {
            String commentId = request.getParameter("id");
            int accountId = (int) request.getSession().getAttribute("uid");
            String text = request.getParameter("text");
            response.getWriter().print(CommentDAO.createComment2(commentId, accountId, text));
        } catch (IOException ex) {
            System.out.println("Save Comment2 Data Erorr");
        }

    }


    @ServeAt(value = "/render", method = ServeMethod.GET)
    public void serveRenderPost(HttpServletRequest request, HttpServletResponse response) {
        try {
            int accountId = (int) request.getSession().getAttribute("uid");
            List<Status> status = StatusDAO.getListStatusUser(accountId);
            List<Post> posts = new ArrayList<>();
            if (status != null) {
                Collections.sort(status, (Status a, Status b) -> b.getStatusId() - a.getStatusId());

                for (Status stt : status) {
                    stt.setNumberOfEmoji(EmojiDAO.getStatusNumberOfEmojis(stt.getStatusId()));
                    Post post = new Post();
                    post.setStatus(stt);
                    List<Pair<Comment, List<Comment2>>> li = new ArrayList<>();
                    List<Comment> comments = CommentDAO.getListComment(stt.getStatusId());
                    
                    if (comments != null) {
                        Collections.sort(comments, (Comment a, Comment b) -> b.getCommentId() - a.getCommentId());
                        for (Comment comment : comments) {
                            li.add(new Pair<>(comment, CommentDAO.getListComment2(comment.getCommentId())));
                        }
                        post.setComment(li);
                    }
                    posts.add(post);
                }

            }
            request.setAttribute("posts", posts);
            request.setAttribute("avatar", StatusDAO.getAvatar(accountId));
            request.getRequestDispatcher("/client/profile/profilePost.jsp").forward(request, response);
        } catch (ServletException ex) {
            System.out.println("Render ServletException");
        } catch (IOException ex) {
            System.out.println("RenderI OException ");
        }

    }

   
}
