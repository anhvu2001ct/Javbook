package com.group1.ws;

import com.google.gson.JsonObject;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import javax.websocket.CloseReason;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

/**
 *
 * @author Anh Vu Nguyen {@literal <nganhvu>}
 */
@ServerEndpoint("/ws/test")
public class MessageHandler extends BaseWS {
    private static ConcurrentMap<String, Session> clients = new ConcurrentHashMap<String, Session>();

    @Override
    protected void addClient(Session session) {
        clients.put(id, session);
    }

    @Override
    protected void onMessage(Session session, JsonObject msg) {
        String to = msg.getAsJsonPrimitive("to").getAsString();
        Session client = clients.get(to);
        if (client != null) {
            msg.remove("to");
            msg.addProperty("from", id);
            client.getAsyncRemote().sendText(msg.toString());
        }
    }

    @Override
    protected void onClose(Session session, CloseReason reason) {
        if (id != null) clients.remove(id);
    }
    
}
