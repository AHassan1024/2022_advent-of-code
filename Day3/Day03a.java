package Day3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Day03a {

  private static final String FILENAME = "/Users/main/Git_Projects/2022_advent-of-code/Day3/day03/input.txt";

  public static int getPriority(char c) {
    if (c >= 'a' && c <= 'z') {
      return c - 'a' + 1;
    } else if (c >= 'A' && c <= 'Z') {
      return c - 'A' + 1 + 26;

    } else {
      return 0;
    }

  }

  public static void main(String[] args) {
    // Read each line in the input.txt file

    File file = new File(FILENAME);

    // Use a buffered reader to read each round invididually.

    try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
      int sum = 0;

      while (true) {
        String line = bufferedReader.readLine();
        if (line == null) {
          // EOF!
          break;
        }
        if (line.length() % 2 != 0) {
          // line is not in the correct format
          break;
        }

        int container_length = line.length() / 2;
        // We can now create a Rucksack
        // Break down each line into a Rucksack, with two String containers
        Rucksack rucksack = new Rucksack(line.substring(0, container_length), line.substring(container_length));

        // Compare the two container strings to create a priority character
        String misplacedItems = rucksack.misplacedItems();

        // Uncomment below to check Rucksack contents.
        // System.out.println(rucksack + "has misplaced: " + misplacedItems);

        // Convert each priority character into int
        // Sum the priorities
        sum += getPriority(misplacedItems.charAt(0));
      }
      System.out.println("Total priorities = " + sum);

    } catch (IOException e) {
      e.printStackTrace();
    }

  }

}
