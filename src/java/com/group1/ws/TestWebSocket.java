package com.group1.ws;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.group1.controller.ServerInit;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import javax.websocket.CloseReason;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import lombok.AllArgsConstructor;

@AllArgsConstructor
class TheMessage {
    String from;
    JsonElement data;
}

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
        
        String to = msg.getAsJsonPrimitive("to").getAsString();
        Session client = clients.get(to);
        if (client != null) {
            TheMessage message = new TheMessage(id, msg.get("data"));
            client.getAsyncRemote().sendText(ServerInit.gson.toJson(message));
        }
    }

    @Override
    protected void onClose(Session session, CloseReason reason) {
        if (id != null) clients.remove(id);
    }
    
}
