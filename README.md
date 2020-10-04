# LIBS

## WEBSOCKETS
Simple Websocket client and server
You need to import some maven libs
```xml
<dependency>
	<groupId>org.glassfish.tyrus.bundles</groupId>
	<artifactId>tyrus-standalone-client</artifactId>
	<version>1.15</version>
</dependency>
<dependency>
    	<groupId>org.glassfish.tyrus</groupId>
    	<artifactId>tyrus-server</artifactId>
   	<version>1.12</version>
</dependency>	
<dependency>
	<groupId>org.glassfish.tyrus</groupId>
	<artifactId>tyrus-container-grizzly-server</artifactId>
	<version>1.12</version>
</dependency>
```

## RUN
###### A java file for multi threading your code
```java
Run run = new Run() {
  @Override
  public void run() {
    //YOUR CODE
  }
};
run.runTask(true);
```

## Tray
###### All you need for your Tray in java
You need to import Run lib too
```java
//FILE SYSTEM
Image image = Toolkit.getDefaultToolkit().createImage(new File("C:/path/to/your/image.png").getAbsolutePath());

//OR FROM CLASSPATH
Image image = Toolkit.getDefaultToolkit().createImage(getClass().getResource("image.png"));
Tray tray = new Tray("Name", image);

//CUSTOM PUSH NOTIF ICON
tray.initCustomIcon(Runtime.getRuntime());

//NOTIF BASIC ICON
tray.notif("Title", "Desc", MessageType.INFO);

//NOTIF CUSTOM ICON
tray.notif("Title", "Desc", new File("C:/path/to/your/image.png"));
```
