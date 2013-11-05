package cga.p2.turtle;

import org.amcgala.TurtleMode;

public class TurtleGeological extends TurtleMode {
	
	private float geoHeight;
	
	
	public TurtleGeological(float height){
		geoHeight = 2;
		geoHeight = height/2;
		
		System.out.println(geoHeight);
	}
	
	public void draw(){
		//turtleCommands();
		System.out.println("geologicals ready. " + geoHeight);
	}
	
	/*@Override
	/*public void turtleCommands() {
		// TODO Auto-generated method stub
	}*/
	
	@Override
	public void turtleCommands(){
		turnRight(15);
		move(geoHeight);
		turnRight(105);
		move(geoHeight * (3/8) );
		turnLeft(113);
		move(geoHeight * (2/5));
		turnRight(99);
		move(71);
	}
	


}
