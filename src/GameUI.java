import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Enumeration;

public class GameUI extends JFrame {
    private JPanel cardPanel;
    private CardLayout cardLayout;

    public GameUI() {
        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);

        WelcomeScreen welcomeScreen = new WelcomeScreen();
        welcomeScreen.setStartButtonListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "main");
            }
        });

        MainGameScreen mainGameScreen = new MainGameScreen();

        cardPanel.add(welcomeScreen, "welcome");
        cardPanel.add(mainGameScreen, "main");

        add(cardPanel);

        setTitle("Pokémon Card Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new GameUI());
    }
}


