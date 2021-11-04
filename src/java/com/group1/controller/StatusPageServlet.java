/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group1.controller;

import com.group1.misc.Pair;
import com.group1.model.Comment;
import com.group1.model.Comment2;
import com.group1.model.Post;
import com.group1.model.Status;
import com.group1.model.dao.CommentDAO;
import com.group1.model.dao.EmojiDAO;
import com.group1.model.dao.StatusDAO;
import java.io.IOException;
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
@WebServlet("/status/*")
public class StatusPageServlet extends BaseServlet {

    @Override
    protected void processGET(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Status stt = StatusDAO.getStatus("4");
        int accountId = (int) request.getSession().getAttribute("uid");
        List<Post> posts = new ArrayList<>();
        if (stt != null) {
            stt.setNumberOfEmoji(EmojiDAO.getStatusNumberOfEmojis(4));
            stt.setUserEmotion(EmojiDAO.isStatusUserEmojis(stt.getStatusId(), accountId));
            if (EmojiDAO.getListStatusMaxEmojis(stt.getStatusId()) != null) {
                stt.setMax1(EmojiDAO.getListStatusMaxEmojis(stt.getStatusId()).get(0));
                if (EmojiDAO.getListStatusMaxEmojis(stt.getStatusId()).size() == 2) {
                    stt.setMax2(EmojiDAO.getListStatusMaxEmojis(stt.getStatusId()).get(1));
                }
            }
            Post post = new Post();
            post.setStatus(stt);
            List<Pair<Comment, List<Comment2>>> li = new ArrayList<>();
            List<Comment> comments = CommentDAO.getListComment(stt.getStatusId());

            if (comments != null) {
                Collections.sort(comments, (Comment a, Comment b) -> b.getCommentId() - a.getCommentId());
                for (Comment comment : comments) {
                    comment.setNumberOfEmoji(EmojiDAO.getCommentNumberOfEmojis(comment.getCommentId()));
                    comment.setUserEmotion(EmojiDAO.isCommentUserEmojis(comment.getCommentId(), accountId));
                    if (EmojiDAO.getListCommentMaxEmojis(comment.getCommentId()) != null) {
                        comment.setMax1(EmojiDAO.getListCommentMaxEmojis(comment.getCommentId()).get(0));
                        if (EmojiDAO.getListCommentMaxEmojis(comment.getCommentId()).size() == 2) {
                            comment.setMax2(EmojiDAO.getListCommentMaxEmojis(comment.getCommentId()).get(1));
                        }
                    }
                    List<Comment2> comments2 = CommentDAO.getListComment2(comment.getCommentId());
                    if (comments2 != null) {
                        Collections.sort(comments2, (Comment2 a, Comment2 b) -> b.getComment2Id() - a.getComment2Id());
                        for (Comment2 comment2 : comments2) {
                            comment2.setUserEmotion(EmojiDAO.isComment2UserEmojis(comment2.getComment2Id(), accountId));
                            comment2.setNumberOfEmoji(EmojiDAO.getComment2NumberOfEmojis(comment2.getComment2Id()));
                            if (EmojiDAO.getListComment2MaxEmojis(comment2.getComment2Id()) != null) {
                                comment2.setMax1(EmojiDAO.getListComment2MaxEmojis(comment2.getComment2Id()).get(0));
                                if (EmojiDAO.getListComment2MaxEmojis(comment2.getComment2Id()).size() == 2) {
                                    comment2.setMax2(EmojiDAO.getListComment2MaxEmojis(comment2.getComment2Id()).get(1));
                                }
                            }
                        }
                    }
                    li.add(new Pair<>(comment, comments2));
                }
                post.setComment(li);
            }
            posts.add(post);

        }
        request.setAttribute("posts", posts);
        request.setAttribute("userID", accountId);
        request.getRequestDispatcher("/client/common/statusPage.jsp").forward(request, response);

    }

    @Override
    protected void processPOST(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
