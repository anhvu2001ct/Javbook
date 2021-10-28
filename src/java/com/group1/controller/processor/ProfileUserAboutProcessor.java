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
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
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
        
        // update Name
        if (ProfileUserAboutDAO.updateName(uid, name)){
            out.print("success");
        } else {
            ProfileUserAbout profileUser = ProfileUserAboutDAO.getProfileUser(uid);
            out.print(profileUser.getName());
        }
    }
    
    @ServeAt(value="/updateCareer", method=ServeMethod.POST)
    public void serveUpdateCareer(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        
        PrintWriter out = response.getWriter();

        String career = request.getParameter("career");
        
        HttpSession ses = request.getSession();
        int uid = (Integer) ses.getAttribute("uid");
        
        // update Career
        if (ProfileUserAboutDAO.updateCareer(uid, career)){
            out.print("success");
        } else {
            ProfileUserAbout profileUser = ProfileUserAboutDAO.getProfileUser(uid);
            out.print(profileUser.getCareer());
        }
    }
    
    @ServeAt(value="/updateAddress", method=ServeMethod.POST)
    public void serveUpdateAddress(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        
        PrintWriter out = response.getWriter();

        String address = request.getParameter("address");
        
        HttpSession ses = request.getSession();
        int uid = (Integer) ses.getAttribute("uid");
        
        // update Address
        if (ProfileUserAboutDAO.updateAddress(uid, address)){
            out.print("success");
        } else {
            ProfileUserAbout profileUser = ProfileUserAboutDAO.getProfileUser(uid);
            out.print(profileUser.getAddress());
        }
    }
    
    @ServeAt(value="/updateGender", method=ServeMethod.POST)
    public void serveUpdateGender(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        
        PrintWriter out = response.getWriter();

        String gender = request.getParameter("gender");
        
        HttpSession ses = request.getSession();
        int uid = (Integer) ses.getAttribute("uid");
        
        // update Gender
        if (ProfileUserAboutDAO.updateGender(uid, gender)){
            out.print("success");
        } else {
            ProfileUserAbout profileUser = ProfileUserAboutDAO.getProfileUser(uid);
            out.print(profileUser.getGender());
        }
    }
    
    @ServeAt(value="/updateDOB", method=ServeMethod.POST)
    public void serveUpdateDOB(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        
        PrintWriter out = response.getWriter();

        HttpSession ses = request.getSession();
        int uid = (Integer) ses.getAttribute("uid");

        String DOB = request.getParameter("dob");
        long t = 0;
       
        try {
            t = (new SimpleDateFormat("yyyy-MM-dd").parse(DOB)).getTime();
        } catch (ParseException ex) {
            Logger.getLogger(ProfileUserAboutProcessor.class.getName()).log(Level.SEVERE, null, ex);
        }
          
        // update DOB
        if (ProfileUserAboutDAO.updateDOB(uid, new Date(t))){
            out.print("success");
        } else {
            ProfileUserAbout profileUser = ProfileUserAboutDAO.getProfileUser(uid);
            out.print(profileUser.getGender());
        }
    }
    
}
