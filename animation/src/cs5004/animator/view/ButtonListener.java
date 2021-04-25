package cs5004.animator.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

/**
 * ButtonListener class listen for button events on the PlaybackView.
 */
public class ButtonListener implements ActionListener {
  private Map<String, Runnable> buttonevents;
  
  /**
   * Initializes buttonsevents map.
   */
  public ButtonListener() {
    buttonevents = null;
  }
  
  /**
   * Sets the map of button events and runnable to call from when an event is triggered.
   * @param map Hashmap of commands and runnable
   */
  public void setButtonClickedActionMap(Map<String, Runnable> map) {
    buttonevents = map;
  }
  
  @Override
  public void actionPerformed(ActionEvent e) {
    if (buttonevents.containsKey(e.getActionCommand())) {
      buttonevents.get(e.getActionCommand()).run();
    }
  
  }
  
  
}
