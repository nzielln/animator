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
    
    System.out.println("Provide an \"-in\" file, \"-out\" the type of \"-view\" "
            + "you would like to see, and \"-speed\" if applicable.");
    String inputStr = scan.nextLine();
    HashMap<String, String> in = new HashMap<>();
    scan.close();
    
    //ReadInputs
    Scanner s = new Scanner(inputStr);
    
    while (s.hasNext()) {
      String next = s.next();
      if (next.equals("-in")) {
        in.put("in", s.next());
      } else if (next.equals("-out")) {
        in.put("out", s.next());
      } else if (next.equals("-view")) {
        in.put("view", s.next());
      } else if (next.equals("-speed")) {
        in.put("speed", s.next());
      }
    }
    s.close();
    
    //GetReadable
    String fileInput = in.get("in").replace("\"", ""); //from the CLI - should have a method for this??
    String filename = "./src/cs5004/animator/files/" + fileInput;
    File demo = new File(filename);
    FileReader f = new FileReader(demo);
    
    //Build Model
    AnimationBuilder<Animation> b = new AnimationBuilderImpl(m);
    AnimationReader.parseFile(f, b);
    
    //Factory depending on "view"
    View view = factory.create(in, m);
    view.animate(m, in);
    
  }
}

//test text: -in smalldemo.txt -view text -speed 2
//test svg: -in smalldemo.txt -view svg -speed 2
//test visual: -in smalldemo.txt -view visual -speed 2
    

