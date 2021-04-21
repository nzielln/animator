package cs5004.animator.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

import cs5004.animator.model.Shape;
import cs5004.animator.model.Animation;

import javax.swing.JFrame;
import javax.swing.JScrollPane;

/**
 * A JFrame for our animations, implements the View interface.
 */
public class GraphicView extends JFrame implements View {
  private GraphicsPanel panel;
  private String view;
  
  /**
   * Constructor for a GraphicView, takes in no arguments.
   */
  public GraphicView() {
    super("Animation");
    this.view = "Visual";
  }
  
  @Override
  public void currentView(List<Shape> m) {
    Objects.requireNonNull(m, "Model can't be null");

    this.panel.updateModel(m);
    this.repaint();
  }
  
  @Override
  public String getViewType() {
    return this.view;
  }
  
  @Override
  public View getView() {
    return this;
  }
  
  @Override
  public void animate(HashMap<String, String> str) {
    throw new UnsupportedOperationException(" ");
    
  }
  
  
  @Override
  public void animateVisual(List<Shape> m) {
  /*
    List<Shape> model = new ArrayList<>(m.getShapes());

    int tick = 1;

    if (in.get("speed") != null) {
      tick = Integer.parseInt(in.get("speed"));
      if (tick <= 0) {
        throw new IllegalArgumentException("Speed needs to be positive integer");
      }
    }
  
    int count = 0;
    int lengthAnimation = 0;
  
    //get the total length of the animation
    for (Shape shape : model) {
      if (shape.getDisappears() > lengthAnimation) {
        lengthAnimation = shape.getDisappears();
      }
    }
  
    //do we get how long the animation is from the user at all? Does this need to be <= or <?
    while (count < lengthAnimation) {
      List<Shape> modified = m.getByTime(count);
    
      //update the animation and model to newModel
      //update count
      this.currentView(modified);
      count += 1;
    
      //Timer to let user see changes
      try {
        Thread.sleep(1000 / tick);
      } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
      }
    }*/
  }

  @Override
  public void buildModel(int x, int y, int w, int h) {
    setSize(w,
            h);
    
    setLocation(x,
           y);
    
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLayout(new BorderLayout());
    setVisible(true);
    
    this.panel = new GraphicsPanel();
    this.panel.setPreferredSize(new Dimension(w,
            h));
    this.panel.setLocation(x, y);
  
    add(panel, BorderLayout.CENTER);
    
    JScrollPane scroll = new JScrollPane(this.panel);
    setPreferredSize(new Dimension(w, h));
    add(scroll, BorderLayout.CENTER);
    
    setVisible(true);
    panel.setVisible(true);
    scroll.setVisible(true);
  
  }

}