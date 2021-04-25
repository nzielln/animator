package cs5004.animator.view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.HashMap;
import java.util.Objects;
import java.util.List;
import java.util.Timer;

import javax.swing.*;

import cs5004.animator.model.Animation;
import cs5004.animator.model.Shape;
import cs5004.animator.model.AnimationImpl;

/**
 * JFrame for the animations for the Playback view. It implements functionality for users to
 * play/pause, rewind, speed up, slow down, and loop animations.
 */
public class PlaybackView extends JFrame {
  //main
  private Animation model;
  private HashMap<String, String> in;
  private int count;
  private int tick;
  private int length;
  private boolean loop;
  private String state;
  private Timer timer;
  private javax.swing.Timer swingtimer;
  
  private GraphicsPanel panel;
  private JScrollPane mainscroll;
  
  //playback panel
  private JPanel btnspanel;
  private JButton playpause;
  private JButton rewind;
  private JButton save;
  private JButton upload;
  private JButton up;
  private JButton down;
  private JButton looper;
  private String view;
  
  //state panel
  private JPanel statepanel;
  private JLabel speedlabel;
  private JLabel looplabel;
  private JLabel statelabel;
  private JLabel speedtext;
  private JLabel looptext;
  private JLabel statetext;
  private JPanel speedpanel;
  private JPanel looppanel;
  private JPanel pppanel;
  
  //menu for saving/uploading files
  private JMenuBar menubar;
  private JMenuBar menu;
  private JMenuItem savefile;
  private JMenuItem uploadfile;
  
  //File Choose
  private JFileChooser chooser;
  
  
  
  public PlaybackView() {
    super("Animation");
    this.view = "Playback";
    this.model = new AnimationImpl();
    this.in =  new HashMap<>();
    
  }

  /**
   *
   * @param m
   * @param in
   */
  public void buildModel(Animation m, HashMap<String, String> in) {
    this.model = m;
    this.in = in;
    this.loop = false;
    this.count = 0;
    this.state = "playing";
    this.tick = Integer.parseInt(in.get("speed"));
    this.length = Integer.parseInt(in.get("length"));
    
    int x = m.getCanvasX();
    int y = m.getCanvasY();
    int w = m.getCanvasWidth();
    int h = m.getCanvasHeight();
    
    setSize(w, h);
    setLocation(x, y);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLayout(new BorderLayout());
    
    panel = new GraphicsPanel(m.getByTime(0), model);
    panel.setPreferredSize(new Dimension(w, h));
    panel.setLocation(x,y);
    add(panel, BorderLayout.CENTER);
    mainscroll = new JScrollPane(panel);
    setPreferredSize(new Dimension(w, h));
    add(mainscroll, BorderLayout.CENTER);
    
    
    //state panel
    statepanel = new JPanel();
    statepanel.setLayout(new BoxLayout(statepanel, BoxLayout.X_AXIS));
    statepanel.setSize(new Dimension(w, 100));
    statepanel.setBackground(Color.white);
    statepanel.setAlignmentY(Component.CENTER_ALIGNMENT);
    add(statepanel, BorderLayout.NORTH);
    
    //create text panels
    speedpanel = new JPanel();
    speedpanel.setLayout(new BorderLayout());
    speedpanel.setAlignmentX(Component.CENTER_ALIGNMENT);
    speedpanel.setSize(new Dimension(50, 80));
    
    looppanel = new JPanel();
    looppanel.setLayout(new BorderLayout());
    looppanel.setAlignmentX(Component.CENTER_ALIGNMENT);
    looppanel.setSize(new Dimension(50, 80));
    
    pppanel = new JPanel();
    pppanel.setLayout(new BorderLayout());
    pppanel.setAlignmentX(Component.CENTER_ALIGNMENT);
    pppanel.setSize(new Dimension(50, 80));
    
    //create labels
    speedlabel = createLabelPnel("Current Speed", speedpanel.getWidth());
    looplabel = createLabelPnel("Looped", looppanel.getWidth());
    statelabel = createLabelPnel("Current State", pppanel.getWidth());
    
    //create labels' label
    speedtext = createLabelPnel(String.valueOf(tick).toUpperCase(), speedpanel.getWidth());
    looptext = createLabelPnel(String.valueOf(loop).toUpperCase(), looppanel.getWidth());
    statetext = createLabelPnel(state.toUpperCase(), pppanel.getWidth());
    
    pppanel.add(statelabel, BorderLayout.NORTH);
    pppanel.add(statetext, BorderLayout.SOUTH);
    
    speedpanel.add(speedlabel, BorderLayout.NORTH);
    speedpanel.add(speedtext, BorderLayout.SOUTH);
    
    looppanel.add(looplabel, BorderLayout.NORTH);
    looppanel.add(looptext, BorderLayout.SOUTH);
    
    
    statepanel.add(pppanel);
    statepanel.add(speedpanel);
    statepanel.add(looppanel);
    
    
    //buttonpanel
    btnspanel = new JPanel();
    btnspanel.setLayout(new BoxLayout(btnspanel, BoxLayout.X_AXIS));
    btnspanel.setSize(new Dimension(w, 80));
    btnspanel.setBackground(Color.white);
    btnspanel.setAlignmentY(Component.CENTER_ALIGNMENT);
    add(btnspanel, BorderLayout.SOUTH);
    
    btnspanel.add(Box.createHorizontalGlue());
    upload = createButton("Upload File", "uplo.png", "upload");
    rewind = createButton("Rewind", "re.png", "rewind");
    up = createButton("Increase Speed", "up.png", "up speed");
    playpause = createButton("Pause ", "po.png", "pause");
    down = createButton("Decrease Speed", "down.png", "down speed");
    looper = createButton("Loop", "Asset 1.png", "loop");
    save = createButton("Save File", "save.png", "save");
    btnspanel.add(Box.createHorizontalGlue());
    
    //Files
    chooser = new JFileChooser();
    
    //set visible
    mainscroll.setVisible(true);
    panel.setVisible(true);
    btnspanel.setVisible(true);
    setVisible(true);
    
    //btnspanel.add(output);
  }

