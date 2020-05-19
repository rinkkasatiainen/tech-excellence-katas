package kata;

public class Game {

    public static final char EMPTY_CELL_TOKEN = '_';
    private final char[][] board;
    private final Board b;
    private char nextPlayer = 'X';

    public Game() {
        board = initializeBoard();
        Board b = new Board(this.board);
        this.b = b;
    }

    private static char[][] initializeBoard() {
        char[][] tokens = new char[3][3];
        for (int row = 0; row < 3; row++) {
            for (int column = 0; column < 3; column++) {
                tokens[column][row] = EMPTY_CELL_TOKEN;
            }
        }
        return tokens;
    }

    public void placeToken(int row, int column) {
        if (b.cellAt(row, column) == EMPTY_CELL_TOKEN) {
            setCell(row, column, nextPlayer);
            switchPlayer();
        }
    }

    private void setCell(int row, int column, char nextPlayer) {
        this.board[column - 1][row - 1] = nextPlayer;
    }

    private void switchPlayer() {
        this.nextPlayer = this.nextPlayer == 'X' ? 'O' : 'X';
    }

    public char turn() {
        return this.nextPlayer;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (int row = 0; row < 3; row++) {
            for (int column = 0; column < 3; column++) {
                result.append(board[column][row]);
            }
            result.append('\n');
        }
        return result.toString();
    }

    public char winner() {
        if (b.cellAt(1,1) == b.cellAt(1,2)&&
                b.cellAt(1,2) == b.cellAt(1,3)) {
            return b.cellAt(1,1);
        }
        return '_';
    }
}
