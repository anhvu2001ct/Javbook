package com.group1.controller.processor;

import com.group1.misc.Sout;
import com.group1.rest.BaseProcessor;
import com.group1.rest.ServeAt;
import com.group1.rest.ServeMethod;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Anh Vu Nguyen {@literal <nganhvu>}
 */
@WebServlet("/process/test/*")
public class TestProcessor extends BaseProcessor {
    private void printParams(HttpServletRequest request) {
        request.getParameterMap().forEach((key, values) -> {
            System.out.print(key + ": ");
            Sout.print(values);
        });
    }
    
    @ServeAt("/sendGET")
    public void serveGET(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Sout.print("\n---Params from GET");
        printParams(request);
    }
    
    @ServeAt(value="/sendPOST", method=ServeMethod.POST)
    public void servePOST(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Sout.print("\n---Params from POST");
        printParams(request);
    }
    
    @ServeAt(value="/sendBoth", method={ServeMethod.GET, ServeMethod.POST})
    public void serveBoth(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Sout.print("\n---Params from both");
        printParams(request);
    }
}
