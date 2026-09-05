import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public class DrawGraphics {
    BouncingBox box1;
    BouncingBox mybox;
    BouncingBox mybox1;
    ArrayList<BouncingBox> boxes;
    BouncingString s;
    
    /** Initializes this class for drawing. */
    public DrawGraphics() {
        boxes = new ArrayList<BouncingBox>();
        box1 = new BouncingBox(200, 50, Color.RED);
        box1.setMovementVector(20,10);
        mybox = new BouncingBox(20,100,Color.blue);
        mybox.setMovementVector(10,20);
        mybox1 = new BouncingBox(100,30,Color.CYAN);
        mybox1.setMovementVector(5,5);
        boxes.add(box1);
        boxes.add(mybox);
        boxes.add(mybox1);
        s = new BouncingString("Hello World!",122,22);
        s.setMovementVector(10,10);
    }

    /** Draw the contents of the window on surface. Called 20 times per second. */
    public void draw(Graphics surface) {
        surface.drawLine(50, 50, 250, 250);
        for (BouncingBox box : boxes) {
            box.draw(surface);
        }
        surface.drawString("Happy,birthday!",5,6);
        surface.drawOval(100,100,100,100);
        s.draw(surface);
    }
} 