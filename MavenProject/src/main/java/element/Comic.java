package element;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Comic extends Element{
	
	private String type;
	public String name;
	private Integer copys;
	
	public Comic (String type, String name, Integer copys){
		this.type = type;
		this.name = name;
		this.copys = copys;
		
	}
	
	public Comic (String type, String name){
		this.type = type;
		this.name = name;		
	
	}
	
	public Comic(ResultSet rs) {
		try {
			this.id = rs.getInt(1);
			this.name = rs.getString(2);
			this.type = rs.getString(3);
			this.copys = rs.getInt(4);
		} catch (SQLException e) {
		}
		
	}
	
	public Comic (String id){
		this.id =  new Integer(id);
		
	}


	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getCopys() {
		return copys;
	}
	public void setCopys(Integer copys) {
		this.copys = copys;
	}
	
	

}
