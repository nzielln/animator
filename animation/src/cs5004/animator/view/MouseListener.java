package cs5004.animator.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.util.Map;

public class MouseListener implements java.awt.event.MouseListener {
  private Map<String, Runnable> mouseevents;
  
  public MouseListener() {
    mouseevents = null;
  }
  
  public void setButtonClickedActionMap(Map<String, Runnable> map) {
    mouseevents = map;
  }
  
  
  @Override
  public void mouseClicked(MouseEvent e) {
  
  
  }
  
  @Override
  public void mousePressed(MouseEvent e) {
  
  }
  
  @Override
  public void mouseReleased(MouseEvent e) {
  
  }
  
  @Override
  public void mouseEntered(MouseEvent e) {
  
  }
  
  @Override
  public void mouseExited(MouseEvent e) {
  
  }
}
