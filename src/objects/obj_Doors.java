package objects;

import entity.Entity;
import main.GamePanel;

public class obj_Doors extends Entity {

    public obj_Doors(GamePanel gp) {
        super(gp);

        name = "Doors";
        down1 = setup("/resources/items/Doors", gp.tileSize, gp.tileSize);
        collision = true;

        solidArea.x = 0;
        solidArea.y = 16;
        solidArea.width = 48;
        solidArea.height = 32;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;


    }
}
