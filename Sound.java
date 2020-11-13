import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;

public class Sound {

    static Clip clip;
    static boolean musicOff = true;

    public static void setMusic(String musicLocation) {
        if (musicOff) {
            try {
                File musicPath = new File(musicLocation);
                if (musicPath.exists()) {
                    AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
                    clip = AudioSystem.getClip();
                    clip.open(audioInput);
                    play();
                    //musicOn = true;
                    //clip.loop(Clip.LOOP_CONTINUOUSLY);

//                System.out.println("\t[0] - To Play Music");
//                int stopMusic = DungeonRunMain.intInputMethod();
//                if (stopMusic == 0) {
//                    play();
//                } else {
//                    stop();
//                }
                } else {
                    System.out.println("ERROR! - Can't find music-file!");
                }
            }
            catch(Exception ex){
                ex.printStackTrace();
            }
            musicOff = false;
        } else if (!musicOff){
            stop();
            /*try {
                File musicPath = new File(musicLocation);
                if (musicPath.exists()) {
                    AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
                    clip = AudioSystem.getClip();
                    clip.open(audioInput);
                    play();
                    //musicOn = true;
                    //clip.loop(Clip.LOOP_CONTINUOUSLY);

//                System.out.println("\t[0] - To Play Music");
//                int stopMusic = DungeonRunMain.intInputMethod();
//                if (stopMusic == 0) {
//                    play();
//                } else {
//                    stop();
//                }
                } else {
                    System.out.println("ERROR! - Can't find music-file!");
                }
            }
            catch(Exception ex){
                ex.printStackTrace();
            }*/
            musicOff = true;
        }
    }
    public static void setFx(String musicLocation) {
        try {
            File musicPath = new File(musicLocation);
            if (musicPath.exists()) {
                AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
                clip = AudioSystem.getClip();
                clip.open(audioInput);
                play();
            } else {
                System.out.println("ERROR! - Can't find sound file!");
            }
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }

    public static void play(){
        clip.setFramePosition(0);
        clip.start();
    }

    public static void stop(){
        clip.stop();
        clip.close();
    }
}