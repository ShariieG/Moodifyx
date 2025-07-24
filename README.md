# Moodifyx - Mood Based Music Player

Moodifyx is a Java Swing desktop application that plays music based on the user’s selected or detected mood. It allows for random playlist shuffling, user-uploaded songs, and text-based mood detection.

---

## 🎵 Features

- 🎧 Play songs based on your mood: *happy*, *chill*, *moody*
- 🔁 Shuffle playlist for each mood
- 🎼 Upload and play your own `.wav` files
- 💬 Detect mood from user-entered text
- 🛑 Start/Stop playback and Exit anytime

---

## 📁 Folder Structure

```
Moodifyx/
├── Song.java                 # Represents a song with title and file path
├── MoodRepository.java       # Stores and categorizes songs by mood
├── SongPlayer.java           # Handles audio playback
├── MoodSelectorUI.java       # The main Swing UI with controls
└── music/                    # Folder to store .wav files
```

---

## 🚀 How to Run

1. Ensure you have **Java 8 or later** installed.
2. Place your `.wav` files inside the `music/` directory.
3. Compile and run:
   ```bash
   javac *.java
   java MoodSelectorUI
   ```

---

## 📦 Requirements
- Java JDK 8 or above
- `.wav` audio files only (no MP3 support yet)

---

## 🛠 Future Improvements
- ✅ Text-based mood detection
- ⏳ Facial expression-based mood detection (planned)
- ⏳ MP3 support (planned)
- ⏳ Persistent custom playlists

---

## 🤖 Example Moods and Files

| Mood   | Example Files             |
|--------|---------------------------|
| Happy  | `happygirl.wav`, `happygirly.wav` |
| Chill  | `chillvibe.wav`           |
| Moody  | `moodyguy.wav`            |

---

## 💡 Tip

To detect a mood using text, simply type words like "happy", "moody", or "chill" into the mood input box and press **Detect Mood**.

---

## 🧑‍💻 Author
Developed by Sharon Galela — a passionate developer with experience in Java, Swing, and creative projects like Moodifyx 🎶
