import java.util.ArrayList;
import java.util.HashMap;

public class VirtualPet extends Pet {

    private Integer energy;
    private Integer negativesActions;
    private Integer ingest;
    private Integer humor;
    private HashMap<String, Action> validActions;
    private ArrayList<Action> performedActions;
    
    public VirtualPet(String name){
        super(name);
        this.energy = new Integer(100);
        this.negativesActions = new Integer(0);
        this.ingest = new Integer(0);
        this.humor = new Integer(5);
        this.validActions = new HashMap<>();
        this.performedActions = new ArrayList<Action>();
    }
    
    public void doAction(String name){
    	if (!this.getAlive())
    		System.out.println("Your pet is dead. Cant perform any action.");
    	else{
    	Action action = validActions.get(name);
    	if (this.getSleep())
    		System.out.println("You must wake up your peto before doing an action");
    	else{
	    		if ("Sleep".equals(action.getName()))
	    			this.sleep();
	    		else
	    			if ("Eat".equals(action.getName()) || ("Drink".equals(action.getName()))){
	    				ingest++;
	    				negativesActions = 0;
	    			}
	    			else
	    				if ("Decrease".equals(action.getType())){
	    					negativesActions++;
	    					ingest = 0;
	    				}
	    		
	    		if (!this.getSleep() && this.getAlive()){
			    	if (action.getType().equals("Increase"))
			    		sumarEnergia(action.getValue());
			    	else
			    		restarEnergia(action.getValue());
		    	performedActions.add(action);	
		    	}
		    	checkPetStatus();
		    	
	    	}
    	}
    }
    
    public void checkPetStatus(){
    	if (0 > this.getEnergy()){
    		this.setAlive(false);
    		System.out.println("Your pet energy went below 0. Get another");
    	}
    	else{
    		if (ingest == 5){
    			System.out.println("Your pet die due indigestion");
    			this.setAlive(false);
    		}
    		if (negativesActions == 3){
    			this.sleep();
    			System.out.println("I'm tired. I'm going to bed.");
    			this.negativesActions = 0;
    		}
    	}
   	
    };
    
    public Integer getEnergy() {
        return energy;
    }
    public void setEnergy(Integer energy) {
        this.energy = energy;
    }
    public Integer getNegativeActions() {
        return negativesActions;
    }
    public void setNegativeActions(Integer negativesActions) {
        this.negativesActions = negativesActions;
    }
    
    public Integer getHumor() {
        return humor;
    }
    public void setHumor(Integer humor) {
        this.humor = humor;
    }
    
    public void setIngest(Integer ingest) {
        this.ingest = ingest;
    }

    public Integer getIngest() {
        return ingest;
    };


    private void sumarEnergia(Integer suma){
    	this.setEnergy(this.getEnergy() + suma );
        if (this.getEnergy()> 100)
        	this.setEnergy(100);
    }
    
    private void restarEnergia(Integer resta){
    	this.setEnergy(this.getEnergy() - resta);
 
    	
    }

	public HashMap<String, Action> getValidActions() {
		return validActions;
	}

	public void setValidActions(HashMap<String, Action> validActions) {
		this.validActions = validActions;
	}

	public ArrayList<Action> getPerformedActions() {
		return performedActions;
	}

	public void setPerformedActions(ArrayList<Action> performedActions) {
		this.performedActions = performedActions;
	}
    
    
    
    
}