import java.util.ArrayList;
import java.util.HashMap;

public class PetManager {

	//private  ArrayList<VirtualPet> mascotas;
	//ArrayList<VirtualPet> casadas;
	
	public static HashMap<String,Action> getActions(){
		HashMap<String,Action> retorno = new HashMap<>();
	 	//Declaration of all the actions
    	Action eat = new Action("Eat","Increase",10);
    	retorno.put("Eat", eat);
    	Action drink = new Action("Drink", "Increase",5);
    	retorno.put("Drink", drink);
    	Action sleep = new Action("Sleep", "Increase",25);
    	retorno.put("Sleep", sleep);
    	

    	Action run = new Action("Run", "Decrease",5);
    	retorno.put("Run", run);
    	Action walk = new Action("Walk", "Decrease",5);
    	retorno.put("Walk", walk);
    	Action jump = new Action("Jump", "Decrease",5);
    	retorno.put("Jump", jump);
    	
    	return retorno;
	}
	
    public static void main(String[] args) {
    	
    	ArrayList<VirtualPet> mascotas = new ArrayList<VirtualPet>();
    	HashMap<String,Action> validActions = getActions();
    	
    	//
    	
        VirtualPet mascotita1 = new VirtualPet("Pochito");
        mascotita1.setValidActions(validActions);
        mascotita1.doAction("Eat");
        mascotita1.doAction("Eat");
        mascotita1.doAction("Eat");
        mascotita1.doAction("Eat");
//        mascotita1.doAction("Eat");
        mascotita1.doAction("Run");
        mascotita1.doAction("Run");
        mascotita1.doAction("Run");
        
        
        mascotas.add(mascotita1);
        

    }

}