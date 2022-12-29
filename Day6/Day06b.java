package Day6;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Day06b {

  private static final String FILENAME = "/Users/main/Git_Projects/2022_advent-of-code/Day6/src/input.txt";

  public static void main(String[] args) {
    // Read each line in the input.txt file

    File file = new File(FILENAME);

    // Use a buffered reader to read each round invididually.

    try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
      int sum = 0;

      // We are iterating over
      while (true) {
        String line = bufferedReader.readLine();
        if (line == null) {
          // EOF!
          break;
        }

        // Create objects, if needed

        // Create in-between structures and use helper methods

        // Create summand
        // sum += ...;
      }
      System.out.println("Total sum = " + sum);

    } catch (IOException e) {
      e.printStackTrace();
    }

  }

  public static boolean allDifferent(char[] lastFour) {
    //
    String s = Arrays.toString(lastFour);
    int i = 0;
    int j = s.length() - 1;

    boolean flag = true;

    while (true) {
      if (i == s.length() - 1)
        break;
      // DUPLICATE FOUND
      if (i != j && s.charAt(i) == s.charAt(j)) {
        flag = false;
        break;
      } else {
        j--;
        // COMPARING DONE AGAINST i-TH CHAR TO ALL OTHER CHARS, INCREMENT i NOW
        if (j == 0) {
          j = s.length() - 1;
          i += 1;
        }
      }
    }

    return flag;
  }

}
