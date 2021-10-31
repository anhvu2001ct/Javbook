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
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Mr Khang
 */
public class StatusDAO {

    public static int createStatus(int accountID, String text, String statusImg, String audience) {
        try {

            String query = "INSERT INTO Status(AccountUserID, Text, StatusImg, Time, AudienceID)\n"
                    + "Values (?,?,?,?,?);";
            PreparedStatement ps = SQL.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, accountID);
            ps.setString(2, text);
            ps.setString(3, statusImg);
            Timestamp time = new Timestamp(System.currentTimeMillis());
            ps.setTimestamp(4, time);
            ps.setInt(5, Integer.parseInt(audience));
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            rs.next();
            return rs.getInt(1);
        } catch (SQLException ex) {
            System.err.println("Create Status Error");
        }
        return -1;
    }

    public static void editStatus(String statusId, String text, String mood) {
        try {
            String query = "UPDATE Status\n"
                    + "SET  \n"
                    + "	Text =?\n"
                    + "	,AudienceID =?\n"
                    + "	,ActiveTime= ?\n"
                    + "WHERE StatusId= ?;";
            PreparedStatement ps = SQL.prepareStatement(query);
            ps.setString(1, text);
            ps.setInt(2, Integer.parseInt(mood));
            Timestamp time = new Timestamp(System.currentTimeMillis());
            ps.setTimestamp(3, time);
            ps.setInt(4, Integer.parseInt(statusId));
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("Edit Status Error");
        }

    }

    public static void deleteStatus(String statusId) {
        try {
            String query = "DELETE  FROM Status\n"
                    + "WHERE StatusID = ?;";
            PreparedStatement ps = SQL.prepareStatement(query);
            ps.setInt(1, Integer.parseInt(statusId));
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("Delete Status Error");
        }

    }

    public static List<Status> getListStatusUser(int acccountID) {
        try {
            List<Status> list = new ArrayList<>();
            String query = "select Name, Avatar, StatusID, Text, StatusImg, Time, ActiveTime, AudienceID\n"
                    + "from Status s , AccountProfile a \n"
                    + "where a.AccountUserID = ?  and s.AccountUserID =a.AccountUserID ";
            PreparedStatement ps = SQL.prepareStatement(query);
            ps.setInt(1, acccountID);
            ResultSet rs = ps.executeQuery();
            SimpleDateFormat s = new SimpleDateFormat("MM/dd/yyyy HH:mm");
            if (!rs.isBeforeFirst()) {
                return null;
            } else {
                while (rs.next()) {
                    Status status = new Status(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getString(4),
                            rs.getString(5), s.format(rs.getTimestamp(6)),
                            String.format("%1$TD %1$TT", rs.getTimestamp(7)), rs.getInt(8));
                    list.add(status);
                }
                return list;
            }
        } catch (SQLException ex) {
            System.err.println("Get Status User Error");
        }
        return null;
    }

    public static String getAvatar(int acccountID) {
        try {
            String avatar = "";
            String query = "select Avatar\n"
                    + "from AccountProfile\n"
                    + "where AccountUserID = ?";
            PreparedStatement ps = SQL.prepareStatement(query);
            ps.setInt(1, acccountID);
            ResultSet rs = ps.executeQuery();
            if (!rs.isBeforeFirst()) {
                return null;
            } else {
                while (rs.next()) {
                    avatar = rs.getString(1);
                }
                return avatar;

            }
        } catch (SQLException ex) {
            System.err.println("Get Avatar Error");
        }
        return null;
    }

    public static List<String> getListPhotoUser(int accountID) {
        try {
            List<String> list = new ArrayList<>();
            String query = "select StatusImg\n"
                    + "from Status\n"
                    + "where AccountUserID =?";
            PreparedStatement ps = SQL.prepareStatement(query);
            ps.setInt(1, accountID);
            ResultSet rs = ps.executeQuery();
            if (!rs.isBeforeFirst()) {
                return null;
            } else {
                while (rs.next()) {
                    String photo = rs.getString(1);
                    list.add(photo);
                }
                return list;
            }
        } catch (SQLException ex) {
            System.err.println("Get Photo User Error");
        }
        return null;
    }

}
