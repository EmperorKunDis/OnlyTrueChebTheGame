package entity;

import main.GamePanel;
import main.KeyHandler;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Player extends Entity{

    public final int maxLife;   // Max life of player (100)
    public int life;      // Life of player (100)
    public final int maxMana;   // Max mana of player (100)
    public int mana;      // Mana of player (100)
    public final int maxStamina;    // Max stamina of player (100)
    public int stamina;       // Stamina of player (100)
    public final int maxWeight;     // Max weight of player (100)
    public int weight;        // Weight of player (100)
    public final int maxSpeed;      // Max speed of player (100)
    public int speed;         // Speed of player (100)
    public int lifePercentile;  // Life percentile of player (100)
    public int standCounter = 0;

    KeyHandler keyHandler;
    public int screenX;
    public int screenY;


    public Player(int maxLife, int life, GamePanel gp, KeyHandler keyHandler, int maxMana, int mana, int maxStamina,
                  int stamina, int maxWeight, int weight, int maxSpeed, int speed) {
        super(gp);
        this.maxLife = maxLife;
        this.life = life;
        this.maxMana = maxMana;
        this.mana = mana;
        this.maxStamina = maxStamina;
        this.stamina = stamina;
        this.maxWeight = maxWeight;
        this.weight = weight;
        this.maxSpeed = maxSpeed;
        this.speed = speed;
        name = "Hufito";
        this.keyHandler = keyHandler;   // Keyboard event handler

        solidArea = new Rectangle();    // Set solid area of player (collision)
        solidArea.x = 8;
        solidArea.y = 64;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
        solidArea.width = 32;
        solidArea.height = 48;

        setDefaultValues();                         // Set default values of player (position, direction, speed)

        getPlayerImage();                           // Load player images
        getPlayerAttackImage();                     // Load player attack images

        update();                                   // Update player position and collision


    }
    public void setDefaultValues() {
        worldX = gp.tileSize * 15 ;
        worldY = gp.tileSize * 15 ;
        speed = 4;
        direction = "downbase";
        imageMaxNum = 2;

        screenX = gp.screenWidth/2 - (gp.tileSize/2);
        screenY = gp.screenHeight/2 - (gp.tileSize/2);

    }
    public void getPlayerImage()
    {                             // Load player images
            up1 = setup("/resources/characters/npc/Huf/Huf_up1",gp.tileSize,gp.tileSize*2);
            up2 = setup("/resources/characters/npc/Huf/Huf_up2",gp.tileSize,gp.tileSize*2);
            down1 = setup("/resources/characters/npc/Huf/Huf_down1",gp.tileSize,gp.tileSize*2);
            down2 = setup("/resources/characters/npc/Huf/Huf_down2",gp.tileSize,gp.tileSize*2);
            left1 = setup("/resources/characters/npc/Huf/Huf_left1",gp.tileSize,gp.tileSize*2);
            left2 = setup("/resources/characters/npc/Huf/Huf_left2",gp.tileSize,gp.tileSize*2);
            right1 = setup("/resources/characters/npc/Huf/Huf_right1",gp.tileSize,gp.tileSize*2);
            right2 = setup("/resources/characters/npc/Huf/Huf_right2",gp.tileSize,gp.tileSize*2);
    }


    public void getPlayerAttackImage() {
        attackUp1 = setup("/resources/characters/npc/Huf/Huf_attackUp1",gp.tileSize,gp.tileSize*2);
        attackUp2 = setup("/resources/characters/npc/Huf/Huf_attackUp2",gp.tileSize,gp.tileSize*2);
        attackDown1 = setup("/resources/characters/npc/Huf/Huf_attackDown1",gp.tileSize,gp.tileSize*2);
        attackDown2 = setup("/resources/characters/npc/Huf/Huf_attackDown2",gp.tileSize,gp.tileSize*2);
        attackLeft1 = setup("/resources/characters/npc/Huf/Huf_attackLeft1",gp.tileSize,gp.tileSize*2);
        attackLeft2 = setup("/resources/characters/npc/Huf/Huf_attackLeft2",gp.tileSize,gp.tileSize*2);
        attackRight1 = setup("/resources/characters/npc/Huf/Huf_attackRight1",gp.tileSize,gp.tileSize*2);
        attackRight2 = setup("/resources/characters/npc/Huf/Huf_attackRight2",gp.tileSize,gp.tileSize*2);
    }

    public void update() {  // Update player position and collision

        // Calculate life percentile of player
        lifePercentile = (int) ((double) life / (double) maxLife * 100);

        //If player pressed enter, player will attack.
        if(attack == true) { attacking(); }

        //If player pressed any arrow key, player will move.
        else if(keyHandler.upPressed == true || keyHandler.downPressed == true || keyHandler.leftPressed == true ||
                keyHandler.rightPressed == true || keyHandler.enterPressed == true) {
            //Set direction
            if(keyHandler.upPressed == true) {direction = "up";}
            else if (keyHandler.downPressed ==true) {direction = "down";}
            else if (keyHandler.leftPressed == true) {direction = "left";}
            else if (keyHandler.rightPressed == true) {direction = "right";}
            //Check Tile Collision
            collisionOn = false;
            //collisionOn =
            gp.cChecker.checkTile(this);

            //Check Object Collision
            int objIndex = gp.cChecker.checkObject(this, true);
            pickUpObject(objIndex);

            //Check NPC Collision
            int npcIndex = gp.cChecker.checkEntity(this, gp.npc );
            interactNPC(npcIndex);

            //Check Monster Collision
            int monsterIndex = gp.cChecker.checkEntity(this, gp.monster );
            contactMonster(monsterIndex);

            //Check Event
            gp.eHandler.checkEvent();

            //If collision is FALSE, Entity can move.
            if (collisionOn == false && gp.keyHandler.enterPressed == false) {
                switch (direction) {
                    case "up": worldY -=  speed; break;
                    case "down": worldY +=  speed; break;
                    case "left": worldX -= speed; break;
                    case "right": worldX += speed; break;
                }
            }

            gp.keyHandler.enterPressed = false;

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
        else {standCounter ++;
            if(standCounter > 20) {spriteNum = 1;standCounter = 0;
            }
        }
        //Outsite KeyHandler
        if(invincible == true) {invincibleCounter++;
            if(invincibleCounter > 120) {invincible = false;invincibleCounter = 0;
            }
        }
    }
    public void attacking() {

        spriteCounter++;

        if(spriteCounter <= 20) {
            spriteNum = 1;
            }
        if(spriteCounter > 20 && spriteCounter <= 80) {
            spriteNum = 2;
        }
        if (spriteCounter > 80) {
            spriteNum = 1;
            spriteCounter = 0;
            attack = false;
        }
    }
    public void pickUpObject(int i) {
        if(i != 999) {}
    }
    public void interactNPC(int i) {

        if(gp.keyHandler.enterPressed == true) {
            if(i != 999) {
                {gp.gameState = gp.dialogueState;gp.npc[i].speak();}}
            else {
                {attack = true;}
            }
        }
    }
    public void contactMonster(int i) {if(i != 999) {
        if(invincible == false) {life -= 5;invincible = true;}}}

    public void draw(Graphics2D g2) {
        BufferedImage image = null;
        switch(direction) {
            case "up":
                if(attack == true) {
                    if(spriteNum == 1) {image = attackUp1;}
                    if(spriteNum == 2) {image = attackUp2;}}
                else {
                    if(spriteNum == 1) {image = up1;}
                    if(spriteNum == 2) {image = up2;}}break;
            case "down":
                if(attack == true) {
                    if(spriteNum == 1) {image = attackDown1;}
                    if(spriteNum == 2) {image = attackDown2;}}
                else {
                    if(spriteNum == 1) {image = down1;}
                    if(spriteNum == 2) {image = down2;}}break;
            case "left":
                if(attack == true) {
                    if(spriteNum == 1) {image = attackLeft1;}
                    if(spriteNum == 2) {image = attackLeft2;}}
                else {
                    if(spriteNum == 1) {image = left1;}
                    if(spriteNum == 2) {image = left2;}}break;
            case "right":
                if(attack == true) {
                    if(spriteNum == 1) {image = attackRight1;}
                    if(spriteNum == 2) {image = attackRight2;}}
                else {
                    if(spriteNum == 1) {image = right1;}
                    if(spriteNum == 2) {image = right2;}}break;
        }
        //set composite
        if(invincible == true) {g2.setComposite( AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.3f) );}

        g2.drawImage(image, screenX, screenY, null);

        //reset composite
        g2.setComposite( AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1.0f) );
    }
}
