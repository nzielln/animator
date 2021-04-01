public class Oval extends AbstractShape {
  private final String type;
  
  public Oval(String name, float pointX, float pointY, float X, float Y, int r, int g, int b) {
    super(name, pointX, pointY, X, Y,  r, g, b);
    this.type = "OVAL";
  }
  
  //GETTERS----------------------------------------------------------------------------------------
  @Override
  public String getType() {
    return this.type;
  }
  
  //OTHER------------------------------------------------------------------------------------------
  @Override
  public Shape copy() {
    return new Oval(this.getName(), this.getPositionX(), this.getPositionY(), this.getX(),
            this.getY(), this.getColor().getR(), this.getColor().getG(),  this.getColor().getB());
  }
  
  @Override
  public String toString() {
    return "Name: " + this.getName() + "\n"
            + "Type: " + this.type + "\n"
            + "Center: (" + this.getPositionX() + "," + this.getPositionY() + ")\n"
            + "X-Radius: " + this.getX() + "\n"
            + "Y-Radius: " + this.getY() + "\n"
            + "Color: " + this.getColor() + "\n"
            + "Appears: " + this.getAppears() + "\n"
            + "Disappears: " + this.getDisappears() + "\n";
  }
  
  
}
