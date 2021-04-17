package cs5004.animator.model;

import java.util.Objects;

/**
 * AbstractShape implements the Shape interface, it represents methods common to shapes in the
 * animation.
 */
public abstract class AbstractShape implements Shape {
  String name;
  String type;
  Color color;
  int x;
  int y;
  int w;
  int h;
  int appears;
  int disappears;
  boolean propertiesSet;
  
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
      this.type = type.toUpperCase();
      this.color = null;
      this.x = 0;
      this.y = 0;
      this.w = 0;
      this.h = 0;
      this.appears = 0;
      this.disappears = 0;
      this.propertiesSet = false;
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
  public int getPositionX() {
    return this.x;
  }
  
  @Override
  public int getPositionY() {
    return this.y;
  }
  
  @Override
  public int getWidth() {
    return this.w;
  }
  
  @Override
  public int getHeight() {
    return this.h;
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
    return this.propertiesSet;
  }
  
  //SETTERS AND OTHER------------------------------------------------------------------------------
  @Override
  public void setProperties(int x, int y, int w, int h, int r, int g, int b) {
    if (r < 0 || g < 0 || b < 0
            || r > 255 || g > 255 || b > 255) {
      throw new IllegalArgumentException("RGB values must be between 0 - 255");
    } else if (w <= 0 || h <= 0) {
      throw new IllegalArgumentException("Length must be positive integer or 0.");
    }
  
    this.x = x;
    this.y = y;
    this.w = w;
    this.h = h;
    this.color = new Color(r, g, b);
    this.propertiesSet = true;
  }
  
  @Override
  public void setAppearsDisappears(int appears, int disappears) {
    if (appears < 0) {
      throw new IllegalArgumentException("Time must be positive integer.");
    } else if (disappears < 0) {
      throw new IllegalArgumentException("Time must be positive integer.");
    } else if (appears > disappears) {
      throw new IllegalArgumentException("Appear must be less than disappear");
    }
    
    this.appears = appears;
    this.disappears = disappears;
  }
  
  @Override
  public void changePosition(int x, int y) {
    
    this.x = x;
    this.y = y;
  }
  
  @Override
  public void changeSize(int w, int h) {
    if (w <= 0 || h <= 0) {
      throw new IllegalArgumentException("Length must be positive integer or 0.");
    }
    this.w = w;
    this.h = h;
  }
  
  @Override
  public void changeColor(int r,int g, int b) {
    if (r < 0 || g < 0 || b < 0
            || r > 255 || g > 255 || b > 255) {
      throw new IllegalArgumentException("RGB values must be between 0 - 255");
    }
    
    this.color = new Color(r,g,b);
  }
  
  @Override
  public boolean sameObject(Shape other) {
    Objects.requireNonNull(other);
    
    return (this.name.equals(other.getName()) && this.color.sameObject(other.getColor())
            && this.x == other.getPositionX() && this.y == other.getPositionY()
            && this.w == other.getWidth() && this.h == other.getHeight()
            && this.appears == other.getAppears() && this.disappears == other.getDisappears()
            && this.type.equals(other.getType()));
  }
  
}
