import java.awt.*;
import java.util.List;

public class AbstractTransformation implements Transformation {
  private ShapeNode shape;
  
  public AbstractTransformation(ShapeNode s) {
    this.shape = s;
  }
  
  
  @Override
  public ShapeNode getShape() {
    return this.shape;
  }
  
  @Override
  public void changePosition(ShapeNode s, float positionX, float positionY) {
  
  }
  
  @Override
  public void changeColor(ShapeNode s, Color C) {
  
  }
  
  @Override
  public void changeSize(ShapeNode s, int X, int Y) {
  
  }
  
  @Override
  public void addTransformation(ShapeNode s, List<ShapeNode> l) {
  
  }
  
  @Override
  public void removeTransformation(ShapeNode s, List<ShapeNode> l) {
  
  }
}
