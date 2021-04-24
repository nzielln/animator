package cs5004.animator.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Scanner;


import cs5004.animator.model.Animation;
import cs5004.animator.util.AnimationBuilder;
import cs5004.animator.util.AnimationBuilderImpl;
import cs5004.animator.util.AnimationReader;
import cs5004.animator.view.PlaybackView;
import cs5004.animator.view.Reader;
import cs5004.animator.view.View;
import cs5004.animator.view.ViewFactory;

/**
 * The ViewController class represents a controller for the view. It implements the functionality
 * defined in the Controller interface and adds functionality for increasing and decreasing speed,
 * looping the animation, and play and pausing the animation.
 */
public class ViewController implements Controller{
  private final Reader r;
  private final ViewFactory factory;
  private View view;
  private PlaybackView playbackview;
  private final String instr;
  private ButtonEvents btnevents;
  private KeyboardEvents keyevents;

  /**
   * This is the constructor for the ViewController. It creates a new Reader, ViewFactory, and
   * PlaybackView objects. It takes int TODO
   * @param instr (string) the
   */
  public ViewController(String instr) {
    this.r = new Reader();
    this.factory = new ViewFactory();
    this.playbackview = new PlaybackView();
    this.instr = instr;

  }



  @Override
  public View getView() {
    return this.view;
  }

  @Override
  public PlaybackView getPlaybackview() {
    return this.playbackview;
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

  @Override
  public void exit() {
    if (r.getInputs().get("view").equalsIgnoreCase("playback")) {
      playbackview.exitView();
    } else {
      view.exitView();
    }
  }

  /**
   * Creates an animation with the provided information and an animation model.
   * @param in (Hashmap<String, String>) a hashmap of -in, -out, -view, -speed information.
   * @param m (Animation) the specified Animation.
   */
  private void playback(HashMap<String, String> in, Animation m) {
    String fileInput = in.get("in").replace("\"", "");
    try {
      File demo = new File(fileInput);
      FileReader f = new FileReader(demo);
      AnimationBuilder<Animation> b = new AnimationBuilderImpl(m);
      AnimationReader.parseFile(f, b);
      in.put("length", "" + m.getAnimationLength());
      playbackview.buildModel(m, in);
      btnevents = new ButtonEvents(playbackview);
      keyevents = new KeyboardEvents(playbackview);
      btnevents.configButtonListener();
      keyevents.configureKeyboardListener();
      playbackview.animate();
    } catch (FileNotFoundException e) {
      throw new IllegalArgumentException("File not found.");
    }
  }
  
  
  
}



