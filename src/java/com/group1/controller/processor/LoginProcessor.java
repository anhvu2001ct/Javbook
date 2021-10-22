package com.group1.controller.processor;

import static com.group1.controller.ServerInit.gson;
import com.group1.misc.Secret;
import com.group1.model.Account;
import com.group1.model.dao.AccountDAO;
import com.group1.rest.BaseProcessor;
import com.group1.rest.ServeAt;
import com.group1.rest.ServeMethod;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Dang Minh Canh
 */
@WebServlet("/process/login/*")
public class LoginProcessor extends BaseProcessor {
    @ServeAt("")
    public void serveIndex(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
//        response.getWriter().println(JsonParser.parseReader(IO.getReader("notify/user1.json")).getAsJsonObject().toString());
        request.setAttribute("name", "Nguyễn Anh Vũ");
        request.getRequestDispatcher("/test/nganhvu/send.jsp").include(request, response);
    }
    
    @ServeAt(value="/createNewAccount", method=ServeMethod.POST)
    public void serveCreateNewAccount(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, SQLException {
        PrintWriter out = response.getWriter();
        
        String signupUsername = request.getParameter("signupUsername");
        String signupPassword = request.getParameter("signupPassword");
        String signupRepassword = request.getParameter("signupRepassword");
        String signupCheckbox = request.getParameter("signupCheckbox");
        
        ArrayList<String> list = new ArrayList<>();

        // check validation for username
        String USERNAME_PATTERN = "^[a-z]([a-z0-9]){5,19}";
        Pattern pattern = Pattern.compile(USERNAME_PATTERN);
        Matcher matcher = pattern.matcher(signupUsername);
   
        if (!matcher.matches()){
            list.add("username");
        } else {
            // check available username
            if (!AccountDAO.isAvailableUsername(signupUsername)){
                list.add("available_username");
            }
        }
        
        // check validation for password
        String PASSWORD_PATTERN = "^[a-zA-Z]([a-zA-Z0-9]){5,19}";
        pattern = Pattern.compile(PASSWORD_PATTERN);
        matcher = pattern.matcher(signupPassword);
        if (!matcher.matches()){
            list.add("password");
        } else {
            // check password is the same
            if (!signupPassword.equals(signupRepassword)){
                list.add("repassword");
            }
        }
        
        // check checkbox "I agree all terms & conditions."
        if (signupCheckbox.equals("false")){
            list.add("checkbox");
        }
        
        if (list.isEmpty()){
            AccountDAO.createNewAccount(signupUsername, signupPassword);
        }

        out.print(gson.toJson(list));
    }
    
    @ServeAt(value="/signin", method=ServeMethod.POST)
    public void serveSignin(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, SQLException {
        PrintWriter out = response.getWriter();
        
        String signinUsername = request.getParameter("signinUsername");
        String signinPassword = request.getParameter("signinPassword");
        String signinRememberPassword = request.getParameter("signinRememberPassword");
        
        // check account exist in database
        if (!AccountDAO.isAccountExists(signinUsername, signinPassword)){
            out.print("fail");
            return;
        }
        
        Account account = AccountDAO.getAccountByUsername(signinUsername);
        Cookie cookie = new Cookie("JBID", Secret.encode1(signinUsername));
        cookie.setPath("/Javbook");
        
        // check checkbox "Remember password in 30 days."
        if (signinRememberPassword.equals("true")){
            cookie.setMaxAge(3600 * 24 * 30);
        }

        response.addCookie(cookie);
        out.print("success");
    }
}
