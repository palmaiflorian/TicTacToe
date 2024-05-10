import javax.swing.*;
import java.awt.*;

public class OptionsPanel extends JPanel {

    public OptionsPanel() {
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (UnsupportedLookAndFeelException | ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }

        setLayout(new GridLayout(3, 1));

        JButton newGameButton = new JButton("New Game");
        newGameButton.setFont(new Font("Arial", Font.PLAIN, 48));
        newGameButton.setForeground(new Color(5, 232, 170));
        newGameButton.setBackground(new Color(0, 0, 0));
        newGameButton.setFocusPainted(false);

        JButton loadGameButton = new JButton("Load Game");
        loadGameButton.setFont(new Font("Arial", Font.PLAIN, 48));
        loadGameButton.setForeground(new Color(5, 232, 170));
        loadGameButton.setBackground(new Color(9, 8, 8));
        loadGameButton.setFocusPainted(false);

        JButton exitButton = new JButton("Exit");
        exitButton.setFont(new Font("Arial", Font.PLAIN, 48));
        exitButton.setForeground(new Color(5, 232, 170));
        exitButton.setBackground(new Color(9, 8, 8));
        exitButton.setFocusPainted(false);

        newGameButton.addActionListener(Listeners.NewGameListener());
        loadGameButton.addActionListener(Listeners.LoadGamePanelListener());
        exitButton.addActionListener(Listeners.ExitActionListener());

        add(newGameButton);
        add(loadGameButton);
        add(exitButton);
    }
}