/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group1.controller;

import com.group1.misc.Serect;
import com.group1.misc.Sout;
import com.group1.model.dao.AccountDAO;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Anh Vu Nguyen {@literal <nganhvu>}
 */
@WebFilter("/*")
public class SessionFilter implements Filter {
    private String[] ALLOWED = {"/assets", "/process", "/ws"};
    
    private boolean isAllowed(String path) {
        for (String val: ALLOWED) {
            if (path.startsWith(val)) return true;
        }
        return false;
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;
        String path = request.getServletPath();

        if (isAllowed(path)) {
            chain.doFilter(request, response);
            return;
        }
        
        int uid = -1;
        if (request.getCookies() != null) {
            for (Cookie cookie: request.getCookies()) {
                if (cookie.getName().equals("JBID")) {
                    try {
                        uid = AccountDAO.getAccountByUsername(Serect.decode1(cookie.getValue())).getAccountID();
                    } catch (Exception e) {
                        Sout.print("Error getting UID!!!");
                        e.printStackTrace();
                    }
                    break;
                }
            }
        }
        
        if (uid == -1) request.getRequestDispatcher("/client/login/login.jsp").forward(request, response);
        else {
            HttpSession ses = request.getSession();
            if (ses.getAttribute("user") == null) ses.setAttribute("uid", uid);
            chain.doFilter(request, response);
        }
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        
    }
    
    @Override
    public void destroy() {
        
    }
    
}
