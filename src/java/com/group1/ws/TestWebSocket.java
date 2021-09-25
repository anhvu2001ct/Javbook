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
public class TestWebSocket extends BaseWS {
    private static ConcurrentMap<String, Session> clients = new ConcurrentHashMap<String, Session>();

    @Override
    protected void addClient(Session session) {
        clients.put(id, session);
    }

    @Override
    protected void onMessage(Session session, JsonObject msg) {
        System.out.println(msg);
        Session client = clients.get(msg.getAsJsonPrimitive("to").getAsString());
        if (client != null) {
            client.getAsyncRemote().sendText(msg.get("data").toString());
        }
    }

    @Override
    protected void onClose(Session session, CloseReason reason) {
        if (id != null) clients.remove(id);
    }
    
}
