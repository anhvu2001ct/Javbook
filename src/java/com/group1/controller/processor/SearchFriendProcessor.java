package com.group1.controller.processor;

import com.group1.controller.IndexServlet;
import com.group1.misc.Pair;
import com.group1.model.ProfileUserAbout;
import com.group1.model.dao.SearchFriendDAO;
import com.group1.rest.BaseProcessor;
import com.group1.rest.ServeAt;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Dang Minh Canh
 */
@WebServlet("/process/searchFriend/*")
public class SearchFriendProcessor extends BaseProcessor {
    
    @ServeAt("/index")
    public void serveIndex(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {         
        
        PrintWriter out = response.getWriter();
        
        HttpSession ses = request.getSession();
        int uid = (Integer) ses.getAttribute("uid");
        
        String name = request.getParameter("name");
        
        List<Pair<ProfileUserAbout, Integer>> searchFriendList = SearchFriendDAO.getAllUserByName(uid, name);
        
        if (searchFriendList != null){
            Collections.sort(searchFriendList, (Pair<ProfileUserAbout, Integer> a, Pair<ProfileUserAbout, Integer> b) -> b.second - a.second);
        }
        
        request.setAttribute("searchFriendList", searchFriendList);
        
        // Header (Quynh)
        IndexServlet.setInfoHeader(request);
        
        request.getRequestDispatcher("/client/searchFriend/searchFriend.jsp").forward(request, response);
        
        
    }
    
}