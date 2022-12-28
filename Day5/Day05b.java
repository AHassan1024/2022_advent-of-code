package Day5;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

public class Day05b {

  private static final String FILENAME = "/Users/main/Git_Projects/2022_advent-of-code/Day5/src/input.txt";

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
        LinkedList<Character>[] cratesInEachStack = new LinkedList[stacks];
        for (int i = 0; i < stacks; i++) {
          cratesInEachStack[i] = new LinkedList<Character>();
        }

        while (!line.isEmpty()) {
          // Either ...[X], or ints
          // Initialise the Stacks here.
          if (line.contains("[")) {
            // This line contains crates.
            int currStack = 0;
            for (int i = 1; i < line.length(); i += 4) {
              if (line.charAt(i) == ' ') {
                // There are no crates in this position.
                // do nothing?

              } else if ("ABCDEFGHIJKLMNOPQRSTUVWXYZ".contains(line.substring(i, i + 1))) {
                // Add these crates to the LinkedLists.
                cratesInEachStack[currStack].add(line.charAt(i));
              }
              // Every 4th char is either a \s, or an [A-Z] character.
              currStack++;
            }
          }
          // Stacks have been initialised

          line = bufferedReader.readLine();
        }

        // Uncomment this to check the stacks!
        // for (int i = 0; i < stacks; i++) {
        // // Iterate through each stack,
        // // look at all the crates in all the linked lists.
        // System.out.println(cratesInEachStack[i].toString());
        // }

        LinkedList<String> instructions = new LinkedList<String>();

        if (line.isEmpty()) {
          line = bufferedReader.readLine();
          while (line != null) {
            instructions.add(line);
            line = bufferedReader.readLine();
          } // we have a full ordered LinkedList of instructions
        }
        // Both the starting state and instructions have been encoded.

        // Create in-between structures and use helper methods
        // Break down the instructions into helper methods
        while (!instructions.isEmpty()) {
          // Each instruction is in the format:
          // move $1 from $2 to $3
          // Iterate over $1-1, and do:
          // move(fromStack - 1, toStack - 1);
          String[] current = instructions.poll().split(" ");
          // current[0] = "move",
          // current[1] = "1",
          // current[2] = "from",
          // current[3] = "2",
          // current[4] = "to",
          // current[5] = "1"

          move(Integer.parseInt(current[1]), Integer.parseInt(current[3]), Integer.parseInt(current[5]),
              cratesInEachStack);
        } // Now, each instruction has been fulfilled.

        // Finally, let's create a string with the top crate of each stack:
        for (LinkedList<Character> stack : cratesInEachStack) {
          char first = stack.peek();
          top += first;
        }
      }
      System.out.println("Crates at the top of each stack: " + top);

    } catch (IOException e) {
      e.printStackTrace();
    }

  }

  private static void move(int many, int fromStack, int toStack, LinkedList<Character>[] cratesInEachStack) {
    LinkedList<Character> crates = new LinkedList<>();
    // Populates the crates that need moving, e.g. crates = {(C) -> (M)}
    for (int i = 0; i < many; i++) {
      // Retrieve the head, and remove from the stack
      char crate = (Character) cratesInEachStack[fromStack - 1].poll();
      // add to the tail of the LinkedList
      crates.add(crate);
    }

    LinkedList<Character> moveToStack = (LinkedList<Character>) cratesInEachStack[toStack - 1];

    crates.addAll(moveToStack);
    cratesInEachStack[toStack - 1] = crates;

  }
}
