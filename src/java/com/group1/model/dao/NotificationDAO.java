/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group1.model.dao;

import com.group1.model.HeaderNotification;
import static com.group1.model.db.SQLConnector.SQL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ASUS
 */
public class HeaderNotificationDAO {

    public static List<HeaderNotification> getListEmotionNotification(int userid) {
        try {
            List<HeaderNotification> list = new ArrayList<>();
            String query = "SELECT ap.Name, ap.Avatar,s.Time\n"
                    + "from dbo.Status s , dbo.StatusEmotion se, dbo.AccountProfile ap\n"
                    + "where s.AccountUserID = ? AND s.StatusID = se.StatusID AND se.AccountUserID = ap.AccountUserID and not se.AccountUserID = ?";
            PreparedStatement ps = SQL.prepareStatement(query);
            ps.setInt(1, userid);
            ps.setInt(2, userid);
            ResultSet rs = ps.executeQuery();
            if (!rs.isBeforeFirst()) {
                return null;

            } else {
                while (rs.next()) {
                    String time = "about " + CommentDAO.calculateTime(rs.getTimestamp(3)) + " ago";
                    String message = " recently reacted to your post";
                    String icon ="grin";
                    HeaderNotification hn = new HeaderNotification(rs.getString(1), rs.getString(2), time, message,icon);
                    list.add(hn);
                }

                return list;
            }

        } catch (Exception e) {
            System.out.println("Get notification error!");
        }

        return null;
    }

    public static List<HeaderNotification> getListCommentNotification(int userid) {

        try {
            List<HeaderNotification> list = new ArrayList<>();
            String query = "SELECT ap.Name, ap.Avatar,cm.Time\n"
                    + "from dbo.Status s , dbo.Comment cm, dbo.AccountProfile ap\n"
                    + "where s.AccountUserID = ? and s.StatusID = cm.StatusID and cm.AccountUserID = ap.AccountUserID and not cm.AccountUserID = ?\n";

            PreparedStatement ps = SQL.prepareStatement(query);
            ps.setInt(1, userid);
            ps.setInt(2, userid);
            ResultSet rs = ps.executeQuery();
            if (!rs.isBeforeFirst()) {
                return null;

            } else {
                while (rs.next()) {
                    String time = "about " + CommentDAO.calculateTime(rs.getTimestamp(3)) + " ago";
                    String icon = "comment-alt";
                    String message = " recently commented to your post";
                    HeaderNotification hn = new HeaderNotification(rs.getString(1), rs.getString(2), time, message,icon);
                    list.add(hn);
                }

                return list;
            }

        } catch (Exception e) {
            System.out.println("Get notification error!");
        }

        return null;
    }

}
