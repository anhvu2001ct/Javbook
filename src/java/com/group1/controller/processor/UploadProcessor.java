package com.group1.controller.processor;

import com.group1.controller.ServerInit;
import com.group1.model.db.IO;
import com.group1.rest.BaseProcessor;
import com.group1.rest.ServeAt;
import com.group1.rest.ServeMethod;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author Anh Vu Nguyen {@literal <nganhvu>}
 */
@MultipartConfig(fileSizeThreshold = 1024*1024,
        maxFileSize = 1024*1024*3,
        maxRequestSize = 1024*1024*6)
@WebServlet("/process/upload/*")
public class UploadProcessor extends BaseProcessor {
    @ServeAt(value="/image", method=ServeMethod.POST)
    public void serve(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Part part = request.getPart("file");
        String savePath = request.getParameter("savePath");
        String fileName = request.getParameter("fileName");
        part.write(IO.getPathToFile(ServerInit.imgPath, savePath, fileName).toString());
        response.getWriter().print("done");
    }
}
