package cs5004.animator.view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;
import java.util.List;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import cs5004.animator.model.Animation;
import cs5004.animator.model.Shape;
import cs5004.animator.model.AnimationImpl;

public class PlaybackView extends JFrame implements ActionListener, ItemListener, ListSelectionListener {
  private GraphicsPanel panel;
  private JPanel btnspanel;
  private JScrollPane mainscroll;
  private JButton play;
  private JButton pause;
  private JButton rewind;
  private JButton fast;
  private JButton looper;
  private String view;
  private Animation model;
  private HashMap<String, String> in;
  private int count;
  private int tick;
  private boolean loop;
  private String state;
  private JLabel output;
  
  public PlaybackView() {
    super("Animation");
    this.view = "Playback";
    this.model = new AnimationImpl();
    this.in =  new HashMap<>();
    
  }
  
  
  
  public void buildModel(Animation m, HashMap<String, String> in) {
    this.model = m;
    this.in = in;
    int x = m.getCanvasX();
    int y = m.getCanvasY();
    int w = m.getCanvasWidth();
    int h = m.getCanvasHeight();
    
    setSize(w, h);
    setLocation(x, y);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLayout(new BorderLayout());
    setVisible(true);
    
    panel = new GraphicsPanel(m.getByTime(0), model);
    panel.setPreferredSize(new Dimension(w, h));
    panel.setLocation(x, y);
    add(panel, BorderLayout.CENTER);
    mainscroll = new JScrollPane(panel);
    setPreferredSize(new Dimension(w, h));
    add(mainscroll, BorderLayout.CENTER);
    
    setVisible(true);
    panel.setVisible(true);
    mainscroll.setVisible(true);
    
    btnspanel = new JPanel();
    btnspanel.setLayout(new BoxLayout(btnspanel, BoxLayout.PAGE_AXIS));
    btnspanel.setSize(new Dimension(500, 200));
    btnspanel.setBackground(Color.lightGray);
    btnspanel.setVisible(true);
    add(btnspanel, BorderLayout.PAGE_END);
    
    play = createButton("Play", "pl.png", "play");
    pause = createButton("Pause", "po.png", "pause");
    rewind = createButton("Rewind", "re.png", "rewind");
    fast = createButton("Fast Foward", "fo.png", "foward");
    looper = createButton("Loop", "fo.png", "loop");
  
    output = new JLabel("Output goes here.");
    output.setBorder(BorderFactory.createLineBorder(Color.red));
    
    btnspanel.add(output);
  }
  
  public void animate(int t, boolean l, int c) {
    this.count = c;
    this.tick = t;
    this.loop = l;
    
    List<Shape> model = new ArrayList<>(this.model.getShapes());
  
    int lengthAnimation = 0;
    
    //get the total length of the animation
    for (Shape shape : model) {
      if (shape.getDisappears() > lengthAnimation) {
        lengthAnimation = shape.getDisappears();
      }
    }
    
    //do we get how long the animation is from the user at all? Does this need to be <= or <?
    while (count < lengthAnimation) {
      List<Shape> modified = this.model.getByTime(count);
      
      //update the animation and model to newModel
      //update count
      this.currentView(modified);
      count += 1;
      //If loop is on, reset the count to 0 so the animation can start again
      if (loop) {
        if (count == lengthAnimation) {
          count = 0;
        }
      }
      
      //Timer to let user see changes
      try {
        Thread.sleep(1000 / tick);
      } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
      }
    }
  
  }
  
  private void getFrame(int frame) {
    
    //do we get how long the animation is from the user at all? Does this need to be <= or <?
    List<Shape> modified = this.model.getByTime(frame);
      
      //update the animation and model to newModel
      //update count
    this.currentView(modified);
    
  }
  
  public void currentView(List<Shape> m) {
    Objects.requireNonNull(m, "Model can't be null");
    
    this.panel.updateModel(m);
    this.repaint();
    
  }
  
  private JButton createButton(String name, String file, String command) {
    ImageIcon img = new ImageIcon(new ImageIcon("./resources/icons/pl.png").getImage()
            .getScaledInstance(50, 50, Image.SCALE_DEFAULT));
    
    JButton btn = new JButton(name, img);
    
    btn.setPreferredSize(new Dimension(150, 30));
    btn.setMinimumSize(getSize());
    btn.setAlignmentX(Component.CENTER_ALIGNMENT);
    btn.setAlignmentY(Component.CENTER_ALIGNMENT);
    btn.setVerticalTextPosition(AbstractButton.BOTTOM);
    btn.setHorizontalTextPosition(AbstractButton.CENTER);
    btn.addActionListener(this);
    btn.setActionCommand(command);
    
    btnspanel.add(btn);
    
    return btn;
  }
  
  @Override
  public void actionPerformed(ActionEvent e) {
    switch (e.getActionCommand()) {
      case "play":
        this.state = "play";
        
        animate(tick, loop, count);
        this.revalidate();
        this.repaint();
        break;
      case "pause":
        this.state = "pause";
        while (e.getActionCommand().equals("pause")) {
          getFrame(count);
        }
        this.revalidate();
        this.repaint();
        break;
      case "rewind":
        this.count = 0;
        this.state = "rewind";
        animate(tick, loop, count);
        this.revalidate();
        this.repaint();
        
        break;
      case "forward":
        this.state = "forward";
        this.tick += 1;
        
        animate(tick, loop, count);
        this.revalidate();
        this.repaint();
        break;
      case "loop":
        this.state = "loop";
        this.loop = !this.loop;
        animate(tick, loop, count);
        this.revalidate();
        this.repaint();
    
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
