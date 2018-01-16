package socket;

/*  The java.net package contains the basics needed for network operations. */
import java.net.*;


/* The java.io package contains the basics needed for IO operations. */
import java.io.*;

public class ClientSocketConection {
	
	public enum ProcessingState{LOGIN,COMMAND, LOGIN_OK};
	
	//Common variables of all ClientSocketConnections
	public static int SERVER_PORT = 0;
	public static String SERVER_IP = "";
	public static InetAddress IP;
	public static ProcessingState STATE;
	
	//Created each time client wants to communicate to server
	String user;
	Socket socket;
	ObjectInputStream in;
	ObjectOutputStream out;
	

	public ClientSocketConection(String serverIP, int port) {
		ClientSocketConection.SERVER_PORT = port;
		ClientSocketConection.SERVER_IP = serverIP;
		setThisIP();
	}
	
	public ClientSocketConection() {
		if(ClientSocketConection.SERVER_PORT == 0 || ClientSocketConection.SERVER_IP == "") {
			System.err.println("MISSING SERVER IP AND PORT!");
		}
	}
	
	public void newConnection() {
		try {
			this.socket = new Socket(SERVER_IP, SERVER_PORT);
			this.out = new ObjectOutputStream(this.socket.getOutputStream());
			this.in = new ObjectInputStream(this.socket.getInputStream());
			out.flush();
		} catch (UnknownHostException e) {
			System.err.println("Error UnknownHost!");
			e.printStackTrace();
		} catch(IOException io) {
			io.printStackTrace(); 
		}
	}
	
	public void newConnection(String serverIP, int port) {
		ClientSocketConection.SERVER_PORT = port;
		ClientSocketConection.SERVER_IP = serverIP;
		try {
			ClientSocketConection.IP =  InetAddress.getLocalHost();
			this.socket = new Socket(SERVER_IP, SERVER_PORT);
			this.out = new ObjectOutputStream(this.socket.getOutputStream());
			this.in = new ObjectInputStream(this.socket.getInputStream());
			out.flush();
			
		} catch (UnknownHostException e) {
			System.err.println("Error UnknownHost!");
			e.printStackTrace();
		} catch(IOException io) {
			io.printStackTrace(); 
		}
	}
	
	public void testConnection() {
		try {
			this.socket = new Socket(SERVER_IP, SERVER_PORT);
			this.out = new ObjectOutputStream(this.socket.getOutputStream());
			this.in = new ObjectInputStream(this.socket.getInputStream());
			out.flush();
			SocketObject objClient = new SocketObject(1,this.getThisIP());
			this.sendObject(objClient);
			SocketObject objServer = this.getObject();
			if (objServer.getCommand().compareTo("OK") == 0) {			
				System.out.println("Connection to server successfull!\n");
			} else {
				System.err.println("Failed to connect to server... Shuting down the client...\n");
				System.exit(0);
			}
			
		} catch (UnknownHostException e) {
			System.err.println("Error UnknownHost!");
			e.printStackTrace();
		} catch(IOException io) {
			io.printStackTrace(); 
		}
	}

	public void sendObject(SocketObject obj) {
		try {
			System.out.println(obj);
			out.writeUnshared(obj);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public SocketObject getObject() {
		SocketObject obj = null;
		try {
			obj = (SocketObject) in.readUnshared();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return obj;
	}

	public void close() {
		try {
			socket.close();
			in.close();
			out.close();
		}catch(IOException io) {
            io.printStackTrace();            
        }
	}
	
	//Getters
	public String getThisIP() {
		return ClientSocketConection.IP.getHostAddress();
	}
	public int getServerPort() {
		return ClientSocketConection.SERVER_PORT;
	}
	public String getServerIP() {
		return ClientSocketConection.SERVER_IP;
	}
	
	//Setters
	public static void setThisIP() {
		try {
			ClientSocketConection.IP =  InetAddress.getLocalHost();
		} catch (UnknownHostException e) {
			System.err.println("Error UnknownHost!");
			e.printStackTrace();
		}
	}
	
}