package com.group1.controller.processor;

import com.group1.controller.ServerInit;
import static com.group1.controller.ServerInit.gson;
import com.group1.misc.Secret;
import com.group1.misc.Sout;
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
@WebServlet("/process/profileUserAbout/*")
public class ProfileUserAboutProcessor extends BaseProcessor {
    
    @ServeAt("/index")
    public void serveIndex(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, SQLException {         
        HttpSession ses = request.getSession();
        int uid = (Integer) ses.getAttribute("uid");
        
        ProfileUserAbout profileUser = ProfileUserAboutDAO.getProfileUser(uid);
        Account account = AccountDAO.getAccount(uid);
        
        request.setAttribute("profileUser", profileUser);
        request.setAttribute("account", account);

        request.getRequestDispatcher("/client/profile/profileAbout.jsp").forward(request, response);
    }
    
    @ServeAt(value="/updateName", method=ServeMethod.POST)
    public void serveUpdateName(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        
        PrintWriter out = response.getWriter();

        String name = request.getParameter("name");
        
        HttpSession ses = request.getSession();
        int uid = (Integer) ses.getAttribute("uid");
        
        // check account exist in database
        if (ProfileUserAboutDAO.updateName(uid, name)){
            out.print("success");
        } else {
            ProfileUserAbout profileUser = ProfileUserAboutDAO.getProfileUser(uid);
            out.print(profileUser.getName());
        }

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
       
        response.addCookie(cookie);
        out.print("success");
    }
}
