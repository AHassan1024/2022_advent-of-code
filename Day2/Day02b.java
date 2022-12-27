package Day2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Day02b {

  private static final String FILENAME = "/Users/main/Git_Projects/2022_advent-of-code/Day2/day02a/input.txt";

  public static Move toWin(Move opp) {
    switch (opp) {
      case ROCK:
        return Move.PAPER;
      case PAPER:
        return Move.SCISSORS;
      case SCISSORS:
        return Move.ROCK;
      default:
        // Error - not a valid move.
        // Next best move is return the same move as opponent.
        return opp;
    }
  }

  public static Move toLose(Move opp) {
    switch (opp) {
      case ROCK:
        return Move.SCISSORS;
      case PAPER:
        return Move.ROCK;
      case SCISSORS:
        return Move.PAPER;
      default:
        // Error - not a valid move.
        // Next best move is return the same move as opponent.
        return opp;
    }
  }

  public static int points(Move opp, Move you) {
    // Calculate the points scored in this round
    int outcome;
    if (opp == you) {
      // draw
      outcome = 3;
    } else if (you == toWin(opp)) {
      // you win
      outcome = 6;
    } else {
      // you lose
      outcome = 0;
    }

    // shape you selected + outcome of the round
    return you.score() + outcome;
  }

  public static Move createMove(char moveChar) {
    switch (moveChar) {
      case 'A':
        return Move.ROCK;
      case 'B':
        return Move.PAPER;
      case 'C':
      default:
        return Move.SCISSORS;
    }
  }

  public static Move findYourMove(Move oppMove, char outcome) {
    switch (outcome) {
      case 'X':
        return toLose(oppMove);
      case 'Z':
        return toWin(oppMove);
      case 'Y':
      default:
        return oppMove;
    }

  }

  public static void main(String[] args) {

    File file = new File(FILENAME);

    // Use a buffered reader to read each round invididually.

    try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
      int sum = 0;

      while (true) {
        String round = bufferedReader.readLine();
        if (round == null) {
          // EOF!
          break;
        }
        if (round.length() != 3) {
          // Round is not in the correct format
          break;
        }

        // we now start the rounds ...
        // split round = moveChar1 + " " + moveChar2
        Move oppMove = createMove(round.charAt(0));
        Move youMove = findYourMove(oppMove, round.charAt(2));

        sum += points(oppMove, youMove);
        System.out.println("SUM: " + sum);

      }

    } catch (IOException e) {
      e.printStackTrace();
    }

  }

}
