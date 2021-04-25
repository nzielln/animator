package cs5004.animator.view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

import cs5004.animator.model.AnimationImpl;
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
  private javax.swing.Timer swingtimer;
  private int count;
  private int length;
  private Animation model;
  private int tick;
  
  /**
   * Constructor for a GraphicView, takes in no arguments.
   */
  public GraphicView() {
    super("Animation");
    this.view = "Visual";
    this.model = new AnimationImpl();
    this.length = 0;
    this.count = 0;
    this.tick = 0;
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
  public void animate(Animation m, HashMap<String, String> in) {
    this.tick = Integer.parseInt(in.get("speed"));
    swingtimer = new javax.swing.Timer(1000 / tick, new AnimateAction());
    swingtimer.setInitialDelay(1000);
    swingtimer.start();
  }
  
  private class AnimateAction implements ActionListener {
    
    @Override
    public void actionPerformed(ActionEvent e) {
      if (count > length) {
        count = length;
      }
      
      List<Shape> modified = model.getByTime(count);
      currentView(modified);
      count += 1;
    }
  }
  
  @Override
  public void buildModel(Animation m) {
    this.length = m.getAnimationLength();
    this.model = m;
    
    setSize(m.getCanvasWidth(),
            m.getCanvasHeight());
    
    setLocation(m.getCanvasX(),
            m.getCanvasY());
    
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLayout(new BorderLayout());
    setVisible(true);
    
    this.panel = new GraphicsPanel(m.getByTime(0), m);
    this.panel.setPreferredSize(new Dimension(m.getCanvasWidth(),
            m.getCanvasHeight()));
    this.panel.setLocation(m.getCanvasX(), m.getCanvasY());
    
    add(panel, BorderLayout.CENTER);
    
    JScrollPane scroll = new JScrollPane(this.panel);
    setPreferredSize(new Dimension(m.getCanvasWidth(), m.getCanvasHeight() ));
    add(scroll, BorderLayout.CENTER);
  
    pack();
    setVisible(true);
    panel.setVisible(true);
    
    
  }
  
  @Override
  public void exitView() {
    System.exit(0);
  }
  
}
