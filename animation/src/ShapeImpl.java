/**
 *
 */
public abstract class ShapeImpl implements Shape {
  private final String name;
  private Color color;
  private double positionX;
  private double positionY;
  private double appears;
  private double disappears;

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
  public ShapeImpl(String name, int r, int g, int b, double positionX,
                   double positionY, double appears, double disappears) {
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
  public double getAppears() {
    return this.appears;
  }

  /**
   *
   * @return
   */
  @Override
  public double getDisappears(){
    return this.disappears;
  }

  /**
   *
   * @return
   */
  @Override
  public double getPositionX() {
    return this.positionX;
  }

  /**
   *
   * @return
   */
  @Override
  public double getPositionY() {
    return this.positionY;
  }

}
