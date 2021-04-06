package animation;

import java.util.Objects;

/**
 * AbstractShape implements the Shape interface, it represents methods common to shapes in the
 * animation.
 */
public abstract class AbstractShape implements Shape {
  final String name;
  final Color color;
  final float pointX;
  final float pointY;
  final int X;
  final int Y;
  int appears;
  int disappears;
  boolean appearsFlag;
  boolean disappearsFlag;
  String type;
  
  /**
   * Constructor a shape, takes in parameter to create a shape.
   * @param name unique id/name for the shape
   * @param pointX (float) the initial X coordinate position of the shape on a positive plane
   * @param pointY (float)  the initial Y coordinate position of the shape on a positive plane
   * @param X (int) the initial x-radius or width of the shape
   * @param Y (int) the initial y-radius or length of the shape
   * @param r (int) the red value of the shape's color
   * @param g (int) the green value of the shape's color
   * @param b (int) the blue value of the shape's color
   * @throws IllegalArgumentException if pointX or pointY are less than 0, X or Y are less than or
   *      equal to 0, if RGB values provided are less than 0 or greater than 255 and if name
   *      provided is null or an empty string.
   */
  public AbstractShape(
          String name, float pointX, float pointY, int X, int Y, int r, int g, int b) {
    if (name == null || name.equals("")) {
      throw new IllegalArgumentException("Name can't be null or empty string");
    } else if (pointX < 0 || pointY < 0) {
      throw new IllegalArgumentException("Length must be positive integer or 0.");
    } else if (X <= 0 || Y <= 0) {
      throw new IllegalArgumentException("Coordinate points must both be positive integers or 0.");
    } else if (r < 0 || g < 0 || b < 0
            || r > 255 || g > 255 || b > 255) {
      throw new IllegalArgumentException("RGB values must be between 0 - 255");
    } else {
      this.name = name;
      this.color = new Color(r, g, b);
      this.pointX = pointX;
      this.pointY = pointY;
      this.X = X;
      this.Y = Y;
      this.appears = 0;
      this.disappears = 0;
      this.appearsFlag = false;
      this.disappearsFlag = false;
      this.type = null;
    }
  }
  
  //GETTERS----------------------------------------------------------------------------------------
  @Override
  public Shape getShape() {
    return this;
  }
  
  @Override
  public String getType() {
    return this.type;
  }
  
  @Override
  public String getName() {
    return this.name;
  }
  
  @Override
  public Color getColor() {
    return this.color;
  }
  
  @Override
  public float getPositionX() {
    return this.pointX;
  }
  
  @Override
  public float getPositionY() {
    return this.pointY;
  }
  
  @Override
  public int getX() {
    return this.X;
  }
  
  @Override
  public int getY() {
    return this.Y;
  }
  
  @Override
  public int getAppears() {
    return this.appears;
  }
  
  @Override
  public int getDisappears() {
    return this.disappears;
  }
  
  
  //SETTERS AND OTHER OTHER------------------------------------------------------------------------
  @Override
  public void setAppears(int appears) {
    if (appears < 0) {
      throw new IllegalArgumentException("Must be positive integer.");
    } else if (this.disappearsFlag && appears > this.disappears) {
      throw new IllegalArgumentException("Must be within acceptable range.");
    }
    
    this.appears = appears;
    this.appearsFlag = true;
  }
  
  @Override
  public void setDisappears(int disappears) {
    if (disappears < 0) {
      throw new IllegalArgumentException("Must be positive integer.");
    } else if (this.appearsFlag && disappears < this.appears) {
      throw new IllegalArgumentException("Must be within acceptable range.");
    }
    
    this.disappears = disappears;
    this.disappearsFlag = true;
  }
  
  @Override
  public boolean equals(Shape other) {
    Objects.requireNonNull(other);
    return (this.name.equals(other.getName()) && this.color.equals(other.getColor())
            && this.pointX == other.getPositionX() && this.pointY == other.getPositionY()
            && this.X == other.getX() && this.Y == other.getY()
            && this.appears == other.getAppears() && this.disappears == other.getDisappears()
            && this.type.equals(other.getType()));
  }
  
}
