package com.group1.controller.processor;

import com.group1.controller.ServerInit;
import static com.group1.controller.ServerInit.gson;
import com.group1.misc.Secret;
import com.group1.model.FriendRequest;
import com.group1.model.Notification;
import com.group1.model.ProfileUserAbout;
import com.group1.model.dao.NotificationDAO;
import com.group1.model.dao.ProfileUserAboutDAO;
import com.group1.rest.BaseProcessor;
import com.group1.rest.ServeAt;
import com.group1.rest.ServeMethod;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Lê Nhật Quỳnh
 */
@WebServlet("/process/realtimenotification/*")
public class RealtimeNotificationProcessor extends BaseProcessor {

    @ServeAt(value = "/comment", method = ServeMethod.POST)
    public void serveRealtimeCommentNotification(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String statusID = request.getParameter("statusID");
        String commentID = request.getParameter("commentID");
        int senderID = Integer.parseInt(Secret.decode2(request.getParameter("senderID")));
        int receiverID = (int) request.getSession().getAttribute("uid");
        String reference = String.format("status=%s&comment=%s", statusID, commentID);
        Notification nf = NotificationDAO.getOneNotification(receiverID, senderID, "7", reference);
        request.setAttribute("notification", nf);
        request.getRequestDispatcher("/client/common/miniNotification.jsp").forward(request, response);
    }

    @ServeAt(value = "/popupcomment", method = ServeMethod.POST)
    public void serveRealtimePopupComment(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String statusID = request.getParameter("statusID");
        String commentID = request.getParameter("commentID");
        int senderID = Integer.parseInt(Secret.decode2(request.getParameter("senderID")));
        int receiverID = (int) request.getSession().getAttribute("uid");
        String reference = String.format("status=%s&comment=%s", statusID, commentID);
        Notification nf = NotificationDAO.getOneNotification(receiverID, senderID, "7", reference);
        List<String> list = new ArrayList<>();
        list.add(nf.getSendername());
        list.add("commented on your post");
        list.add(nf.getSenderavatar());
        list.add("info");
        list.add(String.format("/Javbook/status?%s", nf.getUrl()));
        response.getWriter().print(gson.toJson(list));
    }

    @ServeAt(value = "/react", method = ServeMethod.POST)
    public void serveRealtimeReactNotification(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String statusID = request.getParameter("statusID");
        String emojiID = request.getParameter("emojiID");
        int senderID = Integer.parseInt(Secret.decode2(request.getParameter("senderID")));
        int receiverID = (int) request.getSession().getAttribute("uid");
        String reference = String.format("status=%s", statusID);
        Notification nf = NotificationDAO.getOneNotification(receiverID, senderID, emojiID, reference);
        request.setAttribute("notification", nf);
        request.getRequestDispatcher("/client/common/miniNotification.jsp").forward(request, response);
    }

    @ServeAt(value = "/popupreact", method = ServeMethod.POST)
    public void serveRealtimePopupReact(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String statusID = request.getParameter("statusID");
        String emojiID = request.getParameter("emojiID");
        int senderID = Integer.parseInt(Secret.decode2(request.getParameter("senderID")));
        int receiverID = (int) request.getSession().getAttribute("uid");
        String reference = String.format("status=%s", statusID);
        Notification nf = NotificationDAO.getOneNotification(receiverID, senderID, emojiID, reference);
        List<String> list = new ArrayList<>();
        list.add(nf.getSendername());
        list.add("reacted on your post");
        list.add(nf.getSenderavatar());
        list.add("success");
        list.add(String.format("/Javbook/status?%s", nf.getUrl()));
        response.getWriter().print(gson.toJson(list));
    }

    @ServeAt(value = "/friend", method = ServeMethod.POST)
    public void serveRealtimeFriendNotification(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int senderID = Integer.parseInt(Secret.decode2(request.getParameter("senderID")));
        int receiverID = (int) request.getSession().getAttribute("uid");
        FriendRequest fr = NotificationDAO.getOneFriendRequests(receiverID, senderID);
        request.setAttribute("friendrq", fr);
        request.getRequestDispatcher("/client/common/miniFriendRequest.jsp").forward(request, response);

    }

    @ServeAt(value = "/popupfriend", method = ServeMethod.POST)
    public void serveRealtimePopupFriend(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int senderID = Integer.parseInt(Secret.decode2(request.getParameter("senderID")));
        int receiverID = (int) request.getSession().getAttribute("uid");
        FriendRequest fr = NotificationDAO.getOneFriendRequests(receiverID, senderID);
        List<String> list = new ArrayList<>();
        list.add(fr.getSendername());
        list.add("sent you a friend request");
        list.add(fr.getSenderavatar());
        list.add("kb");
        list.add(String.format("/Javbook/profile/%s/", fr.getSender()));
        response.getWriter().print(gson.toJson(list));

    }
}
