package cga.p1.turtle;
import org.amcgala.TurtleMode;


public class TurtleSquare extends TurtleMode{

	@Override
	public void turtleCommands() {
		double length = (int) 300;
		System.out.println(1 + 0.05f);
		goToStart(length);
        
		while(length > 50){
            newSquare(length);
            gap(25);
            length -= 50;
            turnLeft(5);
        }
	}

	/**
	 * Setzt den Startpunkt von x = width/2, y = height/2
	 * auf Startpunkt für zentriertes Quadrat
	 * @param width
	 */
	private void goToStart(double width) {
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


	private void newSquare(double length) {
		for (int i=0; i<4; i++){
			move(length);
			turnRight(90);
		}
		
	}


	public static void main(String args[]){
		new TurtleSquare();
	}
}
