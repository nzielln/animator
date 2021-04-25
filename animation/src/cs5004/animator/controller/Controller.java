package cs5004.animator.controller;

import java.util.HashMap;
import cs5004.animator.model.Animation;
import cs5004.animator.view.View;

/**
 * Controller for the Animation program.
 */
public interface Controller {

  /**
   * Gets the input information and plays the correct animation view type.
   */
  void go();

  /**
   * Exits the current view.
   */
  void exit();
  
  /**
   * Removes a shape at the given x and y positions from the current model.
   * @param x int, x position of shape to remove
   * @param y int, y position of shape to remove
   */
  void removeShape(int x, int y);
  

  /**
   * Returns the current view.
   * @return (View) the view.
   */
  View getView();
  
  /**
   * Creates and plays the playback view model, configures listeners for button, keyboard and mouse
   * events.
   * @param in HashMap of CLI input string
   * @param m Animation, the model for the animation
   */
  void playback(HashMap<String, String> in, Animation m);

}