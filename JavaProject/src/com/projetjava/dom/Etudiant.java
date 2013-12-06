package com.projetjava.dom;
public class Etudiant
{
	private String id;
	
	private String nom;
	
	private String prenom;
	
	private String groupe;
	
	public Etudiant()
	{
		this.id = null;
		this.nom = null;
		this.prenom = null;
		this.groupe = null;
	}

	public String getId()
	{
		return id;
	}

	public void setId(String id)
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

	public String getGroupe()
	{
		return groupe;
	}

	public void setGroupe(String groupe)
	{
		this.groupe = groupe;
	}

	@Override
	public String toString()
	{
		return "Etudiant [id=" + id + ", nom=" + nom + ", prenom=" + prenom
				+ "]";
	}
	
}
