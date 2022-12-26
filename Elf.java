public class Elf implements Comparable<Elf> {
  int calories;

  Elf() {
    // Constructor of Elf class
    calories = 0;
  }

  Elf(int calories) {
    if (calories < 1) {
      System.err.println("Incorrect calories input! (< 1)");
    }
    this.calories = calories;
  }

  public void addMoreCalories(int more) {
    this.calories += more;
  }

  public int getCalories() {
    return calories;
  }

  // @Override
  public String toString() {
    return "This Elf carries " + calories + " calories.";
  }

  // // @Override
  // public int compare(Elf e1, Elf e2) {
  // return e1.calories - e2.calories;
  // }

  @Override
  // max first
  public int compareTo(Elf e) {
    return (this.calories > e.calories) ? -1 : ((calories == e.calories) ? 0 : 1);
  }

}
