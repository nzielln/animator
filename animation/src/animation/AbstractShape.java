package animation;

import java.util.Objects;

/**
 * AbstractShape implements the Shape interface, it represents methods common to shapes in the
 * animation.
 */
public abstract class AbstractShape implements Shape {
  String name;
  String type;
  Color color;
  int pointX;
  int pointY;
  int x;
  int y;
  int appears;
  int disappears;
  boolean appearsFlag;
  boolean disappearsFlag;
  int properties;
  Shape startState;
  Shape endState;
  
  
  /**
   * Constructor a shape, takes in parameter to create a shape.
   * @param name unique id/name for the shape
   * @param type
   */
  public AbstractShape(
          String name, String type) {
    if (name == null || name.equals("")) {
      throw new IllegalArgumentException("Name can't be null or empty string");
    } else if (type == null || type.equals("")) {
      throw new IllegalArgumentException("Name can't be null or empty string");
    } else {
      this.name = name;
      this.type = null;
      this.color = null;
      this.pointX = 0;
      this.pointY = 0;
      this.x = 0;
      this.y = 0;
      this.appears = 0;
      this.disappears = 0;
      this.appearsFlag = false;
      this.disappearsFlag = false;
      this.startState = null;
      this.endState = null;
      this.properties = 0;
    }
  }
  
  //GETTERS----------------------------------------------------------------------------------------
  @Override
  public Shape getShape() {
    return this;
  }
  
  @Override
  public String getType() {
    return this.type.toUpperCase();
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
  public int getPositionX() {
    return this.pointX;
  }
  
  @Override
  public int getPositionY() {
    return this.pointY;
  }
  
  @Override
  public int getX() {
    return this.x;
  }
  
  @Override
  public int getY() {
    return this.y;
  }
  
  @Override
  public int getAppears() {
    return this.appears;
  }
  
  @Override
  public int getDisappears() {
    return this.disappears;
  }
  
  @Override
  public boolean getCreated() {
    return this.properties == 5 && this.appearsFlag && this.disappearsFlag;
  }
  
  @Override
  public Shape getStartState() {
    return this.startState;
  }
  
  @Override
  public Shape getEndState() {
    return this.endState;
  }
  
  //SETTERS AND OTHER------------------------------------------------------------------------------
  @Override
  public void setColor(int r, int g, int b) {
    if (r < 0 || g < 0 || b < 0
            || r > 255 || g > 255 || b > 255) {
      throw new IllegalArgumentException("RGB values must be between 0 - 255");
    }
    
    this.color = new Color(r, g, b);
    this.properties += 1;
  }
  
  @Override
  public void setPositionX(int pointX) {
    if (pointX < 0) {
      throw new IllegalArgumentException("Length must be positive integer or 0.");
    }
    this.pointX = pointX;
    this.properties += 1;
  }
  
  @Override
  public void setPositionY(int pointY) {
    if (pointY < 0) {
      throw new IllegalArgumentException("Length must be positive integer or 0.");
    }
    this.pointY = pointY;
    this.properties += 1;
  }
  
  @Override
  public void setX(int x) {
    if (x <= 0) {
      throw new IllegalArgumentException("Coordinate points must both be positive integers or 0.");
    }
    this.x = x;
    this.properties += 1;
  }
  
  @Override
  public void setY(int y) {
    if ( y <= 0) {
      throw new IllegalArgumentException("Coordinate points must both be positive integers or 0.");
    }
    
    this.y = y;
    this.properties += 1;
  }
  
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
  public void setStartState(Shape s) {
    if (s.getCreated()) {
      this.startState = s.copy();
    }
  }
  
  @Override
  public void setEndState(Shape s) {
    if (s.getCreated()) {
      this.startState = s.copy();
    }
  }
  
  @Override
  public boolean sameObject(Shape other) {
    Objects.requireNonNull(other);
    
    return (this.name.equals(other.getName()) && this.color.sameObject(other.getColor())
            && this.pointX == other.getPositionX() && this.pointY == other.getPositionY()
            && this.x == other.getX() && this.y == other.getY()
            && this.appears == other.getAppears() && this.disappears == other.getDisappears()
            && this.type.equals(other.getType()));
  }
  
}
