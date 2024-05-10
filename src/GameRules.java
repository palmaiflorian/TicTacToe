

public class GameRules {
    private static int numToWin;

    public static void setNumToWin(int a) {
        numToWin=a;
    }
    private static char currentPlayer = 'X';
    public static char getCurrentPlayer() {
        return currentPlayer;
    }
    public static void setCurrentPlayer(char player) {
        currentPlayer = player;
    }
    public static void changeCurrentPlayer() {
        currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
    }

    public static boolean checkWin() {
        // Check rows, columns, and diagonals for a win
        return (checkRows() || checkColumns() || checkDiagonals());
    }

    public static boolean checkRows() {
        for (int i = 0; i < Board.getBoardSize(); i++) {
            for (int j = 0; j <= Board.getBoardSize() - numToWin; j++) {
                boolean win = true;
                for (int k = 0; k < numToWin; k++) {
                    String buttonText = GamePanel.getButtons()[i][j + k].getText();
                    if (buttonText.isEmpty() || buttonText.charAt(0) != currentPlayer) {
                        win = false;
                        break;
                    }
                }
                if (win)
                    return true;
            }
        }
        return false;
    }

    public static boolean checkColumns() {
        for (int i = 0; i < Board.getBoardSize(); i++) {
            for (int j = 0; j <= Board.getBoardSize() - numToWin; j++) {
                boolean win = true;
                for (int k = 0; k < numToWin; k++) {
                    String buttonText = GamePanel.getButtons()[j + k][i].getText();
                    if (buttonText.isEmpty() || buttonText.charAt(0) != currentPlayer) {
                        win = false;
                        break;
                    }
                }
                if (win)
                    return true;
            }
        }
        return false;
    }

    public static boolean checkDiagonals() {
        for (int i = 0; i <= Board.getBoardSize() - numToWin; i++) {
            for (int j = 0; j <= Board.getBoardSize() - numToWin; j++) {
                boolean win = true;
                for (int k = 0; k < numToWin; k++) {
                    String buttonText = GamePanel.getButtons()[i + k][j + k].getText();
                    if (buttonText.isEmpty() || buttonText.charAt(0) != currentPlayer) {
                        win = false;
                        break;
                    }
                }
                if (win)
                    return true;
            }
        }

        for (int i = 0; i <= Board.getBoardSize() - numToWin; i++) {
            for (int j = numToWin - 1; j < Board.getBoardSize(); j++) {
                boolean win = true;
                for (int k = 0; k < numToWin; k++) {
                    String buttonText = GamePanel.getButtons()[i + k][j - k].getText();
                    if (buttonText.isEmpty() || buttonText.charAt(0) != currentPlayer) {
                        win = false;
                        break;
                    }
                }
                if (win)
                    return true;
            }
        }

        return false;
    }

    public static boolean isBoardFull() {
        for (int i = 0; i < Board.getBoardSize(); i++) {
            for (int j = 0; j < Board.getBoardSize(); j++) {
                if (GamePanel.getButtons()[i][j].getText().isEmpty()) {
                    return false;
                }
            }
        }
        return true;
    }
}
