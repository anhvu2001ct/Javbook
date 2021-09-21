/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group1.controller;

import com.group1.model.db.SQLConnector;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import lombok.Getter;

/**
 *
 * @author Anh Vu Nguyen {@literal <nganhvu>}
 */
public class ServerInit implements ServletContextListener {
    @Getter
    private ServletContext context;
    
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        context = sce.getServletContext();
        System.out.println("Init " + Thread.currentThread());
        SQLConnector.establishConnection();
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("Down " + Thread.currentThread());
        SQLConnector.closeConnection();
    }
}