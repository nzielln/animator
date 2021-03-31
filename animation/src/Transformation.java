import java.util.List;

public interface Transformation {
  ShapeNode getShape();
  
  ShapeNode moveShape(float toX, float toY, int timeStart, int timeEnd);
  
  ShapeNode changeColor(Color toColor, int timeStart, int timeEnd);
  
  ShapeNode scaleShape(float toX, float toY, int timeStart, int timeEnd);
  
  void addTransformation(ShapeNode s, List<ShapeNode> l);
  
  void removeTransformation(ShapeNode s, List<ShapeNode> l);
  
}
