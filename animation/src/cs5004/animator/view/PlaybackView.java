package cs5004.animator.view;

import java.awt.*;
import java.util.List;

import javax.swing.JFrame;

import cs5004.animator.model.Animation;
import cs5004.animator.model.Shape;

/**
 * A PlaybackView class that extends JFrame and implements the Playback interface.
 */
public class PlaybackView extends JFrame implements Playback {
  private JFrame frame;
  private String view;
  //ASSIGNMENT 8
  
  /**
   *
   */
  public PlaybackView(GraphicView graphic) {
    super("Animation");
    this.view = "Playback";
    this.frame = graphic;
  }
  
  @Override
  public void makeFrame() {
    setSize(1000, 1000);
    setLocation(0, 0);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLayout(new BorderLayout());
    setVisible(true);
  
    add(frame, BorderLayout.CENTER);
    frame.setVisible(true);
    
  }
  
  
  
}
