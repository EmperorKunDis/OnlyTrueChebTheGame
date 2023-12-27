package objects;

import entity.Entity;
import main.GamePanel;

public class obj_Weed extends Entity {

    public obj_Weed(GamePanel gp) {
        super(gp);

        name = "Weed";
        image = setup("/resources/items/Weed", gp.tileSize, gp.tileSize);
        /*
        image2 = setup("/resources/items/heart_half.png");
        image3 = setup("/resources/items/heart_empty.png");
         */


    }
}
