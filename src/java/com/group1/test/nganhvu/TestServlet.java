package com.group1.test.nganhvu;

import com.group1.controller.BaseServlet;
import com.group1.controller.ServerInit;
import static com.group1.controller.ServerInit.gson;
import com.group1.misc.Sout;
import com.group1.model.db.IO;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;

@AllArgsConstructor
class Account {
    String name;
    int age;
}

/**
 *
 * @author Anh Vu Nguyen {@literal <nganhvu>}
 */
@WebServlet("/test/nganhvu/")
public class TestServlet extends BaseServlet {
    int cnt = 0;
    
    @Override
    protected void processGET(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println(++cnt);
        List<String> files = IO.getFilesName(ServerInit.webPath, "assets/js/common");
        Sout.print(gson.toJson(files));
        request.getRequestDispatcher("/test/nganhvu/websocket.jsp").forward(request, response);
    }

    @Override
    protected void processPOST(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
    }
}
