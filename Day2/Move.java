package Day2;

public enum Move {
  ROCK("A", "X", 1),
  PAPER("B", "Y", 2),
  SCISSORS("C", "Z", 3);

  private final char oppMovechar;
  private final char youMovechar;
  private final int score;

  Move(char oppMovechar, char youMovechar, int score) {
    this.oppMovechar = oppMovechar;
    this.youMovechar = youMovechar;
    this.score = score;
  }

  private int points(Move opp, Move you) {
    // Calculate the points scored in this round
    int outcome;
    if (opp == you) {
      // draw
      outcome = 3;
    } else if (you == ifOppThenYouMove(opp)) {
      // you win
      outcome = 6;
    } else {
      // you lose
      outcome = 0;
    }

    // shape you selected + outcome of the round
    return you.score + outcome;
  }

  private Move toMove(char in) {
    switch (in) {
      case 'A', 'X':
        return ROCK;
      case 'B', 'Y':
        return PAPER;
      case 'C', 'Z':
        return SCISSORS;
      default:
        break;
    }
  }

  private char oppMovechar() {
    return oppMovechar;
  }

  private char youMovechar() {
    return youMovechar;
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
