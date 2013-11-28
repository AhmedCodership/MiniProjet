package com.projetjava.analyseSAX;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.helpers.*;


public class AnalyseDocument
{
	public static void main(String args[])
	{
		// Instanciation d'un parseur SAX 
		XMLReader parser = null;
		try 
		{
			parser = XMLReaderFactory.createXMLReader("org.apache.xerces.parsers.SAXParser");
			System.out.println("Instanciation analyseur OK");
			
		}
		catch (SAXException e){
			System.err.println("Impossible d'instancier l'analyseur");
			System.exit(1);} 
		
		try
		{
			// D�but de l'analyse
			File f = new File("etudiant.xml");
			System.out.println(f.getAbsolutePath());
			InputSource file = new InputSource(new FileInputStream(f));
			
			AffichageDocument doc = new AffichageDocument();
			parser.setContentHandler(doc);
			parser.parse(file);
			System.out.println("Analyse du document termin�e");
			
		}
		catch (SAXException e){
			System.err.println("Erreur lors de l'analyse du document");
			System.exit(1);
		}
		catch (IOException f){
			System.err.println("Erreur lors de la lecture du document");
			System.exit(1);
		}
		
	}
}
