import java.awt.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JOptionPane;



public class Functions {
    public static void resetGame(JButton[][] buttons) {
        for (JButton[] button : buttons) {
            for (JButton jButton : button) {
                jButton.setText("");
            }
        }
        GameRules.changeCurrentPlayer();
    }

    public static void saveGame() {
        try {
            String filename;
            if (Board.isOnePlayerGame()) {
                filename = "1Player.txt";
            } else {
                filename = "2Player.txt";
            }
            BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
            writer.write(Board.getBoardSize() + "\n");
            writer.write(GameRules.getCurrentPlayer() + "\n");

            for (int i = 0; i < Board.getBoardSize(); i++) {
                for (int j = 0; j < Board.getBoardSize(); j++) {
                    JButton button = GamePanel.getButtons()[i][j];
                    String text = button.getText();
                    Color textColor = button.getForeground();
                    writer.write(text + "\n");
                    writer.write(textColor.getRGB() + "\n");
                }
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void loadGame() {
        try {
            String filename;
            if (Board.isOnePlayerGame()) {
                filename = "1Player.txt";
            } else {
                filename = "2Player.txt";
            }
            FileReader reader = new FileReader(filename);
            BufferedReader bufferedReader = new BufferedReader(reader);

            int loadedBoardSize = Integer.parseInt(bufferedReader.readLine());
            Board.setBoardSize(loadedBoardSize);
            char loadedCurrentPlayer = bufferedReader.readLine().charAt(0);
            GameRules.setCurrentPlayer(loadedCurrentPlayer);

            GameRules.setNumToWin(Math.min(loadedBoardSize, 5));

            GamePanel gp = new GamePanel(loadedBoardSize);
            Board.getCards().add(gp, "GAME");
            Board.showGamePanel();
            resetGame(GamePanel.getButtons());

            for (int i = 0; i < loadedBoardSize; i++) {
                for (int j = 0; j < loadedBoardSize; j++) {
                    String text = bufferedReader.readLine();
                    int rgb = Integer.parseInt(bufferedReader.readLine());
                    Color textColor = new Color(rgb);
                    GamePanel.getButtons()[i][j].setText(text);
                    GamePanel.getButtons()[i][j].setForeground(textColor);
                }
            }
            bufferedReader.close();

            if (Board.isOnePlayerGame() && GameRules.getCurrentPlayer() == Board.getai().getAIPlayer()) {
                Board.getai().aiMove();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void onePlayerGame(int row,int col) {
        JButton button = GamePanel.getButtons()[row][col];

        if (button.getText().isEmpty() && GameRules.getCurrentPlayer() != Board.getai().getAIPlayer()) {
            button.setText(String.valueOf(GameRules.getCurrentPlayer()));
            if (GameRules.getCurrentPlayer() == 'X') {
                button.setForeground(Color.RED);
            } else if (GameRules.getCurrentPlayer() == 'O') {
                button.setForeground(Color.GREEN);
            }

            if (GameRules.checkWin()) {
                JOptionPane.showMessageDialog(Board.getFrame(), "Player " + GameRules.getCurrentPlayer() + " wins!");
                Board.getLogList().add(GameRules.getCurrentPlayer() + "won ");
                if (askToPlayAgain()) {
                    playAgain();
                } else
                    System.exit(0);

            } else if (GameRules.isBoardFull()) {
                JOptionPane.showMessageDialog(Board.getFrame(), "It's a draw!");
                Board.getLogList().add("There was a draw! ");
                if (askToPlayAgain()) {
                    playAgain();
                } else
                    System.exit(0);

            } else {
                GameRules.changeCurrentPlayer();
                    Board.getai().aiMove();

                    if (GameRules.checkWin()) {
                        JOptionPane.showMessageDialog(Board.getFrame(), "AI wins!");
                        Board.getLogList().add(GameRules.getCurrentPlayer() + " won ");
                        if (askToPlayAgain()) {
                            Functions.resetGame(GamePanel.getButtons());
                        } else
                            System.exit(0);

                    } else if (GameRules.isBoardFull()) {
                        JOptionPane.showMessageDialog(Board.getFrame(), "It's a draw!");
                        Board.getLogList().add("There was a draw! ");
                        if (askToPlayAgain()) {
                            Functions.resetGame(GamePanel.getButtons());
                        } else {
                            System.exit(0);
                        }
                    }

            }
        }
    }

    public static void twoPlayerGame(int row,int col) {
        JButton button = GamePanel.getButtons()[row][col];

        if (button.getText().isEmpty()) {
            button.setText(String.valueOf(GameRules.getCurrentPlayer()));

            if (GameRules.getCurrentPlayer() == 'X') {
                button.setForeground(Color.RED);
            } else if (GameRules.getCurrentPlayer() == 'O') {
                button.setForeground(Color.GREEN);
            }

            if (GameRules.checkWin()) {
                JOptionPane.showMessageDialog(Board.getFrame(), "Player " + GameRules.getCurrentPlayer() + " wins!");
                Board.getLogList().add(GameRules.getCurrentPlayer() + " won, ");
                if (askToPlayAgain()) {
                    Functions.resetGame(GamePanel.getButtons());
                } else
                    System.exit(0);

            } else if (GameRules.isBoardFull()) {
                JOptionPane.showMessageDialog(Board.getFrame(), "It's a draw!");
                Board.getLogList().add("There was a draw!, ");
                if (askToPlayAgain()) {
                    Functions.resetGame(GamePanel.getButtons());
                } else {
                    System.exit(0);
                }
            } else
                GameRules.changeCurrentPlayer();
        }
    }

    private static boolean askToPlayAgain() {
        int choice = JOptionPane.showConfirmDialog(Board.getFrame(), "Do you want to play another game?", "Play Again", JOptionPane.YES_NO_OPTION);
        return choice == JOptionPane.YES_OPTION;
    }
    public static void playAgain(){
        Functions.resetGame(GamePanel.getButtons());
        GameRules.changeCurrentPlayer();
        GamePanel gp=new GamePanel(Board.getBoardSize());
        Board.getCards().add(gp, "GAME");
        Board.showGamePanel();
        if(GameRules.getCurrentPlayer()==Board.getai().getAIPlayer()) {
            Board.getai().aiMove();
        }
    }
}
