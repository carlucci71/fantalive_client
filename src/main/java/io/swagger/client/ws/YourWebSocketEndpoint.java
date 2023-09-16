package io.swagger.client.ws;
import javax.websocket.ClientEndpoint;
import javax.websocket.CloseReason;
import javax.websocket.Endpoint;
import javax.websocket.EndpointConfig;
import javax.websocket.MessageHandler;
import javax.websocket.Session;

@ClientEndpoint
public class YourWebSocketEndpoint extends Endpoint {
    @Override
    public void onOpen(Session session, EndpointConfig config) {
        System.out.println("Connessione WebSocket aperta.");
        
        // Aggiungi un gestore per ricevere messaggi
        session.addMessageHandler(new MessageHandler.Whole<String>() {
            @Override
            public void onMessage(String message) {
                System.out.println("Messaggio ricevuto: " + message);
            }
        });
    }

    @Override
    public void onClose(Session session, CloseReason closeReason) {
        System.out.println("Connessione WebSocket chiusa.");
    }

    @Override
    public void onError(Session session, Throwable throwable) {
        System.err.println("Errore WebSocket: " + throwable.getMessage());
    }
}
