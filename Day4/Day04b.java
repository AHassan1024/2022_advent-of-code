package Day4;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

public class Day04b {

  private static final String FILENAME = "/Users/main/Git_Projects/2022_advent-of-code/Day4/src/input.txt";

  public static void main(String[] args) {
    // Read each line in the input.txt file

    File file = new File(FILENAME);

    // Use a buffered reader to read each round invididually.

    try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
      int pairs = 0;

      // We are iterating over
      while (true) {
        String line = bufferedReader.readLine();
        if (line == null) {
          // EOF!
          break;
        }

        // Translate line into two Elf assignments:
        String[] assignments = line.split(",");
        // a List of what the first Elf got assigned,
        // eg. [2, 3, 4]
        List<Integer> elf1 = createAssignmentArray(assignments[0]);

        // a List of what the second Elf got assigned
        // eg. [2, 3, 4, 5]
        List<Integer> elf2 = createAssignmentArray(assignments[1]);

        // Using the two elf1, elf2 List assignments, check if the shorter one is
        // within the longer one using amIContained method

        // Create summand
        pairs += (amIContained(elf1, elf2)) ? 1 : 0;
      }
      System.out.println("Total fully contained pairs = " + pairs);

    } catch (IOException e) {
      e.printStackTrace();
    }

  }

  /**
   * Given both List assignments, return whether one contains the other
   * E.g. "2-4", returns assignment1 as {2, 3, 4}
   */
  private static boolean amIContained(List<Integer> elf1, List<Integer> elf2) {
    List<Integer> iterate = (elf1.size() < elf2.size()) ? elf1 : elf2;
    List<Integer> other = (iterate.equals(elf2)) ? elf1 : elf2;
    boolean contains = true;
    for (Integer i : iterate) {
      // Show false if any Integer is not in the longer one
      contains = contains && other.contains(i);
    }
    return contains;
  }

  /**
   * Given a String assigment, return it as a List
   * E.g. "2-4", returns assignment1 as {2, 3, 4}
   */
  private static List<Integer> createAssignmentArray(String assigned) {
    List<Integer> assignedArray = new ArrayList<Integer>();
    int begin = Integer.parseInt(assigned.split("-")[0]);
    int end = Integer.parseInt(assigned.split("-")[1]);

    for (int i = begin; i <= end; i++) {
      assignedArray.add(i);
    }
    return assignedArray;
  }

}
