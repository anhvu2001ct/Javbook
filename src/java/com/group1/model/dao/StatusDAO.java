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

            String query = "INSERT INTO Status(AccountID, Text, StatusImg, Time, StatusModeID)\n"
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

    public static void editStatus(String statusId) throws SQLException {
        String query = "UPDATE Status"
                + "SET ActiveTime= ?"
                + "WHERE StatusId=?;";
        PreparedStatement ps = SQL.prepareStatement(query);
        ps.setString(1, statusId);
        Timestamp time = new Timestamp(System.currentTimeMillis());
        ps.setTimestamp(2, time);
    }

    public static List<Status> getListStatusUser(String acccountID) throws SQLException {
        List<Status> list = new ArrayList<>();
        String query = "select * from Status where AccountID = ?  ";
        PreparedStatement ps = SQL.prepareStatement(query);
        ps.setString(1, acccountID);
        ResultSet rs = ps.executeQuery();
        if (!rs.isBeforeFirst()) {
            return null;
        } else {

            while (rs.next()) {
                Status status = new Status(rs.getString(1), rs.getString(2), rs.getString(3),
                        rs.getString(4), rs.getDate(5), rs.getDate(6));
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
                Status status = new Status(rs.getString(1), rs.getString(2), rs.getString(3),
                        rs.getString(4), rs.getDate(5), rs.getDate(6));
                list.add(status);
            }
            return list;
        }

    }

}
