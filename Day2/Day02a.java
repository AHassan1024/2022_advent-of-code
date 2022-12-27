package Day2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Day02a {

  private static final String FILENAME = "/Users/main/Git_Projects/2022_advent-of-code/Day2/day02a/input.txt";

  public static void main(String[] args) {

    File file = new File(FILENAME);

    // Use a buffered reader to read each round invididually.

    try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {

      while (true) {
        String round = bufferedReader.readLine();
        // new object round with two moves?
        if (round == null) {
          // EOF!
          break;
        }

        // we now start the rounds ...

      }

    } catch (IOException e) {
      e.printStackTrace();
    }

  }

}
