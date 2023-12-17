package main;

import entity.Entity;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.Random;

import static java.awt.Font.BOLD;

public class UserInterface {

    BufferedImage imageLife = null;;
    GamePanel gp;
    Graphics2D g2;
    Font Kdam,Ancient,Celtic,ComputerPixel,Emulogic,ModeSeven;
    BufferedImage heart_full, heart_half, heart_empty;
    Entity ent = new Entity(gp);
    public boolean messageOn = false;
    public String message = "";
    int messageCounter = 0;
    public boolean gameFinished = false;
    public String currentDialog;
    public int commandNum = 0;
    int titlePic = 0;
    int picRandom = 1;
    public int titleScreenState = 0;
    private String lifeBar = "lifeBar_100";


    public BufferedImage setup(String imagePath) {
        UtilityTool uTool = new UtilityTool();
        BufferedImage image = null;
        try {
            image = ImageIO.read(getClass().getResourceAsStream(imagePath + ".png"));
            image = uTool.scaleImage(image, gp.screenWidth, gp.screenHeight );
        }
        catch(IOException e) {
            e.printStackTrace();
        }
        return image;
    }
    public UserInterface(GamePanel gp) {
        this.gp = gp;

        try {
            InputStream is = getClass().getResourceAsStream( "/resources/fonts/KdamThmorPro-Regular.ttf" );
            Kdam = Font.createFont( Font.TRUETYPE_FONT, is );
            is = getClass().getResourceAsStream( "/resources/fonts/Emulogic-zrEw.ttf" );
            Emulogic = Font.createFont(Font.TRUETYPE_FONT, is);
            is = getClass().getResourceAsStream( "/resources/fonts/ComputerPixel7-mnL2.ttf" );
            ComputerPixel = Font.createFont(Font.TRUETYPE_FONT, is);
            is = getClass().getResourceAsStream( "/resources/fonts/Modeseven-L3n5.ttf" );
            ModeSeven = Font.createFont(Font.TRUETYPE_FONT, is);
            is = getClass().getResourceAsStream( "/resources/fonts/CelticBitRegular-nnWO.ttf" );
            Celtic = Font.createFont(Font.TRUETYPE_FONT, is);
            is = getClass().getResourceAsStream( "/resources/fonts/AncientModernTales-a7Po.ttf" );
            Ancient = Font.createFont(Font.TRUETYPE_FONT, is);
        } catch (FontFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //Create HUD Objects

    }

    public void showMesssage(String text) {
        message = text;
        messageOn = true;
    };
    public void draw(Graphics2D g2) {
        this.g2 = g2;

        g2.setFont(ModeSeven);
        g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        g2.setColor(Color.white);

        //Title Statement
        if (gp.gameState == gp.titleState) {
            drawTitleScreen();
        }
        //Play Statement
        if (gp.gameState == gp.playState) {
            drawPlayerLife();
            //Do PlayState staff
        }
        //Pause Statement
        if (gp.gameState == gp.pauseState) {
            drawPlayerLife();
            drawPauseScreen();
        }
        //Dialog Statement
        if (gp.gameState == gp.dialogueState) {
            drawPlayerLife();
            drawDialogScreen();
        }
    }
    
    public void drawPlayerLife() {
        //gp.player.life = 5;

        int x = 5;
        int y = -120;
        int width = gp.tileSize*10;
        int height = gp.tileSize*5;

        if (gp.player.lifePercentile == 0) {
            lifeBar = "lifeBar_00";
        } else if (00 <= gp.player.lifePercentile && gp.player.lifePercentile <= 05) {
            lifeBar = "lifeBar_05";
        } else if (05 <= gp.player.lifePercentile && gp.player.lifePercentile <= 10) {
            lifeBar = "lifeBar_10";
        } else if (10 <= gp.player.lifePercentile && gp.player.lifePercentile <= 15) {
            lifeBar = "lifeBar_15";
        } else if (15 <= gp.player.lifePercentile && gp.player.lifePercentile <= 20) {
            lifeBar = "lifeBar_20";
        } else if (20 <= gp.player.lifePercentile && gp.player.lifePercentile <= 25) {
            lifeBar = "lifeBar_25";
        } else if (25 <= gp.player.lifePercentile && gp.player.lifePercentile <= 30) {
            lifeBar = "lifeBar_30";
        } else if (30 <= gp.player.lifePercentile && gp.player.lifePercentile <= 35) {
            lifeBar = "lifeBar_35";
        } else if (35 <= gp.player.lifePercentile && gp.player.lifePercentile <= 40) {
            lifeBar = "lifeBar_40";
        } else if (40 <= gp.player.lifePercentile && gp.player.lifePercentile <= 45) {
            lifeBar = "lifeBar_45";
        } else if (45 <= gp.player.lifePercentile && gp.player.lifePercentile <= 50) {
            lifeBar = "lifeBar_50";
        } else if (50 <= gp.player.lifePercentile && gp.player.lifePercentile <= 55) {
            lifeBar = "lifeBar_55";
        } else if (55 <= gp.player.lifePercentile && gp.player.lifePercentile <= 60) {
            lifeBar = "lifeBar_60";
        } else if (60 <= gp.player.lifePercentile && gp.player.lifePercentile <= 65) {
            lifeBar = "lifeBar_65";
        } else if (65 <= gp.player.lifePercentile && gp.player.lifePercentile <= 70) {
            lifeBar = "lifeBar_70";
        } else if (70 <= gp.player.lifePercentile && gp.player.lifePercentile <= 75) {
            lifeBar = "lifeBar_75";
        } else if (75 <= gp.player.lifePercentile && gp.player.lifePercentile <= 80) {
            lifeBar = "lifeBar_80";
        } else if (80 <= gp.player.lifePercentile && gp.player.lifePercentile <= 85) {
            lifeBar = "lifeBar_85";
        } else if (85 <= gp.player.lifePercentile && gp.player.lifePercentile <= 90) {
            lifeBar = "lifeBar_90";
        } else if (90 <= gp.player.lifePercentile && gp.player.lifePercentile <= 95) {
            lifeBar = "lifeBar_95";
        } else if (95 <= gp.player.lifePercentile && gp.player.lifePercentile <=100) {
            lifeBar = "lifeBar_100";
        }
        imageLife = setup("/resources/interface/" + lifeBar);
        g2.drawImage(imageLife, x, y, width, height, null);
    }
    public void drawTitleScreen() {
        if(titleScreenState == 0) {
            g2.setColor(new Color (173, 216, 230));
            g2.fillRect(0, 0, gp.screenWidth, gp.screenHeight);

            //Title Image
            if (titlePic>240) {
                Random random = new Random();
                picRandom = random.nextInt( 10 ) + 1;
                titlePic = 0;
            }
            titlePic++;
            g2.drawImage(setup( "/resources/characters/creating/PicChar" +picRandom),
                    gp.screenWidth - (gp.screenWidth/3),0,gp.screenWidth/3,gp.screenHeight,null);

            // Title name
            g2.setFont( ModeSeven.deriveFont(BOLD,160F));
            String text = "CHEB   FICTION";
            int x = getXforCenteredText(text) - gp.tileSize*3;
            int y = gp.tileSize*3;

            //Shadow
            g2.setColor(new Color(93,120,255));
            g2.drawString(text, x+5, y+5);

            //Main Color
            g2.setColor(Color.WHITE);
            g2.drawString(text, x, y);






            //SubTitle name
            g2.setFont(Ancient.deriveFont(BOLD,82F));

            String text2 = "If Hell had a Disneyland it would be in Cheb.";
            int x2 = getXforCenteredText(text2) - gp.tileSize*3;
            int y2 = gp.tileSize*6;
            g2.setColor(Color.RED);
            g2.drawString(text2, x2+5, y2+5);
            g2.setColor(Color.RED);

            g2.setFont(Ancient.deriveFont(BOLD,80F));
            text2 = "If Hell had a Disneyland it would be in Cheb.";
            x2 = getXforCenteredText(text2) - gp.tileSize*3;
            y2 = gp.tileSize*6;
            //Shadow
            g2.setColor(Color.RED);
            g2.drawString(text2, x2+5, y2+5);

            //Main Color
            g2.setColor(Color.BLACK);
            g2.drawString(text2, x2, y2);

            //Menu
            g2.setFont(ModeSeven.deriveFont( BOLD, 48F ));

            text = "NEW PAIN";
            x = getXforCenteredText(text);
            y += gp.tileSize*6;
            g2.drawString(text, x, y);
            if (commandNum == 0) {
                g2.drawString( ">", x-gp.tileSize,y);
            }

            text = "LOAD PAIN";
            x = getXforCenteredText(text);
            y += gp.tileSize*2;
            g2.drawString(text, x, y);
            if (commandNum == 1) {
                g2.drawString( ">", x-gp.tileSize,y);
            }

            text = "QUIT";
            x = getXforCenteredText(text);
            y += gp.tileSize*2;
            g2.drawString(text, x, y);
            if (commandNum == 2) {
                g2.drawString( ">", x-gp.tileSize,y);
            }
        }
        else if(titleScreenState ==1) {

            g2.setColor(Color.WHITE);
            g2.setFont(g2.getFont().deriveFont(82F));

            String text = "Select your class:";
            int x = gp.tileSize*2; //getXforCenteredText(text)/3;
            int y = gp.tileSize*2;
            String classStatsHead = "Class Stats";
            String classDescription;/* =  "-->" + ent.className +
                                        "\nStrength : " + ent.strength +
                                        "\nDexterity : " + ent.dexterity +
                                        "\nConstitution : " + ent.constitution +
                                        "\nInteligence : " + ent.inteligence +
                                        "\nWisdom : " + ent.wisdom +
                                        "\nCharisma : " + ent.charisma +
                                        "Class Undergroundstory, Skills, Attributs and Others" +
                                        "\nSkills : " + ent.skills +
                                        "\nAbilities : " + ent.abilities;*/
            g2.drawString(text, x, y);

            g2.setColor(Color.WHITE);
            g2.setFont(g2.getFont().deriveFont(42F));

            text = "Underworld Enforcer";
            x = gp.tileSize;//getXforCenteredText( text )/3;
            y += gp.tileSize*2;
            g2.drawString(text, x, y);
            if (commandNum == 0) {
                ent.className = "Underworld Enforcer (Paladin)\n";
                ent.strength = String.valueOf( 16 );
                ent.dexterity = String.valueOf( 12 );
                ent.constitution = String.valueOf( 14 );
                ent.inteligence = String.valueOf( 10 );
                ent.wisdom = String.valueOf( 13 );
                ent.charisma = String.valueOf( 15 );
                ent.skills = "Intimidation, Persuasion, Investigation";
                ent.abilities = "Code of the Streets (ability to discern and enforce underworld laws)";
                ent.story = " Streetwise Mediation (negotiate and resolve criminal disputes)";
                g2.drawString( ">", x-gp.tileSize,y );
            }
            text = "Drug Manufacturer";
            x = gp.tileSize;//getXforCenteredText( text )/3;
            y += gp.tileSize;
            g2.drawString(text, x, y);
            if (commandNum == 1) {
                ent.className = "Drug Cooker (Necromancer)\n";
                ent.strength = String.valueOf( 8 );
                ent.dexterity = String.valueOf( 12 );
                ent.constitution = String.valueOf( 10 );
                ent.inteligence = String.valueOf( 17 );
                ent.wisdom = String.valueOf( 14 );
                ent.charisma = String.valueOf( 11 );
                ent.skills = "Alchemy (drug crafting), Deception, Psychology Knowledge";
                ent.abilities = "Chemical Mastery (create and control addictive substances)";
                ent.story = "Network of Shadows (control over users and dealers)";
                g2.drawString( ">", x-gp.tileSize,y );
            }
            text = "Illicit Botanist";
            x = gp.tileSize;//getXforCenteredText( text )/3;
            y += gp.tileSize;
            g2.drawString(text, x, y);
            if (commandNum == 2) {
                ent.className = "Illicit Botanist (Druid)\n";
                ent.strength = String.valueOf( 10 );
                ent.dexterity = String.valueOf( 14 );
                ent.constitution = String.valueOf( 12 );
                ent.inteligence = String.valueOf( 15 );
                ent.wisdom = String.valueOf( 16 );
                ent.charisma = String.valueOf( 9 );
                ent.skills = "Natural drugs, Survival, Stealth";
                ent.abilities = "Urban Gardening (grow and harvest illegal plants), Brewmaster (create potent concoctions)";
                g2.drawString( ">", x-gp.tileSize,y );
            }
            text = "Hitman";
            x = gp.tileSize; //getXforCenteredText( text )/3;
            y += gp.tileSize;
            g2.drawString(text, x, y);
            if (commandNum == 3) {
                ent.className = "Hitman (Hunter)\n";
                ent.strength = String.valueOf(12);
                ent.dexterity = String.valueOf( 17 );
                ent.constitution = String.valueOf( 13 );
                ent.inteligence = String.valueOf( 11 );
                ent.wisdom = String.valueOf( 15 );
                ent.charisma = String.valueOf( 8 );
                ent.skills = "Tracking, Stealth, Ranged Weapons";
                ent.abilities = "Urban Predator (expertise in urban tracking and elimination),";
                ent.story = " Marked Target (identify and track high-value targets)";
                g2.drawString( ">", x-gp.tileSize,y );
            }
            text = "Gang Enforcer";
            x = gp.tileSize; //getXforCenteredText( text )/3;
            y += gp.tileSize;
            g2.drawString(text, x, y);
            if (commandNum == 4) {
                ent.className = "Gang Enforcer(Warrior)\n";
                ent.strength = String.valueOf( 16 );
                ent.dexterity = String.valueOf( 12 );
                ent.constitution = String.valueOf( 14 );
                ent.inteligence = String.valueOf( 10 );
                ent.wisdom = String.valueOf( 13 );
                ent.charisma = String.valueOf( 15 );
                ent.skills = "Intimidation, Persuasion, Investigation";
                ent.abilities = "Code of the Streets (ability to discern and enforce underworld laws)";
                ent.story = " Streetwise Mediation (negotiate and resolve criminal disputes)";
                g2.drawString( ">", x-gp.tileSize,y );
            }
            text = "Hacker";
            x = gp.tileSize; //getXforCenteredText( text )/3;
            y += gp.tileSize;
            g2.drawString(text, x, y);
            if (commandNum == 5) {
                ent.className = "Gang Enforcer (Warrior)\n";
                ent.strength = String.valueOf( 17 );
                ent.dexterity = String.valueOf( 13 );
                ent.constitution = String.valueOf( 16 );
                ent.inteligence = String.valueOf( 9 );
                ent.wisdom = String.valueOf( 11 );
                ent.charisma = String.valueOf( 10 );
                ent.skills = "Intimidation, Melee Combat, Athletics";
                ent.abilities = "Territorial Dominance (control and defend turf)";
                ent.story = "Fear Factor (intimidate and dominate opponents)";
                g2.drawString( ">", x-gp.tileSize,y );
            }
            text = "Cult Leader";
            x = gp.tileSize; //getXforCenteredText( text )/3;
            y += gp.tileSize;
            g2.drawString(text, x, y);
            if (commandNum == 6) {
                ent.className = "Cult Leader (Priest)\n";
                ent.strength = String.valueOf( 10 );
                ent.dexterity = String.valueOf( 11 );
                ent.constitution = String.valueOf( 12 );
                ent.inteligence = String.valueOf( 14 );
                ent.wisdom = String.valueOf( 16 );
                ent.charisma = String.valueOf( 17 );
                ent.skills = "Persuasion, Deception, Religion";
                ent.abilities = "Cult of Personality (influence and manipulate followers)";
                ent.story = "False Salvation (exploit followers for personal gain)";
                g2.drawString( ">", x-gp.tileSize,y );
            }
            text = "Silent Killer";
            x = gp.tileSize;//getXforCenteredText( text )/3;
            y += gp.tileSize;
            g2.drawString(text, x, y);
            if (commandNum == 7) {
                ent.className = "Silent Killer (Assassin)\n";
                ent.strength = String.valueOf( 11 );
                ent.dexterity = String.valueOf( 18 );
                ent.constitution = String.valueOf( 13 );
                ent.inteligence = String.valueOf( 12 );
                ent.wisdom = String.valueOf( 14 );
                ent.charisma = String.valueOf( 15 );
                ent.skills = "Stealth Kill, Acrobatics, Perception";
                ent.abilities = "Shadow Strike (eliminate targets undetected), Unseen Presence (move unnoticed)";
                g2.drawString( ">", x-gp.tileSize,y );
            }
            text = "Streetwise Occultist";
            x = gp.tileSize; //getXforCenteredText( text )/3;
            y += gp.tileSize;
            g2.drawString(text, x, y);
            if (commandNum == 8) {
                ent.className = "Streetwise Occultist (Shaman)\n";
                ent.strength = String.valueOf( 9 );
                ent.dexterity = String.valueOf( 12 );
                ent.constitution = String.valueOf( 11 );
                ent.inteligence = String.valueOf( 15 );
                ent.wisdom = String.valueOf( 17 );
                ent.charisma = String.valueOf( 13 );
                ent.skills = "Junkies Friends, Insight, Intimidation\n";
                ent.abilities = " Urban Mysticism (drug them all), Cursed Artifacts (deal in forbidden items)";
                g2.drawString( ">", x-gp.tileSize,y );

            }
            text = "BACK";
            x = gp.tileSize; //getXforCenteredText( text )/3;
            y += gp.tileSize*2;
            g2.drawString(text, x, y);
            if (commandNum == 9) {
                g2.drawString( ">", x-gp.tileSize,y );
            }
            classDescription = ent.className;

            text = classStatsHead;
            x = gp.screenWidth/3;//-((gp.screenWidth/3)*2);
            y = gp.screenHeight/5;
            g2.drawString(text, x, y);

            text = classDescription;
            x = gp.screenWidth/3;
            y += gp.tileSize;
            g2.drawString(text, x, y);

            g2.setFont(g2.getFont().deriveFont(20F));

            text = "Strength : " + ent.strength;
            x = gp.screenWidth/3;
            y += gp.tileSize/2;
            g2.drawString(text, x, y);

            text = "Dexterity : " + ent.dexterity;
            x = gp.screenWidth/3;
            y += gp.tileSize/2;
            g2.drawString(text, x, y);

            text = "Constitution : " + ent.constitution;
            x = gp.screenWidth/3;
            y += gp.tileSize/2;
            g2.drawString(text, x, y);

            text = "Inteligence : " + ent.inteligence;
            x = gp.screenWidth/3;
            y += gp.tileSize/2;
            g2.drawString(text, x, y);

            text = "Wisdom : " + ent.wisdom;
            x = gp.screenWidth/3;
            y += gp.tileSize/2;
            g2.drawString(text, x, y);

            text = "Charisma : " + ent.charisma;
            x = gp.screenWidth/3;
            y += gp.tileSize/2;
            g2.drawString(text, x, y);

            text = "Skills : " + ent.skills;
            x = gp.screenWidth/3;
            y += gp.tileSize/2;
            g2.drawString(text, x, y);

            text = "Abilities : " + ent.abilities;
            x = gp.screenWidth/3;
            y += gp.tileSize/2;
            g2.drawString(text, x, y);

            text = ent.story;
            x = (gp.screenWidth/3) + (gp.tileSize*2);
            y += gp.tileSize/2;
            g2.drawString(text, x, y);
        }
    }
    public void drawPauseScreen() {
        g2.setFont(g2.getFont().deriveFont(Font.PLAIN,80F));
        String text = "PAUSED";
        int x = getXforCenteredText(text);
        int y = gp.screenHeight/2;

        g2.drawString(text, x, y);
    }
    public void drawDialogScreen() {

        //Windows
        int x = gp.tileSize;
        int y = gp.screenHeight - (gp.tileSize*6);
        int width = gp.screenWidth - (gp.tileSize*2);
        int height = gp.screenHeight/3;

        drawSubWindow( x, y, width, height);

        g2.setFont(g2.getFont().deriveFont(Font.PLAIN,32F));
        x += gp.tileSize;
        y += gp.tileSize;

        for(String line : currentDialog.split("/n")) {
            g2.drawString(line, x, y);
            y += 40;
        }
    }
    public void drawSubWindow(int x, int y, int width, int height) {

        Color c = new Color(0, 0, 0, 188);
        g2.setColor(c);
        g2.fillRoundRect( x, y, width, height, 35, 35 );

        c = new Color(255,255,255);
        g2.setColor(c);
        g2.setStroke(new BasicStroke(5));
        g2.drawRoundRect(x+5,y+5,width-10,height-10,25,25);
    }
    public int getXforCenteredText(String text) {
        int length = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
        int x = gp.screenWidth/2 - length/2;
        return x;
    }
}
