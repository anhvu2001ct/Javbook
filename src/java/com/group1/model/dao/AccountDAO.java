package com.group1.model.dao;

import com.group1.model.Account;
import static com.group1.model.db.SQLConnector.SQL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Dang Minh Canh
 */
public class AccountDAO {
 
    public static List<Account> getListAccount() throws SQLException{
        String query = "select * from Account";
        
        PreparedStatement ps = SQL.prepareStatement(query); // nem cau lenh query tu netbeans sang sql server 
        ResultSet rs = ps.executeQuery(); // execute query va nhan ket qua tra ve
        List<Account> list = new ArrayList<>();
        while (rs.next()){
            list.add(new Account(rs.getString(1), rs.getString(2)));
        }
        // return List Account
        return list;
    }
    
}
