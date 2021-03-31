import java.util.List;

public interface Transformation {
  ShapeNode getShape();
  void changePosition(ShapeNode s, float positionX, float positionY);
  void changeColor(ShapeNode s, Color C);
  void changeSize(ShapeNode s, int X, int Y);
  
  void addTransformation(ShapeNode s, List<ShapeNode> l);
  
  void removeTransformation(ShapeNode s, List<ShapeNode> l);
  
}
