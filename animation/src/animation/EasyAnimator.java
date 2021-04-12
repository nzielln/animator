package animation;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

import animation.code.cs5004.animator.util.AnimationBuilder;
import animation.code.cs5004.animator.util.AnimationBuilderImpl;
import animation.code.cs5004.animator.util.AnimationReader;

public class EasyAnimator {
  
  public static void main(String[] args) throws FileNotFoundException {
    TextView text = new TextView();
    GraphicView graphic = new GraphicView();
    SVGView svg = new SVGView(); //
    Animation m = new AnimationImpl(); //Model
    
    //---------------------------------------------------------------------------------------------
    //This is the basic idea of getting file
    String fileInput = "smalldemo.txt"; //from the CLI - should have a method for this??
    String filename = "src/animation/code/" + fileInput;
    File demo = new File(filename);
    FileReader f = new FileReader(demo);
    //---------------------------------------------------------------------------------------------
    
    AnimationBuilder<Animation> b = new AnimationBuilderImpl(m);
    AnimationReader.parseFile(f, b);
    //System.out.println(m.toString());
  
  }
}
