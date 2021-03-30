import java.awt.Color;

/**
 *
 */
public abstract class ShapeImpl implements Shape {
  private final String name;
  private final Color color;
  private float positionX;
  private float positionY;
  private int appears;
  private int disappears;

  /**
   *
   * @param name
   * @param color
   * @param positionX
   * @param positionY
   * @param appears
   * @param disappears
   */
  public ShapeImpl(String name, String color, float positionX, float positionY,
                   int appears, int disappears) {
    this.name = name;
    this.color = Color.getColor(color);
    this.positionX = positionX;
    this.positionY = positionY;
    this.appears = appears;
    this.disappears = disappears;
  }

  /**
   *
   * @param name
   * @param r
   * @param g
   * @param b
   * @param positionX
   * @param positionY
   * @param appears
   * @param disappears
   */
  public ShapeImpl(String name, int r, int g, int b, float positionX,
                   float positionY, int appears, int disappears) {
    this.name = name;
    this.color = new Color(r, g, b);
    this.positionX = positionX;
    this.positionY = positionY;
    this.appears = appears;
    this.disappears = disappears;
  }

  /**
   *
   * @return
   */
  @Override
  public String getName() {
    return this.name;
  }

  /**
   *
   * @return
   */
  @Override
  public Color getColor() {
    return this.color;
  }

  /**
   *
   * @return
   */
  @Override
  public float getAppears() {
    return this.appears;
  }

  /**
   *
   * @return
   */
  @Override
  public float getDisappears(){
    return this.disappears;
  }

  /**
   *
   * @return
   */
  @Override
  public float getPositionX() {
    return this.positionX;
  }

  /**
   *
   * @return
   */
  @Override
  public float getPositionY() {
    return this.positionY;
  }

}
