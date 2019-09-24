package Intv;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

public class Main {

  /*
      Part 1:
      Sort this array by the length of the string, then alphabetical order (case-
      insensitive).  For example, a correctly sorted list might be:
          a
          D
          z
          vb
          afd
  */
  static String[] data = {"Lorem", "ipsum", "dolor", "sit", "amet", "consectetur", "adipisicing",
      "elit", "sed", "do", "eiusmod", "tempor", "incididunt", "ut", "labore", "et"};

  static String[] sortedData() {
    Arrays.sort(data, new Comparator<String>() {
      public int compare(String s1, String s2) {
        //TODO: Fill in this function
        if (s1.length() != s2.length()) {
          return s1.length() - s2.length();
        } else {
          s1 = s1.toLowerCase();
          s2 = s2.toLowerCase();
          return s1.compareTo(s2);
        }
      }
    });
    return data;
  }

  /*
      Part 2: Write a small, reasonably efficient class that takes strings as input, and calls
      a callback method whenever a newline ("\n") is reached, passing in the previous line's
      text.  The class should discard old data when possible to save memory.

      Hint: This should not take more than about 15-50 lines of code.
  */
  static class LineParser {

    public interface LineReceiver {

      void lineComplete(String line);
    }

    LineReceiver callback;

    public LineParser(LineReceiver lineReceiver) {
      callback = lineReceiver;
    }

    StringBuilder sb = new StringBuilder();

    public void read(String data) {
      //TODO: Fill in this function
      while (data.length() != 0 && data.contains("\n")) {
        int i = data.indexOf("\n");
        sb.append(data, 0, i);
        callback.lineComplete(sb.toString());
        sb.setLength(0);
        if (i + 1 <= data.length()) {
          data = data.substring(i + 1);
        }
      }
      sb.append(data);
      callback.lineComplete(data);
    }
  }

  /*
  Part 3: Implement the board game Bridges and Bombs..

  Play an online version of the game here:
    https://jasonhenline.github.io/bridges-and-bombs

  This game is played on an 9x9 board of squares between two players called X
  and O. X plays first and then the players alternate taking turns. On their
  turn a player claims an empty square.

  # Bridges #
. 1point3acres
  The goal for each player is to construct a bridge of claimed squares that
  spans from one side of the board to the opposite side.

  A bridge is a set of contiguous squares, where squares are considered
  contiguous if they are neighbors either horizontally or vertically.

  X must construct a bridge between the left and right sides of the board, and
  O must construct a bridge between the top and bottom sides of the board.

  If a player claims a square that completes their required edge-spanning
  bridge and the bridge survives any bomb explosions, that player wins the
  game.

  # Bombs #

  If a claimed square has no vertical or horizontal neighbors belonging to the
  same player, it becomes a bomb. A bomb starts with a countdown timer of 4 and
  after each player's turn the timer value decreases by 1. If a bomb timer
  reaches zero, the bomb explodes, clearing its square and its four neighbor
  squares.

  Bombs are created each turn after any bomb explosions are resolved, so each
  user's turn goes like this:. 1point3acres

   1. The current player claims an empty square.
   2. Any bombs belonging to the player who just moved in neighboring squares
      of the claimed square are defused (their timers are set to undefined and
      they become regular claimed squares).
   3. All bomb timers are decreased by 1.
   4. All bombs with timer equal to zero explode, clearing their square and
      their neighbor squares.
   5. Any claimed square with no neighbors belonging to the same player is
      converted to a bomb with timer set to 4, if it is not already a bomb.
   6. If the claimed square survived the bomb explosions and it completes the
      user's bridge, the user wins the game.
   7. If there are no empty spaces left on the board, the next player has no
      legal moves, so the player who just played wins the game.

  # Extra Credit #
  - Implement a computer player that always makes a valid move
  - Implement a computer player that makes strategic move
   */
  static class Game {

    enum Piece {
      X, O, EMPTY
    }

