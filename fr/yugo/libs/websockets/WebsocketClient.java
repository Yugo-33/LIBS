package fr.yugo.libs.websockets;

import java.io.IOException;
import java.io.StringReader;
import java.net.URI;

import javax.websocket.ClientEndpoint;
import javax.websocket.CloseReason;
import javax.websocket.ContainerProvider;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.WebSocketContainer;

@ClientEndpoint
public abstract class WebsocketClient {

	//private static final Logger LOGGER = Logger.getLogger(WebsocketClient.class.getName());

    public WebsocketClient(URI endpointURI, boolean test) {
        try {
            WebSocketContainer container = ContainerProvider.getWebSocketContainer();
            container.connectToServer(this, endpointURI);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Callback hook for Connection open events.
     *
     * @param userSession the userSession which is opened.
     */
    @OnOpen
    public abstract void onOpen(Session userSession);

    /**
     * Callback hook for Connection close events.
     *
     * @param userSession the userSession which is getting closed.
     * @param reason the reason for connection close
     */
    @OnClose
    public abstract void onClose(Session userSession, CloseReason reason);

    /**
     * Callback hook for Message Events. This method will be invoked when a client send a message.
     *
     * @param message The text message
     */
    @OnMessage
	public abstract void onMessage(String message, Session session);

    public static void sendMessage(Session session, String message) {
	    if (session != null) {
	      session.getAsyncRemote().sendText(message);
	    }
	  }
    
    public static void close(Session session) throws IOException {
    	session.close();
    }
	
}
