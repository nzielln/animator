package cs5004.animator.view;

import java.awt.Component;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Scanner;

import javax.swing.JOptionPane;

import cs5004.animator.model.Animation;
import cs5004.animator.model.AnimationImpl;
import cs5004.animator.util.AnimationBuilder;
import cs5004.animator.util.AnimationBuilderImpl;
import cs5004.animator.util.AnimationReader;

/**
 * A class for reading and parsing CLI arguments, and build model for the animation.
 */
public class Reader {
  HashMap<String, String> inputs;
  Animation model;
  
  /**
   * A Reader constructor, takes in no arguments, sets HashMap for storing input information and
   * our model.
   */
  public Reader() {
    this.inputs = new HashMap<>();
    this.model = new AnimationImpl();
  }
  
  /**
   * Parses input string and populate the input HashMap with in, out, view and speed inputs where
   * applicable.
   * @param in String, input from CLI
   */
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
  
  /**
   * Returns the HashMap of inputs.
   * @return HashMap, inputs for the animation
   */
  public HashMap<String, String> getInputs() {
    return this.inputs;
  
  }
  
  /**
   * Uses AnimationReader and AnimationBuilder to read a text file and populate the model.
   * @param inputs HashMap, a hash map of the animation inputs
   * @param view Animation, the model for the animation
   */
  public void makeModel(HashMap<String, String> inputs, View view) {
    String fileInput = inputs.get("in").replace("\"", "");
    try {
      File demo = new File(fileInput);
      FileReader f = new FileReader(demo);
      AnimationBuilder<Animation> b = new AnimationBuilderImpl(this.model);
      AnimationReader.parseFile(f, b);

    } catch (FileNotFoundException e) {
      if (inputs.get("view").equals("visual")) {
        JOptionPane.showMessageDialog((Component) view.getView(), "File not found.",
                "ERROR", JOptionPane.ERROR_MESSAGE);
      }
      
      throw new IllegalArgumentException("File not found.");
    }
  }
  
  /**
   * Returns the model with shapes and motions from a text file.
   * @return Animation, a populated model
   */
  public Animation getModel() {
    return this.model;
  }

}
