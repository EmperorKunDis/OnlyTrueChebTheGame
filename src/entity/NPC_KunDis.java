package entity;

import main.GamePanel;

import java.util.Random;

public class NPC_KunDis extends Entity{

    public NPC_KunDis(GamePanel gp) {
        super(gp);

        direction = "down";
        speed = 1;

        getImage();
        setDialogue();
        update();
        imageMaxNum = 3;
    }
    public void getImage() {
        up1 = setup("/resources/characters/npc/Kundis/KunDis_up1", gp.tileSize, gp.tileSize*2);
        up2 = setup("/resources/characters/npc/Kundis/KunDis_up2", gp.tileSize, gp.tileSize*2);
        down1 = setup("/resources/characters/npc/Kundis/KunDis_down1", gp.tileSize, gp.tileSize*2);
        down2 = setup("/resources/characters/npc/Kundis/KunDis_down2", gp.tileSize, gp.tileSize*2);
        left1 = setup("/resources/characters/npc/Kundis/KunDis_left1", gp.tileSize, gp.tileSize*2);
        left2 = setup("/resources/characters/npc/Kundis/KunDis_left2", gp.tileSize, gp.tileSize*2);
        right1 = setup("/resources/characters/npc/Kundis/KunDis_right1", gp.tileSize, gp.tileSize*2);
        right2 = setup("/resources/characters/npc/Kundis/KunDis_right2", gp.tileSize, gp.tileSize*2);
    }
    public void setDialogue() {
        dialogues = new String[10];
        dialogues[0] = "Kde muze bejt ten zmrd tak dlouho";
        dialogues[1] = "Kokot by mi z nich praskl";
        dialogues[2] = "Tak to jebu jdu za Mistrem Farkym ten neco urcite splasi";
        dialogues[3] = "Just suck my dick and die";
        dialogues[4] = "A statnej novej rok";
        dialogues[5] = "Ty devko jedna neverna";
    }
    public void setAction() {

        actionCounter++;

        if (actionCounter==240) {
            Random random = new Random();
            int i = random.nextInt(100)+1;

            if (i<= 25) {
                direction = "up";
            }
            if (i> 25 && i<=50) {
                direction = "down";
            }
            if (i>50 && i<=75) {
                direction = "left";
            }
            if (i>75 && i<=100) {
                direction = "right";
            }
            actionCounter = 0;
        }


    }
    public void speak() {
        super.speak();
        Random random = new Random();
        int i = random.nextInt(150)+1;

        if (i<= 25) {
            gp.ui.currentDialog = "Kundis: " + dialogues[0];
        }
        if (i> 25 && i<=50) {
            gp.ui.currentDialog = "Kundis: " + dialogues[1];
        }
        if (i>50 && i<=75) {
            gp.ui.currentDialog = "Kundis: " + dialogues[2];
        }
        if (i>75 && i<=100) {
            gp.ui.currentDialog = "Kundis: " + dialogues[3];
        }
        if (i>100 && i<=125) {
            gp.ui.currentDialog = "Kundis: " + dialogues[4];
        }
        if (i>125 && i<=150) {
            gp.ui.currentDialog = "Kundis: " + dialogues[5];
        }
    }
}
