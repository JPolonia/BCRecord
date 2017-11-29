/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dnb;

import java.net.*;
import java.io.*;
import java.util.*;

public class TestServer {

 public static void main(String[] args) {
	 ServerSocketTCP servidor = new ServerSocketTCP(19999);
	 
	 servidor.TestServer();
 }
}

