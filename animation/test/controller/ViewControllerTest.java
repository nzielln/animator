package controller;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import cs5004.animator.controller.Controller;
import cs5004.animator.controller.ViewController;
import cs5004.animator.view.PlaybackView;

import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ViewControllerTest {
  private Controller c;
  private Controller pc;
  private PlaybackView p = new PlaybackView();
  
  @Before
  public void setUp() throws Exception {
    String in = "-in ./resources/files/smalldemo.txt -view text -speed 2";
    c = new ViewController(in);
    c.go();
    
  
    String inp = "-in ./resources/files/smalldemo.txt -view playback -speed 15";
    pc = new ViewController(inp);
    pc.go();
    
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
      p = pc.getPlaybackView();
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
    } catch (Exception ignored) {}
  
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
    } catch (Exception ignored) {}
    
    try {
      pc.getPlaybackView().exitView();
    } catch (Exception e) {
      fail("Exception should be thrown");
    }
  }
}