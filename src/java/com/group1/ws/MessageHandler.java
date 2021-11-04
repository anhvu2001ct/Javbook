package com.group1.ws;

import com.google.gson.JsonObject;
import com.group1.misc.Secret;
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
        clients.putIfAbsent(id2, ConcurrentHashMap.newKeySet());
        clients.get(id2).add(session);
    }
    
    @Override
    protected void removeClient(Session session) {
        Set<Session> client = clients.get(id2);
        client.remove(session);
        if (client.isEmpty()) clients.remove(id2);
    }

    @Override
    protected void onMessage(Session session, JsonObject msg) {
        String to = msg.getAsJsonPrimitive("to").getAsString();
        Set<Session> client = clients.get(Secret.decode2(to));
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
