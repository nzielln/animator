package cs5004.animator.controller;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Scanner;

import javax.swing.*;

import cs5004.animator.model.Animation;
import cs5004.animator.util.AnimationBuilder;
import cs5004.animator.util.AnimationBuilderImpl;
import cs5004.animator.util.AnimationReader;
import cs5004.animator.view.PlaybackView;
import cs5004.animator.view.Reader;
import cs5004.animator.view.View;
import cs5004.animator.view.ViewFactory;

/**
 *
 */
public class ViewController implements Controller {
  private final Reader r;
  private final ViewFactory factory;
  private View view;
  private PlaybackView playbackview;
  private final String instr;
  
  /**
   *
    * @param instr
   */
  public ViewController(String instr) {
    this.r = new Reader();
    this.factory = new ViewFactory();
    this.instr = instr;
    
  }
  
  
  @Override
  public void go() {
    //Read inputs
    Scanner scan = new Scanner(instr.toString());
    //Parse Inputs
    String in = scan.nextLine();
    r.readIn(in);
    
    if (r.getInputs().get("view").equalsIgnoreCase("playback")) {
      playback(r.getInputs(), r.getModel());
    } else {
  
      view = factory.create(in);
      //Get readbale and generate model
      r.makeModel(r.getInputs(), view);
      //Animate
      view.animate();
    }
  }
  
  private void playback(HashMap<String, String> in, Animation m) {
    playbackview = new PlaybackView();
    String fileInput = in.get("in").replace("\"", "");
    try {
      File demo = new File("./resources/files/" + fileInput);
      FileReader f = new FileReader(demo);
      AnimationBuilder<Animation> b = new AnimationBuilderImpl(m);
      AnimationReader.parseFile(f, b);
      in.put("length", "" + m.getAnimationLength());
      playbackview.buildModel(m, in);
    } catch (FileNotFoundException e) {
      throw new IllegalArgumentException("File not found.");
    }
    playbackview.animate();
    
  }
  
}



