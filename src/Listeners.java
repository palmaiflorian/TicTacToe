
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Listeners {


    public static ActionListener OnePlayerActionListener() {
        return e -> {
            Functions.resetGame(GamePanel.getButtons());
            Board.setOnePlayerGame(true);
            Board.setTwoPlayerGame(false);
            int newSize = Board.askForBoardSize();
            if (newSize > 0) {
                GamePanel gp=new GamePanel(newSize);
                Board.getCards().add(gp, "GAME");
                Functions.resetGame(GamePanel.getButtons());
                Board.showGamePanel();
            }
            if (GameRules.getCurrentPlayer() == Board.getai().getAIPlayer()) {
                Board.getai().aiMove();
            }
        };
    }


    public static ActionListener TwoPlayerActionListener() {
        return e -> {
            Functions.resetGame(GamePanel.getButtons());
            Board.setOnePlayerGame(false);
            Board.setTwoPlayerGame(true);
            int newSize = Board.askForBoardSize();
            if (newSize > 0) {
                GamePanel gp=new GamePanel(newSize);
                Board.getCards().add(gp, "GAME");
                Board.showGamePanel();
            }

        };
    }

    public static ActionListener ExitActionListener() {
        return e -> System.exit(0);
    }

    public static ActionListener LoadOnePlayerActionListener() {
        return e -> {
            Board.setOnePlayerGame(true);
            Board.setTwoPlayerGame(false);
            Functions.loadGame();
        };
    }

    public static ActionListener LoadTwoPlayerActionListener() {
        return e -> {
            Board.setOnePlayerGame(false);
            Board.setTwoPlayerGame(true);
            Functions.loadGame();
        };
    }

    public static ActionListener SaveActionListener() {
        return e -> {
            try {
                Functions.saveGame();
            } catch (NumberFormatException e1) {
                e1.printStackTrace();
            }
        };
    }

    public static ActionListener NewGameListener() {
        return e -> {
            GameModePanel gameModePanel = new GameModePanel();
            Board.getCards().add(gameModePanel, "GAME MODES");
            Board.showGameModePanel();
        };
    }

    public static ActionListener LoadGamePanelListener() {
        return e -> {
            LoadGamePanel loadGamePanel = new LoadGamePanel();
            Board.getCards().add(loadGamePanel, "LOAD GAME");
            Board.showLoadGamePanel();
        };
    }

    public static ActionListener BackToOptionsListener() {
        return e -> Board.showOptionsPanel();
    }

    public static ActionListener NewSinglePlayerGame() {
        return e -> {
            Board.setOnePlayerGame(true);
            Board.setTwoPlayerGame(false);
            int newSize = Board.askForBoardSize();
            if (newSize > 0) {
                GamePanel gp=new GamePanel(newSize);
                Board.getCards().add(gp, "GAME");
                Board.showGamePanel();
                if (GameRules.getCurrentPlayer() == Board.getai().getAIPlayer()) {
                    Board.getai().aiMove();
                }
            }
        };
    }

    public static ActionListener NewMultiPlayerGame() {
        return e -> {
            Board.setOnePlayerGame(false);
            Board.setTwoPlayerGame(true);
            int newSize = Board.askForBoardSize();
            if (newSize > 0) {
                GamePanel gp=new GamePanel(newSize);
                Board.getCards().add(gp, "GAME");
                Board.showGamePanel();

            }
        };
    }
    public static ActionListener logListener() {
        return e-> {
            System.out.println(("TORTENIK"));
                JFrame logFrame = new JFrame("Log Viewer");
                logFrame.setSize(400, 300);
                logFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

                // Create a JTextArea to display the log items
                JTextArea logTextArea = new JTextArea();
                logTextArea.setEditable(false);

                // Create a JScrollPane to scroll through log items
                JScrollPane scrollPane = new JScrollPane(logTextArea);

                // Add the scroll pane to the frame
                logFrame.add(scrollPane);

                // Populate the text area with log items
                for (String logItem : Board.getLogList()) {
                    logTextArea.append(logItem + "\n");
                }
                logFrame.setVisible(true);
        };
    }
}
