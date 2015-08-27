package dataConnection;

import element.Element;

public abstract class DataBaseConnections <T extends Element> {

	
	public DataBaseConnections(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		
	}
	
	public abstract String add(T element);
	public abstract String remove(String id);
	public abstract String modify(T elem);
	
}
