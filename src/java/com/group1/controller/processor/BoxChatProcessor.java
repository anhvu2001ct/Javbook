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
//          
        System.out.println("test" + uid + " " + otherID);
        List<Pair<Chat, Boolean>> chatList = BoxChatDAO.getBoxChat(uid, otherID);
        System.out.println("List" + chatList.toString());

        request.setAttribute("chatList", chatList);

        request.getRequestDispatcher("/client/boxChat/boxChat.jsp").forward(request, response);
        
    }

}
