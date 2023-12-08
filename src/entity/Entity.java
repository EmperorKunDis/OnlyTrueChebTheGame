package entity;

import main.GamePanel;
import main.UtilityTool;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Entity {

    GamePanel gp;
    public BufferedImage  up1, up2, up3, up4, up5, down1, down2, down3, down4, down5, left1, left2, left3, left4, left5, right1, right2, right3, right4, right5;
    public BufferedImage attackUp1, attackUp2, attackDown1, attackDown2, attackLeft1, attackLeft2, attackRight1, attackRight2;
    public BufferedImage  image1, image2, image3, image4, image5, image6, image7, image8, image9, image10;
    public Rectangle solidArea = new Rectangle(0, 0, 48, 48);
    public int solidAreaDefaultX, solidAreaDefaultY;
    String dialogues[] = new String[20];
    public boolean collision = false;

    // STATE
    public int worldX, worldY;
    public boolean collisionOn = false;
    public int spriteNum;
    public boolean invincible = false;
    int dialogueIndex = 0;
    public String direction = "down";
    public boolean attack = false;

    // COUNTER
    public int invincibleCounter = 0;
    public int actionCounter = 0;
    public int spriteCounter = 1;

    // CHARACTERS
    public int imageMaxNum;
    public String name;
    public String hlaska;
    public int speed;
    public int type; // 0 - Item, 1 - Monster, 2 - Object, 3 - Player, 4 - NPC, 5 - NPC - Quest, 6 - NPC - Shop, 7 - NPC - Trainer,
    public String className = new String();
    public String strength = "___";
    public String dexterity = "___";
    public String constitution = "___";
    public String inteligence = "___";
    public String wisdom = "___";
    public String charisma = "___";
    public String skills = "___";
    public String abilities = "___";
    public String story = "___";

    // PLAYER
    public  int maxLife;   // Max life of player (100)
    public int life;      // Life of player (100)
    public  int maxMana;   // Max mana of player (100)
    public int mana;      // Mana of player (100)
    public  int maxStamina;    // Max stamina of player (100)
    public int stamina;       // Stamina of player (100)
    public  int maxWeight;     // Max weight of player (100)
    public int weight;        // Weight of player (100)
    public int maxSpeed;      // Max speed of player (100)     // Speed of player (100)
    public int lifePercentile;
    public Entity(GamePanel gp) {
        this.gp = gp;
    }

    public void setAction() {

    }
    public void speak() {
        if(dialogues[dialogueIndex] == null) {
            dialogueIndex = 0;
        }
        gp.ui.currentDialog = dialogues[dialogueIndex];
        dialogueIndex++;

        switch (gp.player.direction) {
            case "up" : direction = "down"; break;
            case "down" : direction = "up"; break;
            case "left" : direction = "right"; break;
            case "right" : direction = "left"; break;
        }
    }
    public void update() {

        collisionOn = false;
        gp.cChecker.checkTile(this);
        gp.cChecker.checkObject( this,false);
        gp.cChecker.checkEntity( this,gp.npc );
        gp.cChecker.checkEntity(this, gp.monster );
        boolean contactPlayer = gp.cChecker.checkPlayer(this);

        if(this.type == 1 && contactPlayer == true) {
            if(gp.player.invincible == false) {
                gp.player.life -= 10;
                gp.player.invincible = true;
            }
        }

        if (collisionOn == false) {
            switch (direction) {
                case "up": worldY -= speed; break;
                case "down": worldY += speed; break;
                case "left": worldX -= speed; break;
                case "right": worldX += speed; break;
            }
        }

        spriteCounter++;
        if(spriteCounter > 16) {
            switch(imageMaxNum) {
                case 4:
                    if(spriteNum == 1) {spriteNum = 2;} else if (spriteNum == 2) {spriteNum = 3;} else if (spriteNum == 3) {spriteNum = 4;} else if (spriteNum == 4) {spriteNum = 5;} else if (spriteNum == 5) {spriteNum = 1;}
                    spriteCounter = 1;
                    break;
                case 3:
                    if(spriteNum == 1) {spriteNum = 2;} else if (spriteNum == 2) {spriteNum = 3;} else if (spriteNum == 3) {spriteNum = 4;} else if (spriteNum == 4) {spriteNum = 1;}
                    spriteCounter = 1;
                    break;
                case 2:
                    if(spriteNum == 1) {spriteNum = 2;} else if (spriteNum == 2) {spriteNum = 3;} else if (spriteNum == 3){spriteNum = 1;}
                    spriteCounter = 1;
                    break;
                case 1:
                    if(spriteNum == 1) {spriteNum = 2;} else if (spriteNum == 2){spriteNum = 1;}
                    spriteCounter = 1;
                    break;
            }
        }
    }
    public void draw(Graphics2D g2) {


        int screenX = worldX - (gp.player.worldX + gp.player.screenX);
        int screenY = worldY - (gp.player.worldY + gp.player.screenY);

        if (worldX + gp.tileSize > gp.player.worldX - gp.player.screenX &&
                worldX - gp.tileSize < gp.player.worldX + gp.player.screenX &&
                worldY + gp.tileSize > gp.player.worldY - gp.player.screenY &&
                worldY - gp.tileSize < gp.player.worldY + gp.player.screenY ) {

            switch(direction) {
                case "up":
                    switch(spriteNum){case 1:image1 = up1;break;case 2: image2=up2;break; case 3: image3=up3;break; case 4: image4 = up4;break;case 5: image5 = up5;break;}break;
                case "down":
                    switch(spriteNum){case 1:image1 = down1;break;case 2: image2=down2;break;case 3: image3=down3;break;case 4: image4 = down4;break;case 5: image5 = down5;break;}break;
                case "left":
                    switch(spriteNum){case 1:image1 = left1;break;case 2: image2=left2;break;case 3: image3= left3;break;case 4: image4 = left4; break;case 5: image5 = left5;break;}break;
                case "right":
                    switch(spriteNum){case 1:image1 = right1;break;case 2: image2=right2;break;case 3: image3 = right3;break;case 4: image4 = right4;break;case 5: image5 = right5;break;
                    }
                    break;
            }

            g2.drawImage(image1, screenX, screenY, gp.tileSize, gp.tileSize, null);

            g2.setColor(Color.white);
            g2.drawRect(screenX, screenY, gp.tileSize, gp.tileSize);

            if (collisionOn == true) {
                g2.setColor(Color.red);
                g2.drawRect(screenX, screenY, gp.tileSize, gp.tileSize);
            }
        }

    }
    public BufferedImage setup(String imagePath, int weight, int height) {
        UtilityTool uTool = new UtilityTool();
        BufferedImage image = null;
        try {                                                      // resources/characters/npc/Huf/Huf_Up1.png
            image = ImageIO.read(getClass().getResourceAsStream(imagePath + ".png"));
            image = uTool.scaleImage(image, weight, height);
        }
        catch(IOException e) {
            e.printStackTrace();
        }
        return image;
    }

    public void dexterity(Graphics2D g2) {
    }
}
