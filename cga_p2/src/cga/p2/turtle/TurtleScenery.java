package cga.p2.turtle;

import org.amcgala.TurtleMode;

public class TurtleScenery extends TurtleMode{
	
	@Override
	public void turtleCommands() {
		final float sceneWidth = 793;
		final float sceneHeight= 576;
		
		double pisin = Math.sin(Math.PI);
		double picos = Math.cos(Math.PI);
		
		
		for (int k=0; k<360; k+=5){
			System.out.println(k + " :  " + " sin: " + Math.sin(Math.toRadians(k)) + ", cos: " + Math.cos(Math.toRadians(k)));
		}
		
		
		//turtle auf o/o setzen
		gap(3,24);
		
		// erstellt geologie
		geological(sceneWidth, sceneHeight);
		
		// Turtle zum Startpunkt des Hauses
		gap(sceneWidth/2 , (sceneHeight/2)+115);
		//haus(breite, höhe, etagen, fenster/etage)
		housing(142, 100, 7, 5);
		
		// Springt zum Startpunkt der Bäume
		gap(-550, sceneHeight/4-20);
		// erstellt Bäume
		int treeCount = 8;
		botanical(treeCount, sceneWidth, sceneHeight/4);
		
		//gapTest();
	}

	/**
	 * Setzt den Startpunkt von x = width/2, y = height/2
	 * auf Startpunkt für zentriertes Quadrat
	 * @param width
	 */
	private void goToStart(float width) {
        up();
        move(width);
        turnRight(90);
        move(width);
        turnLeft(90);
        down();
	}
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

	private void geological(float sceneWidth, float sceneHeight){
		up();
		turnRight(90);
		move(sceneHeight  * 0.5f);
		turnLeft(180);
		down();
		
		turnRight(10);
		move(111);
		turnRight(5);
		move(100);
		turnRight(115);
		move(59);
		turnLeft(121);
		move(111);
		turnRight(123);
		move(75);
		turnRight(33);
		move(64);
		turnLeft(109);
		move(61);
		turnRight(77);
		move(45);
		turnRight(9);
		move(19);
		for (int i=0; i<6; i++){
			if(i%2==0) turnLeft(36);
			if(i%2!=0) turnRight(40); 
			move(20);
		}
		turnLeft(67);
		
		for (int i=1; i<5; i++){
			if(i%2==0) turnLeft(36); move(20*i);
			if(i%2!=0) turnRight(40); move(20*i);
		}
		turnRight(5);
		move(58);
		
		up();
		turnRight(170);
		move(sceneWidth * 0.95f);
		turnRight(90);
		move(200);
		down();
		
		turnRight(55);
		move(31);
		turnRight(46);
		move(28);
		
		up();
		move(74);
		turnLeft(9);
		down();
		
		move(59);
		
		up();
		turnRight(88);
		move(100);
		turnRight(90);
		move(117);
		turnRight(90);
		move(165);
		down();
		
		turnRight(141);
		move(58);
		turnRight(32);
		move(87);
		turnLeft(27);
		move(64);
		
		turnRight(34);
		up();
		turnRight(77);
		move(165);
		down();
		
		turnRight(131);
		move(32);
		turnRight(19);
		move(67);
		turnLeft(12);
		move(20);
		turnLeft(28);
		move(34);
		
		up();
		turnLeft(7);
		turnLeft(180);
		move(60);
		turnRight(137);
		move(37);
		down();
		
		move(66);
		turnRight(41);
		move(11);
		up();
		turnRight(91);
		move(160);
		turnRight(61);
		move(25);
		down();
		
		move(41);
		turnLeft(17);
		move(63);
		up();
		
		turnLeft(133);
		move(190);
		turnLeft(90);
		move(283);
		turnRight(180);
		down();
		//newSquare(8);
	}
	
	private void botanical(int treeCount, float treeAreaWidth, float treeAreaHeight){
		gap( -50, -10 );
		
		int seg = 5;
		float height = (float) Math.ceil((treeAreaHeight / (6/4)));  
		float offX = (float) (treeAreaWidth / (treeCount+1) );
		float offY = (float) (height);
				
		for (int j=0; j<treeCount; j++){
			gap(offX, offY );
			turnLeft(90);
			move((height/seg));
			
			for (int i=seg-1; i>0; i--){
					branchTree(height, seg, i);
			}
			turnRight(90);
		}
	}
	
