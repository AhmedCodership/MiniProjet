package com.projetjava.classes;

public interface HTTPInterpreter {
	//--Fonctions associ�es aux requ�tes http
	public String getIndex();
	
	public String getDetails(String param);
	
	public String addStudent(String param);
	
	public String deleteStudent(String param);
}
