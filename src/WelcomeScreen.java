import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Enumeration;

public class WelcomeScreen extends JPanel {
    private JButton startButton;
    private ButtonGroup playerCountGroup;

    public WelcomeScreen() {
        setLayout(new BorderLayout());

        JPanel centerPanel = new JPanel(new GridLayout(1, 3, 10, 10)); // Use 3 columns
        add(centerPanel, BorderLayout.CENTER);

        JLabel label = new JLabel("Select the number of players", SwingConstants.CENTER);
        label.setFont(label.getFont().deriveFont(Font.BOLD, 30.0f)); // Set bold and larger font
        add(label, BorderLayout.NORTH);

        playerCountGroup = new ButtonGroup();

        for (int i = 2; i <= 4; i++) {
            JRadioButton radioButton = new JRadioButton(Integer.toString(i) + " Players");
            radioButton.setFont(radioButton.getFont().deriveFont(Font.BOLD, 30.0f)); // Set bold and larger font
            playerCountGroup.add(radioButton);
            centerPanel.add(radioButton);
        }

        startButton = new JButton("START");
        startButton.setFont(startButton.getFont().deriveFont(Font.BOLD, 20.0f)); // Set bold and larger font
        add(startButton, BorderLayout.SOUTH);
    }

    public void setStartButtonListener(ActionListener listener) {
        startButton.addActionListener(listener);
    }

    public int getSelectedPlayerCount() {
        for (Enumeration<AbstractButton> buttons = playerCountGroup.getElements(); buttons.hasMoreElements();) {
            JRadioButton button = (JRadioButton) buttons.nextElement();
            if (button.isSelected()) {
                return Integer.parseInt(button.getText().split(" ")[0]);
            }
        }
        return -1; // No selection
    }
}
