package Day6;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Day06b {

  private static final String FILENAME = "/Users/main/Git_Projects/2022_advent-of-code/Day6/src/input.txt";

  private static final int PACKET = 14;

  public static void main(String[] args) {
    // Read each line in the input.txt file

    File file = new File(FILENAME);

    // Use a buffered reader to read each round invididually.

    try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
      String inputString = bufferedReader.readLine();

      for (int i = 0, j = PACKET; j < inputString.length(); i++, j++) {
        if (allDifferent(inputString.substring(i, j))) {
          System.out.println(j);
          break;
        }
      }
      // System.out.println(i);

      // Create objects, if needed

      // Create in-between structures and use helper methods

      // System.out.println("Total sum = " + sum);

    } catch (IOException e) {
      e.printStackTrace();
    }

  }

  private static boolean allDifferent(String four) {
    return (four.chars().distinct().count() == four.length());
  }
}