package com.projetjava.generatorHTML;

import java.util.Collection;
import java.util.Iterator;

public class generator {
	
	private String header;
	private String footer;
	private String style = "<style type=\"text/css\">body { width:60%;margin:auto;font-family:helvetiva,sans-serif;background:ivory; }header, footer { background:yellowgreen;border: 1px solid green;box-shadow: 0 0 4px 2px black;text-align:center; }header { margin-top:10px;height:90px; } footer { height:150px; }section { width:85%;height:700px;margin:auto;box-shadow: 0 0 4px 2px black inset;background:white; }table { width:50%;margin:auto;border:2px solid green;border-collapse:collapse; }tr,th { border:2px solid green;background:yellowgreen;color:darkgreen; }td { border:1px solid green;background:white;text-align:center; }a { text-decoration:none;color:darkgreen; } a:hover { font-weight:bold; }h3 { color:darkgreen; }</style>";
	private String body;
	private String title;
	
	public String getHTML(String page,Collection c) {
		
		if (page == "simple") {
			
			this.title = "<header><h3>LISTE D'ETUDIANTS</h3></header>";
			
			// Génération du corps en fonction de la requète http
			this.body = "<body>" + this.title + "<section><br/><br/><table><tbody><tr><th>Etudiants</th></tr>";
			Iterator<?> i = c.iterator();
			while (i.hasNext()) // tant que j'ai un element non parcouru
			{
				Object o = i.next();
				this.body += "<tr><td><a href=\"?id=" + o + "\" title=\"Détails\">" + o + "</a></td></tr>";//o.nom et o.id
			}
		}
		else if (page == "details") {
			this.title = "<header><h3>LISTE DETAILLEE DE L'ETUDIANT: " + c + "</h3></header>";//c.nom etudiant
		
			// Génération du corps en fonction de la requète http
			this.body = "<body>" + this.title + "<section><br/><br/><table><tbody><tr><th></th></tr>";
			Iterator<?> i = c.iterator();
			while (i.hasNext()) // tant que j'ai un element non parcouru
			{
				Object o = i.next();
				this.body += "<tr><td></td></tr>";
			}
		}
		else if (page == "add") {
			this.title = "<header><h3>AJOUTER UN ETUDIANT</h3></header>";
		}
		else if (page == "delete") {
			this.title = "<header><h3>SUPPRIMER UN ETUDIANT</h3></header>";
		}
				
		this.header = "<!doctype html><html><head><meta charset=\"utf-8\"/><title>Liste d'étudiants</title>" + this.style + "</head>";
		this.body += "</tbody></table></section><footer></footer></body>";
		this.footer = "</html>";
		
		//Génération finale de la page html
		String html = this.header + this.body + this.footer;
		return html;
	}
}
