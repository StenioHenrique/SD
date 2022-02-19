import java.net.*; 
import java.io.*; 

public class EnviarMsgServer extends Thread {
	protected Socket clientSocket;
	
	public EnviarMsgServer (Socket clientSoc) {
		clientSocket = clientSoc;
		start();
	}

	public void run() {
		System.out.println ("New Communication Thread Started");
		try { 
			PrintWriter out = new PrintWriter(clientSocket.getOutputStream(),true); 
			//variavel que tá lendo do teclado padrao 
			BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
			//variavel que recebe a leitura 
			String userInput;
			
			//System.out.println ("Type Message (\"Bye.\" to quit)");
			while ((userInput = stdIn.readLine()) != null) {
				out.println(userInput);
				if (userInput.equals("Bye."))
					break;
			}
			   
			out.close(); 
			clientSocket.close(); 
		} 
		catch (IOException e) { 
			System.err.println("Problem with Communication Server");
			System.exit(1); 
		} 
	}
} 
