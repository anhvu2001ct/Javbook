package com.group1.model.dao;

import com.group1.model.Friend;
import com.group1.model.ProfileUserAbout;
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
 * @author Dang Minh Canh
 */
public class FriendDAO {

    public static void insertFriend(int A, int B) {
        try {
            String sql = "insert into Friend values(?,?,?)";
            PreparedStatement ps = SQL.prepareStatement(sql);
            if (A < B) {
                ps.setInt(1, A);
                ps.setInt(2, B);
            } else {
                ps.setInt(1, B);
                ps.setInt(2, A);
            }
            Timestamp time = new Timestamp(System.currentTimeMillis());
            ps.setTimestamp(3, time);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Can not insert friend to database!");
        }
    }

    public static List<Friend> getListFriend(int userid) {
        try {
            List<Friend> list = new ArrayList<>();
            String sql = "select *\n"
                    + "from friend f\n"
                    + "where f.A = ? or f.B =?";
            PreparedStatement ps = SQL.prepareStatement(sql);
            ps.setInt(1, userid);
            ps.setInt(2, userid);
            ResultSet rs = ps.executeQuery();
            if (!rs.isBeforeFirst()) {
                return null;

            } else {
                while (rs.next()) {                    
                    
                }
            }
        } catch (Exception e) {
            System.out.println("Can not get list friend!");
        }
        return null;
    }
}
