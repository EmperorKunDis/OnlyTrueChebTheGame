package objects;

import entity.Entity;
import main.GamePanel;

public class obj_PicaPhone extends Entity {

    public obj_PicaPhone(GamePanel gp) {
        super(gp);

        name = "PicaPhone";
        image1 = setup("/resources/items/PicaPhone", gp.tileSize, gp.tileSize);
        /*
        image2 = setup("/resources/items/heart_half.png");
        image3 = setup("/resources/items/heart_empty.png");
         */

    }
}
