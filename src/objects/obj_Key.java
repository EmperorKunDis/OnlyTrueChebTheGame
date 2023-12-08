package objects;

import entity.Entity;
import main.GamePanel;

public class obj_Key extends Entity {

    public obj_Key(GamePanel gp) {
        super(gp);

        name = "SecurityCard";
        image1 = setup("/resources/items/SecurityCard", gp.tileSize, gp.tileSize);
        /*
        image2 = setup("/resources/items/heart_half.png");
        image3 = setup("/resources/items/heart_empty.png");

         */

    }
}
