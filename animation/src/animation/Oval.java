package animation;

/**
 * Represents a Oval shape, extends methods from the AbstractShape.
 */
public class Oval extends AbstractShape {
  
  /**
   * Constructor a shape, calls AbstractShape super that takes in parameter to create a shape.
   * @param name unique id/name for the shape
   * @param type
   */
  public Oval(String name, String type) {
    super(name, type);
  }
  
  //OTHER------------------------------------------------------------------------------------------
  @Override
  public Shape copy() {
    if (!this.getCreated()) {
      return null;
    }
    
    Oval o = new Oval(this.name, this.type);
    o.setColor(this.color.getR(), this.color.getG(), this.color.getB());
    o.setPositionX(this.pointX);
    o.setPositionY(this.pointY);
    o.setX(this.x);
    o.setY(this.y);
    o.setAppears(this.appears);
    o.setDisappears(this.disappears);
    
    return o;
    
    
  }
  
  @Override
  public String toString() {
    return "Name: " + this.name + "\n"
            + "Type: " + this.type + "\n"
            + "Center: (" + this.pointX + "," + this.pointY + "), X radius: " + this.x
            + ", Y radius: " + this.y + ", Color: " + this.color.toString() + "\n"
            + "Appears at t=" + this.appears + "\n"
            + "Disappears at t=" + this.disappears + "\n";
  }
  
  
}
