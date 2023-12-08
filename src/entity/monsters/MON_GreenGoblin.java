package entity.monsters;


import entity.Entity;
import main.GamePanel;

import java.util.Random;

public class MON_GreenGoblin extends Entity {

    GamePanel gp;

    public MON_GreenGoblin(GamePanel gp) {
        super(gp);

        this.gp = gp;

        type = 1;
        name = "Green Goblin";
        direction = "down";
        speed = 1;
        maxLife = 100;
        life = maxLife;
        spriteNum = 1;

        solidArea.x = 3;
        solidArea.y = 18;
        solidArea.width = 42;
        solidArea.height = 30;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;

        imageMaxNum = 3;

        getImage();

    }
    public void getImage() {
       up1 = setup("/resources/characters/monsters/Goblin/Goblin_Up1", gp.tileSize, gp.tileSize*2);
       up2 = setup("/resources/characters/monsters/Goblin/Goblin_Up2", gp.tileSize, gp.tileSize*2);
       up3 = setup("/resources/characters/monsters/Goblin/Goblin_Up3", gp.tileSize, gp.tileSize*2);
       up4 = setup("/resources/characters/monsters/Goblin/Goblin_Up4", gp.tileSize, gp.tileSize*2);
       up5 = setup("/resources/characters/monsters/Goblin/Goblin_Up5", gp.tileSize, gp.tileSize*2);
       down1 = setup("/resources/characters/monsters/Goblin/Goblin_Down1", gp.tileSize, gp.tileSize*2);
       down2 = setup("/resources/characters/monsters/Goblin/Goblin_Down2", gp.tileSize, gp.tileSize*2);
       down3 = setup("/resources/characters/monsters/Goblin/Goblin_Down3", gp.tileSize, gp.tileSize*2);
       down4 = setup("/resources/characters/monsters/Goblin/Goblin_Down4", gp.tileSize, gp.tileSize*2);
       down5 = setup("/resources/characters/monsters/Goblin/Goblin_Down5", gp.tileSize, gp.tileSize*2);
       left1 = setup("/resources/characters/monsters/Goblin/Goblin_Left1", gp.tileSize, gp.tileSize*2);
       left2 = setup("/resources/characters/monsters/Goblin/Goblin_Left2", gp.tileSize, gp.tileSize*2);
       left3 = setup("/resources/characters/monsters/Goblin/Goblin_Left3", gp.tileSize, gp.tileSize*2);
       left4 = setup("/resources/characters/monsters/Goblin/Goblin_Left4", gp.tileSize, gp.tileSize*2);
       left5 = setup("/resources/characters/monsters/Goblin/Goblin_Left5", gp.tileSize, gp.tileSize*2);
       right1 = setup("/resources/characters/monsters/Goblin/Goblin_Right1", gp.tileSize, gp.tileSize*2);
       right2 = setup("/resources/characters/monsters/Goblin/Goblin_Right2", gp.tileSize, gp.tileSize*2);
       right3 = setup("/resources/characters/monsters/Goblin/Goblin_Right3", gp.tileSize, gp.tileSize*2);
       right4 = setup("/resources/characters/monsters/Goblin/Goblin_Right4", gp.tileSize, gp.tileSize*2);
       right5 = setup("/resources/characters/monsters/Goblin/Goblin_Right5", gp.tileSize, gp.tileSize*2);


        spriteCounter++;
        if(spriteCounter > 28) {
            switch(imageMaxNum) {

                case 5: if(spriteNum == 1) {spriteNum = 2;} else if (spriteNum == 2) {spriteNum = 3;} else if (spriteNum == 3) {spriteNum = 4;} else if (spriteNum == 4) {spriteNum = 5;} else if (spriteNum == 5) {spriteNum = 1;}spriteCounter = 1;break;
                case 4: if(spriteNum == 1) {spriteNum = 2;} else if (spriteNum == 2) {spriteNum = 3;} else if (spriteNum == 3) {spriteNum = 4;} else if (spriteNum == 4) {spriteNum = 1;}spriteCounter = 1;break;
                case 3: if(spriteNum == 1) {spriteNum = 2;} else if (spriteNum == 2) {spriteNum = 3;} else if (spriteNum == 3) {spriteNum = 1;}spriteCounter = 1;break;
                case 2: if(spriteNum == 1) {spriteNum = 2;} else if (spriteNum == 2) {spriteNum = 1;}spriteCounter = 1;break;
                case 1: if(spriteNum == 1) {spriteNum = 1;}spriteCounter = 0;break;
            }
        }

    }
    public void setAction() {
        actionCounter++;
        if(actionCounter == 120) {
            Random random = new Random();
            int i = random.nextInt(100)+1;

            if(i<= 25) {
                direction = "up";
            }
            else if(i > 25 && i <= 50) {
                direction = "down";
            }
            else if(i > 50 && i <= 75) {
                direction = "left";
            }
            else if(i > 75 && i <= 100) {
                direction = "right";
            }
            actionCounter = 0;
        }



    }
}

