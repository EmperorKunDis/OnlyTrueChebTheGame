package main;

import entity.Entity;
import entity.Player;
import tile.TileManager;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class GamePanel extends JPanel implements Runnable{
    public static Dimension WINDOW_DIMENSION;
    //  ---->   Screen settings
    final int originalTileSize = 32;    // 32px
    final int tileScale = 2;        // 2x

    public final int tileSize = originalTileSize * tileScale;  // 64px
    public final int maxScreenCol = 30;               // 30*64 = 1920
    public final int maxScreenRow = 16;             // 16*64 = 1024
    public final int screenWidth = tileSize * maxScreenCol;   // Real screen Width in pixels       1920
    public final int screenHeight = tileSize * maxScreenRow;  // Real screen Height in pixels      1024
    //World settings
    public final int maxWorldCol = 100;     // 100*64 = 6400
    public final int maxWorldRow = 100;     // 100*64 = 6400

    // FPS
    int FPS = 120;  // Frames per second

    // System
    TileManager tileManager = new TileManager(this);    // Load tile images and map
    public KeyHandler keyHandler = new KeyHandler(this);    // Keyboard event handler
    Sound music = new Sound();  // Music
    Sound soundEffect = new Sound();    // Sound effect
    public CollisionChecker cChecker = new CollisionChecker(this);  // Collision checker
    public AssetSetter asSet = new AssetSetter(this);   // Set objects and NPC
    public UserInterface ui = new UserInterface(this);  // User interface
    public EventHandler eHandler = new EventHandler(this);  // Event handler
    Thread gameBaseThread;  // Game thread

    //Entities and Objets
    public Player player = new Player(100, 100,this, keyHandler, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100); // Player
    public Entity mon[] = new Entity[25];                                                   // Monster array (max 25)
    public Entity obj[] = new Entity[25];                                                       // Object array (max 25)
    public Entity npc[] = new Entity[25];                                                       // NPC array (max 25)

    ArrayList<Entity> entityList = new ArrayList<>();           // Entity list


    //Game State
    public int gameState;               // Game state
    public final int titleState = 0;    // Game state 0 = title screen
    public final int playState = 1;     // Game state 1 = play
    public final int pauseState = 2;    // Game state 2 = pause
    public final int dialogueState=3;   // Game state 3 = dialogue

    public GamePanel() {
//  ---->   Basic settings of game panel
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));    // Set size of game panel (screen)
        this.setBackground(Color.BLACK);                                    // Set background color
        this.setDoubleBuffered(true);                                       // Set double buffering
        this.addKeyListener(keyHandler);                                    // Add key listener
        this.setFocusable(true);                                            // Set focusable to true (for key listener)
    }

    public void setupWorld() {                                              // Setup world (load map, set objects and NPC)

        asSet.setObjects();                                                 // Set objects
        asSet.setNPC();                                                     // Set NPC NPC_KunDis
        asSet.setMonsters();                                                // Set monsters MON_GreenGoblin
        playMusic(3);                                                     // Play music
        stopMusic();                                                        // Stop music
        gameState = titleState;

    }
    public void startGameThread() {                                         // Start game thread

        gameBaseThread = new Thread(this);                            // Create new thread
        gameBaseThread.start();                                             // Start thread
    }

    @Override
    public void run() {                                                     // Run game thread

        double drawInterval = 1000000000 / FPS;                 // every frame every 0,00833333 with 120 FPS seconds
        double delta = 0;                                       // delta is time gone
        long lastTime = System.nanoTime();                      // last time is time when program started
        long currentTime;                                           // current time is time when program is running
        long timer = 0;                                             // timer is time when program is running
        int drawCount = 0;                                          // draw count is how many times program draw on screen
        int infoCount = 0;                                              // info count is how many times program print info
        while (gameBaseThread != null) {
//  ---->   This saying to program what to do every frame and figurating how times gone
            currentTime = System.nanoTime();                            // current time is time when program is running

            delta += (currentTime - lastTime) / drawInterval;           // delta is time gone
            timer += (currentTime - lastTime);                          // timer is time when program is running
            lastTime = currentTime;                                     // last time is time when program started
            // This if make one frame
            if (delta >= 1) {                                           // if delta is bigger than 1 program draw on screen and update information and delta is 0
                // Update information
                update();
                // Draw on screen with updated information
                repaint();
                delta--;
                drawCount++;
            }
            if (timer >= 1000000000) {                                  // if timer is bigger than 1000000000 program print info and timer is 0
                infoCount++;

                // DebugZone  DebugZone  DebugZone  DebugZone  DebugZone  DebugZone  DebugZone  DebugZone
                System.out.println("Frames pro last second : " + drawCount + ". Pocitadlo jak dlouho Huf blbe cumi : "
                        + infoCount + " vterin.");
                System.out.println("Frames pro last second : " + drawCount + ". Pocitadlo jak dlouho Huf blbe cumi : " + infoCount + " vterin.");
                System.out.println("Player X: " + player.worldX + "------- Player Y: " + player.worldY);
                System.out.println("Player Screen X: " + player.screenX + "------- Player Screen Y: " + player.screenY);
                System.out.println("Player Solid Area X: " + player.solidArea.x + "------- Player Solid Area Y: " + player.solidArea.y);
                System.out.println("Player Direction: " + player.direction);
                System.out.println("Player Speed: " + player.speed);
                System.out.println("Player Life: " + player.life);
                System.out.println("Player Max Life: " + player.maxLife);
                System.out.println("Player Life Percentile: " + player.lifePercentile);
                //DebugZone  DebugZone  DebugZone  DebugZone  DebugZone
                drawCount = 0;
                timer = 0;
            }
        }
    }

    public void update() {                                              // Update game
//  ---->

        if (gameState==playState) {                                     // If game state is play state
            //Player
            player.update();                                            // Update player
            //NPC
            for (int i = 0; i < npc.length; i++) {                      // Update NPC
                if(npc[i] != null) {
                    npc[i].update();
                }
            }
            for(int i = 0; i < mon.length; i++) {                   // Update monster
                if(mon[i] != null) {
                    mon[i].update();
                }
            }
        }
        if (gameState==pauseState) {
            if (keyHandler.VK_ESCAPE == true) {
                   gameState = playState;
            }
        }
    }
    public void paintComponent(Graphics g) {                        // Draw on screen (paint) every frame (every 0,00833333 with 120 FPS seconds)
        super.paintComponent(g);                                    // Paint component (draw on screen) from JPanel (game panel) class
        Graphics2D g2 = (Graphics2D) g;                             // Graphics 2D

        if(gameState == titleState) {                               //Title Screen
            ui.draw(g2);
        }

        else {                                                      //Others

            tileManager.draw(g2);                                   //Tile

            entityList.add(player);

            for(int i = 0; i < npc.length; i++) {                    //Add Objects and NPC to Entity List
                if(npc[i] != null) {
                    entityList.add(npc[i]);
                }
            }
            for(int i = 0;i<obj.length; i++ ) {
                if(obj[i] != null) {
                    entityList.add(obj[i]);
                }
            }
            for(int i = 0;i<mon.length; i++ ) {
                if(mon[i] != null) {
                    entityList.add(mon[i]);
                }
            }
            //Sortin Entities
            Collections.sort(entityList, new Comparator<Entity>() {
                @Override
                public int compare(Entity e1, Entity e2) {
                    int result = Integer.compare(e1.worldY, e2.worldY);
                    return result;
                }
            });
            //Draw Entities
            for(int i = 0; i < entityList.size(); i++) {
                entityList.get(i).draw(g2);
            }
            //Make Entities List Empty
            entityList.clear();

            //User Inteface
            ui.draw(g2);
        }
        g2.dispose();
    }
    public void playMusic(int i) {
        music.setFile(i);
        music.play();
        music.loop();
    }
    public void stopMusic() {
        music.stop();
    }
    public void playSE(int i) {
        soundEffect.setFile(i);
        soundEffect.play();
    }
}
