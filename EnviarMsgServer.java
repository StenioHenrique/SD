import java.net.*; 
import java.io.*; 

//Classe responsavel por implementar a thread que envia as mensagens do cliente
//Ou seja, ela le do teclado e envia para o socket do cliente
public class EnviarMsgServer extends Thread {
	protected Socket clientSocket;
	
	public EnviarMsgServer (Socket clientSoc) {
		clientSocket = clientSoc;
		start();
	}

	public void run() {
		try { 
			System.out.println ("Conectado, digite sua mensagem...");
			
			PrintWriter out = new PrintWriter(clientSocket.getOutputStream(),true); 
			out.flush();
			
			BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
			String userInput;
			
			System.out.println ("Para encerrar a conexão, digite 'Sair'.");
			//loop que faz a leitura do teclado e envia ao cliente 
			while ((userInput = stdIn.readLine()) != null) {
				out.println(userInput);
				if (userInput.equalsIgnoreCase("Sair")) {
					System.out.println("Cliente desconetado!");
					break; 
				}
				out.flush();
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