    /**
     * A board square.
     *
     * Contains the piece on the square an the timer.
     *
     * A negative timer value indicates that there is no timer.
     */
    static class Square {

      Piece piece;
      int timer;

      Square(Piece piece, int timer) {
        this.piece = piece;
        this.timer = timer;
      }

      Square(Piece piece) {
        this(piece, -1);
      }

      Square() {
        this(Piece.EMPTY);
      }
    }

    /**
     * A 2-D position coordinate.
     */
    static class Coordinate {

      int x;
      int y;

      Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
      }

      @Override
      public boolean equals(Object o) {
        Coordinate c = (Coordinate) o;
        return c.x == x && c.y == y;
      }

      @Override
      public int hashCode() {
        return new Integer(x * 31 + y).hashCode();
      }
    }

    private static int size = 9;
    private static Square[][] board;
    private static int[][] dirs = new int[][] {{1,0}, {-1,0}, {0,1}, {0,-1}};


    private BufferedReader inputReader = new BufferedReader(new InputStreamReader(System.in));

    Game() {
      this.board = new Square[this.size][this.size];
      for (int x = 0; x < this.size; x++) {
        this.board[x] = new Square[this.size];
        Arrays.fill(this.board[x], new Square());
      }
    }

    /**
     * Gets the user move from stdin.
     *
     * Continues prompting the user for a move until the user enters a move that is within the
     * boundaries of the board. Does not do any other move validity checking.
     */
    private Coordinate getUserMove() {
      try {
        String text = this.inputReader.readLine();
        int x = text.charAt(0) - 'a';
        int y = Character.digit(text.charAt(1), 10) - 1;
        return new Coordinate(
            Math.max(0, Math.min(this.size - 1, x)),
            Math.max(0, Math.min(this.size - 1, y))
        );
      } catch (Exception e) {
        return this.getUserMove();
      }
    }

    /**
     * Prints the current state of the board to the console.
     */
    private void render() {
      System.out.println("        a    b    c    d    e    f    g    h    i");
      System.out.println("        o    o    o    o    o    o    o    o    o");
      System.out.println("     ----------------------------------------------");
      for (int y = 0; y < this.size; y++) {
        StringBuilder lineBuilder = new StringBuilder();
        lineBuilder.append(y + 1);
        lineBuilder.append("  x | ");
        for (int x = 0; x < this.size; x++) {
          Square square = this.board[y][x];
          switch (square.piece) {
            case O:
              lineBuilder.append('O');
              break;
            case X:
              lineBuilder.append('X');
              break;
            case EMPTY:
              lineBuilder.append(' ');
              break;
          }
          if (square.timer >= 0) {
            lineBuilder.append(square.timer);
          } else {
            lineBuilder.append(' ');
          }
          lineBuilder.append(" | ");
        }
        lineBuilder.append("x");
        System.out.println(lineBuilder.toString());
        System.out.println("     ----------------------------------------------");
      }
      System.out.println("        o    o    o    o    o    o    o    o    o");
    }

