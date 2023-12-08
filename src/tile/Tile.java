package tile;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;

public class Tile extends Image {

    public BufferedImage image;
    public boolean collision = false;

    @Override
    public int getWidth(ImageObserver imageObserver) {
        return 0;
    }

    @Override
    public int getHeight(ImageObserver imageObserver) {
        return 0;
    }

    @Override
    public ImageProducer getSource() {
        return null;
    }

    @Override
    public Graphics getGraphics() {
        return null;
    }

    @Override
    public Object getProperty(String s, ImageObserver imageObserver) {
        return null;
    }
}
