package cs5004.animator.view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import cs5004.animator.model.Animation;
import cs5004.animator.model.Shape;

/**
 * A PlaybackViewPractice class that extends JFrame and implements the Playback interface.
 */
public class PlaybackViewPractice extends JFrame implements ActionListener, ItemListener, ListSelectionListener {
  private JButton play;
  private JButton pause;
  private JLabel output;
  private JPanel panel;
  private JScrollPane scroll;
  private String view;
  //ASSIGNMENT 8
  
  /**
   *
   */
  public PlaybackViewPractice() {
    super("Animation");
    setSize(400, 400);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setBackground(Color.BLUE);
    panel = new JPanel();
    panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
    panel.setVisible(true);
    panel.setSize(new Dimension(300, 300));
    panel.setBackground(Color.PINK);
    scroll = new JScrollPane(panel);
    scroll.setVisible(true);
    add(panel, BorderLayout.CENTER);
    add(scroll);
    
  
    ImageIcon pla = new ImageIcon(new ImageIcon("./resources/icons/pl.png").getImage()
            .getScaledInstance(50, 50, Image.SCALE_DEFAULT));
  
    this.view = "Playback";
    play = new JButton("Play", pla);
    play.setPreferredSize(new Dimension(150, 30));
    play.setMinimumSize(getSize());
    play.setAlignmentX(Component.CENTER_ALIGNMENT);
    play.setAlignmentY(Component.CENTER_ALIGNMENT);
    play.setVerticalTextPosition(AbstractButton.BOTTOM);
    play.setHorizontalTextPosition(AbstractButton.CENTER);
  
    ImageIcon pau = new ImageIcon(new ImageIcon("./resources/icons/po.png").getImage()
            .getScaledInstance(50, 50, Image.SCALE_DEFAULT));
  
    this.view = "Playback";
    pause = new JButton("Play", pau);
    pause.setPreferredSize(new Dimension(150, 30));
    pause.setMinimumSize(getSize());
    pause.setAlignmentX(Component.CENTER_ALIGNMENT);
    pause.setAlignmentY(Component.CENTER_ALIGNMENT);
    pause.setVerticalTextPosition(AbstractButton.BOTTOM);
    pause.setHorizontalTextPosition(AbstractButton.CENTER);
    
    play.addActionListener(this);
    play.setActionCommand("play");
  
    pause.addActionListener(this);
    pause.setActionCommand("pause");
    
    output = new JLabel("Output goes here.");
    output.setBorder(BorderFactory.createLineBorder(Color.red));
    
    panel.add(play);
    panel.add(pause);
    panel.add(output);
    
    
    setVisible(true);
  
  }
  
  
  
  @Override
  public void actionPerformed(ActionEvent e) {
    switch (e.getActionCommand()) {
      case "play" -> output.setText("You cliked play!");
      case "pause" -> output.setText("You cliked pause!");
      default -> output.setText("What??");
    }
    
  }
  
  @Override
  public void itemStateChanged(ItemEvent e) {
  
  }
  
  @Override
  public void valueChanged(ListSelectionEvent e) {
  
  }
}
