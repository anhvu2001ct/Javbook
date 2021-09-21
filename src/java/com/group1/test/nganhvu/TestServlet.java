/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group1.test.nganhvu;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.group1.controller.BaseServlet;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Anh Vu Nguyen {@literal <nganhvu>}
 */
@WebServlet("/test/nganhvu/")
public class TestServlet extends BaseServlet {
    int cnt = 0;
    
    @Override
    protected void processGET(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        JsonElement json = JsonParser.parseReader(new BufferedReader(new FileReader("/data.json")));
        String filename = "/WEB-INF/data/test.json";
        ServletContext context = getServletContext();
        System.out.println(context.getContextPath());
        System.out.println(context.getRealPath(""));
        System.out.println(context.getRealPath("/"));
        System.out.println(context.getRealPath("/WEB-INF"));
        System.out.println(context.getRealPath("/WEB-INF/"));
    }

    @Override
    protected void processPOST(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
    }
}
