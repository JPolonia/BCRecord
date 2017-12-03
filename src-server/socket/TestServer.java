package socket;
import java.io.*;

public class TestServer {

 public static void main(String[] args) throws IOException {
	 TCPServer server = new TCPServer(4444);
	 server.runServer();
 }
}

