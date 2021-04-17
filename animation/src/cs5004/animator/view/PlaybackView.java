package cs5004.animator.view;

import java.util.List;

import javax.swing.*;
import cs5004.animator.model.*;

public class PlaybackView extends JFrame implements Playback {
  private GraphicView view;
  
  public PlaybackView(List<Shape> m, int w, int h, int x, int y) {
    super("Animation");
    setSize(w, h);
    setLocation(x, y);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLayout(null);
    
    this.view = new GraphicView();
    setVisible(true);
    add(view);
    view.setVisible(true);
  }
}