  //Animation Action

  /**
   *
   */
  private class AnimateAction implements ActionListener {
    
    @Override
    public void actionPerformed(ActionEvent e) {
      if (count > length) {
        count = length;
      }
      List<Shape> modified = model.getByTime(count);
      currentView(modified);
      if (state.equals("paused")) {
        count = count;
        
      } else {
        count += 1;
      }
      //If loop is on, reset the count to 0 so the animation can start again
      if (loop) {
        looper.setBackground(Color.GREEN);
        if (count == length) {
          count = 0;
        }
      }
    }
  }

  /**
   *
   */
  public void animate() {
    Object[] options = {"Play Animation", "Exit Animation"};
    int pane = JOptionPane.showOptionDialog(this,
            "Use the buttons on the screen or your keyboard to control the animation.\n"
                    + "UP - Increase Speed\n"
                    + "DOWN - Decrease Speed\n"
                    + "LEFT - Rewind\n"
                    + "RIGHT - Loop\n"
                    + "SPACE - Play/Pause\n",
            "Playback Animation",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.PLAIN_MESSAGE,
            null,
            options,
            options[0]);
    
    if (pane == JOptionPane.NO_OPTION) {
      System.exit(0);
    }
  
    
    swingtimer = new javax.swing.Timer(1000 / tick, new AnimateAction());
    swingtimer.setInitialDelay(1000);
    swingtimer.start();
    // timer.schedule(new AnimateTask(), count, 1000 / tick);
    
  }

  /**
   *
   */
  public void slowanimate() {
    swingtimer = new javax.swing.Timer((1000 / tick) + 1000, new AnimateAction());
    swingtimer.setInitialDelay(1000);
    swingtimer.start();
    // timer.schedule(new AnimateTask(), count, 1000 / tick);
    
  }

  /**
   * Gets the current frame a point in time.
   * @param frame (int) the specific time point.
   */
  private void getFrame(int frame) {
    
    List<Shape> modified = this.model.getByTime(frame);
    this.currentView(modified);
    
  }

  /**
   * Updates the view panel with the new list of shapes and states from the animation.
   * @param m (List<Shape>) a list of shapes at a particular time in the animation.
   */
  public void currentView(List<Shape> m) {
    Objects.requireNonNull(m, "Model can't be null");
    
    this.panel.updateModel(m);
    this.repaint();
    
  }
  
  public HashMap<String, String> getInputs() {
    return in;
  }
  
  /**
   * Creates a JButton object for the view.
   * @param name (String) the name of the button.
   * @param file (String) the name of the image file for the button.
   * @param command (String) the command to set the action for.
   * @return
   */
  private JButton createButton(String name, String file, String command) {
    ImageIcon img = new ImageIcon(new ImageIcon("../icons/" + file).getImage()
            .getScaledInstance(20, 20, Image.SCALE_DEFAULT));
    
    JButton btn = new JButton(name, img);
    
    btn.setPreferredSize(new Dimension(100, 80));
    btn.setMinimumSize(getSize());
    btn.setAlignmentX(Component.CENTER_ALIGNMENT);
    btn.setAlignmentY(Component.CENTER_ALIGNMENT);
    btn.setVerticalTextPosition(AbstractButton.BOTTOM);
    btn.setHorizontalTextPosition(AbstractButton.CENTER);
    btn.setActionCommand(command);
    btn.setOpaque(true);
    btn.setBorderPainted(false);
    
    btnspanel.add(btn);
    
    return btn;
  }

