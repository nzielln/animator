package cs5004.animator.model;

import java.text.DecimalFormat;

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
    o.setProperties(this.x, this.y, this.w, this.h,
            this.color.getR(), this.color.getG(), this.color.getB());
    o.setAppears(this.appears);
    o.setDisappears(this.disappears);
    
    return o;
    
    
  }
  
  @Override
  public String toString() {
    DecimalFormat f = new DecimalFormat("0.0");
  
    return "Name: " + this.name + "\n"
            + "Type: " + this.type + "\n"
            + "Center: (" + f.format(this.x) + "," + f.format(this.y) + "), X radius: "
            + f.format(this.w) + ", Y radius: " + f.format(this.h) + ", Color: "
            + this.color.toString() + "\n"
            + "Appears at t=" + this.appears + "\n"
            + "Disappears at t=" + this.disappears + "\n";
  }
  
  
}
