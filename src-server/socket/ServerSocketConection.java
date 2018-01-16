package socket;

import java.net.*;
import java.util.ArrayList;

import database.PostgreSQL;

import java.io.*;

/**
 * @author João
 *
 */
public class ServerSocketConection {
	
	public enum ProcessingState{CONNECT,COMMAND,DUMMY};	
	public static int PORT;
	
	String userDB;
	String passDB;
	String url;    //?currentSchema=BCRecord
	String ssl_parameter;
	
	/**
	 * Socket listens for new connections
	 */
	ServerSocket serverSocket;
	


	public ServerSocketConection(int port, String userDB, String passDB, String url, String ssl_parameter) {
		try {
			ServerSocketConection.PORT = port;
			serverSocket = new ServerSocket(PORT);
			System.out.println("Server up & running ...");
			this.userDB = userDB;
			this.passDB = passDB;
			this.url = url;
			this.ssl_parameter = ssl_parameter;
		} catch (Exception e) {
			System.out.println("Error creating socket on that Port ...");
		}
	}



	public void runServer() {
		while (true) {
			try {
				Socket socket = serverSocket.accept();
				new ClientThread(socket).start();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public class ClientThread extends Thread {
		
		//ServerManager manager; 
		
		Socket socket;
		
		ObjectOutputStream out;
		ObjectInputStream in;
		
		private ProcessingState currentState;
		
		String name, user, pass, clientIP, role;
		
		boolean run = true;
		    
		PostgreSQL p;
		
		
		ClientThread(Socket serverSocket) {
			this.socket = serverSocket;
		}

		public void run() {
			try {
	
				SocketObject objClient,objServer;
				
				objClient = new SocketObject(1,serverSocket.getInetAddress().getHostAddress()); 
				
				
				p = new PostgreSQL(url, userDB, passDB, ssl_parameter);
				
				in= new ObjectInputStream((this.socket).getInputStream());
				out= new ObjectOutputStream((this.socket).getOutputStream());
				
				objServer = new SocketObject(1,serverSocket.getInetAddress().getHostAddress()); 
				//objServer.list = new  ArrayList<String>();		
				
				currentState = ProcessingState.COMMAND;				
								
				while (run) {
					//Read Socket
					try {
						objClient = (SocketObject) in.readUnshared();
					} catch (Exception e) {
						e.printStackTrace();
						System.out.println(this.clientIP + " has disconnected");
						socket.close();
						run = false;
					}
					
					if(objClient.getNumber() == 1) currentState = ProcessingState.CONNECT;
					System.out.println(objClient.getNumber() +" "+ currentState.toString() + " " + objClient.getCommand());
					
					//Process data
					switch (currentState) {
						case CONNECT:
							this.clientIP = objClient.getIPaddress();
							objServer.setCommand("OK");
							out.writeUnshared(objServer);
							System.out.println(this.clientIP + " has connected.");
							socket.close();
			        		System.out.println(this.clientIP + " has disconnected.");
							run = false;
			        		break;	
				        case COMMAND:
				        	run = processCommand(objClient,objServer);
				        	out.writeUnshared(objServer);
				        	if(!run) {
				        		socket.close();
				        		System.out.println(objClient.getUser() + " has disconnected.");
				        	}
				            break;
				        case DUMMY:
				        	break;
				        default:
				        	break;
				    }
				}

			} catch (IOException e) {
				e.printStackTrace();
		
			}
		}
		
		public boolean processLogin(SocketObject obj) {	
			this.role = p.login(obj.getUser(), obj.getPassword());
			
			if (role == null) {
    			System.out.println("Error login try again...");
    			return false;
    		}else {
        		System.out.println(obj.getUser() + " has connected.");
    		}
			
			return true;
		}
		
		public boolean processCommand(SocketObject objClient, SocketObject objServer) {
			switch (objClient.getCommand().toString()) {
				case "LOGIN": 
					if (!processLogin(objClient)) {
						objServer.setCommand("ERROR");
						return false;
					}else {
						objServer.setCommand("LOGIN OK");
		    			objServer.setRole(role);
		    			return true;
					}
				case "SHUTDOWN": System.exit(0);
				case "INSERT MEDIC": 
					if(p.registMedic("Test", objClient.getNewUser(), objClient.getNewPassword())==1) {
						objServer.setCommand("INSERT OK");
						return true;
					}else {
						objServer.setCommand("ERROR");
						return false;
					}
				case "INSERT PATIENT": 
					if(p.registPatient("Test",  objClient.getNewUser(), objClient.getNewPassword(), "", 0, "", "", "")==1) {
						objServer.setCommand("INSERT OK");
						return true;
					}else {
						objServer.setCommand("ERROR");
						return false;
					}
				case "LOGOUT": return false;
				default: return true;
			}
		}
	}
}