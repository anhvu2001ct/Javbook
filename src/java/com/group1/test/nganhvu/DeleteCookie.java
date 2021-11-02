package com.group1.test.nganhvu;

import com.group1.controller.BaseServlet;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Anh Vu Nguyen {@literal <nganhvu>}
 */
@WebServlet("/test/nganhvu/delete/")
public class DeleteCookie extends BaseServlet {
    @Override
    public void processGET(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie cookie = new Cookie("JBID", "");
        cookie.setPath("/Javbook");
        cookie.setMaxAge(0);
        response.addCookie(cookie);
    }

    @Override
    protected void processPOST(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("POST");
    }
}