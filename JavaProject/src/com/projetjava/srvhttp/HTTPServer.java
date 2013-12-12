package com.projetjava.srvhttp;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;


public class HTTPServer{
	public static void main(String[] args){
		// args 0 : l'adresse locale en notation pointée
		// args 1 : le port local
		
		InetAddress thisIp; // on chope l'ip locale du poste pour ecoute sur le reseau
		try {
			thisIp = InetAddress.getLocalHost(); 
			InetSocketAddress sa = new InetSocketAddress(thisIp.getHostAddress(),Integer.parseInt("80"));
			System.out.println(thisIp.getHostAddress() + ":80");

			ServerSocket ss = null;
			try{
				ss = new ServerSocket();
				ss.bind(sa);
			} catch (IOException e) {
				System.out.println("erreur creation socket");
			}
			
			while (true){
				try{
					Socket sock = ss.accept();
					HTTPServerThread serv = new HTTPServerThread(sock);
					serv.start();
				} catch (IOException e) {
					System.out.println("erreur creation thread");
				}
			}
		} catch (UnknownHostException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} 
		
	}
}