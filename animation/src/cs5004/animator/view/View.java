package cs5004.animator.view;


import java.util.HashMap;
import java.util.List;

import cs5004.animator.model.Animation;
import cs5004.animator.model.Shape;

/**
 * View interface, represents model implemented by each view.
 */
public interface View {
  
  /**
   * Returns the type of view.
   * @return String, type of view.
   */
  String getViewType();
  
  /**
   * Returns the view object, where applicable.
   * @return View, the view object.
   */
  View getView();
  
  /**
   * Starts the animation using information from the HashMap of inputs and generated mdoel.
   */
  void animate();
  
  
  /**
   * Builds a JFrame model using information from the model.
   * @param m Animation, the model for the animation
   */
  void buildModel(Animation m, HashMap<String, String> in) throws UnsupportedOperationException;
  
  /**
   * Updates the view for the GraphicView, takes in a list of shapes.
   * @param shapes list, a list of shapes for update the current frame of the JFrame.
   */
  void currentView(List<Shape> shapes) throws UnsupportedOperationException;

  /**
   * Exits the current view.
   */
  void exitView();
  
  
}
