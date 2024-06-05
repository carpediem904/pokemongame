import javax.swing.*;
import java.awt.*;

public class MainGameScreen extends JPanel {
    public MainGameScreen() {
        setLayout(new BorderLayout());

        // Create player panels on all four sides
        PlayerPanel playerPanelNorth = createPlayerPanel();
        PlayerPanel playerPanelSouth = createPlayerPanel();
        PlayerPanel playerPanelWest = createPlayerPanel();
        PlayerPanel playerPanelEast = createPlayerPanel();

        add(playerPanelNorth, BorderLayout.NORTH);
        add(playerPanelSouth, BorderLayout.SOUTH);
        add(playerPanelWest, BorderLayout.WEST);
        add(playerPanelEast, BorderLayout.EAST);

        // Create a tabletop in the center
        JPanel tabletopPanel = new JPanel();
        tabletopPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK)); // Visual border
        add(tabletopPanel, BorderLayout.CENTER);
    }

    private PlayerPanel createPlayerPanel() {
        PlayerPanel playerPanel = new PlayerPanel();
        playerPanel.setPreferredSize(new Dimension(100, 100)); // Set preferred size
        playerPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK)); // Visual border
        return playerPanel;
    }

    private class PlayerPanel extends JPanel {
        public PlayerPanel() {
            setLayout(new GridLayout(2, 3, 10, 10)); // 2 rows, 3 columns with spacing

            for (int i = 0; i < 6; i++) {
                JPanel cardPanel = new JPanel();
                cardPanel.setPreferredSize(new Dimension(50, 70)); // Set card size
                cardPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK)); // Visual border
                add(cardPanel);
            }
        }
    }
}