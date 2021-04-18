package cs5004.animator;


import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

import cs5004.animator.view.View;
import cs5004.animator.view.ViewFactory;

public class EasyAnimator {
  
  public static void main(String[] args) throws FileNotFoundException {
    ViewFactory factory = new ViewFactory();
    Scanner scan = new Scanner(System.in);
    
    System.out.println("Provide an \"-in\" file, \"-out\" the type of \"-view\" "
            + "you would like to see, and \"-speed\" if applicable.");
    String in = scan.nextLine();
    View view = factory.create(in);
    view.readInputs(in);
    view.getReadable();
    //ByteArrayOutputStream b = new ByteArrayOutputStream();
    //PrintStream out = new PrintStream(b);
    //PrintStream sys = System.out;
    //System.setOut(out);
    view.animate();
    //System.out.flush();
    //System.setOut(sys);
    //System.out.println("Hey: " + b.toString());
 
  }
}

//test text: -in smalldemo.txt -view text -speed 2
//test svg: -in smalldemo.txt -view svg -speed 2 -out s.svg
//test visual: -in smalldemo.txt -view visual -speed 20
    

