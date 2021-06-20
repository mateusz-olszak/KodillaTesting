package com.kodilla.rps;


public class Game extends GameState{

    private final User user;
    private final Computer computer;
    private final int winRounds;
    private CHOICES playerChoice;
    private CHOICES computerChoice;
    private RESULT result;
    private int wins;
    private int loses;
    private int ties;
    private boolean endGame = false;
    private boolean restartGame = false;
    private int playerWin=0;
    private int computerWin=0;

    public Game(final User user, final int winRounds) {
        this.user = user;
        this.computer = new Computer(user);
        this.winRounds = winRounds;
    }

    public void play(){
        playerChoice = user.getChoice();
        if (playerChoice == CHOICES.END) endGame = true;
        else if (playerChoice == CHOICES.RESTART){
            restartGame = true;
            displayStats();
            stats();
        }
        else{
            computerChoice = computer.getChoice();
            result = getResult();
            displayResults();
            stats();
        }
    }

    public void displayStats(){
        System.out.println("You have played " + (wins+loses+ties) + " times");
        System.out.println("Player " + user.getUsername() + " has won " + wins + " times");
        System.out.println("You have lost " + loses + " times");
        System.out.println("The tie was " + ties + (ties == 1 ? " time" : " times"));
    }

    private void stats(){
        if (result == RESULT.WIN)
            wins++;
        else if (result == RESULT.LOSE)
            loses++;
        else if (result == RESULT.TIE)
            ties++;
    }

    private void displayResults(){
        switch (result){
            case WIN:
                System.out.println(playerChoice + " beats " + computerChoice + ". Player wins");
                break;
            case LOSE:
                System.out.println(playerChoice + " loses to " + computerChoice + ". Computer wins");
                break;
            case TIE:
                System.out.println(playerChoice + " equals to " + computerChoice + ". Its a tie");

        }
    }

    private RESULT getResult(){
        if (playerChoice == computerChoice) return RESULT.TIE;
        switch (playerChoice){
            case ROCK:
                return rockAndScissorsCase(CHOICES.SCISSORS, CHOICES.PAPER);
            case PAPER:
                return paperCase();
            case SCISSORS:
                return rockAndScissorsCase(CHOICES.PAPER, CHOICES.ROCK);
            case SPOCK:
                return spockCase();
            case LIZARD:
                return lizardCase();
        }
        return null;
    }

    private RESULT lizardCase() {
        if (computerChoice == CHOICES.PAPER){
            playerWin++;
            return RESULT.WIN;
        }else if (computerChoice == CHOICES.ROCK){
            playerWin++;
            return RESULT.WIN;
        }else if (computerChoice == CHOICES.SCISSORS){
            computerWin++;
            return RESULT.LOSE;
        }else{
            computerWin++;
            return RESULT.LOSE;
        }
    }

    private RESULT spockCase() {
        if (computerChoice == CHOICES.PAPER){
            computerWin++;
            return RESULT.LOSE;
        }else if (computerChoice == CHOICES.ROCK){
            playerWin++;
            return RESULT.WIN;
        }else if (computerChoice == CHOICES.SCISSORS){
            playerWin++;
            return RESULT.WIN;
        }else{
            computerWin++;
            return RESULT.LOSE;
        }
    }

    private RESULT paperCase() {
        if (computerChoice == CHOICES.ROCK){
            playerWin++;
            return RESULT.WIN;
        }else if (computerChoice == CHOICES.SCISSORS){
            computerWin++;
            return RESULT.LOSE;
        }else if (computerChoice == CHOICES.SPOCK){
            playerWin++;
            return RESULT.WIN;
        }else {
            computerWin++;
            return RESULT.LOSE;
        }
    }

    private RESULT rockAndScissorsCase(CHOICES scissors, CHOICES paper) {
        if (computerChoice == scissors) {
            playerWin++;
            return RESULT.WIN;
        } else if (computerChoice == paper) {
            computerWin++;
            return RESULT.LOSE;
        } else if (computerChoice == CHOICES.SPOCK) {
            computerWin++;
            return RESULT.LOSE;
        } else {
            playerWin++;
            return RESULT.WIN;
        }
    }

    public int getWinner() {
        if (playerWin == winRounds)
            return playerWin;
        else if (computerWin == winRounds)
            return computerWin;
        else return 0;
    }

    public boolean endGame(){
        return endGame;
    }

    public boolean restartGame(){
        return restartGame;
    }
}
