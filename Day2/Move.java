package Day2;

public enum Move {
  ROCK,
  PAPER,
  SCISSORS;

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
