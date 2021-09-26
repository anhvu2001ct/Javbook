package com.group1.model.dao;

import com.group1.model.Account;
import static com.group1.model.db.SQLConnector.SQL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Dang Minh Canh
 */
public class AccountDAO {
 
    public static boolean isAccountExists(String username, String password) throws SQLException{
        String query = "SELECT * " 
                + "FROM AccountUser " 
                + "WHERE Username = ? "
                + "AND Password = ?";
        PreparedStatement ps = SQL.prepareStatement(query); // nem cau lenh query tu netbeans sang sql server 
        ps.setString(1, username);
        ps.setString(2, password);
        
        ResultSet rs = ps.executeQuery(); // execute query va nhan ket qua tra ve
        
        return rs.isBeforeFirst();
    }
    
    public static void createNewAccount(String username, String password) throws SQLException{
        String query = "INSERT INTO AccountUser(Username, Password) "
                + "VALUES (?, ?);";
        
        PreparedStatement ps = SQL.prepareStatement(query); // nem cau lenh query tu netbeans sang sql server 
        ps.setString(1, username);
        ps.setString(2, password);
        ps.executeUpdate();
    }
    
    public static boolean isAvailableUsername(String username) throws SQLException{
        String query = "SELECT * " 
                + "FROM AccountUser " 
                + "WHERE Username = ?;";
        PreparedStatement ps = SQL.prepareStatement(query); // nem cau lenh query tu netbeans sang sql server 
        ps.setString(1, username);
        
        ResultSet rs = ps.executeQuery(); // execute query va nhan ket qua tra ve
        
        return !rs.isBeforeFirst();
    }
    
    public static Account getAccountByUsername(String username) throws SQLException{
        String query = "SELECT * " 
                + "FROM AccountUser " 
                + "WHERE Username = ?;";
        PreparedStatement ps = SQL.prepareStatement(query); // nem cau lenh query tu netbeans sang sql server 
        ps.setString(1, username);
        
        ResultSet rs = ps.executeQuery(); // execute query va nhan ket qua tra ve
        
        // if do not have account
        if (!rs.isBeforeFirst()){
            return null;
        } else {
            // if have account
            rs.next();
            return new Account(rs.getInt(1), rs.getString(2), rs.getString(3), 
                               rs.getString(4), rs.getString(5), rs.getString(6),
                               rs.getDate(7), rs.getString(8), rs.getBoolean(9));
        }
    }
    
    public static Account getAccount(String accountID) throws SQLException{
        String query = "SELECT * " 
                + "FROM AccountUser " 
                + "WHERE AccountID = ?;";
        PreparedStatement ps = SQL.prepareStatement(query); // nem cau lenh query tu netbeans sang sql server 
        ps.setString(1, accountID);
        
        ResultSet rs = ps.executeQuery(); // execute query va nhan ket qua tra ve
        
        // if do not have account
        if (!rs.isBeforeFirst()){
            return null;
        } else {
            // if have account
            rs.next();
            return new Account(rs.getInt(1), rs.getString(2), rs.getString(3), 
                               rs.getString(4), rs.getString(5), rs.getString(6),
                               rs.getDate(7), rs.getString(8), rs.getBoolean(9));
        }
    }
    
}
