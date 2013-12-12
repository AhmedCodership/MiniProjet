package com.projetjava.interpretor;
import org.xml.sax.Attributes;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class Parser extends DefaultHandler
{
	// Création d'un localisateur
	private Locator loc;
	
	public void setDocumentLocator(Locator locator)
	{
		this.loc = locator;
	}
	
	public void startDocument() throws SAXException
	{
		System.out.println("Debut de lecture du document ... Ligne "+this.loc.getLineNumber()+", \tcolonne "+this.loc.getColumnNumber()+
			" \t:début de document\n");
	}
	
	public void endDocument() throws SAXException
	{
		System.out.println("\nFin de lecture du document ... Ligne "+this.loc.getLineNumber()+", \tcolonne "+this.loc.getColumnNumber()+
			" \t:fin de document\n");
	}
	
	public void startElement(String uri, String local, String qName, Attributes attrs) throws SAXException
	{
		System.out.print("Ligne "+this.loc.getLineNumber()+", \tcolonne "+this.loc.getColumnNumber()
				+" \t -> Début d'un élément " + qName);
		
		int l = attrs.getLength();
		
		if (l > 0)
		{
			System.out.print(" ( Attributs : ");
			
			for (int i = 0; i < l; i++) 
				System.out.print("{"+ attrs.getQName(i) + " : " + attrs.getValue(i)+"} ");
			
			System.out.print(")");
		}
		System.out.println();
	}
	
	public void endElement(String uri, String local, String qName) throws SAXException
	{
		System.out.println("Ligne "+this.loc.getLineNumber()+", \tcolonne "+this.loc.getColumnNumber()+
			" \t-> Fin d'un élément " + qName);
	}
	
	public void characters(char[] ch, int start, int l) throws SAXException
	{
		String s = new String(ch, start, l);
		if (!(s.equals("\n")))
			System.out.println("Ligne "+this.loc.getLineNumber()+", \tcolonne "+this.loc.getColumnNumber()+
				" \tValeur : " + s);
	}
}
