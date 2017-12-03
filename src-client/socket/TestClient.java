package socket;

/*  The java.net package contains the basics needed for network operations. */
import java.net.*;
import java.util.Scanner;
/* The java.io package contains the basics needed for IO operations. */
import java.io.*;


public class TestClient {
  
    public static void main(String[] args) throws UnknownHostException, IOException{
    	
    	String value = null;
    	//String analyse= null;
    	String name= null;
    	Scanner scanner = new Scanner(System.in);
	    System.out.println("Client name:");
		name = scanner.nextLine();
    	TCPClient cliente = new TCPClient(name,"localhost",4444);
    	cliente.makeConnection();
    	
    	while(true){
    	    System.out.println("What value to send?");
    		value = scanner.nextLine();
    		cliente.sendValue(value);
    		if(value.compareTo("exit")==0)
    			break;
    	}
    	cliente.close();
    	scanner.close();
    	
    }
        
}
