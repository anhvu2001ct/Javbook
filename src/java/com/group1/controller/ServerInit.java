package com.group1.controller;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.group1.misc.Secret;
import com.group1.model.db.IO;
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
    public static JsonObject config;
    public static Gson gson = new Gson();
    
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        context = sce.getServletContext();
        String rootPath = Paths.get(context.getRealPath("")).getParent().getParent().toString();
        dataPath = Paths.get(rootPath, "data").toString();
        imgPath = Paths.get(rootPath, "web/assets/img").toString();
        config = gson.fromJson(IO.getReader(context.getRealPath(""), "WEB-INF/config.json"), JsonObject.class);
        SQLConnector.establishConnection();
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        SQLConnector.closeConnection();
    }
}