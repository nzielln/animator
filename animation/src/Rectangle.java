import java.awt.*;

public class Rectangle extends AbstractShape {
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
  
  @Override
  public String toString() {
    return "Name: " + this.getName() + "\n"
            + "Type: " + this.type + "\n"
            + "Corner: (" + this.getPositionX() + "," + this.getPositionY() + ")\n"
            + "Width: " + this.getWidth() + "\n"
            + "Length: " + this.getLength() + "\n"
            + "Color: " + this.getColor() + "\n";
  }

}
