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

public class PlaybackView extends JFrame implements ActionListener, ItemListener, ListSelectionListener {
  //main
  private Animation model;
  private HashMap<String, String> in;
  private int count;
  private int tick;
  private int length;
  private boolean loop;
  private String state;
  private Timer timer;
  
  private GraphicsPanel panel;
  private JScrollPane mainscroll;
  
  //playback panel
  private JPanel btnspanel;
  private JButton playpause;
  private JButton rewind;
  private JButton fast;
  private JButton looper;
  private String view;
  
  //state panel
  private JPanel statepanel;
  private JLabel speedlabel;
  private JLabel looplabel;
  private JLabel statelabel;
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
    
    setSize(1000, 1000);
    setLocation(0, 0);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLayout(new BorderLayout());
    
    panel = new GraphicsPanel(m.getByTime(0), model);
    panel.setPreferredSize(new Dimension(1000, 800));
    panel.setLocation(0,0);
    add(panel, BorderLayout.CENTER);
    mainscroll = new JScrollPane(panel);
    setPreferredSize(new Dimension(w, h));
    add(mainscroll, BorderLayout.CENTER);
    
    //state panel
    statepanel = new JPanel();
    statepanel.setLayout(new BoxLayout(statepanel, BoxLayout.X_AXIS));
    statepanel.setSize(new Dimension(1000, 100));
    statepanel.setBackground(Color.white);
    statepanel.setAlignmentY(Component.CENTER_ALIGNMENT);
    add(statepanel, BorderLayout.NORTH);
    
    //buttonpanel
    btnspanel = new JPanel();
    btnspanel.setLayout(new BoxLayout(btnspanel, BoxLayout.X_AXIS));
    btnspanel.setSize(new Dimension(1000, 100));
    btnspanel.setBackground(Color.lightGray);
    btnspanel.setAlignmentY(Component.CENTER_ALIGNMENT);
    add(btnspanel, BorderLayout.SOUTH);
  
    btnspanel.add(Box.createHorizontalGlue());
    rewind = createButton("Rewind", "re.png", "rewind");
    playpause = createButton("Pause ", "po.png", "pause");
    fast = createButton("Speed", "forward.png", "speed");
    looper = createButton("Loop", "Asset 1.png", "loop");
    btnspanel.add(Box.createHorizontalGlue());
    
    //timer
    timer = new Timer();
  
    
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
    timer.schedule(new AnimateTask(), count, 1000 / tick);
  
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
    btn.addActionListener(this);
    btn.setActionCommand(command);
    btn.setOpaque(true);
    btn.setBorderPainted(false);
    
    btnspanel.add(btn);
    
    return btn;
  }
  
  @Override
  public void actionPerformed(ActionEvent e) {
    switch (e.getActionCommand()) {
      case "play":
        this.state = "play";
        for (Component c : btnspanel.getComponents()) {
          c.setBackground(Color.WHITE);
        }
        playpause.setText("Pause");
        playpause.setIcon(new ImageIcon(new ImageIcon("./resources/icons/po.png").getImage()
                .getScaledInstance(20, 20, Image.SCALE_DEFAULT)));
        playpause.setActionCommand("pause");
        
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
        
        
        break;
      case "rewind":
        this.count = 0;
        this.state = "rewind";
        for (Component c : btnspanel.getComponents()) {
          if (c.isBackgroundSet()) {
            c.setBackground(Color.WHITE);
          }
        }
        rewind.setBackground(Color.GREEN);
        
        break;
      case "speed":
        this.state = "speed";
        this.tick += 1;
        for (Component c : btnspanel.getComponents()) {
          if (c.isBackgroundSet()) {
            if (c.isBackgroundSet()) {
              c.setBackground(Color.WHITE);
            }
          }
        }
        fast.setBackground(Color.YELLOW);
        
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
        break;
    }
  }
  
  @Override
  public void itemStateChanged(ItemEvent e) {
  
  }
  
  @Override
  public void valueChanged(ListSelectionEvent e) {
  
  }
}