	private void branchTree(float height, int seg, int i) {
		double l = Math.random() * 10;
		double r = Math.random() * 10;
		double lor = l + r;		
		float branchLength = (float) (( (height * 0.75) / seg) * i);
		
		if (seg >= 2) {
			if(lor < 5.5) {
				float angle = getAngle();
				turnLeft(angle);
				drawBranch(branchLength);		
				turnLeft(180-angle);
				
			} else if(lor > 15){
				float angle = getAngle();
				turnRight(angle);
				drawBranch(branchLength);		
				turnRight(180-angle);

			} else {
				float angle = getAngle();
				turnLeft(angle);
				drawBranch(branchLength);
				turnLeft(180-angle);
				
				angle = getAngle();
				turnRight(angle);
				drawBranch(branchLength);		
				turnRight(180-angle);
			}
		} else { return; }
		move(height/seg);
		
	}

	//Malt einen Ast/Zweig
	private void drawBranch(float length){
		if (length > 20){
			for (int k=0; k<2; k++) {
				move(length/2);
				if (Math.random()*2 > 1){
					turnLeft(30);
					move(length/4);
					turnRight(180);
					move(length/4);
					turnLeft(150);
				} else {	
					turnRight(30);
					move(length/4);
					turnLeft(180);
					move(length/4);
					turnRight(150);
				}
			}
			turnRight(180);
			move(length);
			
		}
	}
	
	/**
	 * Generiert einen zufälligen WInkel zw 50 und 75 Grad
	 * @return float 75 <= angle >= 50
	 */
	private float getAngle(){
		float angle = (float) Math.random() * 90; 
		angle = (float) ( (angle > 75) ? 75 : (angle < 50 ) ? 50 : angle);
		return angle;
	}
	
	/**
	 * Zeichnet das Haus
	 * @param width
	 * @param height
	 * @param floors
	 * @param windows
	 */
	private void housing(float width, float height, float floors, float windows){
		float floorHeight = Math.round((height / floors));
		
		for(int i=0; i<floors; i++){
			up();
			turnLeft(90);
			move(floorHeight);
			turnRight(90);
			down();
			newRect(width, floorHeight);
			if(i==0){
				drawDoor(width, floorHeight);
			}
			else {
				drawWindows(width, floorHeight, windows);
			}
		}

		double a = 0;
		double b = 0;
		double c = width;
		
		float alpha = 45;
		float gamma = 90;

		a = c * 0.707106781;
		b = Math.sqrt(Math.pow(c, 2) - Math.pow(a, 2));
		
		
		turnLeft(alpha);
		move((float) b);
		turnRight(gamma);
		move((float) a);
		turnLeft(45);
	}
	
	private void drawWindows(float width, float floorHeight, float windows){
		float windowGaps = windows + 1;
		float floorGapY = floorHeight / 5;
		float floorGapX = (width / 5) / windowGaps;
		
		float windowWidth = ( (width / 5) * 4 / windows);
		float windowHeight = (floorHeight / 5) *  3;
		
		float xPos = 0;
		up();
		move(floorGapX);
		xPos+=floorGapX;
		turnRight(90);
		move(floorGapY);
		turnLeft(90);
		down();
		for (int i=0; i<windows; i++){
			newRect(windowWidth, windowHeight);
			up();
			move(windowWidth + floorGapX);
			xPos+=(windowWidth + floorGapX);
			down();
		}
		
		up();

		turnLeft(90);
		move(floorGapY);
		turnLeft(90);
		move(xPos);
		turnRight(180);
		down();
	}
	
	private void drawDoor(float width, float height){
		float doorWidth = width / 5;
		float doorHeight = (height / 5) * 4;
		
		up();
		move(width/2 - doorWidth/2);
		turnRight(90);
		move(height / 5);
		turnLeft(90);
		down();
		
		newRect(doorWidth, doorHeight);
		
		up();
		turnLeft(90);
		move(height / 5);
		turnLeft(90);
		move(width/2 - doorWidth/2);
		turnRight(180);
		down();
		
	}

	private void gapTest(){
		for (int j=1; j<10; j++){
			gap(j*5, j*5);
			newSquare(j*5);
		}
		for (int n=1;n<5;n++){
			gap(n*5, n*(-5));
			newSquare(n*5);
		}
		for (int k=1; k<5;k++){
			gap(k*(-5), k*(-5));
			newSquare(k*5);
		}
		for(int l=1; l<5;l++){
			gap(l*(-5), l*(5));
			newSquare(l*5);
		}
	}
	
	public static void main(String args[]){
		new TurtleScenery();
	}
}
