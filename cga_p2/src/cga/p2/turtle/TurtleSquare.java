package cga.p2.turtle;
import org.amcgala.TurtleMode;


public class TurtleSquare extends TurtleMode{

	@Override
	public void turtleCommands() {
		float sceneWidth = 800;
		float sceneHeight= 600;
		
		float length = (int) 100;
		
		System.out.println(1 + 0.05f);
		//goToStart(length);
        
		while(length > 50){
            newSquare(length);
            gap(25);
            length -= 50;
            turnLeft(5);
        }
		turnRight(5);
		
		up();
		move(sceneWidth/2);
		turnRight(90);
		move((sceneHeight/2) + 50);
		turnLeft(90);
		down();
		
		newSquare(5);
	}

	/**
	 * Setzt den Startpunkt von x = width/2, y = height/2
	 * auf Startpunkt für zentriertes Quadrat
	 * @param width
	 */
	private void goToStart(float width) {
        up();
        turnLeft(180);
        move(width/2);
        turnRight(90);
        move(width/2);
        turnRight(90);
        down();
		
	}


	private void gap(int i) {
		up();
		move(i);
		turnRight(90);
		move(i);
		turnLeft(90);
		down();
	}


	private void newSquare(float length) {
		for (int i=0; i<4; i++){
			move(length);
			turnRight(90);
		}
		
	}


	public static void main(String args[]){
		new TurtleSquare();
	}
}
