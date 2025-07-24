// MoodSelectorUI.java
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import java.awt.BorderLayout;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;

public class MoodSelectorUI {
    private JFrame frame;
    private JComboBox<String> moodDropdown;
    private JButton playButton, stopButton, exitButton, uploadButton, detectButton;
    private JTextField moodInputField;

    private MoodRepository moodRepo;

    public MoodSelectorUI() {
        moodRepo = new MoodRepository();
        createUI();
    }

    private void createUI() {
        frame = new JFrame("Moodifyx - Mood Based Music Player");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLayout(new BorderLayout());

        JPanel topPanel = new JPanel();
        moodDropdown = new JComboBox<>(moodRepo.getAllMoods().toArray(new String[0]));
        topPanel.add(new JLabel("Select Mood: "));
        topPanel.add(moodDropdown);

        moodInputField = new JTextField(15);
        detectButton = new JButton("Detect Mood");
        topPanel.add(new JLabel("Enter Mood Text: "));
        topPanel.add(moodInputField);
        topPanel.add(detectButton);

        JPanel bottomPanel = new JPanel();
        playButton = new JButton("Play");
        stopButton = new JButton("Stop");
        exitButton = new JButton("Exit");
        uploadButton = new JButton("Upload Song");

        bottomPanel.add(playButton);
        bottomPanel.add(stopButton);
        bottomPanel.add(exitButton);
        bottomPanel.add(uploadButton);

        frame.add(topPanel, BorderLayout.NORTH);
        frame.add(bottomPanel, BorderLayout.SOUTH);

        addEventListeners();
        frame.setVisible(true);
    }

    private void addEventListeners() {
        playButton.addActionListener(e -> {
            String mood = (String) moodDropdown.getSelectedItem();
            java.util.List<Song> playlist = new ArrayList<>(moodRepo.getSongsForMood(mood));
            Collections.shuffle(playlist);
            SongPlayer.playPlaylist(playlist);
        });

        stopButton.addActionListener(e -> SongPlayer.stop());

        exitButton.addActionListener(e -> {
            SongPlayer.stop();
            frame.dispose();
        });

        uploadButton.addActionListener(e -> {
            JFileChooser fileChooser = new JFileChooser();
            int result = fileChooser.showOpenDialog(frame);
            if (result == JFileChooser.APPROVE_OPTION) {
                File file = fileChooser.getSelectedFile();
                Song customSong = new Song(file.getName(), file.getAbsolutePath());
                SongPlayer.play(customSong.getFilePath());
            }
        });

        detectButton.addActionListener(e -> {
            String input = moodInputField.getText().toLowerCase();
            if (input.contains("happy")) {
                moodDropdown.setSelectedItem("happy");
            } else if (input.contains("chill")) {
                moodDropdown.setSelectedItem("chill");
            } else if (input.contains("moody")) {
                moodDropdown.setSelectedItem("moody");
            } else {
                JOptionPane.showMessageDialog(frame, "Could not detect mood. Try 'happy', 'chill', or 'moody'.");
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MoodSelectorUI());
    }
}
