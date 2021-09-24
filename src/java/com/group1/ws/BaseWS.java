/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group1.ws;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import static com.group1.controller.ServerInit.gson;
import com.group1.misc.Sout;
import java.io.IOException;
import javax.websocket.CloseReason;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;

/**
 *
 * @author Anh Vu Nguyen {@literal <nganhvu>}
 */
public abstract class BaseWS {
    protected String id;
    
    @OnOpen
    public void open(Session session) {
        System.out.printf("New connection. ID = %s\n", session.getId());
        onOpen(session);
    }

   @OnMessage
   public void message(Session session, String msg) throws IOException {
       JsonArray arr = gson.fromJson(msg, JsonArray.class);
       if (arr.size() == 2) {
           id = arr.get(1).getAsString();
           addClient(session);
           return;
       }
       onMessage(session, arr.get(0).getAsJsonObject());
   }
   
   @OnError
    public void error(Session session, Throwable error) {
        Sout sout = new Sout("OnError");
        sout.add("ID = ", id, error);
        sout.print();
        onError(session, error);
    } 	

    @OnClose
    public void close(Session session, CloseReason reason) {
        System.out.printf("Connection closed. ID = %s\n", session.getId());
        onClose(session, reason);
    }
    
    protected abstract void addClient(Session session);
    protected abstract void onMessage(Session session, JsonObject msg);
    protected abstract void onClose(Session session, CloseReason reason);
    
    protected void onOpen(Session session) {}
    protected void onError(Session session, Throwable error) {}
}
