package Day3;

public class Rucksack {
  private String container1;
  private String container2;

  Rucksack(String container1, String container2) {
    this.container1 = container1;
    this.container2 = container2;
  }

  @Override
  public String toString() {
    return "Rucksack: [" + container1 + ", " + container2 + "]";
  }

  public String misplacedItems() {
    StringBuilder misplaced = new StringBuilder();
    String iterateString = (this.container1.length() < this.container2.length()) ? (this.container1)
        : (this.container2);
    String otherString = (iterateString == this.container1) ? this.container2 : this.container1;
    for (int i = 0; i < iterateString.length(); i++) {
      if (otherString.contains(iterateString.substring(i, i + 1))) {
        misplaced.append(Character.toString(iterateString.charAt(i)));
      }
    }
    return misplaced.toString();
  }

}
