package objects;

import entity.Entity;
import main.GamePanel;

public class obj_Czeko extends Entity {

    public obj_Czeko(GamePanel gp) {
        super(gp);

        name = "Czeko";
        image = setup("/resources/items/Czeko", gp.tileSize, gp.tileSize);
        /*
        image2 = setup("/resources/items/heart_half.png");
        image3 = setup("/resources/items/heart_empty.png");

         */

    }
}
