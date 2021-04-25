package cs5004.animator.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Map;

/**
 *
 */
public class ButtonListener implements ActionListener {
  private Map<String, Runnable> buttonevents;
  private File savefile;
  private File uploadfile;
  
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

  /**
   *
   * @param e
   */
  @Override
  public void actionPerformed(ActionEvent e) {
    if (buttonevents.containsKey(e.getActionCommand())) {
      buttonevents.get(e.getActionCommand()).run();
    }
  
  }

  /**
   *
   * @return
   */
  public File getSaveFile() {
    return savefile;
  }

  /**
   *
   * @return
   */
  public File getUploadFile() {
    return uploadfile;
  }
  
}
