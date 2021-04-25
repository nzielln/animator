package cs5004.animator.view;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Map;

/**
 *
 */
public class MouseEventListener implements MouseListener {
  private Map<Integer, Runnable> mouseclick;
  private Map<Integer, Runnable> mouseentered;
  private Map<Integer, Runnable> mouseexited;
  private Map<Integer, Runnable> mousepressed;
  private Map<Integer, Runnable> mousereleased;
  private int x;
  private int y;
  

  /**
   *
   */
  public MouseEventListener() {
    mouseclick = null;
    mouseentered = null;
    mousepressed = null;
    mouseexited = null;
    mousereleased = null;
  }

  /**
   *
   * @param map
   */
  public void setMouseclick(Map<Integer, Runnable> map) {
    mouseclick = map;
  }
  
  /**
   *
   * @param map
   */
  public void setMouseentered(Map<Integer, Runnable> map) {
    mouseentered = map;
  }
  
  /**
   *
   * @param map
   */
  public void setMouseexited(Map<Integer, Runnable> map) {
    mouseexited = map;
  }
  
  /**
   *
   * @param map
   */
  public void setMousepressed(Map<Integer, Runnable> map) {
    mousepressed = map;
  }
  
  /**
   *
   * @param map
   */
  public void setMousereleased(Map<Integer, Runnable> map) {
    mousereleased = map;
  }

  /**
   * Returns the x-coordinate where the mouse was clicked.
   * @return (int) the x-coordinate
   */
  public int getX() {
    return x;
  }

  /**
   * Returns the y-coordinate where the mouse was clicked.
   * @return (int) the y-coordinate
   */
  public int getY() {
    return y;
  }

  /**
   *
   * @param e
   */
  @Override
  public void mouseClicked(MouseEvent e) {
    if (mouseclick.containsKey(e.getButton())) {
      mouseclick.get(e.getButton()).run();
      System.out.println("MOUSE WAS CLICKED");
      x = e.getX();
      y = e.getY();
    }
  
  }

  /**
   *
   * @param
   */
  @Override
  public void mousePressed(MouseEvent e) {
    if (mousepressed.containsKey(e.getButton())) {
      mousepressed.get(e.getButton()).run();
      System.out.println("MOUSE WAS CLICKED");
      x = e.getX();
      y = e.getY();
    }
  }

  /**
   *
   * @param e
   */
  @Override
  public void mouseReleased(MouseEvent e) {
    if (mousereleased.containsKey(e.getButton())) {
      mousereleased.get(e.getButton()).run();
    }
  }

  /**
   *
   * @param e
   */
  @Override
  public void mouseEntered(MouseEvent e) {
    if (mouseentered.containsKey(e.getButton())) {
      mouseentered.get(e.getButton()).run();
    }
  }

  /**
   *
   * @param e
   */
  @Override
  public void mouseExited(MouseEvent e) {
    if (mouseexited.containsKey(e.getButton())) {
      mouseexited.get(e.getButton()).run();
    }
  }
}
