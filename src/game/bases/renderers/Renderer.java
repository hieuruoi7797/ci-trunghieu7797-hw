package game.bases.renderers;

import game.bases.Vector2D;

import java.awt.*;
import java.util.Vector;

/**
 * Created by Admin on 7/25/2017.
 */
public interface Renderer {
    void render(Graphics g2d, Vector2D position);
}
