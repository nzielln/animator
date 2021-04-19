package cs5004.animator.view;

import java.io.File;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Objects;

import cs5004.animator.model.Animation;
import cs5004.animator.model.Shape;
import cs5004.animator.model.Transformation;



public class SVGView extends AbstractView {
  private String view;
  
  public SVGView() {
    this.view = "SVG";
  }
  
  
  @Override
  public String getViewType() {
    return this.view;
  }
  
  @Override
  public void animate(Animation m, HashMap<String, String> inputs) {
    Objects.requireNonNull(m, "Animation can't be null");
    Objects.requireNonNull(inputs, "Inputs can't be null");
    
    int speed = 1;
    if (inputs.get("speed") != null) {
      speed = Integer.parseInt(inputs.get("speed").replace("\"",""));
    }
    
    try {
      
      FileWriter f = new FileWriter("./resources/outputs/" + inputs.get("out").replace("\"", ""));
      String canvas = "<svg width=\"" + m.getCanvasWidth() + "\" height=\"" + m.getCanvasHeight()
              + "\" version=\"1.1\" \n\txmlns=\"http://www.w3.org/2000/svg\">\n\n";
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
                      + "s\" attributeName=\"width" + "\" from=\"" + t.getInitialWidth() + "\" to=\""
                      + t.getToWidth() + "\" fill=\"freeze\" />\n";
              ty = "\t<animate attributeType=\"xml\" begin=\"" + t.getTimeStart() / speed
                      + "s\" dur=\"" + (t.getTimeEnd() - t.getTimeStart()) / speed
                      + "s\" attributeName=\"height" + "\" from=\"" + t.getInitialHeight() + "\" to=\""
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
  public void buildModel(Animation f) {
    throw new UnsupportedOperationException("This method is not supported by the Text view.");
    
  }
  
  @Override
  public View getView() {
    throw new UnsupportedOperationException("This operation isn't supported by this class.");
  }
  
}

