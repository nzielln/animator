import org.junit.Before;
import org.junit.Test;

import animation.Color;

import static org.junit.Assert.*;

public class ColorTest {
  private Color c;
  private Color bad;
  
  
  @Before
  public void setUp() throws Exception {
    try {
      c = new Color(255, 255, 255);
    } catch (Exception e) {
      fail("No exception should be thrown");
    }
  
    try {
      c = new Color(255, 0, 255);
    } catch (Exception e) {
      fail("No exception should be thrown");
    }
    
    try {
      c = new Color(0, 0, 0);
    } catch (Exception e) {
      fail("No exception should be thrown");
    }
  
    try {
      c = new Color(122, 214, 34);
    } catch (Exception e) {
      fail("No exception should be thrown");
    }
    
    //Invalid Inputs
    try {
      bad = new Color(-123, 214, 34);
      fail("Exception should be thrown");
    } catch (Exception ignored) {
    }
  
    try {
      bad = new Color(256, 214, 34);
      fail("Exception should be thrown");
    } catch (Exception ignored) {
    }
    
    try {
      bad = new Color(-123, 345, -2);
      fail("Exception should be thrown");
    } catch (Exception ignored) {
    }
  
    try {
      bad = new Color(321, 435, 345);
      fail("Exception should be thrown");
    } catch (Exception ignored) {
    }
  }
  
  @Test
  public void getRGB() {
    assertEquals(122, c.getR());
    assertEquals(214, c.getG());
    assertEquals(34, c.getB());
  }
  
  @Test
  public void getColor() {
    assertEquals(122, c.getColor().getR());
    assertEquals(214, c.getColor().getG());
    assertEquals(34, c.getColor().getB());
  }

  @Test
  public void testEquals() {
    try {
      Color c2 = new Color(122, 214, 34);
      assertTrue(c.equals(c2));
    } catch (Exception e) {
      fail("No exception should be thrown");
    }

    try {
      Color c2 = null;
      c.equals(c2);
      fail("Exception should be thrown");
    } catch (Exception ignored) {
    }

    try {
      Color c2 = null;
      c2.equals(c);
      fail("Exception should be thrown");
    } catch (Exception ignored) {
    }
  }
  
  @Test
  public void testToString() {
    String cstr = "(122, 214, 34)";
    assertEquals(cstr, c.toString());
  }
}