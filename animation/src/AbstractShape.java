import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 */
public abstract class AbstractShape implements Shape {
  //should we make these package private so we don't have to call getters when
  //we want to use this info in rectangle and oval?
  final String name;
  final Color color;
  final float pointX;
  final float pointY;
  final int X;
  final int Y;
  int appears;
  int disappears;
  
  /**
   *
   * @param name
   * @param pointX
   * @param pointY
   * @param X
   * @param Y
   * @param r
   * @param g
   * @param b
   */
  public AbstractShape
  (String name, float pointX, float pointY, int X, int Y, int r, int g, int b) {
    if (name == null || name.equals("")) {
      throw new IllegalArgumentException("Name can't be null or empty string");
    } else if (pointX <= 0 || pointY <= 0) {
      throw new IllegalArgumentException("Length must be positive integer");
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
    }
  }
  
  //GETTERS----------------------------------------------------------------------------------------
  @Override
  public Shape getShape() {
    return this;
  }
  
  @Override
  public String getType() {
    return null;
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
      throw new IllegalArgumentException("Must be positive integer");
    }
    this.appears = appears;
  }
  
  @Override
  public void setDisappears(int disappears) {
    if (disappears < 0) {
      throw new IllegalArgumentException("Must be positive integer");
    }
    this.disappears = disappears;
  }
  
  @Override
  public boolean equals(Shape other) {
    Objects.requireNonNull(other);
    return this.name.equals(other.getName()) && this.color.equals(other.getColor())
            && this.pointX == other.getX() && this.pointY == other.getY()
            && this.appears == other.getAppears() && this.disappears == other.getDisappears();
  }
  
}
