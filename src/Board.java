import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;


public class Board {
    private static JFrame frame;
    public static JFrame getFrame() {
        return frame;
    }
    private static JPanel cards;
    public static JPanel getCards() {
        return cards;
    }
    private static int boardSize;
    public static void setBoardSize(int size) {
        boardSize=size;
    }

    public static int getBoardSize(){
        return boardSize;
    }
    private static AI ai;
    public static AI getai() {
        return ai;
    }
    private static boolean isOnePlayerGame=false;
    public static boolean isOnePlayerGame() {
        return isOnePlayerGame;
    }
    public static void setOnePlayerGame(boolean b) {
        isOnePlayerGame=b;
    }
    private static boolean isTwoPlayerGame=false;
    public static void setTwoPlayerGame(boolean b) {
        isTwoPlayerGame=b;
    }
    public static JPanel panel;

    public static ArrayList<String> logList=new ArrayList<>();
    public static ArrayList<String> getLogList(){
        return logList;
    }



    public static int askForBoardSize() {

        String input = JOptionPane.showInputDialog(frame, "Please enter the board size (e.g. 3 for a 3x3 board):");
        try {
            int size = Integer.parseInt(input);
            if (size > 0) {
                if(size>4) {
                    GameRules.setNumToWin(5);
                }else {
                    GameRules.setNumToWin(size);
                }
                return size;
            }
            JOptionPane.showMessageDialog(frame, "Invalid board size. Please enter a positive number.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
        } catch (NumberFormatException e) {
            throw new RuntimeException(e);
        }
        return -1;
    }

    public Board() {
        ai=new AI();
        ai.setAIPlayer('O');

        frame = new JFrame("Tic Tac Toe");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        cards = new JPanel(new CardLayout());
        JPanel optionsPanel = new OptionsPanel();
        cards.add(optionsPanel, "OPTIONS");
        frame.add(cards);
        showOptionsPanel();

        frame.setSize(800, 800);
        frame.setVisible(true);
    }


    public static void showOptionsPanel() {
        CardLayout cardLayout = (CardLayout) cards.getLayout();
        cardLayout.show(cards, "OPTIONS");
    }

    public static void showGamePanel() {
        CardLayout cardLayout = (CardLayout) cards.getLayout();
        cardLayout.show(cards, "GAME");
    }
    public static void showGameModePanel() {
        CardLayout cardLayout = (CardLayout) cards.getLayout();
        cardLayout.show(cards, "GAME MODES");
    }
    public static void showLoadGamePanel() {
        CardLayout cardLayout = (CardLayout) cards.getLayout();
        cardLayout.show(cards, "LOAD GAME");
    }


}