    // TODO: Implement this function.
    private void play() {
      Square s = new Square(Piece.X, -1);
      Set<Square> bombs = new HashSet<>();
      boolean firstPlayer = true;
      while (true) {
        this.render();
        Coordinate coordinate = this.getUserMove();

        // TODO: Don't accept invalid moves.
        if (outRange(coordinate.y, coordinate.x)) {
          System.out.println("Please enter a valid move!");
          continue;
        }
        // TODO: Alternate players.
        if (firstPlayer) {
          this.board[coordinate.y][coordinate.x] = new Square(Piece.X, 4);
        } else {
          this.board[coordinate.y][coordinate.x] = new Square(Piece.O, 4);
        }
        // TODO: Defuse neighbor bombs belonging to the same player (set
        //  their timers to a negative value).
        for (int[] dir: dirs) {
          int nextRow = coordinate.y + dir[0];
          int nextCol = coordinate.x + dir[1];
          if (outRange(nextRow, nextCol)) continue;
          if (this.board[nextRow][nextCol].timer > 0) {
            this.board[nextRow][nextCol] = new Square(this.board[coordinate.y][coordinate.x].piece, -1);
          }
        }
        // TODO: Decrement bomb counters by 1.
        for (int i = 0; i < size; i++) {
          for (int j = 0; j < size; j++) {
            if (i != coordinate.y && j != coordinate.x && getNeighbor(i, j) == 0 && this.board[i][j].timer > 0) {
              this.board[i][j].timer--;
            }
          }
        }

        // TODO: Explode any bombs where the timer has reached zero.
        for (int i = 0; i < size; i++) {
          for (int j = 0; j < size; j++) {
            if (getNeighbor(i, j) == 0 && this.board[i][j].timer == 0) {
              for (int[] dir : dirs) {
                int nextRow = i + dir[0];
                int nextCol = j + dir[1];
                if (!outRange(nextRow, nextCol) && !this.board[nextRow][nextCol].piece.equals(Piece.EMPTY)) {
                  this.board[nextRow][nextCol] = new Square();
                }
              }
              bombs.remove(this.board[i][j]);
              this.board[i][j] = new Square();
            }
          }
        }
        // TODO: Convert any lonely claimed squares to bombs with timer set to 4.
        for (int i = 0; i < size; i++) {
          for (int j = 0; j < size; j++) {
            if (!bombs.contains(this.board[i][j]) && getNeighbor(i,j) == 0 && !this.board[i][j].piece.equals(Piece.EMPTY)) {
              this.board[i][j].timer = 4;
              bombs.add(this.board[i][j]);
            }
          }
        }
        // TODO: Check if the current player won by making a spanning bridge.
        if (firstPlayer) {
          int i = 1;
          for (; i < size; i++){
            if (!this.board[coordinate.y][i].piece.equals(this.board[coordinate.y][i - 1].piece)) break;
          }
          if (i == size) {
            System.out.println("Player X won the game.");
            System.exit(0);
          }
        } else {
          int i = 1;
          for (; i < size; i++){
            if (!this.board[i][coordinate.x].piece.equals(this.board[i - 1][coordinate.x].piece)) break;
          }
          if (i == size) {
            System.out.println("Player O won the game.");
            System.exit(0);
          }
        }
        // TODO: If there are no empty squares left on the board, this player is the winner.
        if (getEmpty() == 0) {
          System.out.println("You win!");
        }
        firstPlayer = !firstPlayer; // switch player

      }

    }

    private int getEmpty() {
      int count = 0;
      for (int i = 0; i < size; i++) {
        for (int j = 0; j < size; j++) {
          if (this.board[i][j].piece.equals(Piece.EMPTY)) {
            count++;
          }
        }
      }
      return count;
    }

    private int getNeighbor(int i, int j) {
      int count = 0;
      for (int[] dir: dirs) {
        int nextRow = i + dir[0];
        int nextCol = j + dir[1];
        if (!outRange(nextRow, nextCol) && !this.board[nextRow][nextCol].piece.equals(Piece.EMPTY)) {
          count++;
        }
      }
      return count;
    }
    private static boolean outRange(int y, int x) {
      if (x < 0 || x >= size || y < 0 || y >= size) {
        return true;
      }
      return false;
    }

    /*
    Test Driver
    */
    public static void main(String[] args) {
      System.out.print("Part 1:\n");
      for (String s : sortedData()) {
        System.out.println(s);
      }

      System.out.print("\n\nPart 2:\n");
      LineParser parser = new LineParser(new LineParser.LineReceiver() {
        @Override
        public void lineComplete(String line) {
          System.out.println(line.replace("\n", " "));
        }
      });

      parser.read("This is t");
      parser.read("he first l");
      parser.read("ine.\nAnd this is the second.\n");
      parser.read("And this is the third.\nAnd the");
      parser.read(" fourth.\n");

      System.out.print("\n\nPart 3:\n");
      new Game().play();
    }
  }
}
