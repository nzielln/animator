package cs5004.animator;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Scanner;

import javax.swing.*;

import cs5004.animator.model.Animation;
import cs5004.animator.model.AnimationImpl;
import cs5004.animator.util.AnimationBuilder;
import cs5004.animator.util.AnimationBuilderImpl;
import cs5004.animator.util.AnimationReader;
import cs5004.animator.view.Reader;
import cs5004.animator.view.View;
import cs5004.animator.view.ViewFactory;

public class EasyAnimator {
  
  public static void main(String[] args) throws FileNotFoundException {
    ViewFactory factory = new ViewFactory();
    Reader r = new Reader();
    //Animation m = new AnimationImpl();
    System.out.println("Provide an \"-in\" file, \"-out\" the type of \"-view\" "
            + "you would like to see, and \"-speed\" if applicable.");
    
    //Read inputs
    Scanner scan = new Scanner(System.in);
    //HashMap<String, String> inputs = new HashMap<>();
    
    //Parse Inputs
    String in = scan.nextLine();
    View view = factory.create(in);
    r.readIn(in);
    //Get readbale and generate model
    r.makeModel(r.getInputs(), view);
    
    //Animate
    view.animate(r.getModel(), r.getInputs());
 
  }
}

//test text: -in smalldemo.txt -view text -speed 2
//test svg: -in smalldemo.txt -view svg -speed 2 -out s.svg
//test visual: -in smalldemo.txt -view visual -speed 20
    

