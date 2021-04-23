package cs5004.animator.view;


import cs5004.animator.model.Animation;

/**
 * An interface for a Playback View object.
 */
public interface Playback {
  //ASSIGNMENT 8

  /**
   * Makes the frame for the Playback View.
   */
  void makeFrame(/*int x, int y, int w, int h*/);

  /**
   * Animates the animation for the Playback View.
   */
  void animate();
}
