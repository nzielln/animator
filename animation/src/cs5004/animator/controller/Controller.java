package cs5004.animator.controller;

import java.util.HashMap;

import cs5004.animator.model.Animation;
import cs5004.animator.view.PlaybackView;
import cs5004.animator.view.View;

/**
 * Controller for the Animation program.
 */
public interface Controller {
  //ASSIGNMENT 8
  /*
  Methods we'll need
  Start
  Play
  Pause
  Rewind/Restart
  
  Enable/Disable looping
  
  Increase/Decrease speed
  Takes in user input/keyboard interact/clicks
  Add new option -playback to CLI commands - should upen editor view
  
   */

  /**
   * Gets the input information and plays the correct animation view type.
   */
  void go();

  /**
   * Exits the current view.
   */
  void exit();
  
  /**
   * Exits the current view.
   */
  void removeShape(int x, int y);
  

  /**
   * Returns the current view.
   * @return (View) the view.
   */
  View getView();
  
  void playback(HashMap<String, String> in, Animation m);

  /**
   * Returns a PlaybackView object.
   * @return the playback view object.
   */
  PlaybackView getPlaybackview();
}