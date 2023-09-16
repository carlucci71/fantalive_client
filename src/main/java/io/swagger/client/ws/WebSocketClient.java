package io.swagger.client.ws;
import javax.websocket.ContainerProvider;
import javax.websocket.Session;
import javax.websocket.WebSocketContainer;
import java.net.URI;

public class WebSocketClient {
    public static void main(String[] args) {
        String serverUri = "ws://example.com/websocket"; // Sostituisci con l'URL del server WebSocket a cui desideri connetterti
        serverUri = "ws://app.3utilities.com:8080/messaggi-websocket";
        
        WebSocketContainer container = ContainerProvider.getWebSocketContainer();
        
        try {
            Session session = container.connectToServer(YourWebSocketEndpoint.class, new URI(serverUri));

            int i=0;
            while(i<1) {
                // Puoi ora utilizzare la sessione WebSocket per inviare e ricevere dati
                session.getBasicRemote().sendText("{operazione: \"ping\", nomegiocatore: \"dante\", idgiocatore: \"2\"}");
                Thread.currentThread().sleep(2000);
            }
            
            // Chiudi la sessione quando hai finito
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
