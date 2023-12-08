package main;

import entity.NPC_KunDis;
import entity.monsters.MON_GreenGoblin;

public class AssetSetter {

    GamePanel gp;

    public AssetSetter(GamePanel gp) {
        this.gp = gp;
    }

    public void setObjects() {

    }
    public void setNPC() {

        gp.npc[0] = new NPC_KunDis( gp );
        gp.npc[0].worldX = gp.tileSize*20;
        gp.npc[0].worldY = gp.tileSize*10;

    }
    public void setMonsters() {
        gp.monster[0] = new MON_GreenGoblin( gp );
        gp.monster[0].worldX = gp.tileSize*10;
        gp.monster[0].worldY = gp.tileSize*20;

        gp.monster[1] = new MON_GreenGoblin( gp );
        gp.monster[1].worldX = gp.tileSize*35;
        gp.monster[1].worldY = gp.tileSize*20;
    }

}
