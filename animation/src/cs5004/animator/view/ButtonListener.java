package cs5004.animator.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

/**
 *
 */
public class ButtonListener implements ActionListener {
  private Map<String, Runnable> buttonevents;
  
  /**
   *
   */
  public ButtonListener() {
    buttonevents = null;
  }
  
  /**
   *
   * @param map
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
