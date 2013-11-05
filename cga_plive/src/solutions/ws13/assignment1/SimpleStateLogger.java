package solutions.ws13.assignment1;

import akka.actor.Actor;
import akka.japi.Creator;
import org.amcgala.RGBColor;
import org.amcgala.Scene;
import org.amcgala.agent.Agent;
import org.amcgala.agent.StateLoggerAgent;
import org.amcgala.agent.World;
import org.amcgala.math.Vertex3f;
import org.amcgala.shape.Rectangle;

import java.util.Map;

/**
 *
 */
public final class SimpleStateLogger extends StateLoggerAgent {
    Scene scene = new Scene("SimpleStateLogger");
    Rectangle[][] rectangles;


    @Override
    public void onInit() {
        rectangles = new Rectangle[worldWidth][worldHeight];

        for (int x = 0; x < rectangles.length; x++) {
            for (int y = 0; y < rectangles[0].length; y++) {
                rectangles[x][y] = new Rectangle(new Vertex3f(x * scaleX, y * scaleY, -1), (float) scaleX, (float) scaleY);
                rectangles[x][y].setColor(RGBColor.GREEN);
                scene.addShape(rectangles[x][y]);
            }
        }


        framework.addScene(scene);
    }

    @Override
    public void onUpdate(Map<World.Index, World.Cell> cells, Map<Agent.AgentID, Agent.AgentState> agents) {
        /*
         * DIE & SPAWN 
         * 
         * TODO Visualisierung
         *
         * Die Methode bekommt alle wichtigen Informationen der Simulation über die Parameter cells und agents 
         * übergeben.
         *
         * cells:
         * Über diese Map können Informationen über die Zellen der Welt abgefragt werden. World.Index ist die 2d 
         * Koordinate
         * der Zelle in der Welt, World.Cell beinhaltet den Wert der Zelle. Dieser Wert liegt im Interval [0,0;1,0].
         *
         * agents:
         * Über diese Map kann der aktuelle Zustand aller in der Simulation befindlichen Agenten abgefragt werden.
         * Die für die Lösung der Aufgabe wichtigste Information ist die der Position des Agenten.
         *
         *
         * 1. Einfärben des entsprechenden Rechtecks r aus dem Array rectangles. Eine Zelle mit dem Wert 0 sollte 
         * weiß und
         * eine Zelle mit dem Wert 1 sollte schwarz dargestellt werden. Werte dazwischen bekommen einen 
         * entsprechenden Grauwert
         * zugewiesen.
         *
         * 2. Markieren der Rechtecke, auf denen sich ein Agent befindet in einer beliebigen anderen Farbe (z.B. Rot).
         */
    	//Map<World.Index, World.Cell> cells
    	for (Map.Entry<World.Index, World.Cell> c : cells.entrySet()){
    		int cellX = c.getKey().x();
    		int cellY = c.getKey().y();
    		float cellValue = c.getValue().value();

    		if (cellValue == 0){
    			rectangles[cellX][cellY].setColor(RGBColor.WHITE);
    		}
    		else if (cellValue == 1) {
    			rectangles[cellX][cellY].setColor(RGBColor.BLACK);
    		}
    		else{
    			rectangles[cellX][cellY].setColor(new RGBColor(cellValue, cellValue, cellValue));
    		}
    	}
    	//Map<Agent.AgentID, Agent.AgentState> agents
    	for (Map.Entry<Agent.AgentID, Agent.AgentState> a : agents.entrySet()){
    		int agentX = a.getValue().position().x();
    		int agentY = a.getValue().position().y();
    		//System.out.println("Agent: " + agentX + "/" + agentY );
    		//new RGBColor(0x2b, 0x9e, 0xca)
    		rectangles[agentX][agentY].setColor(RGBColor.RED);
    	}
    }

    static class StateLoggerCreator implements Creator<Actor> {
        @Override
        public Actor create() throws Exception {
            return new SimpleStateLogger();
        }
    }
}
