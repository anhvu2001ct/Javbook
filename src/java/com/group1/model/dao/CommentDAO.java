/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group1.model.dao;

import com.group1.model.Comment;
import com.group1.model.Comment2;
import static com.group1.model.db.SQLConnector.SQL;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author Mr Khang
 */
public class CommentDAO {

    public static int createComment(String statusId, int accountId, String text) {
        try {

            String query = "INSERT INTO Comment(StatusID, AccountUserID, Text, Time)\n"
                    + "Values (?,?,?,?);";
            PreparedStatement ps = SQL.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, Integer.parseInt(statusId));
            ps.setInt(2, accountId);
            ps.setString(3, text);
            Timestamp time = new Timestamp(System.currentTimeMillis());
            ps.setTimestamp(4, time);
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            rs.next();
            return rs.getInt(1);
        } catch (SQLException ex) {
            System.err.println("Create Comment Error");
        }
        return -1;
    }

    public static int createComment2(String commentId, int accountId, String text) {
        try {
            String query = "INSERT INTO Comment2(CommentID, AccountUserID, Text, Time)\n"
                    + "Values (?,?,?,?)";
            PreparedStatement ps = SQL.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, Integer.parseInt(commentId));
            ps.setInt(2, accountId);
            ps.setString(3, text);
            Timestamp time = new Timestamp(System.currentTimeMillis());
            ps.setTimestamp(4, time);
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            rs.next();
            return rs.getInt(1);
        } catch (SQLException ex) {
            System.err.println("Create Comment2 Error");
        }
        return -1;
    }

    public static void deleteComment(String commentId) {
        try {
            String query = "DELETE  FROM Comment\n"
                    + "WHERE CommentID = ?";
            PreparedStatement ps = SQL.prepareStatement(query);
            ps.setInt(1, Integer.parseInt(commentId));
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("Delete Comment Error");
        }

    }

    public static void deleteComment2(String comment2Id) {
        try {
            String query = "DELETE  FROM Comment2\n"
                    + "WHERE Comment2ID = ?";
            PreparedStatement ps = SQL.prepareStatement(query);
            ps.setInt(1, Integer.parseInt(comment2Id));
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("Delete Comment Error");
        }

    }

    public static List<Comment> getListComment(int StatusID) {
        try {
            List<Comment> list = new ArrayList<>();
            String query = "select Name,Avatar,CommentID,StatusID,Text,Time,CheckUpdate,c.AccountUserID \n"
                    + "from Comment c ,AccountProfile ap\n"
                    + "where  c.AccountUserID =ap.AccountUserID and c.StatusID =?";
            PreparedStatement ps = SQL.prepareStatement(query);
            ps.setInt(1, StatusID);
            ResultSet rs = ps.executeQuery();
            if (!rs.isBeforeFirst()) {
                return null;
            } else {
                while (rs.next()) {
                    Comment comment = new Comment(rs.getString(1), rs.getString(2), rs.getInt(3),
                            rs.getInt(4), rs.getString(5), calculateTime(rs.getTimestamp(6)), rs.getInt(7), 0, "", "", 0, rs.getInt(8));
                    list.add(comment);
                }
                return list;
            }
        } catch (SQLException ex) {
            System.err.println("Get Comment Error");
        }
        return null;
    }

    public static List<Comment2> getListComment2(int commentid) {
        try {

            List<Comment2> list = new ArrayList<>();
            String query = "select Name ,Avatar,Comment2ID ,CommentID,Text,Time,CheckUpdate,c.AccountUserID \n"
                    + "from Comment2 c  , AccountProfile ap\n"
                    + "where  c.AccountUserID =ap.AccountUserID and c.CommentID =?";
            PreparedStatement ps = SQL.prepareStatement(query);
            ps.setInt(1, commentid);
            ResultSet rs = ps.executeQuery();
            if (!rs.isBeforeFirst()) {
                return null;
            } else {
                while (rs.next()) {

                    Comment2 comment2 = new Comment2(rs.getString(1), rs.getString(2), rs.getInt(3),
                            rs.getInt(4), rs.getString(5), calculateTime(rs.getTimestamp(6)), rs.getInt(7), 0, "", "", 0, rs.getInt(8));
                    list.add(comment2);
                }
                return list;
            }
        } catch (SQLException ex) {
            System.err.println("Get Comment2 Error");
        }
        return null;
    }

    public static String calculateTime(Timestamp time) {
        String dateTime = "";
        Timestamp start = new Timestamp(System.currentTimeMillis());
        Date d2 = new Date(start.getTime());
        Date d1 = new Date(time.getTime());
        long difference_In_Time = d2.getTime() - d1.getTime();
        long difference_In_Seconds = TimeUnit.MILLISECONDS.toSeconds(difference_In_Time) % 60;
        long difference_In_Minutes = TimeUnit.MILLISECONDS.toMinutes(difference_In_Time) % 60;
        long difference_In_Hours = TimeUnit.MILLISECONDS.toHours(difference_In_Time) % 24;
        long difference_In_Days = TimeUnit.MILLISECONDS.toDays(difference_In_Time) % 365;

        if (difference_In_Days != 0) {
            dateTime = difference_In_Days + " d";
        } else if (difference_In_Hours != 0) {
            dateTime = difference_In_Hours + " h";
        } else if (difference_In_Minutes != 0) {
            dateTime = difference_In_Minutes + " m";
        } else if (difference_In_Seconds != 0) {
            dateTime = "1 m";
        }
        return dateTime;
    }
}
