package animation;
public class Color {
  private final int r;
  private final int g;
  private final int b;

  public Color (int r, int g, int b) {
    if (r < 0 || g < 0 || b < 0
            || r > 255 || g > 255 || b > 255) {
      throw new IllegalArgumentException("RGB values must be between 0 - 255");
    }
    this.r = r;
    this.g = g;
    this.b = b;
  }
  
  //GETTERS----------------------------------------------------------------------------------------
  public int getR() {
    return this.r;
  }

  public int getG() {
    return this.g;
  }

  public int getB() {
    return this.b;
  }

  public Color getColor() {
    return this;
  }
  
  //OTHER------------------------------------------------------------------------------------------
  public boolean equals(Color other) {
    return (this.r == other.r && this.b == other.b && this.g == other.g);
  }
  
  @Override
  public String toString() {
    return "(" + this.r + ", " + this.g + ", " + this.b + ")";
  }
}
