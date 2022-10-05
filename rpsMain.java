import javax.swing.*;
class rpsMain extends JFrame{

    public rpsMain() {
        RPS rps = new RPS();

        // HOW TO PLAY message
        JOptionPane.showMessageDialog(rps, "***HOW TO PLAY ROCK PAPER SCISSORS*** \n\n This is a game of luck. Make your choice and hope to beat the computer! \n\n Enter your choice as follows: \n1 for ROCK \n 2 for PAPER \n 3 for SCISSORS");
        
        this.setTitle("Rock Paper Scissors Game");
        this.getContentPane().add(rps);
        this.setSize(500, 400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null); // places the GUI at the center of the screen when opened
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new rpsMain();
    }
}