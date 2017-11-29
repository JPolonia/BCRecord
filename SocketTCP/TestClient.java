/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbn;

/*  The java.net package contains the basics needed for network operations. */
import java.net.*;
/* The java.io package contains the basics needed for IO operations. */
import java.io.*;

/**
 *
 * @author up201307994
 */
public class TestClient {
  
    public static void main(String[] args){
    	
    	ClientSocketTCP cliente = new ClientSocketTCP("localhost",19999);
    	
    	cliente.testSocketConnection("exit");
    	
    }
        
}