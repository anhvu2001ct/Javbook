package com.group1.test.nganhvu;

import com.group1.controller.BaseServlet;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Anh Vu Nguyen {@literal <nganhvu>}
 */
//@WebServlet("/test/nganhvu/Javbook.png/")
public class DefaultServlet extends BaseServlet {
    @Override
    public void processGET(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("GET");
    }

    @Override
    protected void processPOST(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("POST");
    }
}