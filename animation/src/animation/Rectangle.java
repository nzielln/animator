package animation;

/**
 * Represents a Rectangle shape, extends methods from the AbstractShape.
 */
public class Rectangle extends AbstractShape {
  
  /**
   * Constructor a shape, calls AbstractShape super that takes in parameter tr create a shape.
   * @param name unique id/name for the shape
   * @param type
   */
  public Rectangle(String name, String type) {
    super(name, type);
  }
  
  //OTHER------------------------------------------------------------------------------------------
  @Override
  public Shape copy() {
    if (!this.getCreated()) {
      return null;
    }
    
    Rectangle r = new Rectangle(this.name, this.type);
    r.setColor(this.color.getR(), this.color.getG(), this.color.getB());
    r.setPositionX(this.pointX);
    r.setPositionY(this.pointY);
    r.setX(this.x);
    r.setY(this.y);
    r.setAppears(this.appears);
    r.setDisappears(this.disappears);
    
    return r;
    
    
  }
  
  @Override
  public String toString() {
    return "Name: " + this.name + "\n"
            + "Type: " + this.type + "\n"
            + "Min corner: (" + this.pointX + "," + this.pointY + "), Width: " + this.x
            + ", Length: " + this.y + ", Color: " + this.color.toString() + "\n"
            + "Appears at t=" + this.appears + "\n"
            + "Disappears at t=" + this.disappears + "\n";
  }

}
