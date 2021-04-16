import java.util.ArrayList;
import java.util.List;

import cs5004.animator.model.Animation;
import cs5004.animator.model.AnimationImpl;
import cs5004.animator.model.Oval;
import cs5004.animator.model.Shape;
import cs5004.animator.model.*;

public class Main {
  
  public static void main(String[] args) {
    Animation m = new AnimationImpl();
    Shape a = new Oval("a", "ELLIPSE");
    a.setProperties(1,2, 3, 4, 5, 6, 7);
    a.setAppears(1);
    a.setDisappears(50);
    
    Shape b = new Oval("b", "ELLIPSE");
    b.setProperties(11,12, 13, 14, 15, 16, 17);
    b.setAppears(11);
    b.setDisappears(45);
    
    Shape c = new Oval("c", "ELLIPSE");
    c.setProperties(31,32, 33, 34, 35, 36, 37);
    c.setAppears(2);
    c.setDisappears(49);
    
    Shape d = new Oval("d", "ELLIPSE");
    d.setProperties(11,21, 31, 41, 51, 61, 71);
    d.setAppears(21);
    d.setDisappears(40);
    
    Shape e = new Oval("e", "ELLIPSE");
    e.setProperties(111,211, 311, 141, 151, 161, 171);
    e.setAppears(10);
    e.setDisappears(20);
  
    Shape f = new Rectangle("f", "RECTANGLE");
    f.setProperties(101,201, 301, 41, 51, 151, 71);
    f.setAppears(1);
    f.setDisappears(50);
    
    Shape g = new Rectangle("g", "RECTANGLE");
    g.setProperties(1,24, 1, 41, 151, 60, 7);
    g.setAppears(40);
    g.setDisappears(55);
    
    Shape h = new Rectangle("h", "RECTANGLE");
    h.setProperties(11,211, 321, 31, 41, 61, 41);
    h.setAppears(35);
    h.setDisappears(50);
    
    Shape i = new Rectangle("i", "RECTANGLE");
    i.setProperties(21,22, 23, 24, 25, 26, 22);
    i.setAppears(5);
    i.setDisappears(25);
    
    Shape j = new Rectangle("j", "RECTANGLE");
    j.setProperties(11,12, 13, 14, 15, 16, 17);
    j.setAppears(15);
    j.setDisappears(50);
    
    Transformation move = new Move("m", 50, 50, 7, 19);
    move.setInitialX(50);
    move.setInitialY(50);
    
    Transformation scale = new Scale("s", 10, 5, 5, 10);
    scale.setInitialX(50);
    scale.setInitialY(50);
    
    Color n = new Color(122, 122, 122);
    Transformation color = new ChangeColor("c", n, 3, 34);
    color.setInitialColor(new Color(100, 100, 100));
  
    Transformation move2 = new Move("mo", 20, 53, 17, 40);
    move2.setInitialX(50);
    move2.setInitialY(50);
    
    Transformation scale2 = new Scale("sc", 12, 12, 40, 50);
    scale2.setInitialX(50);
    scale2.setInitialY(50);
    
    Color l = new Color(22, 122, 22);
    Transformation color2 = new ChangeColor("co", l, 20, 40);
    color2.setInitialColor(new Color(100, 100, 100));
    
    
    m.addShape(a, new ArrayList<>());
    m.addShape(b, new ArrayList<>());
    m.addShape(c, new ArrayList<>());
    m.addShape(d, new ArrayList<>());
    m.addShape(e, new ArrayList<>());
    m.addShape(f, new ArrayList<>());
    m.addShape(g, new ArrayList<>());
    m.addShape(h, new ArrayList<>());
    m.addShape(i, new ArrayList<>());
    m.addShape(j, new ArrayList<>());
    
    m.addTransformation("a", move);
    m.addTransformation("a", scale);
    m.addTransformation("a", color);
    m.addTransformation("b", move2);
    m.addTransformation("b", color2);
    m.addTransformation("c", color);
    m.addTransformation("c", move);
    m.addTransformation("f", move);
    m.addTransformation("f", color2);
    //m.addTransformation("g", scale2);
    m.addTransformation("h", scale2);
    m.addTransformation("i", scale);
  
    System.out.println(m.toString());
    System.out.println(m.getByTime(5));
  
    java.awt.Color cc = new java.awt.Color(122, 122, 122);
    java.awt.Color ccs = new java.awt.Color(22, 122, 22);
    System.out.println(cc.getRGB());
    System.out.println(ccs.getRGB());
    
    /*scale
    ta=5
    tb=10
    tox = 10, toy=5
    
    /color
    ta=3
    tb=34
    toc=122, 122, 122
    -8750470
     */
    
    
  }
}
