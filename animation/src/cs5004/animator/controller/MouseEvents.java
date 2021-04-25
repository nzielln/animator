package cs5004.animator.controller;

import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.Map;

import cs5004.animator.view.MouseEventListener;
import cs5004.animator.view.PlaybackView;

class MouseEvents {
  private final PlaybackView playbackview;
  private Controller controller;
  private int x;
  private int y;
  MouseEventListener ml = new MouseEventListener();
  
  MouseEvents(PlaybackView p) {
    this.playbackview = p;
  }
  
  
  /**
   * The configButtonListener creates new button listeners for the play/pause, rewind, loop, and
   * up and down speed functionality.
   */
  public void configMouseListener() {
    Map<Integer, Runnable> pressed = new HashMap<>();
    Map<Integer, Runnable> entered = new HashMap<>();
    Map<Integer, Runnable> exited = new HashMap<>();
    Map<Integer, Runnable> released = new HashMap<>();
    Map<Integer, Runnable> click = new HashMap<>();
    
    click.put(MouseEvent.BUTTON1, new RemoveShape());
    pressed.put(MouseEvent.BUTTON1, new RemoveShape());
    
    ml.setMouseclick(click);
    ml.setMouseentered(entered);
    ml.setMouseexited(exited);
    ml.setMousereleased(released);
    ml.setMousepressed(pressed);
    playbackview.addMouseListener(ml);
  
  }
  
  /**
   * A class that represents a decrease speed action.
   */
  class RemoveShape implements Runnable {
    
    /**
     * Tells the view and model to decrease the speed of the animation.
     */
    @Override
    public void run() {
      System.out.println("MOUSE WAS CLICKED");
      
    }
  }
  
  
}
