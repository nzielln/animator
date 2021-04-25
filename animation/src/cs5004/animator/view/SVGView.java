package cs5004.animator.view;

import java.io.FileWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

import cs5004.animator.model.Animation;
import cs5004.animator.model.AnimationImpl;
import cs5004.animator.model.Shape;
import cs5004.animator.model.Transformation;


/**
 * Represents a class for an SVGView, implements the View interface.
 */
public class SVGView implements View {
  private String view;
  private Animation model;
  
  
  /**
   * SVGView constructor that takes in no argument, define the type of view.
   */
  public SVGView() {
    this.view = "SVG";
    this.model = new AnimationImpl();
    
  }
  
  
  @Override
  public String getViewType() {
    return this.view;
  }
  
  @Override
  public void animate(Animation m, HashMap<String, String> in) {
    Objects.requireNonNull(m, "Animation can't be null");
    Objects.requireNonNull(in, "Inputs can't be null");
    
    int speed = 1;
    if (in.get("speed") != null) {
      speed = Integer.parseInt(in.get("speed").replace("\"",""));
    }
    System.out.println(in.get("speed"));
    
    /*
     * The dimensions provided in each .txt file were too small to display the full animation
     * For example, for the smalldemo.txt, the dimensions are 360by 360, but, the ellipse is
     * drawn at positions between (440, 70) and (440, 370), making it unviewable in the space
     * allocated for the animation. To solve this problem, we decided to set a default dimensions
     * to make sure everything is seen.
     * Width: 100%
     * Height: 100%
     */
    try {
    
    
      FileWriter f = new FileWriter("../outputs/" + in.get("out").replace("\"", ""));
      String canvas = "<svg width=\"" + 100 + "%\" height=\"" + 100
              + "%\" version=\"1.1\" \n\txmlns=\"http://www.w3.org/2000/svg\">\n\n";
      f.write(canvas);
    
    
      for (Shape s : m.getShapes()) {
        StringBuilder str = new StringBuilder();
        if (s.getType().equals("ELLIPSE")) {
          String sh = "<ellipse id=\"" + s.getName() + "\" cx=\"" + s.getPositionX() + "\" cy=\""
                  + s.getPositionY() + "\" rx=\"" + s.getWidth() / 2 + "\" ry=\""
                  + s.getHeight() / 2 + "\" fill=\"rgb(" + s.getColor().getR() + ","
                  + s.getColor().getG() + "," + s.getColor().getB()
                  + ")\" visibility=\"visible\" >\n";
          str.append(sh);
        } else if (s.getType().equals("RECTANGLE")) {
          String sh = "<rect id=\"" + s.getName() + "\" x=\"" + s.getPositionX() + "\" y=\""
                  + s.getPositionY() + "\" width=\"" + s.getWidth() + "\" height=\"" + s.getHeight()
                  + "\" fill=\"rgb(" + s.getColor().getR() + "," + s.getColor().getG() + ","
                  + s.getColor().getB() + ")\" visibility=\"visible\" >\n";
          str.append(sh);
        }
      
      
        for (Transformation t : m.getTransformations(s.getName())) {
          String tx = "";
          String ty = "";
          if (t.getTransformationType().equals("Moves")) {
            if (s.getType().equals("RECTANGLE")) {
            
              tx = "\t<animate attributeType=\"xml\" begin=\"" + t.getTimeStart() / speed
                      + "s\" dur=\"" + (t.getTimeEnd() - t.getTimeStart()) / speed
                      + "s\" attributeName=\"x" + "\" from=\"" + t.getInitialX() + "\" to=\""
                      + t.getToX() + "\" fill=\"freeze\" />\n";
            
              ty = "\t<animate attributeType=\"xml\" begin=\"" + t.getTimeStart() / speed
                      + "s\" dur=\"" + (t.getTimeEnd() - t.getTimeStart()) / speed
                      + "s\" attributeName=\"y" + "\" from=\"" + t.getInitialY() + "\" to=\""
                      + t.getToY() + "\" fill=\"freeze\" />\n";
              str.append(tx);
              str.append(ty);
            
            } else {
              tx = "\t<animate attributeType=\"xml\" begin=\"" + t.getTimeStart() / speed
                      + "s\" dur=\"" + (t.getTimeEnd() - t.getTimeStart()) / speed
                      + "s\" attributeName=\"cx" + "\" from=\"" + t.getInitialX() + "\" to=\""
                      + t.getToX() + "\" fill=\"freeze\" />\n";
              ty = "\t<animate attributeType=\"xml\" begin=\"" + t.getTimeStart() / speed
                      + "s\" dur=\"" + (t.getTimeEnd() - t.getTimeStart()) / speed
                      + "s\" attributeName=\"cy" + "\" from=\"" + t.getInitialY() + "\" to=\""
                      + t.getToY() + "\" fill=\"freeze\" />\n";
              str.append(tx);
              str.append(ty);
            }
          
          } else if (t.getTransformationType().equals("Scales")) {
            if (s.getType().equals("ELLIPSE")) {
              tx = "\t<animate attributeType=\"xml\" begin=\"" + t.getTimeStart() / speed
                      + "s\" dur=\"" + (t.getTimeEnd() - t.getTimeStart()) / speed
                      + "s\" attributeName=\"rx" + "\" from=\"" + t.getInitialWidth() + "\" to=\""
                      + t.getToWidth() + "\" fill=\"freeze\" />\n";
              ty = "\t<animate attributeType=\"xml\" begin=\"" + t.getTimeStart() / speed
                      + "s\" dur=\"" + (t.getTimeEnd() - t.getTimeStart()) / speed
                      + "s\" attributeName=\"ry" + "\" from=\"" + t.getInitialHeight() + "\" to=\""
                      + t.getToHeight() + "\" fill=\"freeze\" />\n";
              str.append(tx);
              str.append(ty);
            
            } else {
              tx = "\t<animate attributeType=\"xml\" begin=\"" + t.getTimeStart() / speed
                      + "s\" dur=\"" + (t.getTimeEnd() - t.getTimeStart()) / speed
                      + "s\" attributeName=\"width" + "\" from=\"" + t.getInitialWidth()
                      + "\" to=\""
                      + t.getToWidth() + "\" fill=\"freeze\" />\n";
              ty = "\t<animate attributeType=\"xml\" begin=\"" + t.getTimeStart() / speed
                      + "s\" dur=\"" + (t.getTimeEnd() - t.getTimeStart()) / speed
                      + "s\" attributeName=\"height" + "\" from=\"" + t.getInitialHeight()
                      + "\" to=\""
                      + t.getToHeight() + "\" fill=\"freeze\" />\n";
              str.append(tx);
              str.append(ty);
            
            }
          } else if (t.getTransformationType().equals("Color")) {
            ty = "\t<animate attributeType=\"xml\" begin=\"" + t.getTimeStart() / speed
                    + "s\" dur=\"" + (t.getTimeEnd() - t.getTimeStart()) / speed
                    + "s\" attributeName=\"fill" + "\" from=\"rgb(" + t.getInitialColor().getR()
                    + "," + t.getInitialColor().getG() + "," + t.getInitialColor().getB()
                    + ")\" to=\"rgb(" + t.getToColor().getR()
                    + "," + t.getToColor().getG() + "," + t.getToColor().getB()
                    + ")\" fill=\"freeze\" />\n";
            str.append(ty);
          }
        
        }
        f.write(str.toString());
        f.write("</" + s.getType().toLowerCase().replace("angle", "") + ">\n\n");
      }
    
      f.write("\n\n</svg>");
      f.close();
    
    } catch (Exception e) {
      e.printStackTrace();
    }
  
  }
  
  @Override
  public void buildModel(Animation m) {
    this.model = m;
    
  }
  
  @Override
  public void currentView(List<Shape> shapes) {
    throw new UnsupportedOperationException("This operation is not supported by this class.");
    
  }
  
  @Override
  public View getView() {
    return this;
  }
  
  @Override
  public void exitView() {
    throw new UnsupportedOperationException("This operation is not supported by this class.");
  }
  
}