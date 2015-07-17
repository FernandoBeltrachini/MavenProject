
public class Pet {
    
    private String name;
    private Boolean alive;
    private Boolean sleep;
    
    public Pet(String name){
        this.name = name;
        this.alive = new Boolean(true);
        this.setSleep(new Boolean(false));
    }
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Boolean getAlive() {
        return alive;
    }
    public void setAlive(Boolean alive) {
        this.alive = alive;
    }

	public Boolean getSleep() {
		return sleep;
	}

	public void setSleep(Boolean sleep) {
		this.sleep = sleep;
	}
    
	public void wakeUp(){
		this.sleep = false;
	}
    
	public void sleep(){
		this.sleep = true;
	}
    

}