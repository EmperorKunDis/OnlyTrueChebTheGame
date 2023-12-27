package entity;

import main.GamePanel;
import main.KeyHandler;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Player extends Entity{
    
    public final int maxLife;   // Max life of player (100)
    private final int playerWidth;
    private final int playerHeight;
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
    


    public Player(int playerHeight, int playerWidth, GamePanel gp, KeyHandler keyHandler, int maxLife, int life, int maxMana, int mana, int maxStamina,
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
        this.playerWidth = playerWidth;
        this.playerHeight = playerHeight;
        name = "Hufito";
        this.keyHandler = keyHandler;   // Keyboard event handler

        solidArea = new Rectangle();    // Set solid area of player (collision)
        solidArea.x = 32;
        solidArea.y = 64;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
        solidArea.width = 32;
        solidArea.height = 24;

        setDefaultValues();                         // Set default values of player (position, direction, speed)

        getPlayerImage();                           // Load player images
        getPlayerAttackImage();                     // Load player attack images

        update();                                   // Update player position and collision


    }
    public void setDefaultValues() {
        worldX = gp.tileSize * 15 ;
        worldY = gp.tileSize * 15 ;
        speed = 2;
        direction = "downbase";
        imageMaxNum = 6;

        screenX = gp.screenWidth/2 - (gp.tileSize/2);
        screenY = gp.screenHeight/2 - (gp.tileSize/2);

    }
    public void getPlayerImage()
    {                             // Load player images
        up1 = setup("/resources/characters/npc/Huf/Huf_up1", playerWidth, playerHeight);
        up2 = setup("/resources/characters/npc/Huf/Huf_up2", playerWidth, playerHeight);
        up3 = setup("/resources/characters/npc/Huf/Huf_up3", playerWidth, playerHeight);
        up4 = setup("/resources/characters/npc/Huf/Huf_up4", playerWidth, playerHeight);
        up5 = setup("/resources/characters/npc/Huf/Huf_up5", playerWidth, playerHeight);
        up6 = setup("/resources/characters/npc/Huf/Huf_up6", playerWidth, playerHeight);
        down1 = setup("/resources/characters/npc/Huf/Huf_down1", playerWidth, playerHeight);
        down2 = setup("/resources/characters/npc/Huf/Huf_down2", playerWidth, playerHeight);
        down3 = setup("/resources/characters/npc/Huf/Huf_down3", playerWidth, playerHeight);
        down4 = setup("/resources/characters/npc/Huf/Huf_down4", playerWidth, playerHeight);
        down5 = setup("/resources/characters/npc/Huf/Huf_down5", playerWidth, playerHeight);
        down6 = setup("/resources/characters/npc/Huf/Huf_down6", playerWidth, playerHeight);
        left1 = setup("/resources/characters/npc/Huf/Huf_left1", playerWidth, playerHeight);
        left2 = setup("/resources/characters/npc/Huf/Huf_left2", playerWidth, playerHeight);
        left3 = setup("/resources/characters/npc/Huf/Huf_left3", playerWidth, playerHeight);
        left4 = setup("/resources/characters/npc/Huf/Huf_left4", playerWidth, playerHeight);
        left5 = setup("/resources/characters/npc/Huf/Huf_left5", playerWidth, playerHeight);
        left6 = setup("/resources/characters/npc/Huf/Huf_left6", playerWidth, playerHeight);
        right1 = setup("/resources/characters/npc/Huf/Huf_right1", playerWidth, playerHeight);
        right2 = setup("/resources/characters/npc/Huf/Huf_right2", playerWidth, playerHeight);
        right3 = setup("/resources/characters/npc/Huf/Huf_right3", playerWidth, playerHeight);
        right4 = setup("/resources/characters/npc/Huf/Huf_right4", playerWidth, playerHeight);
        right5 = setup("/resources/characters/npc/Huf/Huf_right5", playerWidth, playerHeight);
        right6 = setup("/resources/characters/npc/Huf/Huf_right6", playerWidth, playerHeight);
    }


    public void getPlayerAttackImage() {
        attackUp1 = setup("/resources/characters/npc/Huf/Huf_attackUp1", playerWidth, playerHeight);
        attackUp2 = setup("/resources/characters/npc/Huf/Huf_attackUp2", playerWidth, playerHeight);
        attackUp3 = setup("/resources/characters/npc/Huf/Huf_attackUp3", playerWidth, playerHeight);
        attackUp4 = setup("/resources/characters/npc/Huf/Huf_attackUp4", playerWidth, playerHeight);
        attackUp5 = setup("/resources/characters/npc/Huf/Huf_attackUp5", playerWidth, playerHeight);
        attackUp6 = setup("/resources/characters/npc/Huf/Huf_attackUp6", playerWidth, playerHeight);
        attackDown1 = setup("/resources/characters/npc/Huf/Huf_attackDown1", playerWidth, playerHeight);
        attackDown2 = setup("/resources/characters/npc/Huf/Huf_attackDown2", playerWidth, playerHeight);
        attackDown3 = setup("/resources/characters/npc/Huf/Huf_attackDown3", playerWidth, playerHeight);
        attackDown4 = setup("/resources/characters/npc/Huf/Huf_attackDown4", playerWidth, playerHeight);
        attackDown5 = setup("/resources/characters/npc/Huf/Huf_attackDown5", playerWidth, playerHeight);
        attackDown6 = setup("/resources/characters/npc/Huf/Huf_attackDown6", playerWidth, playerHeight);
        attackLeft1 = setup("/resources/characters/npc/Huf/Huf_attackLeft1", playerWidth, playerHeight);
        attackLeft2 = setup("/resources/characters/npc/Huf/Huf_attackLeft2", playerWidth, playerHeight);
        attackLeft3 = setup("/resources/characters/npc/Huf/Huf_attackLeft3", playerWidth, playerHeight);
        attackLeft4 = setup("/resources/characters/npc/Huf/Huf_attackLeft4", playerWidth, playerHeight);
        attackLeft5 = setup("/resources/characters/npc/Huf/Huf_attackLeft5", playerWidth, playerHeight);
        attackLeft6 = setup("/resources/characters/npc/Huf/Huf_attackLeft6", playerWidth, playerHeight);
        attackRight1 = setup("/resources/characters/npc/Huf/Huf_attackRight1", playerWidth, playerHeight);
        attackRight2 = setup("/resources/characters/npc/Huf/Huf_attackRight2", playerWidth, playerHeight);
        attackRight3 = setup("/resources/characters/npc/Huf/Huf_attackRight3", playerWidth, playerHeight);
        attackRight4 = setup("/resources/characters/npc/Huf/Huf_attackRight4", playerWidth, playerHeight);
        attackRight5 = setup("/resources/characters/npc/Huf/Huf_attackRight5", playerWidth, playerHeight);
        attackRight6 = setup("/resources/characters/npc/Huf/Huf_attackRight6", playerWidth, playerHeight);  
    }

    public void update() {  // Update player position and collision

        // Calculate life percentile of player
        lifePercentile = (int) ((double) life / (double) maxLife * 100);

        //If player pressed enter, player will attack.
        if(attack) { attacking(); }

        //If player pressed any arrow key, player will move.
        else if(keyHandler.upPressed || keyHandler.downPressed || keyHandler.leftPressed ||
                keyHandler.rightPressed || keyHandler.enterPressed) {
            //Set direction
            if(keyHandler.upPressed) {direction = "up";}
            else if (keyHandler.downPressed) {direction = "down";}
            else if (keyHandler.leftPressed) {direction = "left";}
            else if (keyHandler.rightPressed) {direction = "right";}
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
            int monsterIndex = gp.cChecker.checkEntity(this, gp.mon );
            contactMonster(monsterIndex);

            //Check Event
            gp.eHandler.checkEvent();

            //If collision is FALSE, Entity can move.
            if (!collisionOn && !gp.keyHandler.enterPressed) {
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

                        case 6: if(spriteNum == 1) {spriteNum = 2;} else if (spriteNum == 2) {spriteNum = 3;} else if (spriteNum == 3) {spriteNum = 4;} else if (spriteNum == 4) {spriteNum = 5;} else if (spriteNum == 5) {spriteNum = 1;}spriteCounter = 1;break;
                        case 5: if(spriteNum == 1) {spriteNum = 2;} else if (spriteNum == 2) {spriteNum = 3;} else if (spriteNum == 3) {spriteNum = 4;} else if (spriteNum == 4) {spriteNum = 1;}spriteCounter = 1;break;
                        case 4: if(spriteNum == 1) {spriteNum = 2;} else if (spriteNum == 2) {spriteNum = 3;} else if (spriteNum == 3) {spriteNum = 1;}spriteCounter = 1;break;
                        case 3: if(spriteNum == 1) {spriteNum = 2;} else if (spriteNum == 2) {spriteNum = 1;}spriteCounter = 1;break;
                        case 2:
                            spriteCounter = 0;break;
                }
            }
        }
        else {standCounter ++;
            if(standCounter > 20) {spriteNum = 1;standCounter = 0;
            }
        }
        //Outsite KeyHandler
        if(invincible) {invincibleCounter++;
            if(invincibleCounter > 120) {invincible = false;invincibleCounter = 0;
            }
        }
    }
    public void attacking() {

        spriteCounter++;

        if(spriteCounter <=10 ) {
            spriteNum = 1;
            }
        if(spriteCounter > 10 && spriteCounter <= 20) {
            spriteNum = 2;
        }
        if(spriteCounter > 20 && spriteCounter <= 30) {
            spriteNum = 3;
        }
        if(spriteCounter > 30 && spriteCounter <= 40) {
            spriteNum = 4;
        }
        if(spriteCounter > 40 && spriteCounter <= 50) {
            spriteNum = 5;
        }
        if(spriteCounter > 50 && spriteCounter <= 60) {
            spriteNum = 6;
        }

        if (spriteCounter > 60) {
            spriteNum = 1;
            spriteCounter = 0;
            attack = false;
        }
    }
    public void pickUpObject(int i) {
        if (i != 999) {}
    }
    public void interactNPC(int i) {

        if(gp.keyHandler.enterPressed) {
            if(i != 999) {
                {gp.gameState = gp.dialogueState;gp.npc[i].speak();}}
            else {
                {attack = true;}
            }
        }
    }
    public void contactMonster(int i) {if(i != 999) {
        if(!invincible) {life -= 5;invincible = true;}}}

    public void draw(Graphics2D g2) {
        BufferedImage image = null;
        switch(direction) {
            case "up":
                if(attack) {
                    if(spriteNum == 1) {image = attackUp1;}
                    if(spriteNum == 2) {image = attackUp2;}
                    if(spriteNum == 3) {image = attackUp3;}
                    if(spriteNum == 4) {image = attackUp4;}
                    if(spriteNum == 5) {image = attackUp5;}
                    if(spriteNum == 6) {image = attackUp6;}}
                else {
                    if(spriteNum == 1) {image = up1;}
                    if(spriteNum == 2) {image = up2;}
                    if(spriteNum == 3) {image = up3;}
                    if(spriteNum == 4) {image = up4;}
                    if(spriteNum == 5) {image = up5;}
                    if(spriteNum == 6) {image = up6;}}break;
            case "down":
                if(attack) {
                    if(spriteNum == 1) {image = attackDown1;}
                    if(spriteNum == 2) {image = attackDown2;}
                    if(spriteNum == 3) {image = attackDown3;}
                    if(spriteNum == 4) {image = attackDown4;}
                    if(spriteNum == 5) {image = attackDown5;}
                    if(spriteNum == 6) {image = attackDown6;}}
                else {
                    if(spriteNum == 1) {image = down1;}
                    if(spriteNum == 2) {image = down2;}
                    if(spriteNum == 3) {image = down3;}
                    if(spriteNum == 4) {image = down4;}
                    if(spriteNum == 5) {image = down5;}
                    if(spriteNum == 6) {image = down6;}}break;
            case "left":
                if(attack) {
                    if(spriteNum == 1) {image = attackLeft1;}
                    if(spriteNum == 2) {image = attackLeft2;}
                    if(spriteNum == 3) {image = attackLeft3;}
                    if(spriteNum == 4) {image = attackLeft4;}
                    if(spriteNum == 5) {image = attackLeft5;}
                    if(spriteNum == 6) {image = attackLeft6;}}
                else {
                    if(spriteNum == 1) {image = left1;}
                    if(spriteNum == 2) {image = left2;}
                    if(spriteNum == 3) {image = left3;}
                    if(spriteNum == 4) {image = left4;}
                    if(spriteNum == 5) {image = left5;}
                    if(spriteNum == 6) {image = left6;}}break;
            case "right":
                if(attack) {
                    if(spriteNum == 1) {image = attackRight1;}
                    if(spriteNum == 2) {image = attackRight2;}
                    if(spriteNum == 3) {image = attackRight3;}
                    if(spriteNum == 4) {image = attackRight4;}
                    if(spriteNum == 5) {image = attackRight5;}
                    if(spriteNum == 6) {image = attackRight6;}}
                else {
                    if(spriteNum == 1) {image = right1;}
                    if(spriteNum == 2) {image = right2;}
                    if(spriteNum == 3) {image = right3;}
                    if(spriteNum == 4) {image = right4;}
                    if(spriteNum == 5) {image = right5;}
                    if(spriteNum == 6) {image = right6;}}break;
        }
        //set composite
        if(invincible) {g2.setComposite( AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.3f) );}

        g2.drawImage(image, screenX, screenY, null);

        //reset composite
        g2.setComposite( AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1.0f) );
    }
}
