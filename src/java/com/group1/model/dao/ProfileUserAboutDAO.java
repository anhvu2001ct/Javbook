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
    
}
