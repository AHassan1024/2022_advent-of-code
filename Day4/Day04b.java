package Day4;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Day04b {

  private static final String FILENAME = "/Users/main/Git_Projects/2022_advent-of-code/Day4/src/input.txt";

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

}
