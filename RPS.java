// Emmanuel Gutierrez Rivera
class RPS {
    private String name;
    private String ComputerName =  "COMPUTER";
    private String item;
    private int compNum;
    private int playerNum;
    private String winner;
    private int playerScore;
    private int compScore;
    private String currentImage;

    // getters
    public String getName() { return name; }
    public String getComputerName() { return ComputerName; }
    public String getItem() { return item; }
    public String getWinner() { return winner; }
    public int getPlayerScore() { return playerScore; }
    public int getComputerScore() { return compScore; } 
    public int getComputerNumber() { return compNum; }
    public int getPlayerNumber() { return playerNum; }
    public String getCurrentImage() { return currentImage; }

    // setters
    public void setName(String name) {
        this.name = name;
    }
    public void setItem(String item) {
        this.item = item;
    }
    public void setPlayerPick(int playerNum) {
        this.playerNum = playerNum;
    }
    

    // Find winner
    public void findWinner() {
        String playerWin = name + " WON!!";
        String compWin = "COMPUTER WON!!";
        String tie = "It's a TIE!!";

        if (playerNum == 1 && compNum == 3) {
            playerScore++;
            winner = playerWin;
        } else if (playerNum == 2 && compNum == 1) {
            playerScore++;
            winner = playerWin;
        } else if (playerNum == 3 && compNum == 2) {
            playerScore++;
            winner = playerWin;
        } else if (compNum == 1 && playerNum == 3) {
            compScore++;
            winner = compWin;
        } else if (compNum == 2 && playerNum == 1) {
            compScore++;
            winner = compWin;
        } else if (compNum == 3 && playerNum == 2) {
            compScore++;
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

    // set the image with the corresponding number
    public void setImg(int num) {
        if (num == 1) {
            currentImage = "paper.jpg";
        } else if (num == 2) {
            currentImage = "rock.jpg";
        } else {
            currentImage = "scissors.jpg";
        }
    }


    // to string
    public String toString() {
        return winner;
    }
}
