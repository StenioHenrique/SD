import java.net.*; 
import java.io.*; 

public class ReceberMsgServer extends Thread {
	protected Socket clientSocket;

	public ReceberMsgServer (Socket clientSoc){
		clientSocket = clientSoc;
		start();
	}

	public void run() {
		System.out.println ("New Communication Thread Started");
		try {    	
			BufferedReader in = new BufferedReader( 
			new InputStreamReader( clientSocket.getInputStream())); 
			String inputLine; 
			while ((inputLine = in.readLine()) != null){ 
				System.out.println ("Cliente: " + inputLine);
				if (inputLine.equals("Bye.")) 
					break; 
			} 
			in.close(); 
			clientSocket.close(); 		
		}catch (IOException e) { 
			System.err.println("Problem with Communication Server");
			System.exit(1); 
		} 
	}
} 
