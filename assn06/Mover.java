package assn06;

import java.awt.*;

public interface Mover {
    void draw(Graphics surface);
    void setMovementVector(int xIncrement, int yIncrement);
}
