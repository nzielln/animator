package cs5004.animator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Scanner;

import cs5004.animator.model.Animation;
import cs5004.animator.model.AnimationImpl;
import cs5004.animator.util.AnimationBuilder;
import cs5004.animator.util.AnimationBuilderImpl;
import cs5004.animator.util.AnimationReader;
import cs5004.animator.view.View;
import cs5004.animator.view.ViewFactory;

public class EasyAnimator {
  
  
  public static void main(String[] args) throws FileNotFoundException {
    ViewFactory factory = new ViewFactory();
    
    Animation m = new AnimationImpl(); //Model
    Scanner scan = new Scanner(System.in);
    
    System.out.println("What kind of animaton would you like to see?\n");
    System.out.println("Provide an \"-in\" file, \"-out\" the type of \"-view\" "
            + "you would like to see, and \"-speed\" if applicable.");
    String inputStr = scan.nextLine();
    HashMap<String, String> inputs = new HashMap<>();
    scan.close();
    
    //ReadInputs
    Scanner s = new Scanner(inputStr);
    
    while (scan.hasNext()) {
      String next = s.next();
      if (next.equals("-in")) {
        inputs.put("in", s.next());
      } else if (next.equals("-out")) {
        inputs.put("out", s.next());
      } else if (next.equals("-view")) {
        inputs.put("view", s.next());
      } else if (next.equals("-speed")) {
        inputs.put("speed", s.next());
        
      }
    }
    
    //GetReadable
    String fileInput = inputs.get("in").replace("\"", ""); //from the CLI - should have a method for this??
    String filename = "src/cs5004/animator/files/" + fileInput;
    File demo = new File(filename);
    FileReader f = new FileReader(demo);
    
    //Build Model
    AnimationBuilder<Animation> b = new AnimationBuilderImpl(m);
    AnimationReader.parseFile(f, b);
    
    int width = m.getCanvasWidth();
    int height = m.getCanvasHeight();
    int x = m.getCanvasX();
    int y = m.getCanvasY();
    
    //Factory depending on "view"
    View view = factory.create(inputs, m, width, height, x, y);
    
    view.animate(m);
    
    
    //Will need to deal with what to do with resize/reshape
    //Would is be better to have custom methods in each view??
    
  }
  
}
