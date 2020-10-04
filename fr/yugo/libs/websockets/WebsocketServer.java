package fr.yugo.libs.websockets;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/")
public abstract class WebsocketServer {

	 @OnOpen
	 public abstract void onOpen(Session session);
	 
	 @OnClose
	 public abstract void onClose(Session session);
	    
	 @OnMessage
	 public abstract void onMessage(String message, Session session);
	    
	 @OnError
	 public abstract void onError(Throwable t);
	
}
