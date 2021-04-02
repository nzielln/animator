import java.util.Objects;

public class Rectangle extends AbstractShape {
  final String type;
  
  public Rectangle
          (String name, float pointX, float pointY, int X, int Y, int r, int g, int b) {
    super(name, pointX, pointY, X, Y,  r, g, b);
    this.type = "RECTANGLE";
  }
  
  //GETTERS----------------------------------------------------------------------------------------
  @Override
  public String getType() {
    return this.type;
  
  }
  
  //OTHER------------------------------------------------------------------------------------------
  @Override
  public Shape copy() {
    return new Rectangle(this.name, this.pointX, this.pointY, this.X,
            this.Y, this.color.getR(), this.color.getG(),  this.color.getB());
  }

  @Override
  public boolean equals(Shape other) {
    Objects.requireNonNull(other);
    return super.equals(other) && this.type.equals(other.getType());
  }
  
  @Override
  public String toString() {
    return "Name: " + this.name + "\n"
            + "Type: " + this.type + "\n"
            + "Corner: (" + this.pointX + "," + this.pointY + ")\n"
            + "Width: " + this.X + "\n"
            + "Length: " + this.Y + "\n"
            + "Color: " + this.color.toString() + "\n"
            + "Appears: " + this.appears + "\n"
            + "Disappears: " + this.disappears + "\n";
  }

}
