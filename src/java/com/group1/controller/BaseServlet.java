package com.group1.controller;

import com.group1.misc.PathInfo;
import java.io.IOException;
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
        request.setAttribute("pathInfo", new PathInfo(request.getPathInfo()));
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
    
    
    @SuppressWarnings("unchecked")
    protected abstract void processGET(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException;

    
    @SuppressWarnings("unchecked")
    protected abstract void processPOST(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException;
}
