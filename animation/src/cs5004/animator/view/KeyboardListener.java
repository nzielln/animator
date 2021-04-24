package cs5004.animator.view;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Map;

public class KeyboardListener implements KeyListener {
  private Map<Character, Runnable> type;
  private Map<Integer, Runnable> press;
  private Map<Integer, Runnable> release;
  
  public KeyboardListener(){
    type = null;
    release = null;
    press = null;
  }
  
  public void setTypeKeyMaps(Map<Character, Runnable> map) {
    type = map;
  }
  
  public void setPressKeyMaps(Map<Integer, Runnable> map) {
    press = map;
  }
  
  public void setReleaseKeyMaps(Map<Integer, Runnable> map) {
    release = map;
  }
  
  
  @Override
  public void keyTyped(KeyEvent e) {
    if (type.containsKey(e.getKeyChar())) {
      type.get(e.getKeyChar()).run();
    }
  
  }
  
  @Override
  public void keyPressed(KeyEvent e) {
    if (press.containsKey(e.getKeyCode())) {
      press.get(e.getKeyCode()).run();
    }
  
  }
  
  @Override
  public void keyReleased(KeyEvent e) {
    if (release.containsKey(e.getKeyCode())) {
      release.get(e.getKeyCode()).run();
    }
  
  }
  
  
}
