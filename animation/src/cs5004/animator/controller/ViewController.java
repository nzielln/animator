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
import cs5004.animator.view.MouseEventListener;
import cs5004.animator.view.PlaybackView;
import cs5004.animator.view.Reader;
import cs5004.animator.view.View;
import cs5004.animator.view.ViewFactory;

/**
 * The ViewController class represents a controller for the view. It implements the functionality
 * defined in the Controller interface and adds functionality for increasing and decreasing speed,
 * looping the animation, and play and pausing the animation.
 */
public class ViewController implements Controller {
  private final Reader r;
  private final ViewFactory factory;
  private View view;
  private final PlaybackView playbackview;
  private final String instr;
  private Animation model;
  private HashMap<String, String> inputs;
  private String state;
  
  /**
   * This is the constructor for the ViewController. It creates a new Reader, ViewFactory, and
   * PlaybackView objects. It takes int TODO
   * @param instr (string) the
   */
  public ViewController(String instr) {
    this.r = new Reader();
    this.inputs = new HashMap<>();
    this.factory = new ViewFactory();
    this.playbackview = new PlaybackView();
    this.instr = instr;
    
  }
  
  @Override
  public View getView() {
    
    return this.view;
  }
  
  @Override
  public PlaybackView getPlaybackView() {
    return this.playbackview;
  }
  
  @Override
  public void play() {
    Scanner scan = new Scanner(instr);
    String in = scan.nextLine();
    
    r.readIn(in);
    inputs = r.getInputs();
    
    if (inputs.get("view").equalsIgnoreCase("playback")) {
      
      playback(inputs, r.getModel());
      model = r.getModel();
      
    } else {
      
      view = factory.create(in);
      r.buildModel(view);
      model = r.getModel();
      view.animate(model, inputs);
      
    }
  }
  
  @Override
  public void exit() {
    if (inputs.get("view").equalsIgnoreCase("playback")) {
      playbackview.exitView();
      
    } else {
      view.exitView();
      
    }
  }
  
  /**
   * Creates an animation with the provided information and an animation model.
   * @param in (Hashmap of type String, String) a hashmap of -in, -out, -view, -speed information.
   * @param m (Animation) the specified Animation.
   */
  private void playback(HashMap<String, String> in, Animation m) {
    ButtonEvents btnevents;
    MouseEventListener mouseevents;

    String fileInput = in.get("in").replace("\"", "");
    
    try {

      File demo = new File(fileInput);
      FileReader f = new FileReader(demo);
      AnimationBuilder<Animation> b = new AnimationBuilderImpl(m);
      AnimationReader.parseFile(f, b);
      in.put("length", "" + m.getAnimationLength());
      playbackview.buildModel(m, in);
      btnevents = new ButtonEvents(playbackview);
      mouseevents = new MouseEventListener(playbackview);
      btnevents.configButtonListener();
      mouseevents.configMouseListener(this);
      playbackview.animate();
      
    } catch (FileNotFoundException e) {
      throw new IllegalArgumentException("File not found.");
      
    }
  }
  
  @Override
  public void removeShape(int x, int y) {
    if (this.playbackview.getInputs().size() == 0) {
      throw new IllegalStateException("Can only remove shape from a playback view.");
    }
    state = "Removing shape....";
    String name = model.clicked(x, y, playbackview.getCount());
    
    if (name != null) {
      
      model.removeShape(name);
      playbackview.updateModel(model);
      
    }
  }
  
  public String getState() {
    return this.state;
  }
  
}



