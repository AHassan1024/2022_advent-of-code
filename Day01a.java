import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Day01a {

  public static int calorieCount = 0;
  public static List<Integer> caloriesList = new ArrayList<>();

  private static final String FILENAME = "/Users/main/Git_Projects/2022_advent-of-code/day01a/input.txt";

  public static void main(String[] pArgs) throws IOException {

    File file = new File(FILENAME);

    try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
      List<Elf> allElvesList = new ArrayList<Elf>();

      Elf currentElf = new Elf();

      while (true) {
        String tmp = bufferedReader.readLine();

        if (tmp == null) {
          // EOF!
          // add the current Elf to the list of elves, and break.
          if (currentElf.calories != 0) {
            allElvesList.add(currentElf);
          }
          break;
        } else if (tmp.isEmpty()) {
          // newline!

          /**
           * The current elf is already up to date;
           * we just have to add it to the list if
           * it has any calories!
           **/
          if (currentElf.calories != 0) {
            allElvesList.add(currentElf);
          }
          currentElf = new Elf();

        } else {
          // String! (of ints)
          int calories = Integer.parseInt(tmp);
          currentElf.addMoreCalories(calories);
        }
      }

      if (!allElvesList.isEmpty()) {
        Collections.sort(allElvesList);
        System.out.println(allElvesList.get(0));
      }
    }
  }

}