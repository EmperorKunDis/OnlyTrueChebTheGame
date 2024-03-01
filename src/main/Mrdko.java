package main;

import javax.swing.*;

public class Mrdko {
    public static void main(String[] args) {
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("Hellcraft HardCore RPG");

        GamePanel gamePanel = new GamePanel();
        window.add(gamePanel);

        window.pack();

        window.setLocationRelativeTo(null);
        window.setVisible(true);

        gamePanel.setupWorld();
        gamePanel.startGameThread();





        //window.setContentPane(new GamePanel());
        //window.getContentPane().setPreferredSize(GamePanel.WINDOW_DIMENSION);
        //gamePanel.requestFocusInWindow();
        //window.pack();
        //window.setLocationRelativeTo(null);
        //window.setVisible(true);
        //gamePanel.playMusic( 7 );
    }
}
