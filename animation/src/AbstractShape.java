import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public abstract class AbstractShape implements Shape {
  //should we make these package private so we don't have to call getters when
  //we want to use this info in rectangle and oval?
  private final String name;
  private final Color color;
  private float pointX;
  private float pointY;
  private float X;
  private float Y;
  private int appears;
  private int disappears;
  
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
  (String name, float pointX, float pointY, float X, float Y, int r, int g, int b) {
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
  public float getX() {
    return this.X;
  }
  
  @Override
  public float getY() {
    return this.Y;
  }
  
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
  public int getAppears() {
    return this.appears;
  }
  
  @Override
  public int getDisappears() {
    return this.disappears;
  }
  
}
