import java.awt.*;

public class Oval extends ShapeAbstract {
  private final String type;
  
  public Oval(String name, Color color, float pointX, float pointY, float X, float Y) {
    super(name, color, pointX, pointY, X, Y);
    this.type = "OVAL";
  }
  
  @Override
  public String getType() {
    return this.type;
  }
  
  public float getRadiusX() {
    return this.getX();
  }
  
  public float getRadiusY() {
    return this.getY();
  }
  

}
