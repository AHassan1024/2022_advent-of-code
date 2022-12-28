package Day3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Day03b {

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

  /** Given three Elf rucksacks, find the badge. */
  public static String getBadge(String s1, String s2, String s3) {
    StringBuilder s1s2b = new StringBuilder();
    // Find common items between s1 and s2:
    String iterator = (s1.length() < s2.length()) ? s1 : s2;
    String other = (iterator.equals(s2)) ? s1 : s2;
    for (int i = 0; i < iterator.length(); i++) {
      if (other.contains(Character.toString(iterator.charAt(i)))) {
        s1s2b.append(iterator.substring(i, i + 1));
      }
    }
    StringBuilder s1s2s3b = new StringBuilder();
    String s1s2 = s1s2b.toString();
    iterator = (s1s2.length() < s3.length()) ? s1s2 : s3;
    other = (iterator.equals(s3)) ? s1s2 : s3;
    for (int i = 0; i < iterator.length(); i++) {
      if (other.contains(Character.toString(iterator.charAt(i)))) {
        s1s2s3b.append(iterator.substring(i, i + 1));
      }
    }
    return s1s2s3b.toString();
  }

  public static void main(String[] args) {
    // Read each line in the input.txt file

    File file = new File(FILENAME);

    // Use a buffered reader to read each round invididually.

    try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
      int sum = 0;
      // We want to iterate over each group of three Elves.

      while (true) {
        String elf1 = bufferedReader.readLine();
        if (elf1 == null) {
          // EOF!
          break;
        }
        String elf2 = bufferedReader.readLine();
        if (elf2 == null) {
          // EOF!
          break;
        }
        String elf3 = bufferedReader.readLine();
        if (elf3 == null) {
          // EOF!
          break;
        }
        // Three Elves are elf1, elf2, elf3.

        String badge = getBadge(elf1, elf2, elf3);

        sum += getPriority(badge.charAt(0));
      }
      System.out.println("Total priorities = " + sum);

    } catch (IOException e) {
      e.printStackTrace();
    }

  }

}
