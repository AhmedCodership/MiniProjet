package com.projetjava.srvhttp;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;


public class HTTPServerThread extends Thread{
	private Socket s;
	public HTTPServerThread(Socket sock) {
		super(); this.s = sock;
	}
	
	public void run(){
		try	{
			
			InputStream is = this.s.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(is, "US-ASCII"));
			String rq = br.readLine();
			
			System.out.println(rq);

			
			// here
			GenerateurFlux generateur = new GenerateurFlux();
			generateur.getParam(rq);
			String data = generateur.getIndex();
			
			this.s.getOutputStream().write(data.getBytes());
			
			
			br.close();
		} catch (IOException e) {
			System.out.println("erreur");
		}
		
		try {
			this.s.close();
		} catch (IOException e) {
			System.out.println("erreur IO");
		}
}

}

 