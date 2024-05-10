import javax.swing.*;
import java.awt.*;

public class LoadGamePanel extends JPanel {

    public LoadGamePanel() {
        setLayout(new GridLayout(3, 1));

        JButton new1PlayerButton = new JButton("Load previous 1 Player Game");
        new1PlayerButton.setFont(new Font("Arial", Font.PLAIN, 48));
        new1PlayerButton.setForeground(new Color(5, 232, 170));
        new1PlayerButton.setBackground(new Color(9, 8, 8));
        new1PlayerButton.setFocusPainted(false);

        JButton new2PlayerButton = new JButton("Load previous 2 Player Game");
        new2PlayerButton.setFont(new Font("Arial", Font.PLAIN, 48));
        new2PlayerButton.setForeground(new Color(5, 232, 170));
        new2PlayerButton.setBackground(new Color(9, 8, 8));
        new2PlayerButton.setFocusPainted(false);

        JButton exitButton = new JButton("Back");
        exitButton.setFont(new Font("Arial", Font.PLAIN, 48));
        exitButton.setForeground(new Color(5, 232, 170));
        exitButton.setBackground(new Color(9, 8, 8));
        exitButton.setFocusPainted(false);

        new1PlayerButton.addActionListener(Listeners.LoadOnePlayerActionListener());
        new2PlayerButton.addActionListener(Listeners.LoadTwoPlayerActionListener());
        exitButton.addActionListener(Listeners.BackToOptionsListener());

        add(new1PlayerButton);
        add(new2PlayerButton);
        add(exitButton);
    }
}