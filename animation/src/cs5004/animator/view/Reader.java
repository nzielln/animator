package cs5004.animator.view;

import java.awt.*;
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

public class Reader {
  HashMap<String, String> inputs;
  Animation model;
  
  public Reader() {
    this.inputs = new HashMap<>();
    this.model = new AnimationImpl();
  }
  
  public void readIn(String in) {
    Scanner s = new Scanner(in);
    while (s.hasNext()) {
      String next = s.next();
      if (next.equals("-in")) {
        this.inputs.put("in", s.next());
      } else if (next.equals("-out")) {
        this.inputs.put("out", s.next());
      } else if (next.equals("-view")) {
        this.inputs.put("view", s.next());
      } else if (next.equals("-speed")) {
        this.inputs.put("speed", s.next());
      }
    }
    
    if (this.inputs.get("in") == null || this.inputs.get("in").equals("")) {
      throw new IllegalArgumentException("You must provide an \"-in\" file.");
    
    } else if (this.inputs.get("view") == null || this.inputs.get("view").equals("")) {
      throw new IllegalArgumentException("You must provide a \"-view\" type.");
    
    } else if (!(this.inputs.get("view").equalsIgnoreCase("svg")
            || this.inputs.get("view").equalsIgnoreCase("text")
            || this.inputs.get("view").equalsIgnoreCase("visual"))) {
      
      throw new IllegalArgumentException("You must provide a supported \"-view\" type.");
      
    } else if (this.inputs.get("view").equalsIgnoreCase("SVG")) {
      if (this.inputs.get("out") == null || this.inputs.get("out").equals("")) {
        throw new IllegalArgumentException("You must provide an \"-out\" file.");
      }
    
    }
    
  }
  
  public HashMap<String, String> getInputs() {
    return this.inputs;
  
  }
  
  public void makeModel(HashMap<String, String> inputs, View view) {
    String fileInput = inputs.get("in").replace("\"", ""); //from the CLI - should have a method for this??
    String filename = "./resources/files/" + fileInput;
    try {
      File demo = new File(filename);
      FileReader f = new FileReader(demo);
      AnimationBuilder<Animation> b = new AnimationBuilderImpl(this.model);
      AnimationReader.parseFile(f, b);
      if (inputs.get("view").equalsIgnoreCase("visual")) {
        view.buildModel(this.model);
      }
    } catch (FileNotFoundException e) {
      if (inputs.get("view").equals("visual")) {
        JOptionPane.showMessageDialog((Component) view.getView(), "File not found.",
                "ERROR", JOptionPane.ERROR_MESSAGE);
      }
      
      throw new IllegalArgumentException("File not found.");
    }
  }
  
  public Animation getModel() {
    return this.model;
  }
}
