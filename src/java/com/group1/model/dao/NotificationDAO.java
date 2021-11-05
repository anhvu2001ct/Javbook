/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group1.model.dao;

import com.group1.model.Notification;
import static com.group1.model.db.SQLConnector.SQL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author nhatquynh
 */
public class NotificationDAO {

    public static List<Notification> getListNotification(int userid) {
        try {
            List<Notification> list = new ArrayList<>();
            String query = "select n.NotificationID, n.SenderID, a.Name, a.Avatar, n.Time, n.EmojiID, n.Reference, n.Seen\n"
                    + "from Notification n, AccountProfile a\n"
                    + "where n.ReceiverID = ? and n.SenderID = a.AccountUserID and not a.AccountUserID = ?";
            PreparedStatement ps = SQL.prepareStatement(query);
            ps.setInt(1, userid);
            ps.setInt(2, userid);
            ResultSet rs = ps.executeQuery();
            if (!rs.isBeforeFirst()) {
                return null;

            } else {
                while (rs.next()) {
                    String time = "about " + CommentDAO.calculateTime(rs.getTimestamp(5)) + " ago";
                    String message = "";
                    String emoji = "";
                    switch (rs.getInt(6)) {
                        case 1:
                            message = " liked on your post.";
                            emoji = "like.svg";
                            break;
                        case 2:
                            message = " loved on your post.";
                            emoji = "love.svg";
                            break;
                        case 3:
                            message = " care on your post.";
                            emoji = "care.svg";
                            break;
                        case 4:
                            message = " haha on your post.";
                            emoji = "haha.svg";
                            break;
                        case 5:
                            message = " sad on your post.";
                            emoji = "sad.svg";
                            break;
                        case 6:
                            message = " angry on your post.";
                            emoji = "angry.svg";
                            break;
                        case 7:
                            message = " commented on your post.";
                            emoji = "message.svg";
                            break;
                    }

                    Notification nf = new Notification(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), time, emoji, rs.getString(7), rs.getInt(8), message);
                    list.add(nf);
                }

                return list;
            }

        } catch (SQLException e) {
            System.out.println("Get notification error!");
        }

        return null;
    }

    public static void insertNotification(String sender, String emoji, String reference, String statusid) {
        try {
            if (Integer.parseInt(emoji) != 7) {
                deleteNotification(sender, emoji, reference);
            }

            String sql = "insert into Notification (ReceiverID, SenderID, Time, EmojiID, Reference, Seen) values (?,?,?,?,?,?);";
            PreparedStatement ps = SQL.prepareStatement(sql);
            ps.setInt(1, getUseridOfStatus(statusid));
            ps.setInt(2, Integer.parseInt(sender));
            Timestamp time = new Timestamp(System.currentTimeMillis());
            ps.setTimestamp(3, time);
            ps.setInt(4, Integer.parseInt(emoji));
            ps.setString(5, reference);
            ps.setInt(6, 0);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Can not insert notification!");
        }

    }

    public static void deleteNotification(String sender, String emoji, String reference) {
        try {
            String sql = "delete from Notification where SenderID = ? and Reference = ? and  EmojiID = 7";
            String sql2 = "delete from Notification where SenderID = ? and Reference = ? and not EmojiID = 7";
            if (Integer.parseInt(emoji) != 7) {
                PreparedStatement ps = SQL.prepareStatement(sql2);
                ps.setInt(1, Integer.parseInt(sender));
                ps.setString(2, reference);
                ps.executeUpdate();
            } else {
                PreparedStatement ps = SQL.prepareStatement(sql);
                ps.setInt(1, Integer.parseInt(sender));
                ps.setString(2, reference);
                ps.executeUpdate();
            }

        } catch (SQLException e) {
            System.out.println("Can not delete notification!");
        }

    }

    public static void deleteAllNotificationOfStatus(String reference) {
        try {
            String sql = "delete from Notification\n"
                    + "where Reference like ?";
            String s = reference + "%";
            PreparedStatement ps = SQL.prepareStatement(sql);
            ps.setString(1, s);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Can not delete all notification of status!");
        }

    }

    public static int getUseridOfStatus(String statusid) {
        try {
            String sql = "select s.AccountUserID\n"
                    + "from Status s\n"
                    + "where s.StatusID = ?";
            PreparedStatement ps = SQL.prepareStatement(sql);
            ps.setInt(1, Integer.parseInt(statusid));
            ResultSet rs = ps.executeQuery();
            if (!rs.isBeforeFirst()) {
                return 0;
            } else {
                while (rs.next()) {
                    return rs.getInt(1);
                }
            }
        } catch (SQLException e) {

            System.out.println("Can not get userid of status table!");
        }
        return 0;
    }

    public static void isSeenNotification(int notificationid) {
        try {
            String sql = "update Notification\n"
                    + "set Seen = 1\n"
                    + "where NotificationID = ?";
            PreparedStatement ps = SQL.prepareStatement(sql);
            ps.setInt(1, notificationid);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Can not is seen notification!");
        }
    }

}
