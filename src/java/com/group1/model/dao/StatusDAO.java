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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mr Khang
 */
public class StatusDAO {

    public static void createStatus(int accountID, String text, String statusImg, String audience) {
        try {

            String query = "INSERT INTO Status(AccountUserID, Text, StatusImg, Time, StatusModeID)\n"
                    + "Values (?,?,?,?,?);";
            PreparedStatement ps = SQL.prepareStatement(query);
            ps.setInt(1, accountID);
            ps.setString(2, text);
            ps.setString(3, statusImg);
            Timestamp time = new Timestamp(System.currentTimeMillis());
            ps.setTimestamp(4, time);
            ps.setInt(5, Integer.parseInt(audience));

            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(StatusDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void editStatus(int statusId, String text, String mood) throws SQLException {
        String query = "UPDATE Status\n"
                + "SET  \n"
                + "	Text =?\n"
                + "	,StatusModeID =?\n"
                + "	,ActiveTime= ?\n"
                + "WHERE StatusId= ?;";
        PreparedStatement ps = SQL.prepareStatement(query);
        ps.setString(1, text);
        ps.setInt(2, Integer.parseInt(mood));
        Timestamp time = new Timestamp(System.currentTimeMillis());
        ps.setTimestamp(3, time);
        ps.setInt(4, statusId);

    }

    public static List<Status> getListStatusUser(int acccountID) throws SQLException {
        List<Status> list = new ArrayList<>();
        String query = "select Name, StatusID, Text, StatusImg, Time, ActiveTime, StatusModeID\n"
                + "from Status s ,AccountProfile a\n"
                + "where a.AccountUserID = ?  and s.AccountUserID =a.AccountUserID";
        PreparedStatement ps = SQL.prepareStatement(query);

        Timestamp time = new Timestamp(System.currentTimeMillis());

        ps.setInt(1, acccountID);
        ResultSet rs = ps.executeQuery();
        if (!rs.isBeforeFirst()) {
            return null;
        } else {
            while (rs.next()) {
                Status status = new Status(rs.getString(1), rs.getInt(2), rs.getString(3),
                        rs.getString(4), rs.getTimestamp(5), rs.getTimestamp(6), rs.getInt(7));
                list.add(status);
            }
            return list;
        }

    }

    public static List<Status> getListStatus() throws SQLException {
        List<Status> list = new ArrayList<>();
        String query = "select * from Status";
        PreparedStatement ps = SQL.prepareStatement(query);
        ResultSet rs = ps.executeQuery();
        if (!rs.isBeforeFirst()) {
            return null;
        } else {
            while (rs.next()) {
//                Status status = new Status(rs.getString(1), rs.getInt(2), rs.getString(3),
//                        rs.getString(4), rs.getTimestamp(5), rs.getTimestamp(6), rs.getInt(7), rs.getInt(8));
//                list.add(status);
            }
            return list;
        }

    }

}
