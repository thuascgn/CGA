package cga.p2.turtle;

import org.amcgala.TurtleMode;

public class TurtleTrees extends TurtleMode{
	
	@Override
	public void turtleCommands() {
		final float sceneWidth = 793;
		final float sceneHeight= 576;

		//turtle auf o/o setzen
		gap(3,24);
	
		
		
		// Springt zum Startpunkt der Bäume
		gap(0, sceneHeight/2);
		turnLeft(90);
		// erstellt Bäume
		int treeCount = 5;
		botanical(treeCount, sceneWidth, sceneHeight/4);
		
		//gapTest();
	}

	/**
	 * Setzt den Startpunkt von x = width/2, y = height/2
	 * auf Startpunkt für zentriertes Quadrat
	 * @param width
	 */
	private void gap(float x, float y){
		up();
		if (x == 0){  }
		else if (x > 0) {
			move(x);
		} else if (x < 0) {
			turnLeft(180);
			move(Math.abs(x));
			turnRight(180);
		}
		
		if (y == 0){ }
		else if (y>0){
			turnRight(90);
			move(y);
			turnLeft(90);
		} else if (y<0){
			turnLeft(90);
			move(Math.abs(y));
			turnRight(90);
		}
		down();
	}
	private void newSquare(float length) {
		for (int i=0; i<4; i++){
			move(length);
			turnRight(90);
		}
	}
	private void newRect(float length, float width){
		move(length);
		turnRight(90);
		move(width);
		turnRight(90);
		move(length);
		turnRight(90);
		move(width);
		turnRight(90);
	}

	private void botanical(int treeCount, float treeAreaWidth, float treeAreaHeight){
		gap( 50, 0 );
		
		int seg = 5;
		float height = (float) Math.ceil((treeAreaHeight / (6/4)));  
		float offX = (float) (treeAreaWidth / (treeCount+1) );
		float offY = (float) (height);
		int depth = 1;
		
		for (int j=0; j<treeCount; j++){
			drawBranch(height, seg, depth, j);
			
			turnRight(90);
			gap(treeAreaWidth/treeCount, height);
			turnLeft(90);
		}
	}
	
	private void drawBranch(float height, int seg, int depth, int j){
		if(depth < 3){
			for(int i=0; i<seg; i++){
					move(height/seg);
					newSquare(5);
					float angle = 45;
					turnLeft(angle);
					drawBranch(height/4, seg/2, depth+1, j);
					
					/*turnLeft(180-angle);
					turnRight(angle);
					drawBranch(height/4, seg/2, depth+1, j);*/
					
					turnRight(180);
					move(height/seg);
					turnLeft(180-angle);
				}
			
		} else { return; }
	}

	
	/**
	 * Generiert einen zufälligen WInkel zw 50 und 75 Grad
	 * @return float 75 <= angle >= 50
	 */
	private float getAngle(){
		float angle = (float) Math.random() * 90; 
		angle = (float) ( (angle > 75) ? 75 : (angle < 50 ) ? 50 : angle);
		//System.out.println("angle: " + angle);
		return angle;
	}

	
	public static void main(String args[]){
		new TurtleTrees();
	}
}
