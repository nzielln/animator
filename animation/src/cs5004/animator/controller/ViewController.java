package cs5004.animator.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


import cs5004.animator.model.Animation;
import cs5004.animator.util.AnimationBuilder;
import cs5004.animator.util.AnimationBuilderImpl;
import cs5004.animator.util.AnimationReader;
import cs5004.animator.view.ButtonListener;
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
      configButtonListener();
      playbackview.animate();
    } catch (FileNotFoundException e) {
      throw new IllegalArgumentException("File not found.");
    }
  }


  /**
   * The configButtonListener creates new button listeners for the play/pause, rewind, loop, and
   * up and down speed functionality.
   */
  private void configButtonListener() {
    Map<String, Runnable> buttonsmap = new HashMap<>();
    ButtonListener bs = new ButtonListener();

    buttonsmap.put("play", new PlayAction());
    buttonsmap.put("pause", new PauseAction());
    buttonsmap.put("rewind", new RewindAction());
    buttonsmap.put("loop", new LoopAction());
    buttonsmap.put("down speed", new DecreaseSpeedAction());
    buttonsmap.put("up speed", new IncreaseSpeedAction());
    bs.setButtonClickedActionMap(buttonsmap);

    playbackview.addListener(bs);
  }


  /**
   * The PlayAction class represents the view playing the animation.
   */
  class PlayAction implements Runnable {

    /**
     * This runs the animation to start playing.
     */
    @Override
    public void run() {
      playbackview.setState("playing");
      playbackview.setPlayState();
    }
  }

  /**
   * The PausedAction represents the view pausing the animation.
   */
  class PauseAction implements Runnable {

    /**
     * This sets the view to pausing the animation.
     */
    @Override
    public void run() {
      playbackview.setState("paused");
      playbackview.setPauseState();
    }
  }

  /**
   * The RewindAction represents the view rewinding the animation to the beginning again.
   */
  class RewindAction implements Runnable {

    /**
     * Rewinds the animation to the beginning.
     */
    @Override
    public void run() {
      playbackview.setState("rewind");
      playbackview.changeCount(0);
      playbackview.setComponents();
      playbackview.changeRewindBg();
      playbackview.rewindTimer();
      playbackview.setPlayState();
    }
  }

  /**
   * LoopAction is a class that sets the view to loop through the animation over and over again.
   */
  class LoopAction implements Runnable {

    /**
     * Keeps looping through the animation until the user requests to stop.
     */
    @Override
    public void run() {
      playbackview.setState("loop");
      playbackview.loop();
      playbackview.setComponents();
      playbackview.changeLoopBg();
      playbackview.setLoop();
    }
  }

  /**
   * A class that represents an increase speed action.
   */
  class IncreaseSpeedAction implements Runnable {

    /**
     * Tells the view to increase the speed.
     */
    @Override
    public void run() {
      playbackview.setState("up speed");
      playbackview.increaseTick();
      playbackview.setComponents();
      playbackview.changeUpBg();
      playbackview.setTick();
    }
  }

  /**
   * A class that represents a decrease speed action.
   */
  class DecreaseSpeedAction implements Runnable {

    /**
     * Tells the view and model to decrease the speed of the animation.
     */
    @Override
    public void run() {
      playbackview.setState("down speed");
      playbackview.decreaseTick();
      playbackview.setComponents();
      playbackview.changeDownBg();
      playbackview.setTick();
      
    }
  }
}



