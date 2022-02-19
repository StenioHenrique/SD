import java.io.*;
import java.net.*;

//Classe responsavel por implementar a thread que recebe as mensagens do server
//Ou seja, ela escuta o server

public class ReceberMsgCliente extends Thread {
	protected Socket socket; 
	
	public ReceberMsgCliente(Socket socket) throws IOException {
		this.socket = socket; 
		start();
	}
	
	public void run(){
		try {
			System.out.println ("...Ou aguarde o envio por parte do server!");

			BufferedReader in = new BufferedReader(
			new InputStreamReader(socket.getInputStream())); 
			
			String inputLine = ""; 
			
			//Leitura e impressao na tela dos dados que vem do server
			
			while(!"Sair".equalsIgnoreCase(inputLine)) {
				if(in.ready()){
					inputLine = in.readLine();
					if(inputLine.equals("Sair")) {
						System.out.print("Servidor caiu! \r\n");
						break; 
					} else
						System.out.print("Server: "+ inputLine +"\r\n");
					}
			}
			
			socket.close();
			in.close();
			
		} catch (IOException e) {
			System.err.println("Problema de conexao com server!");
			System.exit(1); 
		}
		
	}
}