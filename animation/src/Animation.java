public interface Animation {
  
  /**
   *
   * @param s
   */
  void addShape(ShapeNode s);
  
  /**
   *
   * @param s
   */
  void removeShape(ShapeNode s);
  
  /**
   *
   * @param id
   * @return
   */
  ShapeNode getById(String id);
  
  /**
   *
   * @param t
   * @return
   */
  ShapeNode getByTime(int t);
}
