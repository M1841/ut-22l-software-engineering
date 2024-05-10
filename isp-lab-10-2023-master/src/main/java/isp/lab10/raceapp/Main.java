package isp.lab10.raceapp;

public class Main {
  public static void main(String[] args) {
    Semaphore semaphore = new Semaphore();
    semaphore.window_setup();

    Leaderboard leaderboard = new Leaderboard();
    leaderboard.window_setup();

    CarRace carRace = new CarRace(new String[] { "Red car", "Blue car", "Green car", "Yellow car" }, leaderboard);
    carRace.window_setup();

    PlaySound playSound = new PlaySound();

    semaphore.set_visible();
    try {
      semaphore.start_and_wait();
    } catch (InterruptedException err) {
      System.err.println(err);
    }

    carRace.start();
    playSound.playSound();

    carRace.join();
    playSound.stopSound();
  }
}
