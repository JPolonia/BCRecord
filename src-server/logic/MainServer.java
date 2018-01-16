package logic;

import socket.ServerSocketConection;

/**
 * @author Jo�o
 * Main Server Class, responsible for initing, authenticate and process the requests from client
 */
public class MainServer {

	public static void main(String[] args) {
		
		 String userDB   = "sibd17g22";
		 String passDB = "1";
		 String url = "jdbc:postgresql://dbm.fe.up.pt:5432/sibd17g22";    //?currentSchema=BCRecord
		 String ssl_parameter = "false";
		
		 ServerSocketConection server = new ServerSocketConection(4445, userDB,passDB,url,ssl_parameter);
		 server.runServer();
	}

}
