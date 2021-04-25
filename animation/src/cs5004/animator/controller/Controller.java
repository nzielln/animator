package cs5004.animator.controller;

import cs5004.animator.view.PlaybackView;
import cs5004.animator.view.View;

/**
 * Controller for the Animation program.
 */
public interface Controller {

  /**
   * Gets the input information and plays the correct animation view type.
   */
  void play();

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
   * Returns the a placback view object.
   * @return (PlaybackView) the playbackview.
   */
  PlaybackView getPlaybackView();
  
  /**
   * Returns the current view.
   * @return (View) the view.
   */
  View getView();
  
  
  
  String getState();
  
}