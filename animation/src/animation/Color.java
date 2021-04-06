package animation;

import java.util.Objects;

/**
 * Represents a class that stored the RGB values for a color.
 */
public class Color {
  private final float r;
  private final float g;
  private final float b;
  
  /**
   * Creates a new Color object, takes in float values for RGB.
   * @param r (int) value for red
   * @param g (int) value for green
   * @param b (int) value for blue
   */
  public Color(float r, float g, float b) {
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
  public float getR() {
    return this.r;
  }
  
  /**
   * Returns the G(green) value of the Color object.
   * @return (int) value for g
   */
  public float getG() {
    return this.g;
  }
  
  /**
   * Returns the B(blue) value of the Color object.
   * @return (int) value for b
   */
  public float getB() {
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
    return "(" + this.r + ", " + this.g + ", " + this.b + ")";
  }
}
