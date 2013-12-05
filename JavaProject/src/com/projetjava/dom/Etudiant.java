package com.projetjava.dom;
public class Etudiant
{
	private int id;
	
	private String nom;
	
	private String prenom;
	
	public Etudiant()
	{
		this.id = 0;
		this.nom = null;
		this.prenom = null;
	}

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public String getNom()
	{
		return nom;
	}

	public void setNom(String nom)
	{
		this.nom = nom;
	}

	public String getPrenom()
	{
		return prenom;
	}

	public void setPrenom(String prenom)
	{
		this.prenom = prenom;
	}

	@Override
	public String toString()
	{
		return "Etudiant [id=" + id + ", nom=" + nom + ", prenom=" + prenom
				+ "]";
	}
	
}
