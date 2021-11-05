package com.group1.model.dao;

import com.group1.model.ProfileUserAbout;
import static com.group1.model.db.SQLConnector.SQL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dang Minh Canh
 */
public class SearchFriendDAO {
    
    public static List<ProfileUserAbout> getAllUserByName(int accountID, String name) {
        try {
            String query = "SELECT * "
                    + "FROM AccountProfile "
                    + "WHERE AccountUserID != ? "
                    + "AND Name LIKE ?";
            String s = "%" + name +"%";
            
            PreparedStatement ps = SQL.prepareStatement(query); // nem cau lenh query tu netbeans sang sql server
            ps.setInt(1, accountID);
            ps.setString(2, s);
            ResultSet rs = ps.executeQuery(); // execute query va nhan ket qua tra ve
            
            // if do not have any user
            if (!rs.isBeforeFirst()){
                return null;
            } else {
                // if have user
                List<ProfileUserAbout> list = new ArrayList<>();
                
                while (rs.next()) {
                    list.add(new ProfileUserAbout(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), 
                            rs.getDate(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getInt(9), 
                            rs.getString(10)));
                }
                return list;
            }
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
}
