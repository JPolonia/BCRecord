package UnitTest;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import socket.SocketObject;
import socket.ClientSocketConection;
import socket.ClientSocketConection.ProcessingState;
import database.PostgreSQL;
import logic.Manager;
import socket.ClientSocketConection;
import socket.ServerSocketConection;
import socket.SocketObject;

public class JunitTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	/*
	 * @Test public void testLogin_client_AsMedic() {
	 * 
	 * String username = "joao"; String password = "1"; String role = "medic";
	 * 
	 * SocketObject cliente_paciente = new SocketObject(2,"000000000");
	 * 
	 * cliente_paciente.setUser(username); cliente_paciente.setPassword(password);
	 * cliente_paciente.setRole(role); cliente_paciente.setCommand("LOGIN");
	 * 
	 * System.out.println("LOGIN INFO: " + cliente_paciente.getUser() + " " +
	 * cliente_paciente.getPassword() + " " + cliente_paciente.getRole());
	 * 
	 * 
	 * }
	 */
	@Test
	public void test_database_login() {

		String userDB = "sibd17g22";
		String passDB = "1";
		String url = "jdbc:postgresql://dbm.fe.up.pt:5432/sibd17g22"; // ?currentSchema=BCRecord
		String ssl_parameter = "false";

		PostgreSQL p = new PostgreSQL(url, userDB, passDB, ssl_parameter);

		assertEquals("medic", p.login("joao", "1"));
		assertEquals(null, p.login("joao", "2"));
		

	}
	
	/*@Test
	public void test_database_registMedic() {

		String userDB = "sibd17g22";
		String passDB = "1";
		String url = "jdbc:postgresql://dbm.fe.up.pt:5432/sibd17g22"; // ?currentSchema=BCRecord
		String ssl_parameter = "false";

		PostgreSQL p = new PostgreSQL(url, userDB, passDB, ssl_parameter);

		assertEquals(1 , p.registMedic("joao", "diogo2", "1"));
		assertEquals(0,p.registMedic("joao", "joao", "2"));
	}*/
	/*
	@Test
	public void test_database_registPatient() {

		String userDB = "sibd17g22";
		String passDB = "1";
		String url = "jdbc:postgresql://dbm.fe.up.pt:5432/sibd17g22"; // ?currentSchema=BCRecord
		String ssl_parameter = "false";

		PostgreSQL p = new PostgreSQL(url, userDB, passDB, ssl_parameter);

		assertEquals(1 , p.registPatient("diogo", "diogo", "diogo", "1111", 222, "sd", "sd", "sd"));
	}*/
	
	/*@Test
	public void test_server_login() {

		String userDB = "sibd17g22";
		String passDB = "1";
		String url = "jdbc:postgresql://dbm.fe.up.pt:5432/sibd17g22"; // ?currentSchema=BCRecord
		String ssl_parameter = "false";
		String username = "joao";
		String password = "1";
		String role = "medic";
		PostgreSQL p = new PostgreSQL(url, userDB, passDB, ssl_parameter);

		SocketObject objServer;
		
    	SocketObject objClient = new SocketObject(2,"000000"); 
		    	
	
    	objClient.setUser(username);
    	objClient.setPassword(password);
    	objClient.setRole(role);
    	
		
    	//Sends login info to server
		
	}*/
	
	@Test
	public void test_client_login() {

		String userDB = "sibd17g22";
		String passDB = "1";
		String url = "jdbc:postgresql://dbm.fe.up.pt:5432/sibd17g22"; // ?currentSchema=BCRecord
		String ssl_parameter = "false";
		String username = "joao";
		String password = "1";
		String role = "medic";
		PostgreSQL p = new PostgreSQL(url, userDB, passDB, ssl_parameter);

		ClientSocketConection.SERVER_IP = "localhost";
		ClientSocketConection.SERVER_PORT = 4445;
		ClientSocketConection.STATE = ProcessingState.LOGIN;
		ClientSocketConection.setThisIP();
		
		//Test Socket Connection to server
		ClientSocketConection client = new ClientSocketConection();
		client.testConnection();
		System.out.println("MY IP: "+ client.getThisIP()+" SERVER: " + client.getServerIP() + " PORT: " + client.getServerPort());
		client.close();
		SocketObject objServer;
		
    	SocketObject objClient = new SocketObject(2,"000000"); 
		    	
	
    	objClient.setUser(username);
    	objClient.setPassword(password);
    	objClient.setRole(role);
    	
		Boolean error = Manager.Login("joao","1","medic");
		Boolean error2 = Manager.Login("joaoooo","1","medic");
		assertEquals(false, error);
		assertEquals(true, error2);
		
		
    	//Sends login info to server
		
	}
	
	
}