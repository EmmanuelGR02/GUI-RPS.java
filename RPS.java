import javax.swing.*;

public class RPS extends JPanel{
    // Initializers
    private JTextField choiceField = new JTextField(10);
    private int playerChoice;
    private int compChoice;
    ;

    // Constructor
    public RPS() {
        JPanel playerPickPanel = new JPanel();
        playerPickPanel.setLayout(new BoxLayout(playerPickPanel, BoxLayout.X_AXIS));

        JLabel playerChoice = new JLabel("Enter your choice: ");


        
        playerPickPanel.add(playerChoice);
        playerPickPanel.add(choiceField);
        this.add(playerPickPanel);
    }
}
