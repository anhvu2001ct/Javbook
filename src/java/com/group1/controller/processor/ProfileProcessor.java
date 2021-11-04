/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group1.controller.processor;

import com.group1.controller.IndexServlet;
import com.group1.controller.ServerInit;
import static com.group1.controller.ServerInit.gson;
import com.group1.misc.PathInfo;
import com.group1.misc.Secret;
import com.group1.model.dao.StatusDAO;
import com.group1.model.db.IO;
import com.group1.rest.BaseProcessor;
import com.group1.rest.ServeAt;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Mr Khang
 */
@WebServlet("/process/profile/*")
public class ProfileProcessor extends BaseProcessor {

    @ServeAt("/changeItem")
    public void changeTimeline(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String value = request.getParameter("key");
        int accountId = (int) request.getSession().getAttribute("uid");
        String curId = Secret.decode2(request.getParameter("id"));
        request.setAttribute("id", Integer.parseInt(curId));
        if (value.equals("Photo")) {

            List<String> photos = StatusDAO.getListPhotoUser(Integer.parseInt(curId));
            request.setAttribute("photos", photos);
            request.getRequestDispatcher("/client/profile/profilePhoto.jsp").forward(request, response);
        }
        if (value.equals("Post")) {
            request.getRequestDispatcher("/process/status/render").forward(request, response);
        }
        if (value.equals("About")) {
            request.getRequestDispatcher("/process/profileUserAbout/index").forward(request, response);
        }
        if (value.equals("Friends")) {
            request.getRequestDispatcher("/client/profile/profileFriends.jsp").forward(request, response);
        }

    }

    @ServeAt("/changeJs")
    public void changeJS(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String key = request.getParameter("key");
        if (key.equals("Photo")) {
            List<String> list = IO.getFilesName(ServerInit.webPath, "assets/js/profile/Photo");
            response.getWriter().print(gson.toJson(list));

        }
        if (key.equals("Post")) {
            List<String> list = IO.getFilesName(ServerInit.webPath, "assets/js/profile/Post");
            response.getWriter().print(gson.toJson(list));
        }
        if (key.equals("About")) {

            List<String> list = IO.getFilesName(ServerInit.webPath, "assets/js/profile/About");
            response.getWriter().print(gson.toJson(list));
        }
        if (key.equals("Friends")) {
            List<String> list = IO.getFilesName(ServerInit.webPath, "assets/js/profile/");
            response.getWriter().print(gson.toJson(list));
        }

    }

}
