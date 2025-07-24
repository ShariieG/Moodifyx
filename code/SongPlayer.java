import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;

public class SongPlayer {
    private static Clip clip;

    public static void play(String filePath) {
        stop();
        try {
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(new File(filePath));
            clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.start();
        } catch (Exception e) {
            System.out.println("Error playing sound: " + e.getMessage());
        }
    }

    public static void stop() {
        if (clip != null && clip.isRunning()) {
            clip.stop();
            clip.close();
        }
    }

    public static void playPlaylist(java.util.List<Song> playlist) {
        new Thread(() -> {
            for (Song song : playlist) {
                play(song.getFilePath());
                try {
                    Thread.sleep(5000); // Adjust delay as needed
                } catch (InterruptedException ignored) {}
            }
        }).start();
    }
}