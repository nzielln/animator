package cs5004.animator.view;

import java.awt.event.MouseEvent;
import java.util.Map;

/**
 *
 */
public class MouseListener implements java.awt.event.MouseListener {
  private Map<String, Runnable> mouseevents;

  /**
   *
   */
  public MouseListener() {
    mouseevents = null;
  }

  /**
   *
   * @param map
   */
  public void setButtonClickedActionMap(Map<String, Runnable> map) {
    mouseevents = map;
  }

  /**
   *
   * @param e
   */
  @Override
  public void mouseClicked(MouseEvent e) {
  
  
  }

  /**
   *
   * @param
   */
  @Override
  public void mousePressed(MouseEvent e) {
  
  }

  /**
   *
   * @param e
   */
  @Override
  public void mouseReleased(MouseEvent e) {
  
  }

  /**
   *
   * @param e
   */
  @Override
  public void mouseEntered(MouseEvent e) {
  
  }

  /**
   *
   * @param e
   */
  @Override
  public void mouseExited(MouseEvent e) {
  
  }
}
