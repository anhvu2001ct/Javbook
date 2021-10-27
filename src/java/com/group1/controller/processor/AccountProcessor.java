package com.group1.controller.processor;

import com.group1.model.Account;
import com.group1.model.ProfileUserAbout;
import com.group1.model.dao.AccountDAO;
import com.group1.model.dao.ProfileUserAboutDAO;
import com.group1.rest.BaseProcessor;
import com.group1.rest.ServeAt;
import com.group1.rest.ServeMethod;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Dang Minh Canh
 */
@WebServlet("/process/account/*")
public class AccountProcessor extends BaseProcessor {
    
    @ServeAt("/index")
    public void serveIndex(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, SQLException {         
       
    }
    
    @ServeAt(value="/updatePhone", method=ServeMethod.POST)
    public void serveUpdatePhone(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        
        PrintWriter out = response.getWriter();

        String phone = request.getParameter("phone");
        
        HttpSession ses = request.getSession();
        int uid = (Integer) ses.getAttribute("uid");
        
        // check account exist in database
        if (AccountDAO.updatePhone(uid, phone)){
            out.print("success");
        } else {
            Account account = AccountDAO.getAccount(uid);
            out.print(account.getPhone());
        }
    }
    
}
