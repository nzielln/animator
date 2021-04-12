package cs5004.animator.view;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Scanner;
import cs5004.animator.model.Animation;

public class AbstractView implements View {
  HashMap<String, String> inputs;
  
  public AbstractView() {
    this.inputs = new HashMap<>();
  }
  
  @Override
  public HashMap<String, String> readInputs(String inputs) {
    Scanner scan = new Scanner(inputs);
    
    while (scan.hasNext()) {
      String next = scan.next();
      if (next.equals("-in")) {
        this.inputs.put("in", scan.next());
      } else if (next.equals("-out")) {
        this.inputs.put("out", scan.next());
      } else if (next.equals("-view")) {
        this.inputs.put("view", scan.next());
      } else if (next.equals("-speed")) {
        this.inputs.put("speed", scan.next());
        
      }
    }
    return this.inputs;
  }
  
  @Override
  public FileReader getReadable() throws FileNotFoundException {
    String fileInput = this.inputs.get("in").replace("\"", ""); //from the CLI - should have a method for this??
    String filename = "src/cs5004/animator/files/" + fileInput;
    File demo = new File(filename);
    FileReader f = new FileReader(demo);
    
    return f;
  
  }
  
  @Override
  public void animate(Animation model) {
  
  }
}
