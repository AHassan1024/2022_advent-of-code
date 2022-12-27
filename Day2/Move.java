package Day2;

public enum Move {
  ROCK("ROCK", 1),
  PAPER("PAPER", 2),
  SCISSORS("SCISSORS", 3);

  // private final char oppMovechar;
  // private final char youMovechar;
  private String name;
  private final int score;

  Move(String name, int score) {
    this.name = name;
    this.score = score;
  }

  // Move(char oppMovechar, char youMovechar) {
  // this.oppMovechar = oppMovechar;
  // this.youMovechar = youMovechar;
  // this.score = points(toMove(oppMovechar), toMove(youMovechar));

  public int score() {
    return score;
  }

}
