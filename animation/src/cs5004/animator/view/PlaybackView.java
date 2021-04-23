package cs5004.animator.view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.HashMap;
import java.util.Objects;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import cs5004.animator.model.Animation;
import cs5004.animator.model.Shape;
import cs5004.animator.model.AnimationImpl;

public class PlaybackView extends JFrame {
  //main
  private Animation model;
  private HashMap<String, String> in;
  private HashMap<String, Component> componentHashMap;
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
  
  public PlaybackView() {
    super("Animation");
    this.view = "Playback";
    this.model = new AnimationImpl();
    this.in =  new HashMap<>();
    
  }
  
  
  public void buildModel(Animation m, HashMap<String, String> in) {
    this.model = m;
    this.in = in;
    this.loop = false;
    this.count = 0;
    this.state = "play";
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
    panel.setPreferredSize(new Dimension(w, 650));
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
    componentHashMap.put("speedlabel", speedlabel);
    looplabel = createLabelPnel("Looped", looppanel.getWidth());
    componentHashMap.put("looplabel", looplabel);
    statelabel = createLabelPnel("Current State", pppanel.getWidth());
    componentHashMap.put("statelabel", statelabel);
    
    //create labels' label
    speedtext = createLabelPnel(String.valueOf(tick).toUpperCase(), speedpanel.getWidth());
    componentHashMap.put("speedtext", speedtext);
    looptext = createLabelPnel(String.valueOf(loop).toUpperCase(), looppanel.getWidth());
    componentHashMap.put("looptext", looptext);
    statetext = createLabelPnel(state.toUpperCase(), pppanel.getWidth());
    componentHashMap.put("statetext", statetext);
    
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
    rewind = createButton("Rewind", "re.png", "rewind");
    up = createButton("Increase Speed", "up.png", "up speed");
    playpause = createButton("Pause ", "po.png", "pause");
    down = createButton("Decrease Speed", "down.png", "down speed");
    looper = createButton("Loop", "Asset 1.png", "loop");
    btnspanel.add(Box.createHorizontalGlue());
    
    //timer
    //timer = new Timer();
  
    componentHashMap.put("panel", panel);
    componentHashMap.put("mainscroll", mainscroll);
    componentHashMap.put("statepanel", statepanel);
    componentHashMap.put("btnpanel", btnspanel);
    componentHashMap.put("speedpanel", speedpanel);
    componentHashMap.put("looppanel", looppanel);
    componentHashMap.put("pppanel", pppanel);
    
    //set visible
    mainscroll.setVisible(true);
    panel.setVisible(true);
    btnspanel.setVisible(true);
    setVisible(true);
    
    //btnspanel.add(output);
  }
  
  //Animation Task
  
  private class AnimateTask extends TimerTask {
    private AnimateTask() {
      super();
    }
    
    @Override
    public void run() {
      
      if (count > length) {
        timer.cancel();
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
        if (count == length) {
          count = 0;
        }
      }
      
    }
  }
  
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
        if (count == length) {
          count = 0;
        }
      }
      
    }
  }
  
  
  
  public void animate() {
    swingtimer = new javax.swing.Timer(1000 / tick, new AnimateAction());
    swingtimer.setInitialDelay(1000);
    swingtimer.start();
    // timer.schedule(new AnimateTask(), count, 1000 / tick);
    
  }
  
  private void getFrame(int frame) {
    
    List<Shape> modified = this.model.getByTime(frame);
    this.currentView(modified);
    
  }
  
  public void currentView(List<Shape> m) {
    Objects.requireNonNull(m, "Model can't be null");
    
    this.panel.updateModel(m);
    this.repaint();
    
  }
  
  private JButton createButton(String name, String file, String command) {
    ImageIcon img = new ImageIcon(new ImageIcon("./resources/icons/" + file).getImage()
            .getScaledInstance(20, 20, Image.SCALE_DEFAULT));
    
    JButton btn = new JButton(name, img);
    
    btn.setPreferredSize(new Dimension(100, 80));
    btn.setMinimumSize(getSize());
    btn.setAlignmentX(Component.CENTER_ALIGNMENT);
    btn.setAlignmentY(Component.CENTER_ALIGNMENT);
    btn.setVerticalTextPosition(AbstractButton.BOTTOM);
    btn.setHorizontalTextPosition(AbstractButton.CENTER);
    //TODO btn.addActionListener(this);
    btn.setActionCommand(command);
    btn.setOpaque(true);
    btn.setBorderPainted(false);
    
    btnspanel.add(btn);
    componentHashMap.put(command, btn);
    
    return btn;
  }
  
  private JLabel createLabelPnel(String text, int width) {
    JLabel l = new JLabel(text, JLabel.CENTER);
    l.setSize(new Dimension(width, 40));
    
    
    return l;
  }
  
  public HashMap<String, Component> getComponentHashMap() {
    return componentHashMap;
  }

  
}
