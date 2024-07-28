// ModelFactory.java
package uk.ac.ucl.model;

public class ModelFactory {

  private static Model modelInstance;

  public static Model getModel() {
    if (modelInstance == null) {
      modelInstance = new Model();
    }
    return modelInstance;
  }
}
