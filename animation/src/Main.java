import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

import cs5004.animator.model.Animation;
import cs5004.animator.model.AnimationImpl;
import cs5004.animator.model.Shape;
import cs5004.animator.util.AnimationBuilder;
import cs5004.animator.util.AnimationBuilderImpl;
import cs5004.animator.util.AnimationReader;

public class Main {
  
  public static void main(String[] args) throws FileNotFoundException {
    Animation m = new AnimationImpl();
    String filename = "src/cs5004/animator/files/smalldemo.txt";
    File demo = new File(filename);
    FileReader f = new FileReader(demo);
  
    //Build Model
    AnimationBuilder<Animation> b = new AnimationBuilderImpl(m);
    AnimationReader.parseFile(f, b);
    for (int i = 10; i < 50; i++ ) {
      List<Shape> l = m.getByTime(i);
      System.out.println(l);
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    /*
    Animation m = new AnimationImpl();
    Shape a = new Ellipse("a", "Ellipse");
    a.setProperties(1,2, 3, 4, 5, 6, 7);
    a.setAppears(1);
    a.setDisappears(50);
    
    Shape b = new Ellipse("b", "Ellipse");
    b.setProperties(11,12, 13, 14, 15, 16, 17);
    b.setAppears(11);
    b.setDisappears(45);
    
    Shape c = new Ellipse("c", "Ellipse");
    c.setProperties(31,32, 33, 34, 35, 36, 37);
    c.setAppears(2);
    c.setDisappears(49);
    
    Shape d = new Ellipse("d", "Ellipse");
    d.setProperties(11,21, 31, 41, 51, 61, 71);
    d.setAppears(21);
    d.setDisappears(40);
    
    Shape e = new Ellipse("e", "Ellipse");
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
    
    Color n = new Color(3, 125, 32);
    Transformation color = new ChangeColor("c", n, 3, 34);
    color.setInitialColor(new Color(52, 12, 65));
  
    Transformation move2 = new Move("mo", 20, 53, 17, 40);
    move2.setInitialX(50);
    move2.setInitialY(50);
    
    Transformation scale2 = new Scale("sc", 12, 12, 40, 50);
    scale2.setInitialX(50);
    scale2.setInitialY(50);
    
    Color l = new Color(56, 22, 123);
    Transformation color2 = new ChangeColor("co", l, 20, 40);
    color2.setInitialColor(new Color(23, 45, 134));
    
    
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
    
    move.setShape(a.getName(), a.getType(), 1,2, 3, 4, 5, 6, 7);
    m.addTransformation("a", move);
    
    scale.setShape(a.getName(), a.getType(), 50,50, 3, 4, 5, 6, 7);
    m.addTransformation("a", scale);
  
    color.setShape(a.getName(), a.getType(), 50,50, 10, 5, 5, 6, 7);
    m.addTransformation("a", color);
    
    move2.setShape(b.getName(), b.getType(), 11,12, 13, 14, 15, 16, 17);
    m.addTransformation("b", move2);
    
    color2.setShape(b.getName(), b.getType(), 20,53, 13, 14, 22, 122, 22);
    m.addTransformation("b", color2);
    
    color.setShape(c.getName(), c.getType(), 31,32, 33, 34, 35, 36, 37);
    m.addTransformation("c", color);
    
    move.setShape(c.getName(), c.getType(), 31,32, 33, 34, 122, 122, 122);
    m.addTransformation("c", move);
    
    move.setShape(f.getName(), f.getType(), 101,201, 301, 41, 51, 151, 71);
    m.addTransformation("f", move);
    
    color2.setShape(f.getName(), f.getType(), 50,50, 301, 41, 51, 151, 71);
    m.addTransformation("f", color2);
    
    //m.addTransformation("g", scale2);
    scale2.setShape(h.getName(), h.getType(), 11,211, 321, 31, 41, 61, 41);
    m.addTransformation("h", scale2);
    
    scale.setShape(i.getName(), i.getType(), 101,201, 301, 41, 51, 151, 71);
    m.addTransformation("i", scale);
  */
    
  }
}
