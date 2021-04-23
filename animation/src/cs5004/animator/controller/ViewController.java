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
public class ViewController implements Controller, ActionListener {
  private final Reader r;
  private final ViewFactory factory;
  private View view;
  private PlaybackView playbackview;
  private final String instr;
  private HashMap<String, Component> componentHashMap;
  private String state;
  private boolean loop;
  private int tick;
  private int length;
  private int count;
  
  /**
   *
    * @param instr
   */
  public ViewController(String instr) {
    this.r = new Reader();
    this.factory = new ViewFactory();
    this.instr = instr;
    this.count = 0;
    this.length = 0;
    this.loop = false;
    this.state = "play";
    
  }
  
  
  @Override
  public void go() {
    //Read inputs
    Scanner scan = new Scanner(instr.toString());
    //Parse Inputs
    String in = scan.nextLine();
    r.readIn(in);
    tick = Integer.parseInt(r.getInputs().get("speed"));
    length = r.getModel().getAnimationLength();
    
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
    componentHashMap = playbackview.getComponentHashMap();
    
    playbackview.animate();
    
  }
  
  @Override
  public void actionPerformed(ActionEvent e) {
    switch (e.getActionCommand()) {
      case "play":
        this.state = "play";
        JPanel btsnpanel = (JPanel) componentHashMap.get("btnspanel");
        for (Component c : btsnpanel.getComponents()) {
          c.setBackground(Color.WHITE);
        }
        componentHashMap.get("pause").setText("Pause");
        playpause.setIcon(new ImageIcon(new ImageIcon("./resources/icons/po.png").getImage()
                .getScaledInstance(20, 20, Image.SCALE_DEFAULT)));
        playpause.setActionCommand("pause");
        statetext.setText(String.valueOf(state).toUpperCase());
        
        break;
      case "pause":
        this.state = "paused";
        for (Component c : btnspanel.getComponents()) {
          if (c.isBackgroundSet()) {
            c.setBackground(Color.WHITE);
          }
        }
        
        playpause.setText("Play");
        playpause.setIcon(new ImageIcon(new ImageIcon("./resources/icons/pl.png").getImage()
                .getScaledInstance(20, 20, Image.SCALE_DEFAULT)));
        playpause.setActionCommand("play");
        statetext.setText(String.valueOf(state).toUpperCase());
        
        
        break;
      case "rewind":
        this.count = 0;
        this.state = "rewind";
        for (Component c : btnspanel.getComponents()) {
          if (c.isBackgroundSet()) {
            c.setBackground(Color.WHITE);
          }
        }
        swingtimer.stop();
        panel.removeAll();
        rewind.setBackground(Color.GREEN);
        swingtimer.restart();
        animate();
        
        
        break;
      case "up speed":
        this.state = "up speed";
        this.tick += 1;
        
        for (Component c : btnspanel.getComponents()) {
          if (c.isBackgroundSet()) {
            if (c.isBackgroundSet()) {
              c.setBackground(Color.WHITE);
            }
          }
        }
        up.setBackground(Color.YELLOW);
        speedtext.setText(String.valueOf(tick).toUpperCase());
        swingtimer.restart();
        animate();
        
        break;
      case "down speed":
        this.state = "down speed";
        if (tick == 1) {
          JOptionPane.showMessageDialog(this,
                  "Speed can't be less than 0",
                  "Speed warning",
                  JOptionPane.WARNING_MESSAGE);
          
        } else {
          this.tick -= 1;
          
          for (Component c : btnspanel.getComponents()) {
            if (c.isBackgroundSet()) {
              if (c.isBackgroundSet()) {
                c.setBackground(Color.WHITE);
              }
            }
          }
          down.setBackground(Color.YELLOW);
          speedtext.setText(String.valueOf(tick).toUpperCase());
          swingtimer.restart();
          animate();
        }
        
        break;
      case "loop":
        this.state = "loop";
        this.loop = !this.loop;
        for (Component c : btnspanel.getComponents()) {
          if (c.isBackgroundSet()) {
            c.setBackground(Color.WHITE);
          }
        }
        
        looper.setBackground(Color.RED);
        looptext.setText(String.valueOf(loop).toUpperCase());
        break;
    }
  }
}



