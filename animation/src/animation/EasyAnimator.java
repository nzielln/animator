package animation;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Scanner;

import animation.code.cs5004.animator.util.AnimationBuilder;
import animation.code.cs5004.animator.util.AnimationBuilderImpl;
import animation.code.cs5004.animator.util.AnimationReader;

public class EasyAnimator {
  
  
  public static void main(String[] args) throws FileNotFoundException {
    View text = new TextView();
    Animation m = new AnimationImpl(); //Model
    Scanner scan = new Scanner(System.in);
    
    System.out.println("What kind of animaton would you like to see?\n");
    System.out.println("Provide an \"-in\" file, \"-out\" the type of \"-view\" "
            + "you would like to see, and \"-speed\" if applicable.");
    String inputStr = scan.nextLine();
    
    if (inputStr.contains("text")) {
      text.readInputs(inputStr);
      FileReader f = text.getReadable();
      
      AnimationBuilder<Animation> b = new AnimationBuilderImpl(m);
      AnimationReader.parseFile(f, b);
      
      text.animate(m);
    } else {
      System.out.println("Nothing to do here\n");
    }
    

    /*
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
     */
    
  }
  
}
