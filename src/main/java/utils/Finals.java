package utils;

import java.util.Scanner;

public class Finals {

  public static Scanner scan = new Scanner(System.in);

  public static final String CLEAN = "\033[H\033[2J";

  public static final String RESET = "\u001B[0m";
  public static final String HOME_MENU = """
      Welcome to the Medeiros Car station!
      What do you want to do?
      1 - Consult
      2 - Register
      3 - Update
      4 - Delete
      Dev (5 - Seed Sqlite Data)
      0 - Exit""";
  public static final String ACTION_MENU = """
      You want to do this with:
      1 - Car
      2 - Owner
      0 - Return""";
  public static final String TYPE_MENU = """
      You want to do this by:
      1 - ID
      2 - Get all
      0 - Return""";

  // Regular Colors
  public static final String BLACK = "\033[0;30m"; // BLACK
  public static final String RED = "\033[0;31m"; // RED
  public static final String GREEN = "\033[0;32m"; // GREEN
  public static final String YELLOW = "\033[0;33m"; // YELLOW
  public static final String BLUE = "\033[0;34m"; // BLUE
  public static final String PURPLE = "\033[0;35m"; // PURPLE
  public static final String CYAN = "\033[0;36m"; // CYAN
  public static final String WHITE = "\033[0;37m"; // WHITE

  // Bold
  public static final String BLACK_BOLD = "\033[1;30m"; // BLACK
  public static final String RED_BOLD = "\033[1;31m"; // RED
  public static final String GREEN_BOLD = "\033[1;32m"; // GREEN
  public static final String YELLOW_BOLD = "\033[1;33m"; // YELLOW
  public static final String BLUE_BOLD = "\033[1;34m"; // BLUE
  public static final String PURPLE_BOLD = "\033[1;35m"; // PURPLE
  public static final String CYAN_BOLD = "\033[1;36m"; // CYAN
  public static final String WHITE_BOLD = "\033[1;37m"; // WHITE
}
