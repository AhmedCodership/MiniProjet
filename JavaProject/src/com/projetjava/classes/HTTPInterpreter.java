package com.projetjava.classes;

public interface HTTPInterpreter {
	//--Fonctions associées aux requètes http
	public String getIndex();
	
	public String getDetails(String param);
	
	public String addStudent(String param);
	
	public String deleteStudent(String param);
}
