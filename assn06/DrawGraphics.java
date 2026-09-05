package assn06;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public class DrawGraphics {
    ArrayList<Mover> movers;
    Bouncer movingSprite;
    Bouncer movingOval;
    StraightMover movingStraightRec;
    StraightMover movingStraightOval;

    /** Initializes this class for drawing. */
    public DrawGraphics() {
        movers = new ArrayList<>();
        Rectangle box = new Rectangle(15, 20, Color.RED);
        movingSprite = new Bouncer(100, 170, box);
        movingSprite.setMovementVector(3, 1);
        Oval oval = new Oval(20,20);
        movingOval = new Bouncer(50,100,oval);
        movingOval.setMovementVector(5,5);
        movingStraightOval = new StraightMover(10,10,oval);
        movingStraightRec = new StraightMover(15,15,box);
        movingStraightRec.setMovementVector(10,2);
        movingStraightOval.setMovementVector(2,5);
        movers.add(movingSprite);
        movers.add(movingOval);
        movers.add(movingStraightOval);
        movers.add(movingStraightRec);

    }

    /** Draw the contents of the window on surface. */
    public void draw(Graphics surface) {
       for (Mover bouncer : movers) {
           bouncer.draw(surface);
       }
       for (Mover straightMover : movers){
           straightMover.draw(surface);
       }
    }
}
