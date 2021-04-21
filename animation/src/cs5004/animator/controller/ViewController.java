package cs5004.animator.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import javax.swing.*;

import cs5004.animator.model.Animation;
import cs5004.animator.model.Shape;
import cs5004.animator.model.Transformation;
import cs5004.animator.view.GraphicView;
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
  
    View view = factory.create(in);
    r.readIn(in);
    //Get readbale and generate model
    r.makeModel(r.getInputs(), view);
    
    if (r.getInputs().get("view").equals("playback")) {
      PlaybackView frame = new PlaybackView((GraphicView) view);
      frame.makeFrame();
      view.animate(r.getModel(), r.getInputs());
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setVisible(true);
  
      try {
        // Set cross-platform Java L&F (also called "Metal")
        UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
    
        //UIManager.setLookAndFeel( UIManager.getSystemLookAndFeelClassName());
    
        //   UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
        //    UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        //    for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels())
        //    {
        //       if ("Nimbus".equals(info.getName())) {
        //          UIManager.setLookAndFeel(info.getClassName());
        //         break;
        //    }
        // }
      } catch (UnsupportedLookAndFeelException e) {
        // handle exception
      } catch (ClassNotFoundException e) {
        // handle exception
      } catch (InstantiationException e) {
        // handle exception
      } catch (IllegalAccessException e) {
        // handle exception
      } catch (Exception e) {
      }
    }
  
    //Animate
    view.animate(r.getModel(), r.getInputs());
  
  
  }
    
  }
