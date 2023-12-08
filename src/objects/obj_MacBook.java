package objects;

import entity.Entity;
import main.GamePanel;

public class obj_MacBook extends Entity {

    public obj_MacBook(GamePanel gp) {
        super(gp);

        name = "Laptop";
        image1 = setup("/resources/items/Laptop", gp.tileSize, gp.tileSize);
        /*
        image2 = setup("/resources/items/heart_half.png");
        image3 = setup("/resources/items/heart_empty.png");
         */

    }
}
