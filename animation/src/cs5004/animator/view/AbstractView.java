package cs5004.animator.view;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import javax.swing.*;

import cs5004.animator.model.Animation;
import cs5004.animator.model.AnimationImpl;
import cs5004.animator.model.Shape;
import cs5004.animator.util.AnimationBuilder;
import cs5004.animator.util.AnimationBuilderImpl;
import cs5004.animator.util.AnimationReader;

public abstract class AbstractView implements View {
  HashMap<String, String> inputs;
  Animation model;
  
  public AbstractView() {
    this.inputs = new HashMap<>();
    this.model = new AnimationImpl();
  }
  
  @Override
  public void animate() {
  
  }
  
  @Override
  public void currentView(List<Shape> shapes) {
  }
  
  @Override
  public void readInputs(String in) {
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
      throw new IllegalArgumentException("You must provide an \"-view\" type.");
    
    } else if (this.inputs.get("view").equalsIgnoreCase("SVG")) {
      if (this.inputs.get("out") == null || this.inputs.get("out").equals("")) {
        throw new IllegalArgumentException("You must provide an \"-out\" file.");
      }
      
    }
  
  }
  
  @Override
  public void buildModel(FileReader f)  {
    AnimationBuilder<Animation> b = new AnimationBuilderImpl(model);
    AnimationReader.parseFile(f, b);
  }
  
  @Override
  public void getReadable() throws FileNotFoundException {
    String fileInput = this.inputs.get("in").replace("\"", ""); //from the CLI - should have a method for this??
    String filename = "./src/cs5004/animator/files/" + fileInput;
    try {
      File demo = new File(filename);
      FileReader f = new FileReader(demo);
      buildModel(f);
    } catch (Exception e) {
      throw new FileNotFoundException("File not found.");
    }
  
  
  }
}
