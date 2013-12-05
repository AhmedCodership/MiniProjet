package generatorHTML;

import java.util.Collection;
import java.util.Iterator;

public class generator {
	
	String style = "<style type=\"text/css\">body { width:60%;margin:auto;font-family:helvetiva,sans-serif;background:ivory; }header, footer { background:yellowgreen;border: 1px solid green;box-shadow: 0 0 4px 2px black;text-align:center; }header { margin-top:10px;height:90px; } footer { height:150px; }section { width:85%;height:700px;margin:auto;box-shadow: 0 0 4px 2px black inset;background:white; }table { width:50%;margin:auto;border:2px solid green;border-collapse:collapse; }tr,th { border:2px solid green;background:yellowgreen;color:darkgreen; }td { border:1px solid green;background:white;text-align:center; }a { text-decoration:none;color:darkgreen; } a:hover { font-weight:bold; }h3 { color:darkgreen; }</style>";
	
	public String toHTML(Collection c) {
		
		Iterator i = c.iterator();
		while (i.hasNext()) // tant que j'ai un element non parcouru
		{
			Object o = i.next();
			System.out.println(o);
		}
		
		String header = "<!doctype html><html><head><meta charset=\"utf-8\"/><title>Liste d'étudiants</title>" + this.style + "</head>";
		String footer = "</html>";
		return null;
	}
}
