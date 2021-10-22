package com.group1.ws;

import com.google.gson.JsonObject;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import javax.websocket.CloseReason;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

/**
 *
 * @author Anh Vu Nguyen {@literal <nganhvu>}
 */
@ServerEndpoint("/ws/test")
public class MessageHandler extends BaseWS {
    private static Map<String, Set<Session>> clients = new ConcurrentHashMap<>();

    @Override
    protected void addClient(Session session) {
        clients.putIfAbsent(id, ConcurrentHashMap.newKeySet());
        clients.get(id).add(session);
    }
    
    @Override
    protected void removeClient(Session session) {
        Set<Session> client = clients.get(id);
        client.remove(session);
        if (client.isEmpty()) clients.remove(id);
    }

    @Override
    protected void onMessage(Session session, JsonObject msg) {
        String to = msg.getAsJsonPrimitive("to").getAsString();
        Set<Session> client = clients.get(to);
        if (client != null) {
            msg.remove("to");
            msg.addProperty("from", id);
            client.forEach(c -> c.getAsyncRemote().sendText(msg.toString()));
        }
    }

    @Override
    protected void onClose(Session session, CloseReason reason) {
        removeClient(session);
    }

    @Override
    protected void onError(Session session, Throwable error) {
        removeClient(session);
    }
    
}
