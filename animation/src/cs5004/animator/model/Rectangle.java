package cs5004.animator.model;

import java.text.DecimalFormat;

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
    r.setProperties(this.x, this.y, this.w, this.h,
            this.color.getR(), this.color.getG(), this.color.getB());
    r.setAppears(this.appears);
    r.setDisappears(this.disappears);
    
    return r;
    
    
  }
  
  @Override
  public String toString() {
    DecimalFormat f = new DecimalFormat("0.0");
    return "Name: " + this.name + "\n"
            + "Type: " + this.type + "\n"
            + "Min corner: (" + f.format(this.x) + "," + f.format(this.y) + "), Width: "
            + f.format(this.w) + ", Length: " + f.format(this.h) + ", Color: "
            + this.color.toString() + "\n"
            + "Appears at t=" + this.appears + "\n"
            + "Disappears at t=" + this.disappears + "\n";
  }

}
