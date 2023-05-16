package utils;

import java.util.Scanner;

public class Finals {

  public static Scanner scan = new Scanner(System.in);

  public static final String CLEAN = "\033[H\033[2J";

  public static final String RED = "\u001B[31m";
  public static final String GREEN = "\u001B[32m";
  public static final String BLUE = "\u001B[36m";
  public static final String RESET = "\u001B[0m";
  public static final String HOME_MENU =
    """
    Welcome to the Medeiros Car station!
    What do you want to do?
    1 - Consult
    2 - Register
    3 - Update
    4 - Delete
    0 - Exit""";
  public static final String ACTION_MENU =
    """
    You want to do this with:
    1 - Car
    2 - Owner
    0 - Return""";
  public static final String TYPE_MENU =
    """
    You want to do this by:
    1 - ID
    2 - Get all
    0 - Return""";
}
