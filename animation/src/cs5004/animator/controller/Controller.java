package cs5004.animator.controller;

import cs5004.animator.model.Animation;
import cs5004.animator.view.View;

/**
 * Controller for the Animation program.
 */
public interface Controller {
  //ASSIGNMENT 8
  //JAR: java -jar animation.jar -in smalldemo.txt -view text -out out -speed 2
  /*
  Methods we'll need
  Start
  Play
  Pause
  Rewind/Restart
  
  Enable/Disable looping
  
  Increase/Decrease speed
  Takes in user input/keyboard interfact/clicks
  Add new option -playback to CLI commands - should upen editor view
  
   */
  void callView(String in);
  void go();

}
