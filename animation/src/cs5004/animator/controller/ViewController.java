package cs5004.animator.controller;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import javax.swing.*;

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
 *
 */
public class ViewController implements Controller{
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
    this.playbackview = new PlaybackView();
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

  /**
   *
   * @param in
   * @param m
   */
  private void playback(HashMap<String, String> in, Animation m) {
    String fileInput = in.get("in").replace("\"", "");
    try {
      File demo = new File("./resources/files/" + fileInput);
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
   *
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
   *
   */
  class PlayAction implements Runnable {

    /**
     *
     */
    @Override
    public void run() {
      playbackview.setState("playing");
      playbackview.setPlayState();
    
    }
  }

  /**
   *
   */
  class PauseAction implements Runnable {

    /**
     *
     */
    @Override
    public void run() {
      playbackview.setState("paused");
      playbackview.setPauseState();
      
    }
  }

  /**
   *
   */
  class RewindAction implements Runnable {

    /**
     *
     */
    @Override
    public void run() {
      playbackview.setState("rewind");
      playbackview.changeCount(0);
      playbackview.setComponents();
      playbackview.changeRewindBg();
      playbackview.rewindTimer();
    }
  }

  /**
   *
   */
  class LoopAction implements Runnable {

    /**
     *
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
   *
   */
  class IncreaseSpeedAction implements Runnable {

    /**
     *
     */
    @Override
    public void run() {
      playbackview.setState("up speed");
      playbackview.increaseTick();
      playbackview.setComponents();
      playbackview.changeUpBg();
      playbackview.setTick();
      playbackview.restartimer();
    }
  }

  /**
   *
   */
  class DecreaseSpeedAction implements Runnable {

    /**
     *
     */
    @Override
    public void run() {
      playbackview.setState("down speed");
      playbackview.decreaseTick();
      playbackview.setComponents();
      playbackview.changeDownBg();
      playbackview.setTick();
      playbackview.slow();
      
    }
  }
}



