package main;

import entity.NPC_KunDis;
import entity.monsters.MON_GreenGoblin;
import objects.obj_Doors;

public class AssetSetter {

    GamePanel gp;

    public AssetSetter(GamePanel gp) {
        this.gp = gp;
    }

    public void setObjects() {

        gp.obj[0] = new obj_Doors(gp);
        gp.obj[0].worldX = gp.tileSize*10;
        gp.obj[0].worldY = gp.tileSize*10;
    }
    public void setNPC() {

        gp.npc[0] = new NPC_KunDis( gp );
        gp.npc[0].worldX = gp.tileSize*20;
        gp.npc[0].worldY = gp.tileSize*10;

        gp.npc[1] = new NPC_KunDis( gp );
        gp.npc[1].worldX = gp.tileSize*20;
        gp.npc[1].worldY = gp.tileSize*10;

        gp.npc[2] = new NPC_KunDis( gp );
        gp.npc[2].worldX = gp.tileSize*20;
        gp.npc[2].worldY = gp.tileSize*10;

    }
    public void setMonsters() {
        gp.mon[0] = new MON_GreenGoblin( gp );
        gp.mon[0].worldX = gp.tileSize*10;
        gp.mon[0].worldY = gp.tileSize*20;

        gp.mon[1] = new MON_GreenGoblin( gp );
        gp.mon[1].worldX = gp.tileSize*35;
        gp.mon[1].worldY = gp.tileSize*20;
    }

}
