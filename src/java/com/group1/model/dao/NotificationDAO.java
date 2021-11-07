/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group1.model.dao;

import com.group1.misc.PathInfo;
import com.group1.misc.Secret;
import com.group1.model.FriendRequest;
import com.group1.model.NotiMessage;
import com.group1.model.Notification;
import static com.group1.model.db.SQLConnector.SQL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

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
                    Map<String, String> map = PathInfo.getUrlParams(rs.getString(7));
                    for (Entry<String, String> entry : map.entrySet()) {
                        map.put(entry.getKey(), Secret.encode1(entry.getValue()));
                    }
                    Notification nf = new Notification(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), time, emoji, rs.getString(7), rs.getInt(8), message, PathInfo.toUrlParams(map));
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

    //notification friend dao
    public static List<FriendRequest> getListFriendRequests(int userid) {
        try {
            List<FriendRequest> list = new ArrayList<>();
            String sql = "select nf.SenderID, ap.Name, ap.Avatar, nf.Time\n"
                    + "from NotificationFriend nf, AccountProfile ap\n"
                    + "where nf.ReceiverID = ? and nf.SenderID = ap.AccountUserID";
            PreparedStatement ps = SQL.prepareStatement(sql);
            ps.setInt(1, userid);
            ResultSet rs = ps.executeQuery();

            if (!rs.isBeforeFirst()) {
                return null;

            } else {
                while (rs.next()) {
                    String time = "about " + CommentDAO.calculateTime(rs.getTimestamp(4)) + " ago";
                    String senderid = Secret.encode2(String.valueOf(rs.getInt(1)));
                    FriendRequest fr = new FriendRequest(senderid, rs.getString(2), rs.getString(3), time);
                    list.add(fr);
                }
                return list;
            }

        } catch (SQLException e) {
            System.out.println("can not get list friend request!");
        }
        return null;
    }

    public static FriendRequest getOneFriendRequests(int userid, int userid2) {
        try {

            String sql = "select top 1 nf.SenderID, ap.Name, ap.Avatar, nf.Time\n"
                    + "from NotificationFriend nf, AccountProfile ap\n"
                    + "where nf.ReceiverID = ? and nf.SenderID = ? and nf.SenderID = ap.AccountUserID\n"
                    + "order by nf.SenderID desc";
            PreparedStatement ps = SQL.prepareStatement(sql);
            ps.setInt(1, userid);
            ps.setInt(2, userid2);
            ResultSet rs = ps.executeQuery();

            if (!rs.isBeforeFirst()) {
                return null;

            } else {
                while (rs.next()) {
                    String time = "about " + CommentDAO.calculateTime(rs.getTimestamp(4)) + " ago";
                    String senderid = Secret.encode2(String.valueOf(rs.getInt(1)));
                    FriendRequest fr = new FriendRequest(senderid, rs.getString(2), rs.getString(3), time);
                    return fr;

                }
            }

        } catch (SQLException e) {
            System.out.println("can not get list friend request!");
        }
        return null;
    }

    public static void deleteFriendRequest(int userid, int sender) {
        try {
            String sql = "delete from NotificationFriend where ReceiverID = ? and SenderID = ?";
            PreparedStatement ps = SQL.prepareStatement(sql);
            ps.setInt(1, userid);
            ps.setInt(2, sender);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Can not delete friend request!");
        }
    }

    public static Notification getOneNotification(int receiverID, int senderID, String emojiID, String reference) {
        try {
            String sql = "select top 1 n.NotificationID, n.SenderID, a.Name, a.Avatar, n.Time, n.EmojiID, n.Reference, n.Seen\n"
                    + "from Notification n, AccountProfile a\n"
                    + "where n.ReceiverID = ? and n.SenderID = ? and n.SenderID = a.AccountUserID and n.EmojiID = ? and n.Reference = ?\n"
                    + "order by n.NotificationID desc";
            PreparedStatement ps = SQL.prepareStatement(sql);
            ps.setInt(1, receiverID);
            ps.setInt(2, senderID);
            ps.setInt(3, Integer.parseInt(emojiID));
            ps.setString(4, reference);
            ResultSet rs = ps.executeQuery();

            if (!rs.isBeforeFirst()) {
                return null;

            } else {
                while (rs.next()) {
                    String time = "about 1 m ago";
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
                    Map<String, String> map = PathInfo.getUrlParams(rs.getString(7));
                    for (Entry<String, String> entry : map.entrySet()) {
                        map.put(entry.getKey(), Secret.encode1(entry.getValue()));
                    }
                    Notification nf = new Notification(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), time, emoji, rs.getString(7), rs.getInt(8), message, PathInfo.toUrlParams(map));
                    return nf;
                }
            }

        } catch (Exception e) {
            System.out.println("Can not get real time notification!");
        }
        return null;
    }

    public static List<NotiMessage> getListNotiMessage(int userid) {
        try {
            List<NotiMessage> list = new ArrayList<>();
            String sql = "select n.SenderID,a.Name , a.Avatar, n.Time, n.Seen\n"
                    + "from NotificationChat n, AccountProfile a\n"
                    + "where n.ReceiverID = ?  and n.SenderID =a.AccountUserID";
            PreparedStatement ps = SQL.prepareStatement(sql);
            ps.setInt(1, userid);
            ResultSet rs = ps.executeQuery();

            if (!rs.isBeforeFirst()) {
                return null;

            } else {
                while (rs.next()) {
                    String time = "about " + CommentDAO.calculateTime(rs.getTimestamp(4)) + " ago";
                    String senderid = Secret.encode2(String.valueOf(rs.getInt(1)));
                    NotiMessage fr = new NotiMessage(senderid, rs.getString(2), rs.getString(3), time, String.valueOf(rs.getInt(5)));
                    list.add(fr);
                }
                return list;
            }

        } catch (SQLException e) {
            System.out.println("can not get list notification message!");
        }
        return null;
    }

}