  /**
   * Creates a text label for the panel.
   * @param text (String) the text to put in the panel.
   * @param width (int) the width of the panel
   * @return
   */
  private JLabel createLabelPnel(String text, int width) {
    JLabel l = new JLabel(text, JLabel.CENTER);
    l.setSize(new Dimension(width, 40));
    
    
    return l;
  }
  

  /**
   * Adds an action listener to each of the buttons (play/pause, increase, decrease, loop, rewind).
   * @param al (ActionListener) action listener object for each of the buttons.
   */
  public void addListener(ActionListener al) {
    playpause.addActionListener(al);
    up.addActionListener(al);
    down.addActionListener(al);
    looper.addActionListener(al);
    rewind.addActionListener(al);
    save.addActionListener(al);
    upload.addActionListener(al);
  }

  /**
   * Sets the play/pause button to play. Shows the paused icon if the user wants to pause the
   * animation.
   */
  public void setPlayState() {
    setComponents();
    playpause.setText("Pause");
    playpause.setIcon(new ImageIcon(new ImageIcon("../icons/po.png").getImage()
            .getScaledInstance(20, 20, Image.SCALE_DEFAULT)));
    playpause.setActionCommand("pause");
    statetext.setText(String.valueOf(state).toUpperCase());
    
  }

  /**
   * Sets the play/pause button to paused. Shows the play icon if the user wants the animation to
   * play again.
   */
  public void setPauseState() {
    setComponents();
    playpause.setText("Play");
    playpause.setIcon(new ImageIcon(new ImageIcon("../icons/pl.png").getImage()
            .getScaledInstance(20, 20, Image.SCALE_DEFAULT)));
    playpause.setActionCommand("play");
    statetext.setText(String.valueOf(state).toUpperCase());
    
  }

  /**
   * Sets the status of looping to the viewer frame.
   */
  public void setLoop() {
    looptext.setText(String.valueOf(loop).toUpperCase());
    
  }

  /**
   * Sets the speed of the tick to the viewer frame.
   */
  public void setTick() {
    speedtext.setText(String.valueOf(tick).toUpperCase());
  }

  /**
   * Sets the state.
   * @param s (state) the new state.
   */
  public void setState(String s) {
    this.state = s;
  }

  /**
   * Sets the count for the animation to the new count.
   * @param i (int) the new count that the animation should be at.
   */
  public void changeCount(int i) {
    this.count = i;
  }

  /**
   * Changes the status of loop.
   */
  public void loop() {
    this.loop = !loop;
  }

  /**
   * Increases the tick speed.
   */
  public void increaseTick() {
    this.tick += 1;
    swingtimer.setDelay(1000 / tick);
  }

  /**
   * Decreases the tick speed. Shows error message when the tick is at 1 and trying to decrease.
   */
  public void decreaseTick() {
    if (tick == 1) {
      JOptionPane.showMessageDialog(this,
              "Speed can't be less than 0",
              "Speed warning",
              JOptionPane.WARNING_MESSAGE);
    
    } else {
      this.tick -= 1;
    }
    swingtimer.setDelay(1000 / tick);
  }

  /**
   * Sets the background of each of the components of the button pannel to white.
   */
  public void setComponents() {
    for (Component c : btnspanel.getComponents()) {
        c.setBackground(Color.WHITE);
    }
  }

  /**
   * Sets delay for the rewind timer.
   */
  public void rewindTimer() {
    swingtimer.setDelay(1000 / tick);
  }

  /**
   * Changes the background of the rewind button.
   */
  public void changeRewindBg() {
    rewind.setBackground(Color.YELLOW);
  }

  /**
   * Changes the background of the increase speed button.
   */
  public void changeUpBg() {
    up.setBackground(Color.YELLOW);
  }

  /**
   * Changes the background of the decrease speed button.
   */
  public void changeDownBg() {
    down.setBackground(Color.YELLOW);
  }

  /**
   * Changes the background of the loop button.
   */
  public void changeLoopBg() {
    looper.setBackground(Color.YELLOW);
  }

  /**
   * Exits the current view.
   */
  public void exitView() {
    System.exit(0);
  }
  
  public String getCurrentState() {
    return state;
  }
  
  public void updateModel(Animation m) {
    this.model = m;
  }
  /**
   * Exits the current view.
   */
  public void resetFocus() {
    this.setFocusable(true);
    this.requestFocus();
  }
  
  //Methods for Saving/Upload Files
  public File openFile() {
    upload.setBackground(Color.GREEN);
    chooser.setDialogTitle("Upload A .txt File.");
    if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
      return chooser.getSelectedFile();
    }
    
    return null;
  }
  
  public File saveFile() {
    save.setBackground(Color.GREEN);
    chooser.setDialogTitle("Save Animation as a Text or SVG File.");
    if (chooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
      return chooser.getSelectedFile();
    }
    
    return null;
  }
}
