package controller;

import org.junit.Before;
import org.junit.Test;
import java.awt.event.ActionEvent;

import javax.swing.*;

import cs5004.animator.controller.ButtonEvents;
import cs5004.animator.controller.Controller;
import cs5004.animator.controller.ViewController;
import cs5004.animator.view.ButtonListener;
import cs5004.animator.view.PlaybackView;
import static org.junit.Assert.assertEquals;

/**
 * Class to test button clicks/events in the PlaybackView.
 */
public class ButtonsListenerTest {
  Controller controller;
  PlaybackView p = new PlaybackView();
  private JButton b;
  private ButtonListener bl = new ButtonListener();
  private ButtonEvents be;
  
  @Before
  public void setUp() {
    String in = "-in ./resources/files/smalldemo.txt -view playback -speed 20";
    controller = new ViewController(in);
    controller.go();
    p = controller.getPlaybackView();
    be = new ButtonEvents(p);
    be.configButtonListener();
    bl = be.getBs();
    p.addListener(bl);
  
  }
  
  @Test
  public void buttonEvents() {
    bl.actionPerformed(new ActionEvent(p, 0, "pause"));
    assertEquals("paused", p.getCurrentState());
    
    bl.actionPerformed(new ActionEvent(p, 0, "play"));
    assertEquals("playing", p.getCurrentState());
    
    bl.actionPerformed(new ActionEvent(p, 0, "rewind"));
    assertEquals("rewind", p.getCurrentState());
    
    bl.actionPerformed(new ActionEvent(p, 0, "loop"));
    assertEquals("loop", p.getCurrentState());
  
    bl.actionPerformed(new ActionEvent(p, 0, "up speed"));
    assertEquals("up speed", p.getCurrentState());
  
    bl.actionPerformed(new ActionEvent(p, 0, "down speed"));
    assertEquals("down speed", p.getCurrentState());
    
  }
  
}