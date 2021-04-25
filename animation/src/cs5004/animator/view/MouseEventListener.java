package cs5004.animator.view;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import cs5004.animator.controller.Controller;

/**
 * MouseEventListener listens for click events on the PlaybackView and saves the position.
 */
public class MouseEventListener extends MouseAdapter {
  private PlaybackView playbackview;
  private int x;
  private int y;
  private Controller controller;
  
  /**
   * Constructor takes in a PlaybackView that it listens for events on.
   * @param p PlaybackView
   */
  public MouseEventListener(PlaybackView p) {
    this.playbackview = p;
  }
  
  /**
   * Configures the mouse listener for the PlaybackView, sets the controller.
   * @param con Controller, a controller to send information to
   */
  public void configMouseListener(Controller con) {
    playbackview.addMouseClickListener(this);
    this.controller = con;
  }
  
  /**
   * On a mouse click events, the listener will save the x and y coordinates and send thos
   * to the removeShape() method.
   * @param e MouseEvent
   */
  @Override
  public void mouseClicked(MouseEvent e) {
    x = e.getX();
    y = e.getY();
    removeShape();
  }
  
  /**
   * Call the controller's removeShape method and resets the focus of the view.
   */
  public void removeShape() {
    controller.removeShape(x, y);
    playbackview.resetFocus();
  }
  
  /**
   * Returns the most recent MouseEvent's x position.
   * @return int, x position
   */
  public int getX() {
    return x;
  }
  
  /**
   * Returns the most recent MouseEvent's y position.
   * @return int, y position
   */
  public int getY() {
    return y;
  }
}
