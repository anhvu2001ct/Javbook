package com.group1.model.dao;

import com.group1.model.ProfileUserAbout;
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
public class ProfileUserAboutDAO {
 
    public static void createNewProfileUser(int accountID){
        try {
            String query = "INSERT INTO AccountProfile "
                    + "VALUES (?, 'Javbook User', '1999-1-1', 'The Earth', 'Others', 'Unknown', '4');";
            
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
                return new ProfileUserAbout(rs.getInt(1), rs.getString(2), rs.getDate(3),  
                        rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7));
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
    
}
