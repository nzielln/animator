import java.awt.*;

public class Rectangle extends ShapeAbstract {
  private final String type;
  
  public Rectangle(String name, Color color, float pointX, float pointY, float X, float Y) {
    super(name, color, pointX, pointY, X, Y);
    this.type = "RECTANGLE";
  }
  
  @Override
  public String getType() {
    return this.type;
  }
  
  public float getWidth() {
    return this.getX();
  }
  
  public float getLength() {
    return this.getY();
  }
  
  
  
}
