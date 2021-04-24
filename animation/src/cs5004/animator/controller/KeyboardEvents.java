package cs5004.animator.controller;

import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.Map;

import cs5004.animator.view.KeyboardListener;
import cs5004.animator.view.PlaybackView;

/**
 *
 */
class KeyboardEvents {
  private PlaybackView playbackview;
  
  KeyboardEvents(PlaybackView p) {
    this.playbackview = p;
    
  }

  /**
   *
   */
  public void configureKeyboardListener() {
    Map<Character, Runnable> type = new HashMap<>();
    Map<Integer, Runnable> press = new HashMap<>();
    Map<Integer, Runnable> release = new HashMap<>();
    
    press.put(KeyEvent.VK_UP, new IncreaseSpeedAction());
    press.put(KeyEvent.VK_DOWN, new DecreaseSpeedAction());
    press.put(KeyEvent.VK_LEFT, new RewindAction());
    press.put(KeyEvent.VK_RIGHT, new LoopAction());
    press.put(KeyEvent.VK_SPACE, new PlayPauseAction());
  
    release.put(KeyEvent.VK_UP, new Refocus());
    release.put(KeyEvent.VK_DOWN, new Refocus());
    release.put(KeyEvent.VK_LEFT, new Refocus());
    release.put(KeyEvent.VK_RIGHT, new Refocus());
    release.put(KeyEvent.VK_SPACE, new Refocus());
  
    KeyboardListener kl = new KeyboardListener();
    kl.setPressKeyMaps(press);
    kl.setReleaseKeyMaps(release);
    kl.setTypeKeyMaps(type);
    
    playbackview.addKeyListener(kl);
  }
  
  /**
   * The PausedAction represents the view pausing the animation.
   */
  class PlayPauseAction implements Runnable {
    
    /**
     * This sets the view to pausing the animation.
     */
    @Override
    public void run() {
      if (playbackview.getCurrentState().equals("playing")) {
        playbackview.setState("paused");
        playbackview.setPauseState();
      } else {
        playbackview.setState("playing");
        playbackview.setPlayState();
      }
      
    }
  }
  
  /**
   * The RewindAction represents the view rewinding the animation to the beginning again.
   */
  class RewindAction implements Runnable {
    
    /**
     * Rewinds the animation to the beginning.
     */
    @Override
    public void run() {
      playbackview.setState("rewind");
      playbackview.changeCount(0);
      playbackview.setComponents();
      playbackview.changeRewindBg();
      playbackview.rewindTimer();
      playbackview.setPlayState();
    }
  }
  
  /**
   * LoopAction is a class that sets the view to loop through the animation over and over again.
   */
  class LoopAction implements Runnable {
    
    /**
     * Keeps looping through the animation until the user requests to stop.
     */
    @Override
    public void run() {
      playbackview.setState("loop");
      playbackview.loop();
      playbackview.setComponents();
      playbackview.changeLoopBg();
      playbackview.setLoop();
    }
  }
  
  /**
   * A class that represents an increase speed action.
   */
  class IncreaseSpeedAction implements Runnable {
    
    /**
     * Tells the view to increase the speed.
     */
    @Override
    public void run() {
      playbackview.setState("up speed");
      playbackview.increaseTick();
      playbackview.setComponents();
      playbackview.changeUpBg();
      playbackview.setTick();
    }
  }
  
  /**
   * A class that represents a decrease speed action.
   */
  class DecreaseSpeedAction implements Runnable {
    
    /**
     * Tells the view and model to decrease the speed of the animation.
     */
    @Override
    public void run() {
      playbackview.setState("down speed");
      playbackview.decreaseTick();
      playbackview.setComponents();
      playbackview.changeDownBg();
      playbackview.setTick();
      
    }
  }
  
  /**
   * A class that represents a decrease speed action.
   */
  class Refocus implements Runnable {
    
    /**
     * Tells the view and model to decrease the speed of the animation.
     */
    @Override
    public void run() {
      playbackview.resetFocus();
      
    }
  }
  
  
}
