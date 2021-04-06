package animation;

/**
 * Represents a Rectangle shape, extends methods from the AbstractShape.
 */
public class Rectangle extends AbstractShape {
  
  /**
   * Constructor a shape, calls AbstractShape super that takes in parameter to create a shape.
   * @param name unique id/name for the shape
   * @param pointX (float) the initial X coordinate position of the shape on a positive plane
   * @param pointY (float)  the initial Y coordinate position of the shape on a positive plane
   * @param x (float) the initial x-radius or width of the shape
   * @param y (float) the initial y-radius or length of the shape
   * @param r (float) the red value of the shape's color
   * @param g (float) the green value of the shape's color
   * @param b (float) the blue value of the shape's color
   */
  public Rectangle(
          String name, float pointX, float pointY, float x, float y, float r, float g, float b) {
    super(name, pointX, pointY, x, y,  r, g, b);
    super.type = "RECTANGLE";
  }
  
  //GETTERS----------------------------------------------------------------------------------------
  @Override
  public String getType() {
    return this.type;
  }
  
  //OTHER------------------------------------------------------------------------------------------
  @Override
  public Shape copy() {
    return new Rectangle(this.name, this.pointX, this.pointY, this.x,
            this.y, this.color.getR(), this.color.getG(),  this.color.getB());
  }
  
  @Override
  public String toString() {
    return "Name: " + this.name + "\n"
            + "Type: " + this.type + "\n"
            + "Corner: (" + this.pointX + "," + this.pointY + ")\n"
            + "Width: " + this.x + "\n"
            + "Length: " + this.y + "\n"
            + "Color: " + this.color.toString() + "\n"
            + "Appears: " + this.appears + "\n"
            + "Disappears: " + this.disappears + "\n";
  }

}
