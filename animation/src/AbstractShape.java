import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public abstract class AbstractShape implements Shape {
  private final String name;
  private final Color color;
  private float pointX;
  private float pointY;
  private float X;
  private float Y;
  
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
    this.name = name;
    this.color = new Color(r, g, b);
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
