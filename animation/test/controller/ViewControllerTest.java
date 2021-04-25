package controller;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import cs5004.animator.controller.Controller;
import cs5004.animator.controller.ViewController;
import cs5004.animator.view.PlaybackView;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;

/**
 * This is a test class for the ViewController. It executes the test in ascending order.
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ViewControllerTest {
  private Controller c;
  private Controller pc;

  @Before
  public void setUp() throws Exception {
    String in = "-in ./resources/files/smalldemo.txt -view text -speed 2";
    c = new ViewController(in);
    c.play();
    
  
    String inp = "-in ./resources/files/smalldemo.txt -view playback -speed 15";
    pc = new ViewController(inp);
    pc.play();
    
  }
  
  @Test
  public void getView() {
    
    assertEquals("Text", c.getView().getViewType());
    assertNull(pc.getView());
    
  }
  
  @Test
  public void getState() {
    assertNull(pc.getState());
    
    try {
      pc.removeShape(23, 4);
      assertEquals("Removing shape....", pc.getState());
    } catch (Exception e) {
      fail("Exception should not be thrown");
    }
  }
  
  @Test
  public void getPlaybackView() {
    try {
      PlaybackView p = pc.getPlaybackView();
      p.setPlayState();
      assertEquals("playing", p.getCurrentState());
    } catch (Exception e) {
      fail("Exception should not be thrown");
    }
  }
  
  @Test
  public void removeShape() {
    try {
      c.removeShape(23, 4);
      fail("Exception should be thrown");
    } catch (Exception ignored) {
    }
  
    try {
      pc.removeShape(23, 4);
      
    } catch (Exception e) {
      fail("Exception should not be thrown");
    }
    
  }
  
  @Test
  public void view() {
    try {
      c.getView().exitView();
      fail("Exception should be thrown");
    } catch (Exception ignored) {
    }
    
    try {
      pc.getPlaybackView().exitView();
    } catch (Exception e) {
      fail("Exception should be thrown");
    }
  }
}