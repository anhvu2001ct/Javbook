/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group1.model.dao;

import com.group1.model.Comment;
import com.group1.model.Status;
import static com.group1.model.db.SQLConnector.SQL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Mr Khang
 */
public class CommentDAO {

    public static void createComment(String statusId, int accountId, String text) {
        try {

            String query = "INSERT INTO Comment(StatusID, AccountUserID, Text, Time)\n"
                    + "Values (?,?,?,?);";
            PreparedStatement ps = SQL.prepareStatement(query);
            ps.setInt(1, Integer.parseInt(statusId));
            ps.setInt(2, accountId);
            ps.setString(3, text);
            Timestamp time = new Timestamp(System.currentTimeMillis());
            ps.setTimestamp(4, time);
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("Create Comment Error");
        }
    }

    public static void createComment2(String commentId, String statusId, int accountId, String text) {
        try {
            String query = "INSERT INTO Comment2(CommentID,StatusID, AccountUserID, Text, Time)\n"
                    + "Values (?,?,?,?,?)";
            PreparedStatement ps = SQL.prepareStatement(query);
            ps.setInt(1, Integer.parseInt(commentId));
            ps.setInt(2, Integer.parseInt(statusId));
            ps.setInt(3, accountId);
            ps.setString(4, text);
            Timestamp time = new Timestamp(System.currentTimeMillis());
            ps.setTimestamp(5, time);
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("Create Comment2 Error");
        }
    }

    public static void deleteComment(String commentId) {
        try {
            String query = ";";
            PreparedStatement ps = SQL.prepareStatement(query);
            ps.setInt(1, Integer.parseInt(commentId));
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("Delete Comment Error");
        }

    }

    public static List<Comment> getListComment(int StatusID) {
        try {
            List<Comment> list = new ArrayList<>();
            String query = "select Name,Avatar,CommentID,StatusID,Text,Time,CheckUpdate \n"
                    + "from Comment c , AccountUser au,AccountProfile ap\n"
                    + "where c.AccountUserID =au.AccountUserID and c.AccountUserID =ap.AccountUserID and c.StatusID =?";
            PreparedStatement ps = SQL.prepareStatement(query);

            ps.setInt(1, StatusID);
            ResultSet rs = ps.executeQuery();
            if (!rs.isBeforeFirst()) {
                return null;
            } else {
                while (rs.next()) {
                    Comment comment = new Comment(rs.getString(1), rs.getString(2), rs.getInt(3),
                            rs.getInt(4), rs.getString(5), rs.getTimestamp(6), rs.getInt(7));
                    list.add(comment);
                }
                return list;
            }
        } catch (SQLException ex) {
            System.err.println("Get Comment Error");
        }
        return null;
    }

}
