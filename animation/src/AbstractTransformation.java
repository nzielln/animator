import java.util.List;

public abstract class AbstractTransformation implements Transformation {
  private ShapeNode shape;
  
  public AbstractTransformation(ShapeNode s) {
    this.shape = s;
  }
  
  
  @Override
  public ShapeNode getShape() {
    return this.shape;
  }
  
  @Override
  public ShapeNode moveShape(float toX, float toY, int timeStart, int timeEnd) {
    return null;
  }
  
  @Override
  public ShapeNode changeColor(Color toColor, int timeStart, int timeEnd) {
    return null;
  }
  
  @Override
  public ShapeNode scaleShape(float toX, float toY, int timeStart, int timeEnd) {
    return null;
  }
  
  @Override
  public void addTransformation(ShapeNode s, List<ShapeNode> l) {
  
  }
  
  @Override
  public void removeTransformation(ShapeNode s, List<ShapeNode> l) {
  
  }
}
