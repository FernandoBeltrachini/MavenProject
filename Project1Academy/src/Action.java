
public class Action {

	private String name;
	private String type;
	private Integer value; // could be possitive or negative
	
	public Action (String name, String type, Integer value){
		this.name = name;
		this.type = type;
		this.value = value;
		
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Integer getValue() {
		return value;
	}
	public void setValue(Integer value) {
		this.value = value;
	}
	
	
	
}
