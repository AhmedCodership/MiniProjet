package HTML;

public class HTML {
	
	private String header;
	private String style = "<style type=\"text/css\">body { width:60%;margin:auto;font-family:helvetiva,sans-serif;background:ivory; }header, footer { background:yellowgreen;border: 1px solid green;box-shadow: 0 0 4px 2px black;text-align:center; }header { margin-top:10px;height:90px; } footer { height:150px; }section { width:85%;height:700px;margin:auto;box-shadow: 0 0 4px 2px black inset;background:white; }table { width:50%;margin:auto;border:2px solid green;border-collapse:collapse; }tr,th { border:2px solid green;background:yellowgreen;color:darkgreen; }td { border:1px solid green;background:white;text-align:center; }a { text-decoration:none;color:darkgreen; } a:hover { font-weight:bold; }h3 { color:darkgreen; }</style>";
	private String body = "<body>";
	
	public HTML() { 
		this.header = "<!doctype html><html><head><meta charset=\"utf-8\"/><title>Liste d'étudiants TP JAVA</title>" + this.style + "</head>";		
	}
	
	public void setTitle(String title) {
		this.body += "<header>" + title + "</header><section><br/>";
	}
	
	public void setHeaderTable() {
		this.body += "<table><tbody><tr>";
	}
	
	public void addHeaderTableField(String field) {
		this.body += "<th>" + field + "</th>";
	}
	
	public void setBodyTable() {
		this.body += "</tr><tr>";
	}
	
	public void addBodyTableField(String field) {
		this.body += "<td>" + field + "</td>";
	}
	
	public void setEndTable() {
		this.body += "</tr></tbody></table>";
	}
			
	public String getHTML() {
		this.body += "</section><footer></footer></body></html>";	
		String html = this.header + this.body;
		return html;
	}
}
