package cs5004.animator.view;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import java.util.List;
import java.util.Objects;

import javax.swing.JPanel;

import javax.swing.border.LineBorder;

import cs5004.animator.model.Animation;
import cs5004.animator.model.Shape;

/**
 * A JFrame components that extends JPanel, used to render animation in the JFrame.
 */
public class GraphicsPanel extends JPanel {
  private List<Shape> shapes;
  
  /**
   * Graphic Panel constructor that takes in a list of shapes passed from GraphicView and the model.
   * @param shapes, list, a list of shapes passed from the GraphicView
   * @param model, Animation, the animation model.
   */
  public GraphicsPanel(List<Shape> shapes, Animation model) {
    super(true);

    Objects.requireNonNull(model, "Model can't be null");
  
    this.shapes = shapes;
    setBackground(Color.WHITE);
    setLayout(new BorderLayout());
    setBorder(new LineBorder(Color.BLACK, 3));
  
  }
  
  /**
   * Updates the model to list of shapes received from the model's getByTime method.
   * @param shapes, list, a list of shape objects.
   */
  public void updateModel(List<Shape> shapes) {
    Objects.requireNonNull(shapes, "Model can't be null");
    this.shapes = shapes;
  }
  
  @Override
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
  
    Objects.requireNonNull(g, "Graphics object can't be null");
  
    Graphics2D graphics = (Graphics2D) g;
  
    if (this.shapes == null) {
      return;
    }
  
    int count = 0;
    for (Shape s: shapes) {
      if (s.getType().equals("RECTANGLE")) {
        Color c = new Color(s.getColor().getR(), s.getColor().getG(), s.getColor().getB());
        graphics.setColor(c);
        graphics.drawRect(s.getPositionX(), s.getPositionY(), s.getWidth(), s.getHeight());
        graphics.fillRect(s.getPositionX(), s.getPositionY(), s.getWidth(), s.getHeight());
      } else if (s.getType().equals("ELLIPSE")) {
        Color c = new Color(s.getColor().getR(), s.getColor().getG(), s.getColor().getB());
        graphics.setColor(c);
        graphics.drawOval(s.getPositionX(), s.getPositionY(), s.getWidth(), s.getHeight());
        graphics.fillOval(s.getPositionX(), s.getPositionY(), s.getWidth(), s.getHeight());
      }
    }
  }
}

