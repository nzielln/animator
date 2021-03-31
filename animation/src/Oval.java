import java.awt.*;

public class Oval extends AbstractShape {
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
  
  @Override
  public String toString() {
    return "Name: " + this.getName() + "\n"
            + "Type: " + this.type + "\n"
            + "Center: (" + this.getPositionX() + "," + this.getPositionY() + ")\n"
            + "X-Radius: " + this.getRadiusX() + "\n"
            + "Y-Radius: " + this.getRadiusY() + "\n"
            + "Color: " + this.getColor() + "\n";
  }
  
  
}
