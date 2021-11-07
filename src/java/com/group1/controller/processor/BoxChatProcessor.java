package com.group1.controller.processor;

import com.group1.controller.ServerInit;
import com.group1.misc.Pair;
import com.group1.misc.PathInfo;
import com.group1.misc.Secret;
import com.group1.model.Chat;
import com.group1.model.ProfileUserAbout;
import com.group1.model.dao.BoxChatDAO;
import com.group1.model.dao.ProfileUserAboutDAO;
import com.group1.model.db.IO;
import com.group1.rest.BaseProcessor;
import com.group1.rest.ServeAt;
import com.group1.rest.ServeMethod;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 *
 * @author Dang Minh Canh
 */
@MultipartConfig(fileSizeThreshold = 1024 * 1024,
        maxFileSize = 1024 * 1024 * 2,
        maxRequestSize = 1024 * 1024 * 4)
@WebServlet("/process/boxChat/*")
public class BoxChatProcessor extends BaseProcessor {

    @ServeAt("/index")
    public void serveIndex(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
      
    }
    
    

    @ServeAt(value = "/getBoxChat", method = ServeMethod.POST)
    public void serveGetBoxChat(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        PrintWriter out = response.getWriter();

        HttpSession ses = request.getSession();
        int uid = (Integer) ses.getAttribute("uid");
        
        int otherID = Integer.parseInt(Secret.decode2(request.getParameter("otherID")));
             
//        // update Audience
//        if (ProfileUserAboutDAO.updateAudience(uid, audience)) {
//            out.print("success");
//        } else {
//            out.print(oldAudienceType);
//        }
//        
//          
        System.out.println("test" + uid + " " + otherID);
        List<Pair<Chat, Boolean>> chatList = BoxChatDAO.getBoxChat(uid, otherID);
        System.out.println("List" + chatList.toString());
//        if (chatList != null){
//            Collections.sort(searchFriendList, (Pair<ProfileUserAbout, Integer> a, Pair<ProfileUserAbout, Integer> b) -> b.second - a.second);
//        }
        
//        request.setAttribute("searchFriendList", searchFriendList);
//        
//        // Header (Quynh)
//        IndexServlet.setInfoHeader(request);
//        
//        request.getRequestDispatcher("/client/searchFriend/searchFriend.jsp").forward(request, response);
        out.print("success");
        
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
