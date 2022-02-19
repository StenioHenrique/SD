import java.io.*;
import java.net.*;

public class EnviarMsgCliente extends Thread {
	private Socket socket;
	
	public EnviarMsgCliente(Socket sc) throws IOException { 
		socket = sc; 
	    start(); 
	}
	
	public void run(){
		try { 
			System.out.println ("Conectado, digite sua mensagem...");
		    
		    PrintWriter out = new PrintWriter(socket.getOutputStream(),true);
		    out.flush();
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in)); 
			String userInput = ""; 
			
			System.out.println ("Para encerrar a conexão, digite 'Sair'.");
			while ((userInput = in.readLine()) != null) {
				out.println(userInput);
				if (userInput.equalsIgnoreCase("Sair")) {
					System.out.println("Desconectado!");
					break; 
				}
				out.flush();
			}
			
			out.close();
			socket.close();
			
		} catch (IOException e) {
			System.err.println("Problema de conexao com server!");
			System.exit(1); 
		}
	}
}

