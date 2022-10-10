// Emmanuel Gutierrez Rivera
import javax.swing.*;
import java.awt.*;
import java.util.InputMismatchException;
import java.awt.Color;

public class RPSFrame extends JPanel {
    // RPS class
    private RPS game = new RPS();

    // names panel initializers
    private JPanel playerNames = new JPanel();
    private JLabel enterName = new JLabel("Enter your name: ");
    private JLabel playerName = new JLabel();
    private JLabel names = new JLabel();

    // images initializers
    JPanel imagePanel = new JPanel();
    JButton image1 = new JButton();
    JButton image2 = new JButton();

    // main Image
    private JPanel mainImg = new JPanel();
    private JButton RPSimg = new JButton();

    // pick panel initializers
    private JPanel pickPanel = new JPanel();
    private JTextField playerPick = new JTextField(10);
    private JLabel pickLabel = new JLabel("Pick a Number Between 1 and 3: ");
    private JButton pickButton = new JButton("PICK!");
        
    // play again message
    JPanel PApanel = new JPanel();
    JLabel PAlabel = new JLabel("<html>To play again, delete the number on the text box and type a new one <br/> or you can leave the current. Click \"PICK!\" to play again </html>");

    // win message
    JPanel winMePanel = new JPanel();
    JLabel winMessage = new JLabel();

    // Constructor
    public RPSFrame() {
        displayNames();
        playerPickNum();
        
        // name panel
        playerNames.setLayout(new BorderLayout());
        playerNames.setVisible(false);
        hide(nameButton, namePanel);
        namePanel.add(enterName);
        namePanel.add(nameTfield);
        namePanel.add(nameButton);
        RPSimg.setIcon(new ImageIcon("RPSimg.png")); // add main image
        mainImg.add(RPSimg);
        this.add(mainImg);
        this.add(namePanel);

        // pick panel
        pickPanel.setVisible(false);
        pickPanel.setLayout(new GridLayout(2,2));
        pickPanel.setLayout(new BorderLayout());
        this.add(pickPanel);

        // win message 
        winMessage.setVisible(false);
        winMePanel.add(winMessage);
        this.add(winMePanel);

        wrongInputMessage.setVisible(false);
        this.add(wrongInputMessage);

        // add play again message
        PApanel.add(PAlabel);
        PApanel.setVisible(false);
        this.add(PApanel);

        // images
        imagePanel.setVisible(false);
        this.add(imagePanel);
    }

    // Initializers needed for the namePanel method that will also be needed on other methods
    private JPanel namePanel = new JPanel();
    private JTextField nameTfield = new JTextField(10);
    private JButton nameButton = new JButton("OK");


    // Makes panels dissapear
    public void hide(JButton button, JPanel panel) {
        button.addActionListener( e -> {
            namePanel.setVisible(false);
        });
    }

    // Gets players name
    public void displayNames() {
        nameButton.addActionListener( e -> {
            mainImg.setVisible(false);
            pickPanel.setVisible(true);
            // set name to "NO NAME" if the player did not enter anything for their name
            if (nameTfield.getText().isEmpty()) {
                game.setName("NO NAME");
            } else {
                playerName.setText(nameTfield.getText().toUpperCase());
                game.setName(nameTfield.getText().toUpperCase());
            }
            pickPanel.add(pickLabel, BorderLayout.WEST);
            pickPanel.add(playerPick, BorderLayout.EAST);
            pickPanel.add(pickButton, BorderLayout.SOUTH);
        });
    }

    // Displays names
    // gets the number that the player cose
    // Calls the random pick for the computer from the RPS class
    // finds winner using "rindWinner" from RPS class and outputs the winner
    // displays scores
    public void playerPickNum() {
        pickButton.addActionListener(e -> {
            catchError();
            playerNames.setVisible(true);
            game.computerPick();
            game.findWinner();
            names.setText((game.getName() + ":   " + game.getComputerScore() + "        <SCORES>        " + game.getComputerName() + ":   " + game.getPlayerScore()));
            this.add(names);

            // set the number to the current image by getting the number that the player/computer have picked
            game.setImg(game.getPlayerNumber());
            image1.setIcon(new ImageIcon(game.getCurrentImage()));
            game.setImg(game.getComputerNumber());
            image2.setIcon(new ImageIcon(game.getCurrentImage()));
            imagePanel.add(image1);
            imagePanel.add(image2);

            // display winner
            winMessage.setText(game.toString());
            winMessage.setForeground(Color.RED);
            winMePanel.setVisible(true);
        });
    }

    private JLabel wrongInputMessage = new JLabel("Please delete \"!WRONG INPUT!\" and type a correct number");

    // Check for an invalid input and catch the exception
    // if the player enters a wrong input, the images wont show and a message will appeat to tell the player to enter a correct number
    // when a correct input in entered, the images will appear and the warning message will dissapear
    public void catchError() {
        try {
            int num = Integer.parseInt(playerPick.getText());
            if (num >= 1 && num <= 3) {
                game.setPlayerPick(num);
                winMessage.setVisible(true);
                wrongInputMessage.setVisible(false);
                winMePanel.setVisible(true);
                PApanel.setVisible(true);

                imagePanel.setVisible(true);
                names.setVisible(true);
            } else if (num < 1 && num > 3) {
                imagePanel.setVisible(false);
                names.setVisible(false);
            } else {
                playerPick.setText("!WRONG INPUT!");
                imagePanel.setVisible(false);
                names.setVisible(false);
                wrongInputMessage.setVisible(true);
            }
        } catch (NumberFormatException e) {
            playerPick.setText("!WRONG INPUT!");
            winMessage.setVisible(false);
            imagePanel.setVisible(false);
            names.setVisible(false);
            wrongInputMessage.setVisible(true);
        } catch (InputMismatchException a) {
            playerPick.setText("!WRONG INPUT!");
            winMessage.setVisible(false);
            imagePanel.setVisible(false);
            names.setVisible(false);
            wrongInputMessage.setVisible(true);
        }
    }
}
