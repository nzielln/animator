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
  private JScrollPane scroll;
  private int count;
  private int length;
  private Animation model;
  private int tick;
  
  /**
   * Constructor for a GraphicView, takes in no arguments. Inherits the title of the animation and
   * sets the initial values for the count and tick, while also holding reference to a new
   * AnimationImpl.
   */
  public GraphicView() {
    super("Animation");
    this.view = "Visual";
    this.model = new AnimationImpl();
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

  /**
   * Updates the animation based upon the the action
   */
  private class AnimateAction implements ActionListener {

    /**
     *
     * @param e (ActionEvent) the action that the user selected
     */
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
  
    int x = m.getCanvasX();
    int y = m.getCanvasY();
    int w = m.getCanvasWidth();
    int h = m.getCanvasHeight();
  
    setSize(w, h);
    setLocation(x, y);
  
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLayout(new BorderLayout());
    
  
    panel = new GraphicsPanel(m.getByTime(0), model);
    panel.setPreferredSize(new Dimension(w, h));
    panel.setLocation(x,y);
  
    add(panel, BorderLayout.CENTER);
  
    scroll = new JScrollPane(panel);
    setPreferredSize(new Dimension(w, h));
    add(scroll, BorderLayout.CENTER);
  
    panel.setVisible(true);
    scroll.setVisible(true);
    setVisible(true);
    
    
  }
  
  @Override
  public void exitView() {
    System.exit(0);
  }
  
}
