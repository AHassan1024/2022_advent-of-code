package Day5;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Day05a {

  private static final String FILENAME = "/Users/main/Git_Projects/2022_advent-of-code/Day5/src/test_input.txt";

  public static void main(String[] args) {
    // Read each line in the input.txt file

    File file = new File(FILENAME);

    // Use a buffered reader to read each round invididually.

    try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
      // Final output is the crate at the top of each Stack.
      String top = "";

      // We are iterating over each line
      while (true) {
        String line = bufferedReader.readLine();
        if (line == null) {
          // EOF!
          break;
        }

        // Create objects, if needed
        int stacks = (line.length() + 1) / 4;
        Stack[] cratesInEachStack = new Stack[stacks];
        for (int i = 0; i < stacks; i++) {
          cratesInEachStack[i] = new Stack<Character>();
          System.out.println("Created Stack #" + (i + 1));
        }
        System.out.println("Number of stacks: " + stacks);

        while (!line.isEmpty()) {
          // Either ...[X], or ints
          // Initialise the Stacks here.
          if (line.contains("[")) {
            // This line contains crates.
          }
          //
          // line = line.replaceAll("\\s", "");
          System.out.println(line);
          line = bufferedReader.readLine();
        }

        Queue<String> instructions = new LinkedList<>();

        if (line.isEmpty()) {
          line = bufferedReader.readLine();
          while (line != null) {
            instructions.add(line);
            line = bufferedReader.readLine();
          } // we have a full ordered Queue of instructions
        }
        // Both the starting state and instructions have been encoded.

        // Create in-between structures and use helper methods

        // Create summand
        // sum += ...;
      }
      // System.out.println("Crates at the top of each stack: " + top);

    } catch (IOException e) {
      e.printStackTrace();
    }

  }

}
