package com.group1.ws;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import static com.group1.controller.ServerInit.gson;
import com.group1.misc.Secret;
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
    protected String id, id2;
    
    @OnOpen
    public void open(Session session) {
//        System.out.printf("New connection. SID = %s\n", session.getId());
        onOpen(session);
    }

    @OnMessage
    public void message(Session session, String msg) throws IOException {
       JsonArray arr = gson.fromJson(msg, JsonArray.class);
       if (arr.size() == 2) {
           id2 = arr.get(1).getAsString();
           id = Secret.decode2(id2);
           addClient(session);
           return;
       }
       
       onMessage(session, arr.get(0).getAsJsonObject());
    }
   
    @OnError
    public void error(Session session, Throwable error) {
        System.out.printf("%s - ERROR. SID = %s, id = %s. Code = %s\n", this.getClass().getName(), session.getId(), id, error.getMessage());
        onError(session, error);
    }

    @OnClose
    public void close(Session session, CloseReason reason) {
//        System.out.printf("Connection closed. SID = %s, id = %s\n", session.getId(), id);
        onClose(session, reason);
    }
    
    protected abstract void addClient(Session session);
    protected abstract void removeClient(Session session);
    protected abstract void onMessage(Session session, JsonObject msg);
    protected abstract void onClose(Session session, CloseReason reason);
    protected abstract void onError(Session session, Throwable error);
    
    protected void onOpen(Session session) {}
}
