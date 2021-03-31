import java.util.List;

public interface Transformation {
  Shape getShape();
  
  Shape moveShape(float toX, float toY, int timeStart, int timeEnd);
  
  Shape changeColor(Color toColor, int timeStart, int timeEnd);
  
  Shape scaleShape(float toX, float toY, int timeStart, int timeEnd);
  
  String toString();
  
}
