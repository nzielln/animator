package cs5004.animator.controller;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import javax.swing.*;

import cs5004.animator.view.ButtonListener;
import cs5004.animator.view.PlaybackView;

class ButtonEvents {
  private final PlaybackView playbackview;
  private File file;
  private Controller controller;
  
  ButtonEvents(PlaybackView p) {
    this.playbackview = p;
  }
  
  
  /**
   * The configButtonListener creates new button listeners for the play/pause, rewind, loop, and
   * up and down speed functionality.
   */
  public void configButtonListener() {
    Map<String, Runnable> buttonsmap = new HashMap<>();
    ButtonListener bs = new ButtonListener();
    
    buttonsmap.put("play", new PlayAction());
    buttonsmap.put("pause", new PauseAction());
    buttonsmap.put("rewind", new RewindAction());
    buttonsmap.put("loop", new LoopAction());
    buttonsmap.put("down speed", new DecreaseSpeedAction());
    buttonsmap.put("up speed", new IncreaseSpeedAction());
    buttonsmap.put("save", new Save());
    buttonsmap.put("upload", new Upload());
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
      playbackview.resetFocus();
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
      playbackview.resetFocus();
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
      playbackview.resetFocus();
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
      playbackview.resetFocus();
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
      playbackview.resetFocus();
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
      playbackview.resetFocus();
      
    }
  }
  
  class Save implements Runnable {
    
    /**
     * Tells the view and model to decrease the speed of the animation.
     */
    @Override
    public void run() {
      playbackview.setComponents();
      String f = playbackview.saveFile().getName();
      String ext = f.substring(f.lastIndexOf(".") + 1);
      
      if (!(ext.equals("txt") || ext.equals("svg"))) {
        Object[] options = {"Try Again", "Cance"};
        int pane = JOptionPane.showOptionDialog(playbackview,
                "Only .txt and .svg file accepted.",
                "Invalid File Name",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.PLAIN_MESSAGE,
                null,
                options,
                options[0]);
        
        if (pane == JOptionPane.YES_OPTION) {
          run();
        }
      }
      
      HashMap<String, String> in = playbackview.getInputs();
      in.put("out", f);
      StringBuilder instr = new StringBuilder();
      
      if (ext.equals("txt")) {
        in.replace("view", "text");
      } else if (ext.equals("svg")) {
        in.replace("view", "svg");
      }
      
      for (String s : in.keySet()) {
        if (!s.equals("length")) {
          instr.append("-").append(s).append(" ").append(in.get(s)).append(" ");
        }
      }
      System.out.println(instr.toString());
      controller = new ViewController(instr.toString());
      controller.go();
    }
  }
  class Upload implements Runnable {
    
    /**
     * Tells the view and model to decrease the speed of the animation.
     */
    @Override
    public void run() {
      playbackview.setComponents();
      File f = playbackview.openFile();
      System.out.println(f.getName());
      
      
    }
  }
  
  
}
