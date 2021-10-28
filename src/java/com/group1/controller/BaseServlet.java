package com.group1.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

interface ErrorHandler {
    public void run() throws ServletException, IOException;
}

/**
 *
 * @author Anh Vu Nguyen {@literal <nganhvu>}
 */
public abstract class BaseServlet extends HttpServlet {
    @Override
    public void init() {
        System.out.printf("Servlet init: %s\n", getServletName());
    }

    @Override
    public void destroy() {
        System.out.printf("Servlet destroy: %s\n", getServletName());
    }

    private void processBoth(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String pathInfo = "";
        if (request.getPathInfo() != null) pathInfo = request.getPathInfo();
        StringTokenizer st = new StringTokenizer(pathInfo, "/");
        List<String> li = new ArrayList<>(st.countTokens());
        while (st.hasMoreTokens()) li.add(st.nextToken());
        request.setAttribute("pathQuery", li);
    }

    private void handleError(HttpServletRequest request, HttpServletResponse response, ErrorHandler handler) throws ServletException, IOException {
        try {
            handler.run();
        } catch (Throwable error) {
            request.setAttribute("errorCause", error.getClass());
            request.setAttribute("errorMessage", error.toString().replace("<", "&lt;").replace(">", "&gt;"));
            request.setAttribute("errorLocation", String.format("%s (%s)", this.getServletName(), this.getClass().toString()));
            StringBuilder stackMsg = new StringBuilder();
            for (StackTraceElement trace: error.getStackTrace()) stackMsg.append(trace).append('\n');
            request.setAttribute("errorTraceStack", stackMsg.toString());
            request.getRequestDispatcher("/WEB-INF/spec-pages/servlet_error.jsp").include(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        handleError(request, response, () -> {
            processBoth(request, response);
            processGET(request, response);
        });
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        handleError(request, response, () -> {
            processBoth(request, response);
            processPOST(request, response);
        });
    }
    
    protected abstract void processGET(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException;

    protected abstract void processPOST(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException;
}
