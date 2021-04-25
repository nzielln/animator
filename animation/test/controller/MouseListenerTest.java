package controller;

import org.junit.Before;
import org.junit.Test;

import java.awt.event.MouseEvent;

import cs5004.animator.controller.Controller;
import cs5004.animator.controller.ViewController;
import cs5004.animator.view.MouseEventListener;
import cs5004.animator.view.PlaybackView;

import static org.junit.Assert.assertEquals;

/**
 * Class to test mouseclick events in the PlaybackView.
 */
public class MouseListenerTest {
  Controller controller;
  PlaybackView p = new PlaybackView();
  private MouseEventListener ml;
  
  @Before
  public void setUp() {
    String in = "-in ./resources/files/smalldemo.txt -view playback -speed 20";
    controller = new ViewController(in);
    controller.play();
    p = controller.getPlaybackView();
    ml = new MouseEventListener(p);
    ml.configMouseListener(controller);
    p.addMouseListener(ml);
  
  }
  
  @Test
  public void clickEventTest() {
    ml.mouseClicked(new MouseEvent(p, 1, 0, 0, 234, 123,
            1, false));
    
    assertEquals(234, ml.getX());
    assertEquals(123, ml.getY());
    assertEquals("Removing shape....", controller.getState());
  }
  
}