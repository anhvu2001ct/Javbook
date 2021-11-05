package com.group1.controller.processor;

import static com.group1.controller.ServerInit.gson;
import com.group1.model.Account;
import com.group1.model.dao.AccountDAO;
import com.group1.rest.BaseProcessor;
import com.group1.rest.ServeAt;
import com.group1.rest.ServeMethod;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
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
    public void serveIndex(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {         
       
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
    
    @ServeAt(value="/updateEmail", method=ServeMethod.POST)
    public void serveUpdateEmail(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        
        PrintWriter out = response.getWriter();

        String email = request.getParameter("email");
        
        HttpSession ses = request.getSession();
        int uid = (Integer) ses.getAttribute("uid");
        
        // check account exist in database
        if (AccountDAO.updateEmail(uid, email)){
            out.print("success");
        } else {
            Account account = AccountDAO.getAccount(uid);
            out.print(account.getEmail());
        }
    }
    
    @ServeAt(value="/changePassword", method=ServeMethod.POST)
    public void serveChangePassword(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        
        PrintWriter out = response.getWriter();
        
        String currentPassword = request.getParameter("currentPassword");
        String newPassword = request.getParameter("newPassword");
        String newRepassword = request.getParameter("newRepassword");

        ArrayList<String> list = new ArrayList<>();
        
        HttpSession ses = request.getSession();
        int uid = (Integer) ses.getAttribute("uid");
        // check current password is correct
        Account account = AccountDAO.getAccount(uid);
        if (!currentPassword.equals(account.getPassword())){
            list.add("password");
        }
        
        // check validation for password
        String PASSWORD_PATTERN = "^[a-zA-Z]([a-zA-Z0-9]){5,19}";
        Pattern pattern = Pattern.compile(PASSWORD_PATTERN);
        Matcher matcher = pattern.matcher(newPassword);
        if (!matcher.matches()){
            list.add("newPassword");
        } else {
            // check password is the same
            if (!newRepassword.equals(newPassword)){
                list.add("repassword");
            }
        }

        if (list.isEmpty()){
            if (!AccountDAO.changePassword(uid, newPassword)){
                list.add("fail");
            } 
        }
         
        out.print(gson.toJson(list));
    }
    
    @ServeAt(value="/logout", method=ServeMethod.POST)
    public void serveLogout(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        
        PrintWriter out = response.getWriter();

        // remove cookie("JBID");
        Cookie ck = new Cookie("JBID", ""); // deleting value of cookie  
        ck.setMaxAge(0); //changing the maximum age to 0 seconds  
        ck.setPath("/Javbook");
        response.addCookie(ck); //adding cookie in the response  
        
        // remove all attribute of sesstion
        HttpSession ses = request.getSession();
        ses.invalidate();  

        out.print("success");
       
    }
}
