package com.group1.controller.processor;

import com.group1.controller.ServerInit;
import com.group1.misc.Pair;
import com.group1.misc.PathInfo;
import com.group1.model.Account;
import com.group1.model.ProfileStatus;
import com.group1.model.ProfileUserAbout;
import com.group1.model.dao.AccountDAO;
import com.group1.model.dao.ProfileStatusDAO;
import com.group1.model.dao.ProfileUserAboutDAO;
import com.group1.model.db.IO;
import com.group1.rest.BaseProcessor;
import com.group1.rest.ServeAt;
import com.group1.rest.ServeMethod;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

/**
 *
 * @author Dang Minh Canh
 */
@MultipartConfig(fileSizeThreshold = 1024 * 1024,
        maxFileSize = 1024 * 1024 * 2,
        maxRequestSize = 1024 * 1024 * 4)
@WebServlet("/process/profileUserAbout/*")
public class ProfileUserAboutProcessor extends BaseProcessor {

    @ServeAt("/index")
    public void serveIndex(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, SQLException {
        HttpSession ses = request.getSession();
        int uid = (Integer) ses.getAttribute("uid");
        int accountID = (Integer) request.getAttribute("id");
        ProfileUserAbout profileUser = ProfileUserAboutDAO.getProfileUser(accountID);
        Account account = AccountDAO.getAccount(accountID);
        int profileStatusID = profileUser.getProfileStatusID();
        // get Profile Status
        ProfileStatus profileStatus = ProfileStatusDAO.getProfileStatus(profileStatusID);

        // get Audience
        String audience = profileUser.getAudience();
        ArrayList<Pair<String, String>> audiences = new ArrayList<>();

        for (char ch : audience.toCharArray()) {
            switch (ch) {
                case '1':
                    audiences.add(new Pair<>("Global", "fa-globe-asia"));
                    break;
                case '2':
                    audiences.add(new Pair<>("Friends", "fa-user-friends"));
                    break;
                case '3':
                    audiences.add(new Pair<>("OnlyMe", "fa-lock"));
                    break;
                default:
                    break;
            }
        }

        request.setAttribute("profileUser", profileUser);
        request.setAttribute("profileStatus", profileStatus);
        request.setAttribute("account", account);
        request.setAttribute("audiences", audiences);
        if (accountID == uid) {
            request.getRequestDispatcher("/client/profile/profileAbout.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("/client/otherProfile/profileAbout.jsp").forward(request, response);
        }

    }

    @ServeAt(value = "/updateName", method = ServeMethod.POST)
    public void serveUpdateName(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        PrintWriter out = response.getWriter();

        String name = request.getParameter("name");

        HttpSession ses = request.getSession();
        int uid = (Integer) ses.getAttribute("uid");

        // update Name
        if (ProfileUserAboutDAO.updateName(uid, name)) {
            out.print("success");
        } else {
            ProfileUserAbout profileUser = ProfileUserAboutDAO.getProfileUser(uid);
            out.print(profileUser.getName());
        }
    }

    @ServeAt(value = "/updateCareer", method = ServeMethod.POST)
    public void serveUpdateCareer(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        PrintWriter out = response.getWriter();

        String career = request.getParameter("career");

        HttpSession ses = request.getSession();
        int uid = (Integer) ses.getAttribute("uid");

        // update Career
        if (ProfileUserAboutDAO.updateCareer(uid, career)) {
            out.print("success");
        } else {
            ProfileUserAbout profileUser = ProfileUserAboutDAO.getProfileUser(uid);
            out.print(profileUser.getCareer());
        }
    }

    @ServeAt(value = "/updateAddress", method = ServeMethod.POST)
    public void serveUpdateAddress(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        PrintWriter out = response.getWriter();

        String address = request.getParameter("address");

        HttpSession ses = request.getSession();
        int uid = (Integer) ses.getAttribute("uid");

        // update Address
        if (ProfileUserAboutDAO.updateAddress(uid, address)) {
            out.print("success");
        } else {
            ProfileUserAbout profileUser = ProfileUserAboutDAO.getProfileUser(uid);
            out.print(profileUser.getAddress());
        }
    }

    @ServeAt(value = "/updateGender", method = ServeMethod.POST)
    public void serveUpdateGender(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        PrintWriter out = response.getWriter();

        String gender = request.getParameter("gender");

        HttpSession ses = request.getSession();
        int uid = (Integer) ses.getAttribute("uid");

        // update Gender
        if (ProfileUserAboutDAO.updateGender(uid, gender)) {
            out.print("success");
        } else {
            ProfileUserAbout profileUser = ProfileUserAboutDAO.getProfileUser(uid);
            out.print(profileUser.getGender());
        }
    }

    @ServeAt(value = "/updateDOB", method = ServeMethod.POST)
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
        if (ProfileUserAboutDAO.updateDOB(uid, new Date(t))) {
            out.print("success");
        } else {
            ProfileUserAbout profileUser = ProfileUserAboutDAO.getProfileUser(uid);
            out.print(profileUser.getGender());
        }
    }

    @ServeAt(value = "/updateProfileStatus", method = ServeMethod.POST)
    public void serveUpdateProfileStatus(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        PrintWriter out = response.getWriter();

        HttpSession ses = request.getSession();
        int uid = (Integer) ses.getAttribute("uid");

        String status = request.getParameter("profileStatus");
        int profileStatusID = 4;

        switch (status) {
            case "Married":
                profileStatusID = 3;
                break;
            case "Single":
                profileStatusID = 1;
                break;
            case "Dating":
                profileStatusID = 2;
                break;
            case "Others":
                profileStatusID = 4;
                break;
            default:
                break;
        }

        // update Profile Status ID
        if (ProfileUserAboutDAO.updateProfileStatusID(uid, profileStatusID)) {
            out.print("success");
        } else {
            ProfileUserAbout profileUser = ProfileUserAboutDAO.getProfileUser(uid);
            profileStatusID = profileUser.getProfileStatusID();
            // get Profile Status
            ProfileStatus profileStatus = ProfileStatusDAO.getProfileStatus(profileStatusID);
            out.print(profileStatus.getStatus());
        }
    }

    @ServeAt(value = "/updateAudience", method = ServeMethod.POST)
    public void serveUpdateAudience(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        PrintWriter out = response.getWriter();

        HttpSession ses = request.getSession();
        int uid = (Integer) ses.getAttribute("uid");
        ProfileUserAbout profileUser = ProfileUserAboutDAO.getProfileUser(uid);

        // get Audience
        String audience = profileUser.getAudience();
        char[] audienceChars = audience.toCharArray();

        String itemType = request.getParameter("itemType");
        String audienceType = request.getParameter("audienceType");

        char audienceTypeIndex = '3';
        switch (audienceType) {
            case "Global":
                audienceTypeIndex = '1';
                break;
            case "Friends":
                audienceTypeIndex = '2';
                break;
            case "OnlyMe":
                audienceTypeIndex = '3';
                break;
            default:
                break;
        }

        int itemTypeIndex = 6;

        switch (itemType) {
            case "dob":
                itemTypeIndex = 0;
                break;
            case "address":
                itemTypeIndex = 1;
                break;
            case "gender":
                itemTypeIndex = 2;
                break;
            case "career":
                itemTypeIndex = 3;
                break;
            case "status":
                itemTypeIndex = 4;
                break;
            case "phone":
                itemTypeIndex = 5;
                break;
            default:
                break;
        }

        audienceChars[itemTypeIndex] = audienceTypeIndex;

        // initial value for audience type 
        String oldAudienceType = "";

        switch (audience.charAt(itemTypeIndex)) {
            case '1':
                oldAudienceType = "Global";
                break;
            case '2':
                oldAudienceType = "Friends";
                break;
            case '3':
                oldAudienceType = "OnlyMe";
                break;
            default:
                break;
        }

        audience = String.valueOf(audienceChars);

        // update Audience
        if (ProfileUserAboutDAO.updateAudience(uid, audience)) {
            out.print("success");
        } else {
            out.print(oldAudienceType);
        }
    }

    @ServeAt(value = "/updateAvatar", method = ServeMethod.POST)
    public void serveUpdateAvatar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        PrintWriter out = response.getWriter();

        HttpSession ses = request.getSession();
        int uid = (Integer) ses.getAttribute("uid");

        String avatar = request.getParameter("urlImg");
        String deleteAvatar = request.getParameter("oldUrlImg");
        
        PathInfo pathInfo = new PathInfo(deleteAvatar);
        
        IO.delete(ServerInit.imgPath, "avatar", pathInfo.path[pathInfo.size-1]);
        
        // update Avatar
        if (ProfileUserAboutDAO.updateAvatar(uid, avatar)) {
            out.print("success");
        } else {
            out.print("/Javbook/assets/img/default/avatar.png");
        }
    }

    @ServeAt(value = "/updateCoverImg", method = ServeMethod.POST)
    public void serveUpdateCoverImg(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        PrintWriter out = response.getWriter();

        HttpSession ses = request.getSession();
        int uid = (Integer) ses.getAttribute("uid");

        String coverImg = request.getParameter("urlImg");
        String deleteCoverImg = request.getParameter("oldUrlImg");
        
        PathInfo pathInfo = new PathInfo(deleteCoverImg);
        
        IO.delete(ServerInit.imgPath, "cover", pathInfo.path[pathInfo.size-1]);
        
        // update Avatar
        if (ProfileUserAboutDAO.updateCoverImg(uid, coverImg)) {
            out.print("success");
        } else {
            out.print("/Javbook/assets/img/default/cover.jpg");
        }
    }

}
