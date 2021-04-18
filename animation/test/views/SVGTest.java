package views;

import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

import cs5004.animator.model.Animation;
import cs5004.animator.view.View;
import cs5004.animator.view.ViewFactory;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.fail;

public class SVGTest {
  private ViewFactory factory;
  
  @Test
  public void testView() {
    factory = new ViewFactory();
    try {
      String in = "-in smalldemo.txt -view visual -speed 2";
      View v = factory.create(in);
    
      assertEquals("Visual", v.getView());
    } catch (Exception e) {
      fail("Exception should not be thrown.");
    }
  
    //different order
    try {
      String in = "-speed 2 -view visual -in smalldemo.txt";
      View v = factory.create(in);
    
      assertEquals("Visual", v.getView());
    } catch (Exception e) {
      fail("Exception should not be thrown.");
    }
  
    try {
      String in2 = "-in smalldemo.txt -view text";
      View v2 = factory.create(in2);
      assertEquals("Text", v2.getView());
    } catch (Exception e) {
      fail("Exception should not be thrown.");
    }
  
    try {
      String in3 = "-in smalldemo.txt -view svg -out s.svg";
      View v3 = factory.create(in3);
      assertEquals("SVG", v3.getView());
    } catch (Exception e) {
      fail("Exception should not be thrown.");
    }
  

  }
  
  @Test
  public void testViewBadInputs() {
    
    //File not found - text
    try {
      String in = "-in smalldmo.txt -view text";
      View v = factory.create(in);
  
      fail("Exception should be thrown");
    } catch (Exception ignored) {
    }
  
    //File not found - svg
    try {
      String in = "-in smalldmo.txt -view svg -speed 2";
      View v = factory.create(in);
    
      fail("Exception should be thrown");
    } catch (Exception ignored) {
    }
  
    //File not found - visual
    try {
      String in = "-in smalldmo.txt -view visual -speed 2";
      View v = factory.create(in);
    
      fail("Exception should be thrown");
    } catch (Exception ignored) {
    }
  
    //no in file
    try {
      String in = "-speed 2 -view text";
      View v = factory.create(in);
    
      fail("Exception should be thrown");
    } catch (Exception ignored) {
    }
  
    //no out file - svg
    try {
      String in = "-in smalldemo.txt -view svg";
      View v = factory.create(in);
    
      fail("Exception should be thrown");
    } catch (Exception ignored) {
    }
    
    
  }
  
  @Test
  public void emptyFile() throws FileNotFoundException {
    factory = new ViewFactory();
    String in = "-in empty.txt -view svg -speed 2 -out out.svg";
    View v = factory.create(in);
    v.readInputs(in);
    v.getReadable();
    v.animate();
    StringBuilder s = new StringBuilder();
    File demo = new File("./src/cs5004/animator/outfiles/out.svg");
    FileReader f = new FileReader(demo);
    Scanner scan = new Scanner(f).useDelimiter("\n");
    
    while(scan.hasNext()) {
      s.append(scan.next()).append("\n");
    }
    
    //Empty file should only print this, not animation information
    assertEquals("<svg width=\"0\" height=\"0\" version=\"1.1\""
            + " \n\txmlns=\"http://www.w3.org/2000/svg\">\n\n\n\n</svg>", s.toString().trim());
    
  }
  
  
  @Test
  public void smalldemoSvg() throws FileNotFoundException {
    factory = new ViewFactory();
    String in = "-in smalldemo.txt -view svg -speed 2 -out out.svg";
    View v = factory.create(in);
    v.readInputs(in);
    v.getReadable();
    v.animate();
    StringBuilder s = new StringBuilder();
    File demo = new File("./src/cs5004/animator/outfiles/out.svg");
    FileReader f = new FileReader(demo);
    Scanner scan = new Scanner(f).useDelimiter("\n");
  
    while(scan.hasNext()) {
      s.append(scan.next()).append("\n");
    }
  
    assertEquals("<svg width=\"360\" height=\"360\" version=\"1.1\" \n\t"
            + "xmlns=\"http://www.w3.org/2000/svg\">\n\n"
            + "<rect id=\"R\" x=\"200\" y=\"200\" width=\"50\" height=\"100\" fill=\"rgb(255,0,0)\" visibility=\"visible\" >\n"
            + "\t<animate attributeType=\"xml\" begin=\"5s\" dur=\"20s\" attributeName=\"x\" from=\"200\" to=\"300\" fill=\"freeze\" />\n"
            + "\t<animate attributeType=\"xml\" begin=\"5s\" dur=\"20s\" attributeName=\"y\" from=\"200\" to=\"300\" fill=\"freeze\" />\n"
            + "\t<animate attributeType=\"xml\" begin=\"25s\" dur=\"9s\" attributeName=\"width\" from=\"50\" to=\"25\" fill=\"freeze\" />\n"
            + "\t<animate attributeType=\"xml\" begin=\"25s\" dur=\"9s\" attributeName=\"height\" from=\"100\" to=\"100\" fill=\"freeze\" />\n"
            + "\t<animate attributeType=\"xml\" begin=\"35s\" dur=\"15s\" attributeName=\"x\" from=\"300\" to=\"200\" fill=\"freeze\" />\n"
            + "\t<animate attributeType=\"xml\" begin=\"35s\" dur=\"15s\" attributeName=\"y\" from=\"300\" to=\"200\" fill=\"freeze\" />\n"
            + "</rect>\n\n"
            + "<ellipse id=\"C\" cx=\"440\" cy=\"70\" rx=\"120\" ry=\"60\" fill=\"rgb(0,0,255)\" visibility=\"visible\" >\n"
            + "\t<animate attributeType=\"xml\" begin=\"10s\" dur=\"15s\" attributeName=\"cx\" from=\"440\" to=\"440\" fill=\"freeze\" />\n"
            +  "\t<animate attributeType=\"xml\" begin=\"10s\" dur=\"15s\" attributeName=\"cy\" from=\"70\" to=\"250\" fill=\"freeze\" />\n"
            + "\t<animate attributeType=\"xml\" begin=\"25s\" dur=\"10s\" attributeName=\"cx\" from=\"440\" to=\"440\" fill=\"freeze\" />\n"
            + "\t<animate attributeType=\"xml\" begin=\"25s\" dur=\"10s\" attributeName=\"cy\" from=\"250\" to=\"370\" fill=\"freeze\" />\n"
            + "\t<animate attributeType=\"xml\" begin=\"25s\" dur=\"10s\" attributeName=\"fill\" from=\"rgb(0,0,255)\" to=\"rgb(0,170,85)\" fill=\"freeze\" />\n"
            + "\t<animate attributeType=\"xml\" begin=\"35s\" dur=\"5s\" attributeName=\"fill\" from=\"rgb(0,170,85)\" to=\"rgb(0,255,0)\" fill=\"freeze\" />\n"
            + "</ellipse>\n\n"
            + "\n\n</svg>", s.toString().trim());
  
  
  
  
  }
  
}
