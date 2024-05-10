import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;


public class GamePanel extends JPanel {

    private static JButton[][] buttons;
    public static JButton[][] getButtons() {
        return buttons;
    }

    public GamePanel(int boardSize) {
        System.out.println("GAME PANEL CREATED");
        Board.setBoardSize(boardSize);
        buttons = new JButton[boardSize][boardSize];
        setLayout(new GridLayout(boardSize, boardSize));

        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                buttons[i][j] = new JButton("");
                buttons[i][j].setFont(new Font("Arial", Font.PLAIN, 80));
                buttons[i][j].setBackground(new Color(9, 8, 8));
                add(buttons[i][j]);

                final int row = i;
                final int col = j;
                buttons[i][j].addActionListener(e -> {
                    if (Board.isOnePlayerGame()) {
                        Functions.onePlayerGame(row, col);
                    } else {
                        Functions.twoPlayerGame(row, col);
                    }
                });
            }
        }
        menuInit();

    }
    private void menuInit() {
        JMenuBar menuBar = new JMenuBar();
        Board.getFrame().setJMenuBar(menuBar);

        JMenu newGame = new JMenu("New Game");
        menuBar.add(newGame);
        JMenuItem onePlayer = new JMenuItem("Start New 1 Player Game");
        newGame.add(onePlayer);
        JMenuItem twoPlayer = new JMenuItem("Start New 2 Player Game");
        newGame.add(twoPlayer);

        JMenu loadGame = new JMenu("Load");
        menuBar.add(loadGame);
        JMenuItem loadItem1 = new JMenuItem("Load previous 1 Player game");
        loadGame.add(loadItem1);
        JMenuItem loadItem2 = new JMenuItem("Load previous 2 Player game");
        loadGame.add(loadItem2);

        JMenu saveGame = new JMenu("Save");
        menuBar.add(saveGame);
        JMenuItem saveItem = new JMenuItem("Save Game");
        saveGame.add(saveItem);

        JMenu log = new JMenu("Log");
        menuBar.add(log);
        JMenuItem logItem = new JMenuItem("Show the previous matches");
        log.add(logItem);

        JComboBox<String> exitGameComboBox = new JComboBox<>(new String[]{"Exit Game"});
        menuBar.add(exitGameComboBox);

        onePlayer.addActionListener(Listeners.OnePlayerActionListener());
        twoPlayer.addActionListener(Listeners.TwoPlayerActionListener());
        loadItem1.addActionListener(Listeners.LoadOnePlayerActionListener());
        loadItem2.addActionListener(Listeners.LoadTwoPlayerActionListener());
        saveItem.addActionListener(Listeners.SaveActionListener());
        exitGameComboBox.addActionListener(Listeners.ExitActionListener());
        logItem.addActionListener(Listeners.logListener());
    }



}