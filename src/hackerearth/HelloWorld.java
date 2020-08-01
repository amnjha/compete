package hackerearth;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class HelloWorld{
	public static void main(String[] args) throws IOException{
		ServerSocket listener = new ServerSocket(8080);
		System.out.println("Server Started");
		while(true){
			Socket sock = listener.accept();
			PrintWriter pw = new PrintWriter(sock.getOutputStream(), true);
			pw.println("Goodbye, World!");
			sock.getOutputStream().flush();
			pw.close();
			sock.close();
		}
	}
}