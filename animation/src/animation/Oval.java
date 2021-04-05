package animation;

import java.util.Objects;

public class Oval extends AbstractShape {
  public Oval(String name, float pointX, float pointY, int X, int Y, int r, int g, int b) {
    super(name, pointX, pointY, X, Y,  r, g, b);
    super.type = "OVAL";
  }
  
  //GETTERS----------------------------------------------------------------------------------------
  @Override
  public String getType() {
    return this.type;
  }
  
  //OTHER------------------------------------------------------------------------------------------
  @Override
  public Shape copy() {
    return new Oval(this.name, this.pointX, this.pointY, this.X,
            this.Y, this.color.getR(), this.color.getG(),  this.color.getB());
  }
  
  @Override
  public String toString() {
    return "Name: " + this.name + "\n"
            + "Type: " + this.type + "\n"
            + "Center: (" + this.pointX + "," + this.pointY + ")\n"
            + "X-Radius: " + this.X + "\n"
            + "Y-Radius: " + this.Y + "\n"
            + "Color: " + this.color.toString() + "\n"
            + "Appears: " + this.appears + "\n"
            + "Disappears: " + this.disappears + "\n";
  }
  
  
}
