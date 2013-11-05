package solutions.ws13.assignment3;


import org.amcgala.*;
import org.amcgala.math.Vector3d;
import org.amcgala.shape.util.CompositeShape;
import solutions.ws13.assignment3.lsystem.*;

/**
 * Testklasse für die GL Funktionalität.
 */
public class Main extends Amcgala{

    public Main() {
        Scene scene = new Scene("line");

        CompositeShape shape = new CompositeShape();
        shape.setColor(RGBColor.BLUE);

        LindenmayerSystem lindenmayerSystem = new LindenmayerSystem(
                new Axiom("X"),
                new Rules()
                        .addReplacementRule("F", "FF")
                        .addReplacementRule("X", "F-[[X]+X]+F[+FX]-X[+F+L-F-R]")
                        .addDrawingRule("F", "M")
                        .addDrawingRule("L", "L")
                        .addDrawingRule("R", "R")
                        .addDrawingRule("X", ""),
                new Level(6),
                new Length(6),
                new Angle(25),
                shape,
                new Vector3d(80, 500, -1),
                45
        );

        lindenmayerSystem.run();

        scene.addShape(shape);


        CompositeShape shape2 = new CompositeShape();
        shape2.setColor(RGBColor.RED);

        LindenmayerSystem lindenmayerSystem2 = new LindenmayerSystem(
                new Axiom("FX"),
                new Rules()
                        .addReplacementRule("Y", "FX-Y")
                        .addReplacementRule("X", "X+YF")
                        .addDrawingRule("F", "M")
                        .addDrawingRule("Y", "")
                        .addDrawingRule("X", ""),
                new Level(11),
                new Length(15),
                new Angle(90),
                shape2,
                new Vector3d(500, 400, -1),
                0
        );

        lindenmayerSystem2.run();
        scene.addShape(shape2);
        framework.addScene(scene);
    }

    public static void main(String[] args) {
        new Main();
    }
}
//package solutions.ws13.assignment3;
//
//
//import org.amcgala.*;
//import org.amcgala.math.Vector3d;
//import org.amcgala.shape.util.CompositeShape;
//import solutions.ws13.assignment3.lsystem.*;
//
///**
// * Testklasse für die GL Funktionalität.
// */
//public class Main extends Amcgala{
//
//    public Main() {
//        Scene scene = new Scene("line");
//        
//        //Shape 1
//        CompositeShape shape = new CompositeShape();
//        shape.setColor(RGBColor.BLUE);
//
//        Rules r = new Rules();
//        r.addReplacementRule("F", "FF");
//        r.addReplacementRule("X", "F[-[X]+X]+F[+FX]-X");
//        r.addDrawingRule("F", "M");
//        r.addDrawingRule("X", "");
//        r.printRules();
//        
//        Axiom ax = new Axiom("X");
//        Level lev = new Level(7);
//        Length len = new Length(6);
//        Angle an = new Angle(26);
//        Vector3d v = new Vector3d(20, 550, -1);
//        
//        LindenmayerSystem lindenmayerSystem = new LindenmayerSystem(
//                ax, r, lev, len, an, shape, v, 45 );
//
//        lindenmayerSystem.run();
//
//        scene.addShape(shape);
//
//        //Shape 2
//        
//        CompositeShape shape2 = new CompositeShape();
//        shape2.setColor(RGBColor.RED);
//        
//        Axiom ax2 = new Axiom("FX");
//        Rules r2 = new Rules();
//        r2.addReplacementRule("Y", "FX-Y");
//        r2.addReplacementRule("X", "X+YF");
//        r2.addDrawingRule("F", "M");
//        r2.addDrawingRule("Y", "");
//        r2.addDrawingRule("X", "");
//        r2.printRules();
//        Level lev2 = new Level(9);
//        Length len2 = new Length(15);
//        Angle an2 = new Angle(90);
//        Vector3d v2 = new Vector3d(550, 200, -1);
//        
//        LindenmayerSystem lindenmayerSystem2 = new LindenmayerSystem(
//                ax2, r2, lev2, len2, an2, shape2, v2, 0 );
//
//        lindenmayerSystem2.run();
//        scene.addShape(shape2);
//        
//        framework.addScene(scene);
//    }
//
//    public static void main(String[] args) {
//        new Main();
//    }
//}
