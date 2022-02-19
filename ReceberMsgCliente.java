import java.io.*;
import java.net.*;

public class ReceberMsgCliente extends Thread {
	protected Socket socket; 
	
	public ReceberMsgCliente(Socket socket) throws IOException {
		this.socket = socket; 
		start();
	}
	
	public void run(){
		try {
			InputStream in ;
			InputStreamReader inr;
			BufferedReader bfr = null;
	
			in = socket.getInputStream();
			inr = new InputStreamReader(in);
			bfr = new BufferedReader(inr);
		
			String msg = "";
			while(!"Sair".equalsIgnoreCase(msg)) {
				if(bfr.ready()){
					msg = bfr.readLine();
					if(msg.equals("Sair")) {
						System.out.print("Servidor caiu! \r\n");
						break; 
					} else
						System.out.print("Server: "+ msg+"\r\n");
					}
			}
			
			socket.close();
			in.close();
			inr.close();
			bfr.close(); 
		} catch (IOException e) {
			System.err.println("Problem with connection server!");
			System.exit(1); 
		}
		
	}
}