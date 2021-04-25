package cs5004.animator.view;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Map;

/**
 * KeyboardListener class listens for keyboard events on the PlaybackView.
 */
public class KeyboardListener implements KeyListener {
  private Map<Character, Runnable> type;
  private Map<Integer, Runnable> press;
  private Map<Integer, Runnable> release;

  /**
   * Constructor initilizes maps of runnable for each type of event to null.
   */
  public KeyboardListener(){
    type = null;
    release = null;
    press = null;
  }

  /**
   * Sets the map of runnables for the type map.
   * @param map HashMap of type events and their corresnponding runnable.
   */
  public void setTypeKeyMaps(Map<Character, Runnable> map) {
    type = map;
  }
  
  /**
   * Sets the map of runnables for the pressed map.
   * @param map HashMap of pressed events and their corresnponding runnable.
   */
  public void setPressKeyMaps(Map<Integer, Runnable> map) {
    press = map;
  }

  /**
   * Sets the map of runnables for the release map.
   * @param map HashMap of release events and their corresnponding runnable.
   */
  public void setReleaseKeyMaps(Map<Integer, Runnable> map) {
    release = map;
  }
  
  /**
   * Runs runnable from type map when an type keyboard event is triggered.
   */
  @Override
  public void keyTyped(KeyEvent e) {
    if (type.containsKey(e.getKeyChar())) {
      type.get(e.getKeyChar()).run();
    }
  
  }
  
  /**
   * Runs runnable from press map when an type keyboard event is triggered.
   */
  @Override
  public void keyPressed(KeyEvent e) {
    if (press.containsKey(e.getKeyCode())) {
      press.get(e.getKeyCode()).run();
    }
  
  }
  
  /**
   * Runs runnable from release map when an type keyboard event is triggered.
   */
  @Override
  public void keyReleased(KeyEvent e) {
    if (release.containsKey(e.getKeyCode())) {
      release.get(e.getKeyCode()).run();
    }
  
  }
  
  
}
