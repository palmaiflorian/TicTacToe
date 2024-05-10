import javax.swing.*;
import java.awt.*;

public class GameModePanel extends JPanel {

    public GameModePanel() {
        setLayout(new GridLayout(3, 1));

        JButton new1playerButton = new JButton("New SinglePlayer Game");
        new1playerButton.setFont(new Font("Arial", Font.PLAIN, 48));
        new1playerButton.setForeground(new Color(5, 232, 170));
        new1playerButton.setBackground(new Color(9, 8, 8));
        new1playerButton.setFocusPainted(false);

        JButton new2playerButton = new JButton("New MultiPlayer Game");
        new2playerButton.setFont(new Font("Arial", Font.PLAIN, 48));
        new2playerButton.setForeground(new Color(5, 232, 170));
        new2playerButton.setBackground(new Color(9, 8, 8));
        new2playerButton.setFocusPainted(false);


        JButton exitButton = new JButton("Back");
        exitButton.setFont(new Font("Arial", Font.PLAIN, 48));
        exitButton.setForeground(new Color(5, 232, 170));
        exitButton.setBackground(new Color(9, 8, 8));
        exitButton.setFocusPainted(false);

        new1playerButton.addActionListener(Listeners.NewSinglePlayerGame());
        new2playerButton.addActionListener(Listeners.NewMultiPlayerGame());
        exitButton.addActionListener(e -> Board.showOptionsPanel());

        add(new1playerButton);
        add(new2playerButton);
        add(exitButton);
    }
}