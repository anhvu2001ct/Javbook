/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group1.controller.processor;

import com.group1.model.CountEmoji;
import com.group1.model.Emoji;
import com.group1.model.dao.EmojiDAO;
import com.group1.model.dao.NotificationDAO;
import com.group1.rest.BaseProcessor;
import com.group1.rest.ServeAt;
import com.group1.rest.ServeMethod;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Mr Khang
 */
@WebServlet("/process/emotion/*")
public class EmotionProcessor extends BaseProcessor {

    @ServeAt(value = "/createStatusEmoji", method = ServeMethod.POST)
    public void serveCreateStatusEmoji(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        String statusId = request.getParameter("id");
        int accountId = (int) request.getSession().getAttribute("uid");
        String emojiId = request.getParameter("emoji");
        EmojiDAO.createStatusEmoji(statusId, accountId, emojiId);
        NotificationDAO.insertNotification(accountId, emojiId, statusId);
    }

    @ServeAt(value = "/deleteStatusEmoji", method = ServeMethod.POST)
    public void serveDeleteStatusEmoji(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        String statusId = request.getParameter("id");
        int accountId = (int) request.getSession().getAttribute("uid");
        EmojiDAO.deleteStatusEmoji(statusId, accountId);
        NotificationDAO.deleteNotification(accountId, statusId, "1");
    }

    @ServeAt(value = "/createCommentEmoji", method = ServeMethod.POST)
    public void serveCreateCommentEmoji(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        String commentId = request.getParameter("id");
        int accountId = (int) request.getSession().getAttribute("uid");
        String emojiId = request.getParameter("emoji");
        EmojiDAO.createCommentEmoji(commentId, accountId, emojiId);
    }

    @ServeAt(value = "/deleteCommentEmoji", method = ServeMethod.POST)
    public void serveDeleteCommentEmoji(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        String commentID = request.getParameter("id");
        int accountId = (int) request.getSession().getAttribute("uid");
        EmojiDAO.deleteCommentEmoji(commentID, accountId);
    }

    @ServeAt(value = "/createComment2Emoji", method = ServeMethod.POST)
    public void serveCreateComment2Emoji(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        String statusId = request.getParameter("id");
        int accountId = (int) request.getSession().getAttribute("uid");
        String emojiId = request.getParameter("emoji");
        EmojiDAO.createComment2Emoji(statusId, accountId, emojiId);
    }

    @ServeAt(value = "/deleteComment2Emoji", method = ServeMethod.POST)
    public void serveDeleteComment2Emoji(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        String statusId = request.getParameter("id");
        int accountId = (int) request.getSession().getAttribute("uid");
        EmojiDAO.deleteComment2Emoji(statusId, accountId);
    }

    @ServeAt(value = "/renderPopup", method = ServeMethod.GET)
    public void serveRenderPopup(HttpServletRequest request, HttpServletResponse response) {

        try {
            String id = request.getParameter("id");
            String type = request.getParameter("type");
            List<Emoji> listEmoji = null;
            if (type.equals("status")) {
                listEmoji = EmojiDAO.getListStatusEmoji(id);
            }
            if (type.equals("comment")) {
                listEmoji = EmojiDAO.getListCommentEmoji(id);
            }
            if (type.equals("comment2")) {
                listEmoji = EmojiDAO.getListComment2Emoji(id);
            }
            List<Emoji> listLike = new ArrayList<>();
            List<Emoji> listLove = new ArrayList<>();
            List<Emoji> listCare = new ArrayList<>();
            List<Emoji> listHaha = new ArrayList<>();
            List<Emoji> listSad = new ArrayList<>();
            List<Emoji> listAngry = new ArrayList<>();
            CountEmoji countEmoji = new CountEmoji();
            for (Emoji emoji : listEmoji) {
                if (emoji.getEmojiID() == 1) {
                    countEmoji.setLike(countEmoji.getLike() + 1);
                    listLike.add(emoji);
                }
                if (emoji.getEmojiID() == 2) {
                    countEmoji.setLove(countEmoji.getLove() + 1);
                    listLove.add(emoji);
                }
                if (emoji.getEmojiID() == 3) {
                    countEmoji.setCare(countEmoji.getCare() + 1);
                    listCare.add(emoji);
                }
                if (emoji.getEmojiID() == 4) {
                    countEmoji.setHaha(countEmoji.getHaha() + 1);
                    listHaha.add(emoji);
                }
                if (emoji.getEmojiID() == 5) {
                    countEmoji.setSad(countEmoji.getSad() + 1);
                    listSad.add(emoji);
                }
                if (emoji.getEmojiID() == 6) {
                    countEmoji.setAngry(countEmoji.getAngry() + 1);
                    listAngry.add(emoji);
                }
            }
            request.setAttribute("countEmoji", countEmoji);
            request.setAttribute("listEmoji", listEmoji);
            request.setAttribute("listLike", listLike);
            request.setAttribute("listLove", listLove);
            request.setAttribute("listCare", listCare);
            request.setAttribute("listHaha", listHaha);
            request.setAttribute("listSad", listSad);
            request.setAttribute("listAngry", listAngry);
            request.getRequestDispatcher("/client/profile/popupEmoji.jsp").forward(request, response);
        } catch (ServletException ex) {
            System.out.println("Render Popup ServletException");
        } catch (IOException ex) {
            System.out.println("Render Popup IOException");
        }

    }
}
