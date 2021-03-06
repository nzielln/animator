package cs5004.animator.model;

import java.text.DecimalFormat;
import java.util.Objects;

/**
 * Represents a class that stored the RGB values for a color.
 */
public class Color {
  private final int r;
  private final int g;
  private final int b;
  
  /**
   * Creates a new Color object, takes in int values for RGB.
   * @param r (int) value for red
   * @param g (int) value for green
   * @param b (int) value for blue
   */
  public Color(int r, int g, int b) {
    if (r < 0 || g < 0 || b < 0
            || r > 255 || g > 255 || b > 255) {
      throw new IllegalArgumentException("RGB values must be between 0 - 255");
    }
    this.r = r;
    this.g = g;
    this.b = b;
  }
  
  //GETTERS----------------------------------------------------------------------------------------
  
  /**
   * Returns the R(red) value of the Color object.
   * @return (int) value for r
   */
  public int getR() {
    return this.r;
  }
  
  /**
   * Returns the G(green) value of the Color object.
   * @return (int) value for g
   */
  public int getG() {
    return this.g;
  }
  
  /**
   * Returns the B(blue) value of the Color object.
   * @return (int) value for b
   */
  public int getB() {
    return this.b;
  }
  
  /**
   * Returns the Color object.
   * @return (Color) a color object.
   */
  public Color getColor() {
    return this;
  }
  
  //OTHER------------------------------------------------------------------------------------------
  
  /**
   * Determines whether two Color objects are equal.
   * @param other (Color) color object
   * @return true if the two objects are identical
   */
  public boolean sameObject(Color other) {
    Objects.requireNonNull(other, "Color can't be null");
    return (this.r == other.r && this.b == other.b && this.g == other.g);
  }
  
  /**
   * Returns a string representation of the Color object.
   * @return (String) representation of the object.
   */
  @Override
  public String toString() {
    DecimalFormat f = new DecimalFormat("0.0");
  
    return "(" + f.format(this.r) + ", " + f.format(this.g) + ", " + f.format(this.b) + ")";
  }
}
