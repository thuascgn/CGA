package solutions.ws13.assignment3.lsystem;

import org.amcgala.Turtle;
import org.amcgala.TurtleState;
import org.amcgala.math.Vector3d;
import org.amcgala.shape.util.CompositeShape;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import solutions.ws13.assignment3.lsystem.Angle;
import solutions.ws13.assignment3.lsystem.DrawingRule;
import solutions.ws13.assignment3.lsystem.Axiom;
import solutions.ws13.assignment3.lsystem.Length;
import solutions.ws13.assignment3.lsystem.Level;
import solutions.ws13.assignment3.lsystem.Rules;

import java.util.Stack;

import static java.lang.Math.*;

/**
* Ein Lindenmayer-System, das folgende Zeichnen interpretieren kann:
* - + : Rechtsdrehung
* - - : Linksdrehung
* - [ : Push
* - ] : Pop
*
* @author Robert Giacinto
* @since 2.0
*/
public class LindenmayerSystem {
    private Logger log = LoggerFactory.getLogger(LindenmayerSystem.class);

    private Rules rules;
    private Level level;
    private Stack<Turtle> turtles;
    private Turtle turtle;
    private CompositeShape shape;
    private Length length;
    private Angle angle;
    private Axiom axiom;


    /**
     * Erstellt ein neues L-System.
     *
     * @param axiom  das Startsymbol des L-Systems
     * @param rules  die Ersetzungsregeln, die auf das Axiom angewendet werden
     * @param level  die Rekursionstiefe
     * @param length die Schrittweite
     * @param angle  der Winkel, um den gedreht wird
     * @param shape  das Shape, das für die Darstellung des L-Systems verwendet werden soll
     */
    public LindenmayerSystem(Axiom axiom, Rules rules, Level level, Length length, Angle angle, CompositeShape shape) {
        this.axiom = axiom;
        this.rules = rules;
        this.level = level;
        this.length = length;
        this.angle = angle;
        this.shape = shape;
        turtles = new Stack<>();
        turtle = new Turtle(shape);
    }

    /**
     * Erstellt ein neues L-System.
     *
     * @param axiom         das Startsymbol des L-Systems
     * @param rules         die Ersetzungsregeln, die auf das Axiom angewendet werden
     * @param level         die Rekusionstiefe
     * @param length        die Schrittweite
     * @param angle         der Winkel, um den gedreht wird
     * @param shape         das Shape, das für die Darstellung des L-Systems verwendet werden soll
     * @param startPosition die Startposition der Turtle
     */
    public LindenmayerSystem(Axiom axiom, Rules rules, Level level, Length length, Angle angle, CompositeShape shape, Vector3d startPosition, float startHeading) {
        this(axiom, rules, level, length, angle, shape);
        Vector3d heading = new Vector3d(cos(toRadians(startHeading)), -sin(toRadians(startHeading)), 0).normalize();
        turtle = new Turtle(new TurtleState(startHeading, heading, startPosition), shape);
    }

    /*
     * TODO Fehldende cases ergänzen
     *
     * Folgende cases müssen noch hinzugefügt werden:
     *
     * - => Turtle dreht sich links
     *
     * m => Turtle bewegt sich ohne eine Linie zu zeichnen
     *
     * M => Turtle bewegt sich und zeichnet eine Linie
     *
     * [ => Aktuelle Turtle wird kopiert und auf den Stack gelegt. Verwenden Sie hierzu den Stack turtles.
     *
     * ] => Alte Turtle wird vom Stack geholt.
     */
    /**
     * Wendet die Regeln des L-Systems auf das Startsymbol an.
     */
    public void run() {
        String current = applyRules();
        System.out.println("run()");
        for (char c : current.toCharArray()) {
            switch (c) {
                case '+':
                    log.debug("Right Turn: {}", angle.value);
                    
                    turtle.turnRight(angle.value);
                    break;
                case '-':
                	log.debug("Left Turn: {}", angle.value);
                	
                	turtle.turnLeft(angle.value);
                	break;
                case '[':
                    log.debug("Push Turtle to stack");
                     
                    Turtle t = new Turtle(turtle.getTurtleState(), shape);
                    turtles.push(turtle);
                    turtle = t;
                    break;
                case ']':
                	log.debug("Pop Turtle from Stack");
                	
                	turtle = turtles.pop();
                	break;
                case 'm':
                	log.debug("Move: {}", length.value);
                	
                	turtle.up();
                	turtle.move(length.value);
                	turtle.down();
                	break;
                case 'M':
                	log.debug("Draw: ", length.value);
                	turtle.move(length.value);
                	break;
                case 'L':
                	for(int i=0; i<45;i++){
                		turtle.turnLeft(2);
                		turtle.move(2);
                	}
                	break;
                case 'R':
                	for (int i=0; i<45; i++){
                		turtle.turnRight(2);
                		turtle.move(2);
                	}
                	break;
                default: break;
            }
        }

    }

    /**
     * Anwenden der Ersetzungsregeln auf das Axiom.
     */
    private String applyRules() {
        String current = axiom.getAxiom();
        System.out.println("current: " + current);

        for (int i = 1; i < level.level; i++) {
        	//System.out.println("i / level : " + i + " / " + level.level);
        	String temp = "";
            for (char c : current.toCharArray()) {
                temp += rules.applyReplacementRules(Character.toString(c));
            }
            //
            current = temp;
        }

        String temp = "";
        for (char c : current.toCharArray()) {
            temp += rules.applyDrawingRules(Character.toString(c));
        }
        System.out.println("current2 : " + current);
        current = temp;
        System.out.println("current3 : " + current);
        return current;
    }
    /*
    private String applyRules() {
    	String current = axiom.getAxiom();
        StringBuilder sb = new StringBuilder(100);
        for (int i = 0; i < level.level; i++) {
            for (char c : current.toCharArray()) {
                sb.append(rules.applyReplacementRules(Character.toString(c)));
            }
            current = sb.toString();
            sb = new StringBuilder(100);
        }

        for (char c : current.toCharArray()) {
            sb.append(rules.applyDrawingRules(Character.toString(c)));
        }
        current = sb.toString();
        return current;
    }*/
}
