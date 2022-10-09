import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class RPSFrame extends JPanel {
    // Main Initializers
    private JTextField choiceField = new JTextField(10);
    private int playerChoice;
    private int compChoice;
    private String playerName;
    private RPS game = new RPS();
        

    // Constructor
    public RPSFrame() {
        userName();
        System.out.println(game.getName());
        hide(nameButton, namePanel);
        namePanel.add(name);
        namePanel.add(nameButton);
        this.add(namePanel);
    }

    // Initializers needed for the namePanel method that will also be needed on other methods
    private JPanel namePanel = new JPanel();
    private JTextField name = new JTextField(10);
    private JButton nameButton = new JButton("OK");


    // Makes panels dissapear
    public void hide(JButton button, JPanel panel) {
        button.addActionListener( e -> {
            panel.setVisible(false);
        });
    }

    public void userName() {
        nameButton.addActionListener(e -> {
            game.setName(name.getText());
        });
    }
}
