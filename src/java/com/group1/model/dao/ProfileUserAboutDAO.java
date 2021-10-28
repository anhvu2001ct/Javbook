package com.group1.model.dao;

import com.group1.model.ProfileUserAbout;
import static com.group1.model.db.SQLConnector.SQL;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dang Minh Canh
 */
public class ProfileUserAboutDAO {
 
    public static void createNewProfileUser(int accountID){
        try {
            String query = "INSERT INTO AccountProfile "
                    + "VALUES (?, 'Javbook User', '/Javbook/assets/img/default/avatar.png', "
                    + "'/Javbook/assets/img/default/cover.jpg', '1999-1-1', 'The Earth', 'Others', 'Studies at FPT University', '4', '111111');";
            
            PreparedStatement ps = SQL.prepareStatement(query); // nem cau lenh query tu netbeans sang sql server
            ps.setInt(1, accountID);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProfileUserAboutDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static ProfileUserAbout getProfileUser(int accountID) {
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
                return new ProfileUserAbout(rs.getInt(1), rs.getString(2), rs.getString(3),  
                        rs.getString(4), rs.getDate(5), rs.getString(6), rs.getString(7),
                        rs.getString(8), rs.getInt(9), rs.getString(10));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProfileUserAboutDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public static boolean updateName(int accountID, String name) {
        try {
            String query = "UPDATE AccountProfile "
                    +  "SET Name = ? "
                    +  "WHERE AccountUserID = ?";
            
            PreparedStatement ps = SQL.prepareStatement(query); // nem cau lenh query tu netbeans sang sql server
            ps.setString(1, name);
            ps.setInt(2,accountID);
            
            int affectedRows = ps.executeUpdate(); // execute query va nhan ket qua tra ve
            return (affectedRows != 0);
        } catch (SQLException ex) {
            Logger.getLogger(ProfileUserAboutDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
       
    }
    
    public static boolean updateCareer(int accountID, String career) {
        try {
            String query = "UPDATE AccountProfile "
                    +  "SET Career = ? "
                    +  "WHERE AccountUserID = ?";
            
            PreparedStatement ps = SQL.prepareStatement(query); // nem cau lenh query tu netbeans sang sql server
            ps.setString(1, career);
            ps.setInt(2, accountID);
            
            int affectedRows = ps.executeUpdate(); // execute query va nhan ket qua tra ve
            return (affectedRows != 0);
        } catch (SQLException ex) {
            Logger.getLogger(ProfileUserAboutDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
       
    }
    
    public static boolean updateAddress(int accountID, String address) {
        try {
            String query = "UPDATE AccountProfile "
                    +  "SET Address = ? "
                    +  "WHERE AccountUserID = ?";
            
            PreparedStatement ps = SQL.prepareStatement(query); // nem cau lenh query tu netbeans sang sql server
            ps.setString(1, address);
            ps.setInt(2, accountID);
            
            int affectedRows = ps.executeUpdate(); // execute query va nhan ket qua tra ve
            return (affectedRows != 0);
        } catch (SQLException ex) {
            Logger.getLogger(ProfileUserAboutDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
       
    }
    
    public static boolean updateGender(int accountID, String gender) {
        try {
            String query = "UPDATE AccountProfile "
                    +  "SET Gender = ? "
                    +  "WHERE AccountUserID = ?";
            
            PreparedStatement ps = SQL.prepareStatement(query); // nem cau lenh query tu netbeans sang sql server
            ps.setString(1, gender);
            ps.setInt(2, accountID);
            
            int affectedRows = ps.executeUpdate(); // execute query va nhan ket qua tra ve
            return (affectedRows != 0);
        } catch (SQLException ex) {
            Logger.getLogger(ProfileUserAboutDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
       
    }
    
    public static boolean updateDOB(int accountID, Date DOB) {
        try {
            String query = "UPDATE AccountProfile "
                    +  "SET DOB = ? "
                    +  "WHERE AccountUserID = ?";
            
            PreparedStatement ps = SQL.prepareStatement(query); // nem cau lenh query tu netbeans sang sql server
            ps.setDate(1, DOB);
            ps.setInt(2, accountID);
            
            int affectedRows = ps.executeUpdate(); // execute query va nhan ket qua tra ve
            return (affectedRows != 0);
        } catch (SQLException ex) {
            Logger.getLogger(ProfileUserAboutDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
       
    }
    
    public static boolean updateProfileStatusID(int accountID, int profileStatusID) {
        try {
            String query = "UPDATE AccountProfile "
                    +  "SET ProfileStatusID = ? "
                    +  "WHERE AccountUserID = ?";
            
            PreparedStatement ps = SQL.prepareStatement(query); // nem cau lenh query tu netbeans sang sql server
            ps.setInt(1, profileStatusID);
            ps.setInt(2, accountID);
            
            int affectedRows = ps.executeUpdate(); // execute query va nhan ket qua tra ve
            return (affectedRows != 0);
        } catch (SQLException ex) {
            Logger.getLogger(ProfileUserAboutDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }     
    }
    
    public static boolean updateAudience(int accountID, String audience) {
        try {
            String query = "UPDATE AccountProfile "
                    +  "SET Audience = ? "
                    +  "WHERE AccountUserID = ?";
            
            PreparedStatement ps = SQL.prepareStatement(query); // nem cau lenh query tu netbeans sang sql server
            ps.setString(1, audience);
            ps.setInt(2, accountID);
            
            int affectedRows = ps.executeUpdate(); // execute query va nhan ket qua tra ve
            return (affectedRows != 0);
        } catch (SQLException ex) {
            Logger.getLogger(ProfileUserAboutDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
}
