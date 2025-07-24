import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MoodRepository {
    private final Map<String, java.util.List<Song>> moodSongs = new HashMap<>();

    public MoodRepository() {
        initializeMoodSongs();
    }

    private void initializeMoodSongs() {
        Map<String, String[]> moodFiles = new HashMap<>();
        moodFiles.put("happy", new String[] { "happygirl.wav", "happygirly.wav" });
        moodFiles.put("chill", new String[] { "chillvibe.wav" });
        moodFiles.put("moody", new String[] { "moodyguy.wav" });

        for (Map.Entry<String, String[]> entry : moodFiles.entrySet()) {
            addMood(entry.getKey(), entry.getValue());
        }
    }

    private void addMood(String mood, String[] files) {
        java.util.List<Song> songs = new ArrayList<>();
        for (String file : files) {
            String title = formatTitle(file);
            String path = "music/" + file;
            songs.add(new Song(title, path));
        }
        moodSongs.put(mood, songs);
    }

    private String formatTitle(String fileName) {
        String base = fileName.replace(".wav", "");
        if (base.endsWith("girl")) base = base.replace("girl", "");
        if (base.endsWith("girly")) base = base.replace("girly", "");
        base = base.trim();
        return base.substring(0, 1).toUpperCase() + base.substring(1) + " Vibe";
    }

    public java.util.List<Song> getSongsForMood(String mood) {
        java.util.List<Song> defaultList = new ArrayList<>();
        defaultList.add(new Song("Default Vibe", "music/happygirl.wav"));
        return moodSongs.getOrDefault(mood, defaultList);
    }

    public Set<String> getAllMoods() {
        return moodSongs.keySet();
    }
}