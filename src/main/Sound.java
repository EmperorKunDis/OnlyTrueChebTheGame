package main;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.net.URL;

public class Sound {

    Clip clip;
    URL soundURL[] = new URL[30];

    public Sound() {

        soundURL[0] = getClass().getResource("/resources/sounds/Slurp+8.wav");
        soundURL[1] = getClass().getResource("/resources/sounds/Cough+8.wav");
        soundURL[2] = getClass().getResource("/resources/sounds/Burp+7.wav");
        soundURL[3] = getClass().getResource("/resources/sounds/player-wins-94889.wav");
        soundURL[4] = getClass().getResource("/resources/sounds/error-in-the-file-system-149908.wav");
        soundURL[5] = getClass().getResource("/resources/sounds/pounding-cards-on-table-99355.wav");
        soundURL[6] = getClass().getResource("/resources/sounds/security-system-offline-97117.wav");
    }

    public void setFile(int i) {

        try {
            AudioInputStream ais = AudioSystem.getAudioInputStream(soundURL[i]);
            clip = AudioSystem.getClip();
            clip.open(ais);

        } catch (Exception e) {
            throw new RuntimeException( e );
        }

    }
    public void play() {
        clip.start();
    }
    public void loop() {
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }
    public void stop() {
        clip.stop();
    }
}
