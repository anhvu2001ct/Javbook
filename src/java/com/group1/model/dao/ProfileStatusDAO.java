package com.group1.model.dao;

import com.group1.model.ProfileStatus;
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
public class ProfileStatusDAO {
 
    public static ProfileStatus getProfileStatus(int profileStatusID) {
        try {
            String query = "SELECT * "
                    + "FROM ProfileStatus "
                    + "WHERE ProfileStatusID = ? ";
            
            PreparedStatement ps = SQL.prepareStatement(query); // nem cau lenh query tu netbeans sang sql server
            ps.setInt(1, profileStatusID);
            
            ResultSet rs = ps.executeQuery(); // execute query va nhan ket qua tra ve
            
            // if do not have account
            if (!rs.isBeforeFirst()){
                return null;
            } else {
                // if have account
                rs.next();
                return new ProfileStatus(rs.getInt(1), rs.getString(2), rs.getString(3));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProfileUserAboutDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
  
}
