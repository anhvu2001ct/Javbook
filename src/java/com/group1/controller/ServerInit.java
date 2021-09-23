package com.group1.controller;

import com.group1.model.db.SQLConnector;
import java.nio.file.Paths;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 *
 * @author Anh Vu Nguyen {@literal <nganhvu>}
 */
//@Getter
public class ServerInit implements ServletContextListener {
    public static ServletContext context;
    public static String dataPath, imgPath;
    
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        context = sce.getServletContext();
        String rootPath = Paths.get(context.getRealPath("")).getParent().getParent().toString();
        dataPath = Paths.get(rootPath, "data").toString();
        imgPath = Paths.get(rootPath, "web/assets/img").toString();
        SQLConnector.establishConnection();
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        SQLConnector.closeConnection();
    }
}