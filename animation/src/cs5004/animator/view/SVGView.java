package cs5004.animator.view;

import java.io.FileWriter;

import cs5004.animator.model.Animation;
import cs5004.animator.model.Shape;
import cs5004.animator.model.Transformation;



public class SVGView extends AbstractView {
  
  @Override
  public void animate(Animation m) {
    /*int interval = 0;
    if (this.inputs.get("speed") != null) {
      int time = Integer.parseInt(this.inputs.get("speed"));
      interval = 100 / time;
      
     */
    
    // -in "smalldemo.txt" -out "out.svg" -view "svg"
    try {
      
      FileWriter f = new FileWriter(this.inputs.get("out"));
      String canvas = "<svg width=\"" + m.getCanvasWidth() + "\" height=\"" + m.getCanvasHeight()
              + "\" version=\"1.1\" \n\t xmlns=\"http://www.w3.org/2000/svg\">\n\n";
      f.write(canvas);
      
      
      for (Shape s : m.getShapes()) {
        StringBuilder str = new StringBuilder();
        String tag = "";
        if (s.getType().equals("ELLIPSE")) {
          String sh = "<ellipse id=\"" + s.getName() + "\" cx=\"" + s.getPositionX() + "\" cy=\""
                  + s.getPositionY() + "\" rx=\"" + s.getX() + "\" ry=\"" + s.getY()
                  + "\" fill=\"rgb(" + s.getColor().getR() + "," + s.getColor().getG() + ","
                  + s.getColor().getB() + ")\" visibility=\"visible\" >\n";
          str.append(sh);
        } else if (s.getType().equals("RECTANGLE")) {
          String sh = "<rect id=\"" + s.getName() + "\" x=\"" + s.getPositionX() + "\" y=\""
                  + s.getPositionY() + "\" width=\"" + s.getX() + "\" height=\"" + s.getY()
                  + "\" fill=\"rgb(" + s.getColor().getR() + "," + s.getColor().getG() + ","
                  + s.getColor().getB() + ")\" visibility=\"visible\" >\n";
          str.append(sh);
        }
        
        
        for (Transformation t : m.getTransformations(s.getName())) {
          String tr = "";
          if (t.getTransformationType().equals("Moves")) {
            if (s.getType().equals("RECTANGLE")) {
              if (t.getInitialX() != t.getToX()) {
                tr = "\t<animate attributeType=\"xml\" begin=\"" + t.getTimeStart() * 100
                        + "ms\" dur=\"" + (t.getTimeEnd() - t.getTimeStart()) * 100
                        + "ms\" attributeName=\"x" + "\" from=\"" + t.getInitialX() + "\" to=\""
                        + t.getToX() + "\" fill=\"freeze\" />\n";
              } else {
                tr = "\t<animate attributeType=\"xml\" begin=\"" + t.getTimeStart() * 100
                        + "ms\" dur=\"" + (t.getTimeEnd() - t.getTimeStart()) * 100
                        + "ms\" attributeName=\"y" + "\" from=\"" + t.getInitialY() + "\" to=\""
                        + t.getToY() + "\" fill=\"freeze\" />\n";
              }
            } else {
              if (t.getInitialX() != t.getToX()) {
                tr = "\t<animate attributeType=\"xml\" begin=\"" + t.getTimeStart() * 100
                        + "ms\" dur=\"" + (t.getTimeEnd() - t.getTimeStart()) * 100
                        + "ms\" attributeName=\"cx" + "\" from=\"" + t.getInitialX() + "\" to=\""
                        + t.getToX() + "\" fill=\"freeze\" />\n";
              } else {
                tr = "\t<animate attributeType=\"xml\" begin=\"" + t.getTimeStart() * 100
                        + "ms\" dur=\"" + (t.getTimeEnd() - t.getTimeStart()) * 100
                        + "ms\" attributeName=\"cy" + "\" from=\"" + t.getInitialY() + "\" to=\""
                        + t.getToY() + "\" fill=\"freeze\" />\n";
              }
            }
  
          } else if (t.getTransformationType().equals("Scales")) {
            if (s.getType().equals("ELLIPSE")) {
              if (t.getInitialX() != t.getToX()) {
                tr = "\t<animate attributeType=\"xml\" begin=\"" + t.getTimeStart() * 100
                        + "ms\" dur=\"" + (t.getTimeEnd() - t.getTimeStart()) * 100
                        + "ms\" attributeName=\"rx" + "\" from=\"" + t.getInitialX() + "\" to=\""
                        + t.getToX() + "\" fill=\"freeze\" />\n";
              } else {
                tr = "\t<animate attributeType=\"xml\" begin=\"" + t.getTimeStart() * 100
                        + "ms\" dur=\"" + (t.getTimeEnd() - t.getTimeStart()) * 100
                        + "ms\" attributeName=\"ry" + "\" from=\"" + t.getInitialY() + "\" to=\""
                        + t.getToY() + "\" fill=\"freeze\" />\n";
              }
    
            } else {
              if (t.getInitialX() != t.getToX()) {
                tr = "\t<animate attributeType=\"xml\" begin=\"" + t.getTimeStart() * 100
                        + "ms\" dur=\"" + (t.getTimeEnd() - t.getTimeStart()) * 100
                        + "ms\" attributeName=\"width" + "\" from=\"" + t.getInitialX() + "\" to=\""
                        + t.getToX() + "\" fill=\"freeze\" />\n";
              } else {
                tr = "\t<animate attributeType=\"xml\" begin=\"" + t.getTimeStart() * 100
                        + "ms\" dur=\"" + (t.getTimeEnd() - t.getTimeStart()) * 100
                        + "ms\" attributeName=\"height" + "\" from=\"" + t.getInitialY() + "\" to=\""
                        + t.getToY() + "\" fill=\"freeze\" />\n";
              }
            }
  
          } else if (t.getTransformationType().equals("Color")) {
            tr = "\t<animate attributeType=\"xml\" begin=\"" + t.getTimeStart() * 100
                    + "ms\" dur=\"" + (t.getTimeEnd() - t.getTimeStart()) * 100
                    + "ms\" attributeName=\"fill" + "\" from=\"rgb(" + t.getInitialColor().getR()
                    + "," + t.getInitialColor().getG() + "," + t.getInitialColor().getB()
                    + ")\" to=\"rgb(" + t.getToColor().getR()
                    + "," + t.getToColor().getG() + "," + t.getToColor().getB()
                    + ")\" fill=\"freeze\" />\n";
          }
          
          str.append(tr);
        }
        f.write(str.toString());
        f.write("</" + s.getType().toLowerCase().replace("angle", "") + ">\n\n");
      }
      
      f.write("\n\n</svg>");
      f.close();
      System.out.println("SVG Done.\n");
      
    } catch (Exception e) {
      e.printStackTrace();
    }
    
  }
  
}

