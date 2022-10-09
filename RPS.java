import java.util.Random;
import java.util.Scanner;
class RPS {
    private String name;
    private String item;
    private int compNum;
    private int playerNum;
    private String winner;
    private int playerScore;
    private int compScore;

    // getters
    public String getName() { return name; }
    public String getItem() { return item; }
    public String getWinner() { return winner; }
    public int getPlayerScore() { return playerScore; }
    public int getComputerScore() { return compScore; }
    public int getComputerNumber() { return compNum; }
    public int getPlayerNumber() { return playerNum; }

    // setters
    public void setName(String name) {
        this.name = name;
    }
    public void setItem(String item) {
        this.item = item;
    }
    public void playerPick(int playerNum) {
        this.playerNum = playerNum;
    }
    public void setPlayerScore(int playerScore) {
        this.playerScore = playerScore;
    }
    public void setComputerScore(int compScore) {
        this.compScore = compScore;
    }

    // Find winner
    public void findWinner() {
        String playerWin = name + " WON!!";
        String compWin = "Compuer WON!!";
        String tie = "It's a TIE!!";

        if (playerNum == 1 && compNum == 3) {
            playerScore ++;
            winner = playerWin;
        } else if (playerNum == 2 && compNum == 1) {
            playerScore ++;
            winner = playerWin;
        } else if (playerNum == 3 && compNum == 2) {
            playerScore ++;
            winner = playerWin;
        } else if (compNum == 1 && playerNum == 3) {
            compScore ++;
            winner = compWin;
        } else if (compNum == 2 && playerNum == 1) {
            compScore ++;
            winner = compWin;
        } else if (compNum == 3 && playerNum == 2) {
            compScore ++;
            winner = compWin;
        } else {
            winner = tie;
        }
    }

    // get random num that will represent the item for the computer
    public void computerPick() {
        int randNum = (int)(Math.random() * 3 - 1 + 1) + 1;
        compNum = randNum;
    }

    // to string
    public String toString() {
        return winner;
    }
}
