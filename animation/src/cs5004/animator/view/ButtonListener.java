package cs5004.animator.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

/**
 *
 */
public class ButtonListener implements ActionListener {
  private Map<String, Runnable> buttonEvents;

  /**
   *
   */
  public ButtonListener() {
    buttonEvents = null;
  }

  /**
   *
   * @param map
   */
  public void setButtonClickedActionMap(Map<String, Runnable> map) {
    buttonEvents = map;
  }

  /**
   *
   * @param e
   */
  @Override
  public void actionPerformed(ActionEvent e) {
    if (buttonEvents.containsKey(e.getActionCommand())) {
      buttonEvents.get(e.getActionCommand()).run();
    }
  
  }
}
