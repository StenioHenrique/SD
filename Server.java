import java.net.*; 
import java.io.*; 


public class Server {
	protected Socket clientSocket;
	
	public static void main(String[] args) throws IOException { 
		ServerSocket serverSocket = null;
		try { 
			serverSocket = new ServerSocket(10008); 
			System.out.println ("Connection Socket Created");
			try { 
				while (true){
					Socket s = serverSocket.accept(); 
					System.out.println ("Waiting for Connection");
					new EnviarMsgServer(s);
					new ReceberMsgServer(s); 
				}
			} catch (IOException e) {
				System.err.println("Accept failed."); 
				System.exit(1); 
			}
		} catch (IOException e) {
			System.err.println("Could not listen on port: 10008."); 
			System.exit(1); 
		} finally {
			try {
				serverSocket.close(); 
			} catch (IOException e) { 
				System.err.println("Could not close port: 10008."); 
				System.exit(1); 
			} 
		}
	}
}
