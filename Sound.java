
package mypacman;
import javax.sound.sampled.*;
import java.io.File;

public class Sound {
  private Clip clip;

  public Sound(String audioFile) {
    try {
      // Load the audio file
      File file = new File(audioFile);
      AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);

      // Get the audio format and create a clip
      AudioFormat format = audioStream.getFormat();
      DataLine.Info info = new DataLine.Info(Clip.class, format);
      clip = (Clip)AudioSystem.getLine(info);

      // Open the audio stream and start playing the clip
      clip.open(audioStream);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
 
  public void play() {
    clip.start();
  }

  public void stop() {
    clip.stop();
  }

  public void loop() {
    clip.loop(Clip.LOOP_CONTINUOUSLY);
  }
  
}


