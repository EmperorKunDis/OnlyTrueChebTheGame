package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {
    public boolean upPressed,downPressed,leftPressed,rightPressed,enterPressed;
    public boolean VK_ESCAPE;
    //DEBUG
    GamePanel gp;
    boolean checkDrawTime = false;
    public KeyHandler(GamePanel gp) {
        this.gp = gp;
    }
    @Override
    public void keyTyped(KeyEvent keyEvent) {
    }
    @Override
    public void keyPressed(KeyEvent keyEvent) {
        int code = keyEvent.getKeyCode();

        //Title Statement
        if (gp.gameState == gp.titleState) {
            if (gp.ui.titleScreenState == 0) {
                if (code == keyEvent.VK_W) {
                    gp.ui.commandNum--;
                    if (gp.ui.commandNum < 0) {
                        gp.ui.commandNum = 2;
                    }
                }
                if (code == keyEvent.VK_S) {
                    gp.ui.commandNum++;
                    if (gp.ui.commandNum > 2) {
                        gp.ui.commandNum = 0;

                    }
                }
                if (code == keyEvent.VK_ENTER) {
                    if (gp.ui.commandNum == 0) {
                        gp.ui.titleScreenState = 1;
                        //gp.playMusic( 7 );
                    }
                    if (gp.ui.commandNum == 1) {
                        //Addo Later
                    }
                    if (gp.ui.commandNum == 2) {
                        System.exit( 0 );
                    }
                }
            }
            else if (gp.ui.titleScreenState == 1) {
                if (code == keyEvent.VK_W) {
                    gp.ui.commandNum--;
                    if (gp.ui.commandNum < 0) {
                        gp.ui.commandNum = 9;
                    }
                }
                if (code == keyEvent.VK_S) {
                    gp.ui.commandNum++;
                    if (gp.ui.commandNum > 9) {
                        gp.ui.commandNum = 0;
                    }
                }
                if (code == keyEvent.VK_ENTER) {
                    if (gp.ui.commandNum == 0) {
                        System.out.println( "Do some Paladin things: " );
                        gp.gameState = gp.playState;
                        //gp.playMusic( 7 );
                    }
                    if (gp.ui.commandNum == 1) {
                        System.out.println( "Do some Necromancer things: " );
                        gp.gameState = gp.playState;
                    }
                    if (gp.ui.commandNum == 2) {
                        System.out.println( "Do some Druid things: " );
                        gp.gameState = gp.playState;
                    }
                    if (gp.ui.commandNum == 3) {
                        System.out.println( "Do some Hunter things: " );
                        gp.gameState = gp.playState;
                    }
                    if (gp.ui.commandNum == 4) {
                        System.out.println( "Do some Warrior things: " );
                        gp.gameState = gp.playState;
                    }
                    if (gp.ui.commandNum == 5) {
                        System.out.println( "Do some Mage things: " );
                        gp.gameState = gp.playState;
                    }
                    if (gp.ui.commandNum == 6) {
                        System.out.println( "Do some Priest things: " );
                        gp.gameState = gp.playState;
                    }
                    if (gp.ui.commandNum == 7) {
                        System.out.println( "Do some Assassin things: " );
                        gp.gameState = gp.playState;
                    }
                    if (gp.ui.commandNum == 8) {
                        System.out.println( "Do some Shaman things: " );
                        gp.gameState = gp.playState;
                    }
                    if (gp.ui.commandNum == 9) {
                        gp.ui.titleScreenState = 0;

                    }
                }
            }
        }
        //Play Statement
        if(gp.gameState == gp.playState) {
            if (code == keyEvent.VK_W) {
                upPressed = true;
            }
            if (code == keyEvent.VK_S) {
                downPressed = true;
            }
            if (code == keyEvent.VK_A) {
                leftPressed = true;
            }
            if (code == keyEvent.VK_D) {
                rightPressed = true;
            }
            if (code == keyEvent.VK_ESCAPE) {
                gp.gameState = gp.pauseState;
            }
            if (code == keyEvent.VK_ENTER) {
                enterPressed = true;
            }
            if (code == keyEvent.VK_T) {
                if (checkDrawTime == false) {
                    checkDrawTime = true;
                } else if (checkDrawTime == true) {
                    checkDrawTime = false;
                }
            }
            VK_ESCAPE = false;
        }
        //Pause State
        else if (gp.gameState == gp.pauseState) {
            if (code == keyEvent.VK_ESCAPE) {
                gp.gameState = gp.playState;
            }
        }
        //Dialogue State
        else if (gp.gameState == gp.dialogueState) {
            if(code == keyEvent.VK_SPACE) {
                gp.gameState = gp.playState;
            }
        }

    }
    @Override
    public void keyReleased(KeyEvent keyEvent) {
        int code =keyEvent.getKeyCode();
        if (code == keyEvent.VK_W) {
            upPressed = false;
        }
        if (code == keyEvent.VK_S) {
            downPressed = false;
        }
        if (code == keyEvent.VK_A) {
            leftPressed = false;
        }
        if (code == keyEvent.VK_D) {
            rightPressed = false;
        }
    }
}
