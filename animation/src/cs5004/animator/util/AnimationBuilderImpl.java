package cs5004.animator.util;

import java.util.ArrayList;

import cs5004.animator.model.Animation;
import cs5004.animator.model.ChangeColor;
import cs5004.animator.model.Color;
import cs5004.animator.model.Ellipse;
import cs5004.animator.model.Move;
import cs5004.animator.model.Rectangle;
import cs5004.animator.model.Scale;
import cs5004.animator.model.Shape;
import cs5004.animator.model.Transformation;

/**
 * AnimationBuilder class that implements the AnimationBuilder interface.
 */
public class AnimationBuilderImpl implements AnimationBuilder<Animation> {
  private Animation model;
  
  /**
   * AnimationBuilderImpl constructor that takes in a model.
   * @param model Animation, model to build
   */
  public AnimationBuilderImpl(Animation model) {
    this.model = model;
  }
  
  @Override
  public Animation build() {
    return model;
  }
  
  @Override
  public AnimationBuilder<Animation> setBounds(int x, int y, int width, int height) {
    model.canvas(x, y, width, height);
    
    return null;
  }
  
  @Override
  public AnimationBuilder<Animation> declareShape(String name, String type) {
    Shape s;
    if (type.equalsIgnoreCase("Ellipse")) {
      s = new Ellipse(name, type);
    } else {
      s = new Rectangle(name, type);
    }
    model.addShape(s, new ArrayList<>());
    
    
    return null;
  }
  
  @Override
  public AnimationBuilder<Animation> addMotion(String name, int t1, int x1, int y1, int w1, int h1,
                                               int r1, int g1, int b1, int t2, int x2, int y2,
                                               int w2, int h2, int r2, int g2, int b2) {
    for (Shape s: model.getShapes()) {
      if (s.getName().equals(name)) {
        Shape start;
        Shape end;
        if (s.getType().equalsIgnoreCase("ELLIPSE")) {
          start = new Ellipse(s.getName(), s.getType());
          end = new Ellipse(s.getName(), s.getType());
          
        } else {
          start = new Rectangle(s.getName(), s.getType());
          end = new Rectangle(s.getName(), s.getType());
        }
        createShape(t1, x1, y1, w1, h1, r1, g1, b1, t2, x2, y2, w2, h2, r2, g2, b2, start, end);
        if (!s.getCreated()) {
          s.setProperties(x1, y1, w1, h1, r1, g1, b1);
          s.setAppearsDisappears(t1, t2);
        }
        s.setAppearsDisappears(s.getAppears(), t2);
        createMotion(name, t1, x1, y1, w1, h1, r1, g1, b1, t2, x2, y2, w2, h2, r2, g2, b2);
      }
    }
    return null;
  }

  /**
   * Creates a transformation and adds it to the model.
   * @param name (String) the name of the transformation
   * @param t1 (int) the initial start/appears time
   * @param x1 (int) the initial x-coordinate
   * @param y1 (int) the initial y-coordinate
   * @param w1 (int) the initial width
   * @param h1 (int) the initial height
   * @param r1 (int) the initial R-value
   * @param g1 (int) the initial G-value
   * @param b1 (int) the inital B-value
   * @param t2 (int) the final end/disappears time
   * @param x2 (int) the end x-coordinate
   * @param y2 (int) the end y-coordinate
   * @param w2 (int) the end width
   * @param h2 (int) the end height
   * @param r2 (int) the end R-value
   * @param g2 (int) the end G-value
   * @param b2 (int) the end B-value
   */
  private void createMotion(String name, int t1, int x1, int y1, int w1, int h1, int r1, int g1,
                            int b1, int t2, int x2, int y2, int w2, int h2, int r2, int g2,
                            int b2) {
    int transformation = 3;
    boolean m = false;
    boolean sc = false;
    boolean c = false;
    String type = "";
    for (Shape s: model.getShapes()) {
      if (s.getName().equals(name)) {
        type = s.getType();
      }
    }
    
    while (transformation > 0) {
      if (!m && (x1 != x2 || y1 != y2)) {
        Transformation move = new Move( x2, y2, t1, t2);
        move.setInitial(name, type, x1, y1, w1, h1, r1, g1, b1);
        move.setFinal(name, type, x2, y2, w2, h2, r2, g2, b2);
        model.addTransformation(name, move);
        m = true;
    
      } else if (!sc && (w1 != w2 || h1 != h2)) {
        Transformation scale = new Scale( w2, h2, t1, t2);
        scale.setInitial(name, type, x1, y1, w1, h1, r1, g1, b1);
        scale.setFinal(name, type, x2, y2, w2, h2, r2, g2, b2);
        model.addTransformation(name, scale);
        sc = true;
    
      } else if (!c && (!new Color(r1, g1, b1).sameObject(new Color(r2, g2, b2)))) {
        Transformation color = new ChangeColor( new Color(r2, g2, b2), t1, t2);
        color.setInitial(name, type, x1, y1, w1, h1, r1, g1, b1);
        color.setFinal(name, type, x2, y2, w2, h2, r2, g2, b2);
        model.addTransformation(name, color);
        c = true;
      }
      transformation -= 1;
    }
  }

  /**
   * Sets the initial and ending properties for the initial and end shapes.
   * @param t1 (int) the initial/appears time
   * @param x1 (int) the initial x-coordinate position
   * @param y1 (int) the initial y-coordinate position
   * @param w1 (int) the initial width
   * @param h1 (int) the initial height
   * @param r1 (int) the initial R-value
   * @param g1 (int) the initial G-value
   * @param b1 (int) the initial B-value
   * @param t2 (int) the end/disappears time
   * @param x2 (int) the end x-coordinate position
   * @param y2 (int) the end y-coordinate position
   * @param w2 (int) the end width
   * @param h2 (int) the end height
   * @param r2 (int) the end R-value
   * @param g2 (int) the end G-value
   * @param b2 (int) the end B-value
   * @param start (Shape) the starting Shape
   * @param end (Shape) the ending Shape
   */
  private void createShape(int t1, int x1, int y1, int w1, int h1, int r1, int g1, int b1,
                           int t2, int x2, int y2, int w2, int h2, int r2, int g2, int b2,
                           Shape start, Shape end) {
    start.setProperties(x1, y1, w1, h1, r1, g1, b1);
    start.setAppearsDisappears(t1, t2);
   
    end.setProperties(x2, y2, w2, h2, r2, g2, b2);
    end.setAppearsDisappears(t1, t2);
  }
}
