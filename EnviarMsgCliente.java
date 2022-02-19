import java.io.*;
import java.net.*;

public class EnviarMsgCliente extends Thread {

	private Socket socket;
	
	public EnviarMsgCliente(Socket socket) throws IOException { 
		this.socket = socket; 
	    start(); 
	}
	
	public void run(){
		try { 
			System.out.println ("Conectado, digite sua mensagem...");
		    
		    PrintWriter out = new PrintWriter(socket.getOutputStream(),true);
		    out.flush();
		    
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in)); 
			String userInput; 
			
			System.out.println ("Para encerrar a conexão, digite 'Sair'.");
			while ((userInput = in.readLine()) != null) {
				out.println(userInput);
				
				if (userInput.equalsIgnoreCase("Sair")) {
					System.out.println("Servidor desconetado!");
					break; 
				}
				out.flush();
			}
			
			out.close();
			
		} catch (IOException e) {
			System.err.println("Problema de conexao com server!");
			System.exit(1); 
		}
	}
}

