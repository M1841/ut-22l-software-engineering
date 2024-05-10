package isp.lab10.raceapp;

import java.io.File;
import javax.sound.sampled.*;

public class PlaySound {
  private Clip clip;

  void playSound() {
    try {
      this.clip = AudioSystem.getClip();
      this.clip.open(AudioSystem.getAudioInputStream(new File(".\\shanghai-formula-1-grand-prix.wav")));
      this.clip.start();
    } catch (Exception err) {
      System.err.println(err);
    }
  }

  void stopSound() {
    if (this.clip != null)
      this.clip.stop();
  }

  public static void main(String[] args) throws InterruptedException {
    PlaySound ps = new PlaySound();
    ps.playSound();
    Thread.sleep(15000);
    ps.stopSound();
  }
}
