package cs5004.animator.controller;

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
   *
   */
  void go();
  void exit();
  
  View getView();
  
  PlaybackView getPlaybackview();
}