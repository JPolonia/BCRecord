package logic;

import java.net.InetAddress;
import java.util.Scanner;

import gui.LoginWindow;
import socket.SocketObject;
import socket.ClientSocketConection;
import socket.ClientSocketConection.ProcessingState;

public class MainClient {

	public static void main(String[] args) {
		System.out.println("BCRECORD - Client Application");
		
		//Only to set the serverIP and port, the object will not be used...				
		ClientSocketConection.SERVER_IP = "172.30.7.128";
		ClientSocketConection.SERVER_PORT = 4445;
		ClientSocketConection.STATE = ProcessingState.LOGIN;
		ClientSocketConection.setThisIP();
		
		//Test Socket Connection to server
		ClientSocketConection client = new ClientSocketConection();
		client.testConnection();
		System.out.println("MY IP: "+ client.getThisIP()+" SERVER: " + client.getServerIP() + " PORT: " + client.getServerPort());
		client.close();
		
		//Starts GUI by opening LoginWindow...
		LoginWindow login = new LoginWindow();
		login.getFrame().setVisible(true);	
	}
}
