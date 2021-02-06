package com.example.CapstoneBackend.HelperClasses;

public class CustomExceptions {

  /**
   * This class holds all the exceptions we will throw to the user
   */

   //EXCEPTION FOR WHEN SOMETHING ISN'T FOUND
  public static class NotFoundException extends RuntimeException
  {
    private static final long serialVersionUID = 1L;

      public NotFoundException(String objectName) {
        super(objectName.concat(" was not found."));
      }
  }

  //EXCEPTION FOR DELETING SOMETHING
  public static class NoDeleteException extends RuntimeException
  {
    private static final long serialVersionUID = 1L;

      public NoDeleteException(String objectName) {
        super(objectName.concat(" could not be deleted."));
      }
  }
  

  //WHEN YOU WANNA ADD SOMETHIN TO DB AND THERES AN ERROR
  public static class CreationException extends RuntimeException
  {
    private static final long serialVersionUID = 1L;

      public CreationException(String objectName) {
        super(objectName.concat(" could not be created."));
      }
  }



}
