package com.projetjava.generatorHTML;

import java.util.Collection;
import java.util.Iterator;

import com.projetjava.dom.Etudiant;

public class generator {
	
	private String header;
	private String footer;
	private String style = "<style type=\"text/css\">body { width:60%;margin:auto;font-family:helvetiva,sans-serif;background:ivory; }header, footer { background:yellowgreen;border: 1px solid green;box-shadow: 0 0 4px 2px black;text-align:center; }header { margin-top:10px;height:90px; } footer { height:150px; }section { width:85%;height:700px;margin:auto;box-shadow: 0 0 4px 2px black inset;background:white; }table { width:50%;margin:auto;border:2px solid green;border-collapse:collapse; }tr,th { border:2px solid green;background:yellowgreen;color:darkgreen; }td { border:1px solid green;background:white;text-align:center; }a { text-decoration:none;color:darkgreen; } a:hover { font-weight:bold; }h3 { color:darkgreen; }</style>";
	private String body;
	private String title;
	
	public String getHTML(Collection c, Etudiant e) {
		
		if (e == null) {
			
			this.title = "<header><h3>LISTE D'ETUDIANTS</h3></header>";
			
			// Génération du corps en fonction de la requète http
			this.body = "<body>" + this.title + "<section><br/><br/><table><tbody><tr><th>Etudiants</th></tr>";
			Iterator<Etudiant> i = c.iterator();
			while (i.hasNext()) // tant que j'ai un element non parcouru
			{
				Etudiant s = i.next();
				this.body += "<tr><td><a href=\"?id=" + s.getId() + "\" title=\"Détails\">" + s.getNom() + "</a></td></tr>";
			}
		}
		else {
			
			this.title = "<header><h3>LISTE DETAILLEE DE L'ETUDIANT: " + e.getPrenom() + " " + e.getNom() + "</h3></header>";
		
			// Génération du corps en fonction de la requète http
			this.body = "<body>" + this.title + "<section><br/><br/><table><tbody><tr><th>Id</th><th>Prénom</th><th>Nom</th><th>Groupe</th></tr>";
			this.body += "<tr><td>" + e.getId() + "</td><td>" + e.getPrenom() + "</td><td>" + e.getNom() + "</td><td>" + e.getGroupe() + "</td></tr>";
		}
				
		this.header = "<!doctype html><html><head><meta charset=\"utf-8\"/><title>Liste d'étudiants</title>" + this.style + "</head>";
		this.body += "</tbody></table></section><footer></footer></body>";
		this.footer = "</html>";
		
		//Génération finale de la page html
		String html = this.header + this.body + this.footer;
		return html;
	}
}
