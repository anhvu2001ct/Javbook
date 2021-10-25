package com.group1.model.dao;

import com.group1.model.Account;
import com.group1.model.ProfileUser;
import static com.group1.model.db.SQLConnector.SQL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dang Minh Canh
 */
public class ProfileUserDAO {
 
    public static void createNewProfileUser(int accountID){
        try {
            String query = "INSERT INTO AccountProfile "
                    + "VALUES (?, 'Nguyen Van A', '1999-1-1', 'Unknown', 'Others', 'Unknown','4');";
            
            PreparedStatement ps = SQL.prepareStatement(query); // nem cau lenh query tu netbeans sang sql server
            ps.setInt(1, accountID);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProfileUserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static ProfileUser getProfileUser(int accountID) {
        try {
            String query = "SELECT * "
                    + "FROM AccountProfile "
                    + "WHERE AccountUserID = ? ";
            
            PreparedStatement ps = SQL.prepareStatement(query); // nem cau lenh query tu netbeans sang sql server
            ps.setInt(1, accountID);
            
            ResultSet rs = ps.executeQuery(); // execute query va nhan ket qua tra ve
            
            // if do not have account
            if (!rs.isBeforeFirst()){
                return null;
            } else {
                // if have account
                rs.next();
                return new ProfileUser(rs.getInt(1), rs.getString(2), rs.getDate(3),  
                        rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProfileUserDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
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
                               rs.getString(4), rs.getString(5), rs.getString(6));
        }
    }
    
}