/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group1.rest;

import com.group1.misc.Sout;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServlet;

/**
 *
 * @author Anh Vu Nguyen {@literal <nganhvu>}
 */
public abstract class BaseProcessor extends HttpServlet {
    private boolean init = false;
    private Map<String, Method> serveGET = new HashMap<>();
    private Map<String, Method> servePOST = new HashMap<>();
    
    private void load() throws Exception {
        if (init) return;
        init = true;
        Class<?> clazz = this.getClass();
        for (Method method: clazz.getDeclaredMethods()) {
            ServeAt annotation = method.getAnnotation(ServeAt.class);
            if (annotation != null) {
                method.setAccessible(true);
                String path = annotation.value();
                for (ServeMethod httpMethod: annotation.method()) {
                    if (httpMethod == ServeMethod.GET) serveGET.put(path, method);
                    else servePOST.put(path, method);
                }
            }
        }
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            load();
        } catch (Exception ex) {
            Sout.print("BaseProcessor->loading | Error at:", this.getClass());
            ex.printStackTrace();
        }
        
        String path = request.getPathInfo();
        if (path == null || path.equals("/")) path = "";
        if (!serveGET.containsKey(path)) return;
        
        response.setContentType("text/plain;charset=UTF-8");
        try {
            serveGET.get(path).invoke(this, request, response);
        } catch (Exception ex) {
            Sout.print("BaseProcessor->serving->GET | Error at:", this.getClass());
            ex.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            load();
        } catch (Exception ex) {
            Sout.print("BaseProcessor->loading | Error at:", this.getClass());
            ex.printStackTrace();
        }
        
        String path = request.getPathInfo();
        if (path == null || path.equals("/")) path = "";
        if (!servePOST.containsKey(path)) return;
        
        response.setContentType("text/plain;charset=UTF-8");
        try {
            servePOST.get(path).invoke(this, request, response);
        } catch (Exception ex) {
            Sout.print("BaseProcessor->serving->POST | Error at:", this.getClass());
            ex.printStackTrace();
        }
    }
}
