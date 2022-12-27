package Day2;

public enum Move {
  ROCK("A", "X", 1),
  PAPER("B", "Y", 2),
  SCISSORS("C", "Z", 3);

  private final String oppMoveString;
  private final String youMoveString;
  private final int score;

  Move(String oppMoveString, String youMoveString, int score) {
    this.oppMoveString = oppMoveString;
    this.youMoveString = youMoveString;
    this.score = score;
  }

  private String oppMoveString() {
    return oppMoveString;
  }

  private String youMoveString() {
    return youMoveString;
  }

  private int score() {
    return score;
  }

  public Move ifOppThenYouMove(Move opp) {
    switch (opp) {
      case ROCK:
        return PAPER;
      case PAPER:
        return SCISSORS;
      case SCISSORS:
        return ROCK;
      default:
        System.out.println("Error - not a valid move.\n");
        // Next best move is return the same move as opponent.
        return opp;
    }
  }
}
