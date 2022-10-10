// Emmanuel Gutierrez Rivera
import javax.swing.*;
class rpsMain extends JFrame{

    public rpsMain() {
        RPSFrame rps = new RPSFrame();

        JOptionPane.showMessageDialog(rps, "***HOW TO PLAY ROCK PAPER SCISSORS*** \n\n This is a game of luck. Make your choice and hope to beat the computer! \n\n First provide your name, then... \n\n Enter your choice as follows: \n1 for ROCK \n 2 for PAPER \n 3 for SCISSORS");
        
        this.setTitle("Rock Paper Scissors Game");
        this.getContentPane().add(rps);
        this.setSize(600, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null); // places the GUI at the center of the screen when opened
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new rpsMain();
    }
}

// sources used:

// cookieClicker game that we did during class helped me to insert images
// https://stackoverflow.com/questions/1090098/newline-in-jlabel#:~:text=Surround%20the%20string%20with%20%3Chtml,lines%20with%20.&text=just%20a%20little%20correction%3A%20use,happy%20coding... Helped me on writing on a new line with a JLabel
// https://www.geeksforgeeks.org/java-awt-borderlayout-class/ for borderLayout
// https://mkyong.com/swing/java-swing-how-to-make-a-simple-dialog/ for "showMessageDialog"
// https://docs.oracle.com/en/java/index.html very useful for teaching me all the options available within an specific function