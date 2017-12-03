package socket;

/*  The java.net package contains the basics needed for network operations. */
import java.net.*;
/* The java.io package contains the basics needed for IO operations. */
import java.io.*;


public class TCPClient{
	String serveraddress;
	int port;
	Socket socket;
	PrintWriter printWriter;
	String name;
//	public static void main(String[] args) throws UnknownHostException, IOException{
	public TCPClient(String name,String address, int port){
		serveraddress=address;
		this.port=port;
		this.name=name;
	}
	
	public void makeConnection() throws UnknownHostException, IOException{
		
		this.socket= new Socket(serveraddress,port);
	    this.printWriter = new PrintWriter(this.socket.getOutputStream(),true);
    	printWriter.println(this.name);
	    System.out.println("Connection to server successfull!\n");
	}
	
	public void sendValue(String value){
    	printWriter.println(value);
	}
	
	public void close() throws IOException{
		socket.close();
	}
}