package socket;

import java.net.*;
import java.io.*;

public class TCPServer {
	public static int PORT;
	ServerSocket serverSocket;

	public TCPServer(int port){
		try{
			TCPServer.PORT = port;
			serverSocket= new ServerSocket(PORT);
			System.out.println("Server up & running ...");
		}catch (Exception e){
			System.out.println("Error creating socket on that Port ...");
		}
		
	}
	
	public void runServer() throws IOException{
		while(true){
			Socket socket = serverSocket.accept();	
			new ServerThread(socket).start();			
		}
	}
	
	public class ServerThread extends Thread{
		Socket socket;
		
		ServerThread(Socket socket){
			this.socket=socket;
		}
		
		public void run(){
			try{
				String message= null;
				String name=null;
				BufferedReader bufferedReader= new BufferedReader( new InputStreamReader(this.socket.getInputStream()));
				name=bufferedReader.readLine();
				System.out.println("Client "+name+" has connected.");
				while((message = bufferedReader.readLine()) != null){
					System.out.println("Incoming client message from "+ name +": " + message);
					if(message.toString().equals("exit")){
						System.out.println("Client "+name+ " has disconnected");
						socket.close();
						break;
					}
				}
				
			}catch (IOException e){
				e.printStackTrace();
			}
		}
	}	
}
