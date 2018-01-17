package logic;

import gui.MedicWindow;
import gui.PatientWindow;
import socket.ClientSocketConection;
import socket.SocketObject;

public final class Manager {
	
	private static int myStaticMember;
	
	private Manager() {
		myStaticMember = 1;
	}

	public static boolean Login(String username, String password, String role) {
		SocketObject objServer;
		ClientSocketConection client = new ClientSocketConection();
    	SocketObject objClient = new SocketObject(2,client.getServerIP()); 
		
    	System.out.println("MY IP: "+client.getThisIP()+" SERVER: " + client.getServerIP() + " PORT: " + client.getServerPort());
    	
    	client.newConnection();
    	
    	objClient.setUser(username);
    	objClient.setPassword(password);
    	objClient.setRole(role);
    	objClient.setCommand("LOGIN");
    	
    	System.out.println("LOGIN INFO: " + objClient.getUser() + " " + objClient.getPassword() + " " + objClient.getRole());
		
    	//Sends login info to server
		client.sendObject(objClient);
    
		//Waits for server response
		System.out.println("Waiting for server response...");
		objServer = client.getObject();
		
		//Checks if login info is correct
		if (objServer.getCommand().compareTo("LOGIN OK") == 0) {			
			System.out.println("Login to server successfull!\n");
			//Create Medic Object
			Medic.setUser(username);
			Medic.setPassHash(password);
			return false;
		} else {
			System.out.println("Failed to Login... try again\n");
			//lblInfo.setText("Login Failed!");
			client.close();
		}
		return true;
	}
}
