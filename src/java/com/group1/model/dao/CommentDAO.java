/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group1.model.dao;

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

    public static List<Status> getListComment(int acccountID) {
        try {
            List<Status> list = new ArrayList<>();
            String query = "select Name, Avatar, StatusID, Text, StatusImg, Time, ActiveTime, StatusModeID\n"
                    + "from Status s ,AccountProfile a ,AccountUser au\n"
                    + "where a.AccountUserID = ?  and s.AccountUserID =a.AccountUserID and s.AccountUserID =au.AccountUserID";
            PreparedStatement ps = SQL.prepareStatement(query);

            ps.setInt(1, acccountID);
            ResultSet rs = ps.executeQuery();
            if (!rs.isBeforeFirst()) {
                return null;
            } else {
                while (rs.next()) {
//                    Status status = new Status(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getString(4),
//                            rs.getString(5), rs.getTimestamp(6), rs.getTimestamp(7), rs.getInt(8));
//                    list.add(status);
                }
                return list;
            }
        } catch (SQLException ex) {
            System.err.println("Get Comment Error");
        }
        return null;
    }

}
