package Day6;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Day06a {

  private static final String FILENAME = "/Users/main/Git_Projects/2022_advent-of-code/Day6/src/test_input.txt";

  private static final int PACKET = 4;

  public static void main(String[] args) {
    // Read each line in the input.txt file

    File file = new File(FILENAME);

    // Use a buffered reader to read each round invididually.

    try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
      String inputString = bufferedReader.readLine();

      int i = 0;
      while ((i < inputString.length() - PACKET + 1) && (!allDifferent(inputString.substring(i, i + 4)))) {
        i++;
      }
      System.out.println(i);

      // Create objects, if needed

      // Create in-between structures and use helper methods

      // System.out.println("Total sum = " + sum);

    } catch (IOException e) {
      e.printStackTrace();
    }

  }

  private static boolean allDifferent(String four) {
    int i = 0;
    int j = four.length() - 1;

    boolean diff = false;
    while (true) {
      if (i == four.length() - 1) {
        break;
      }

      if (i != j && (four.charAt(i) == four.charAt(j))) {
        diff = true;
        break;
      } else {
        j--;
        if (j == 0) {
          j = four.length() - 1;
          i++;
        }
      }
    }
    return diff;
  }
}