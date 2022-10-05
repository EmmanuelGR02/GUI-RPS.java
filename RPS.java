import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class RPS extends JPanel implements ActionListener{
    // Initializers
    private JTextField choiceField = new JTextField(15);
    private JButton pick = new JButton("PICK!");
    private int playerChoice;
    private int compChoice;
    private String playerItem;
    private String compItem;  
    JLabel player = new JLabel();  

    // Constructor
    public RPS() {
        JPanel playerPickPanel = new JPanel();
        playerPickPanel.setLayout(new BoxLayout(playerPickPanel, BoxLayout.X_AXIS));

       JPanel choices = new JPanel();
       choices.setLayout(new BoxLayout(choices, BoxLayout.Y_AXIS));

       JLabel playerChoice = new JLabel("Enter your choice: ");

        computerNum();
        computerItem();
        JLabel computer = new JLabel("Computer: " + compItem);

        pick.addActionListener(this);

        playerPickPanel.add(playerChoice);
        playerPickPanel.add(choiceField);
        choices.add(computer);
        choices.add(player);
        this.add(pick);
        this.add(choices);
        this.add(playerPickPanel);
    }

    // sets PLAYERITEM to the item that is specific to the number they picked
    public void playerItem() {
        if (Integer.parseInt(choiceField.getText()) == 1) {
            playerItem = "ROCK";
        } else if (Integer.parseInt(choiceField.getText()) == 2) {
            playerItem = "PAPER";
        } else if (Integer.parseInt(choiceField.getText()) == 3) {
            playerItem = "SCISSORS";
        } else {
            choiceField.setText("Wrong input, TRY AGAIN");
        }
    }

    // sets a random number form 1-3 to the computer
    public void computerNum() {
        int rand = (int)(Math.random() * 3 - 1 + 1) + 1;
        compChoice = rand;
    }

    public void computerItem() {
        if (compChoice == 1) {
            compItem = "ROCK";
        } else if (compChoice == 2) {
            compItem = "PAPER";
        } else if (compChoice == 3) {
            compItem = "SCISSORS";
        }
    }

    public void actionPerformed(ActionEvent e) {
       playerItem();
       player.setText("YOU: " + playerItem);
    }


}
