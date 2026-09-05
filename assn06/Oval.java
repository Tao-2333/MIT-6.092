package assn06;

import java.awt.*;

public class Oval implements Sprite{
    private int width;
    private int height;

    public Oval(int width,int height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public void draw(Graphics surface, int leftX, int topY) {
        surface.fillOval(leftX,topY,width,height);
        surface.drawOval(leftX,topY,width,height);
    }

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public int getHeight() {
        return height;
    }
}
