package logic;

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
	
	public static Patient SearchPatient(String name) {
		SocketObject objServer;
		ClientSocketConection client = new ClientSocketConection();
    	SocketObject objClient = new SocketObject(2,client.getServerIP()); 
		
    	System.out.println("MY IP: "+client.getThisIP()+" SERVER: " + client.getServerIP() + " PORT: " + client.getServerPort());
    	
    	client.newConnection();
    	
    	objClient.setUser(Medic.getUser());
    	objClient.setPassword(Medic.getPassHash());
    	objClient.setRole("medic");
  
    	objClient.setCommand("SEARCH PATIENT");
    	objClient.setPatientName(name);
    	//objClient.list.add(name);
    	
    	System.out.println("LOGIN INFO: " + objClient.getUser() + " " + objClient.getPassword() + " " + objClient.getRole());
		
    	//Sends info to server
		client.sendObject(objClient);
    
		//Waits for server response
		System.out.println("Waiting for server response...");
		objServer = client.getObject();
		
		//Checks if login info is correct
		if (objServer.getCommand().compareTo("SEARCH OK") == 0) {			
			System.out.println("Search return successfully!\n");
			
			//Returns Patient Object
			return objServer.patient;
		} else {
			System.out.println("Search Failed... ");
			//lblInfo.setText("Login Failed!");
			client.close();
		}
		return null;
	}
}
