package com.projetjava.srvhttp;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class HTTPServer{
	public static void main(String[] args){
		// args 0 : l'adresse locale en notation pointée
		// args 1 : le port local
		
		InetSocketAddress sa = new InetSocketAddress("127.0.0.1",Integer.parseInt("80"));
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
	}
}