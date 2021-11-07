package com.group1.model.dao;

import com.group1.misc.Pair;
import com.group1.model.Chat;
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
public class BoxChatDAO {
 
    public static List<Pair<Chat, Boolean>> getBoxChat(int ID, int otherID) {
        try {
            String query = "SELECT * "
                    + "FROM Chat "
                    + "WHERE (ReceiverID = ? AND SenderID = ?) "
                    + "OR (ReceiverID = ? AND SenderID = ?)";

            PreparedStatement ps = SQL.prepareStatement(query); // nem cau lenh query tu netbeans sang sql server
            ps.setInt(1, ID);
            ps.setInt(2, otherID);
            ps.setInt(3, otherID);
            ps.setInt(4, ID);
            ResultSet rs = ps.executeQuery(); // execute query va nhan ket qua tra ve
            
            // if do not have any chat
            if (!rs.isBeforeFirst()){
                return null;
            } else {
                // if have chats
                List<Pair<Chat, Boolean>> list = new ArrayList<>();
                
                while (rs.next()) {
                    Chat chat = new Chat(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4), 
                            rs.getString(5), rs.getString(6));

                    boolean flag = false;
                    if (chat.getSenderID() == ID){
                        flag = true;
                    } 
                    
                    list.add(new Pair<>(chat, flag));
                }
                return list;
            }
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}
