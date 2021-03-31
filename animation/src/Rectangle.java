public class Rectangle extends AbstractShape {
  private final String type;
  
  public Rectangle
          (String name, float pointX, float pointY, float X, float Y, int r, int g, int b) {
    super(name, pointX, pointY, X, Y,  r, g, b);
    this.type = "RECTANGLE";
  }
  
  @Override
  public String getType() {
    return this.type;
  
  }
  
  @Override
  public String toString() {
    return "Name: " + this.getName() + "\n"
            + "Type: " + this.type + "\n"
            + "Corner: (" + this.getPositionX() + "," + this.getPositionY() + ")\n"
            + "Width: " + this.getX() + "\n"
            + "Length: " + this.getY() + "\n"
            + "Color: " + this.getColor() + "\n"
            + "Appears: " + this.getAppears() + "\n"
            + "Disappears: " + this.getDisappears() + "\n";
  }

}
