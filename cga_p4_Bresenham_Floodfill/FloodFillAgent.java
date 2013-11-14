package solutions.ws13.assignment4.open;

import org.amcgala.agent.AgentMessages;
import org.amcgala.agent.AmcgalaAgent;
import org.amcgala.agent.Simulation;
import org.amcgala.agent.World;
import org.amcgala.agent.World.Index;

/**
* Fuellt ein Polygon mit einem Flood Fill Algorithmus.
*/
public class FloodFillAgent extends AmcgalaAgent {


    @Override
    protected AgentMessages.AgentMessage onUpdate(Simulation.SimulationUpdate update) {
        // wenn zellenfarbe noch nicht gesetzt
    	if (update.currentCell().value() == 0) {
            
        	// aktuelle position holen
        	int x = update.currentPosition().x();
        	int y = update.currentPosition().y();
        	
        	// Begrenzungen
        	if(x < 1 || y < 1){
        		//x /y aktualisieren
        		x = (x < 1) ? 198 : x;
        		y = (y < 1) ? 148 : y;
        		
        		// neues kind auf neuem World.Index mit aktualisierten x/y setzen
        		this.spawnChild(new Index(x,y));
        		//Stirb
        		//die();
        		//sag der welt das er tod ist
        		return die();
        	} else if(x > 198 || y > 148){
        		//die();
        		return die();
        	} else {
        		// neue agenten auf nachbarfelder
        		this.spawnChild(new Index(x+1, y));
        		this.spawnChild(new Index(x-1, y));
        		this.spawnChild(new Index(x, y+1));
        		this.spawnChild(new Index(x, y-1));
        		
        		
        		return new AgentMessages.ChangeValue(1);
        	}
        	
        // wenn zellenfarbe bereits gesetzt	
        }else{
            return die();
        }
    }
}

