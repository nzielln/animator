import java.awt.*;

/**
 *
 */
public abstract class ShapeAbstract implements Shape {
  private final String name;
  private final Color color;
  private float pointX;
  private float pointY;
  private float X;
  private float Y;
  
  /**
   *
   * @param name
   * @param color
   * @param pointX
   * @param pointY
   * @param X
   * @param Y
   */
  public ShapeAbstract(String name, Color color, float pointX, float pointY, float X, float Y) {
    this.name = name;
    this.color = color;
    this.pointX = pointX;
    this.pointY = pointY;
    this.X = X;
    this.Y = Y;
  
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
  
}
