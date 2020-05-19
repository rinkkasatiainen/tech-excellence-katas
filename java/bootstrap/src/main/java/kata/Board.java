package kata;

class Board {

    public final char[][] board;

    public Board(char[][] board) {
        this.board = board;
    }

    char cellAt(int row, int column) {
        return this.board[column - 1][row - 1];
    }
}
