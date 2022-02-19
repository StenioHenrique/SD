import java.net.*; 
import java.io.*; 

//Classe responsavel por implementar a thread que recebe as mensagens do cliente
//Ou seja, ela escuta o cliente
public class ReceberMsgServer extends Thread {
	protected Socket clientSocket;

	public ReceberMsgServer (Socket clientSoc){
		clientSocket = clientSoc;
		start();
	}
	
	public void run() {
		
		try { 
			System.out.println ("...Ou aguarde o envio por parte do cliente!");

			BufferedReader in = new BufferedReader( 
			new InputStreamReader( clientSocket.getInputStream())); 
			
			String inputLine = ""; 
			
			// Leitura e impressao na tela dos dados que vem do cliente 
			
			while(!"Sair".equalsIgnoreCase(inputLine)) {
				if(in.ready()){
					inputLine = in.readLine();
					if(inputLine.equals("Sair")) {
						System.out.print("Cliente desconectado! \r\n");
						
						break; 
					} else
						System.out.print("Cliente: "+ inputLine +"\r\n");
					}
			}

			in.close(); 
			clientSocket.close();
			
		}catch (IOException e) { 
			System.err.println("Problema de Comunicacao com o servidor");
			System.exit(1); 
		} 
	}
} 
