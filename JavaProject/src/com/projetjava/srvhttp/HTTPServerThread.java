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
			
			if ((rq != null) && (rq.startsWith("GET "))){
				rq = rq.substring(rq.indexOf(" ")+1);	// on recoit un "GET mapage.html HTTP/1.1"
				rq = rq.substring(0, rq.indexOf(" "));	// du coup on decompose pour chopper juste la page
				rq = rq.substring(1, rq.length());		// on vire le "/" devant le nom de page
				
				if(rq.length() != 0){
					System.out.println("Decomposition : "+rq);	// affichage pour debug
				}
				
				if(rq.length() == 0){
					System.out.println("Taille de la chaine : "+rq.length());	// affichage pour debug
					rq = "index.html";
					System.out.println("Aucune page demandée, on envoie l'index.html");
				}
				File f = new File(rq);
						if (f.isFile()){ // bloc a remplacer par un appel de methode
							DataInputStream dis = new DataInputStream(new FileInputStream(f));
							System.out.println("Fichier balancé : "+f); // debug, voir quel nom de fichier on envoie
							byte[] data = new byte[(int) f.length()];
							//System.out.println(data); // affichage du fichier en bytes 
							dis.readFully(data); dis.close();
							this.s.getOutputStream().write(data);
							String t = new String( data , "Cp1252" );
							System.out.println("\n"+t); // affichage contenu fichier
						}
			}
			
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