package com.kodilla.rps;

public class Game{

    private final User user;
    private final Computer computer;
    private final int winRounds;
    private Choice playerChoice;
    private Choice computerChoice;
    private Result result;
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
        if (playerChoice == Choice.END) endGame = true;
        else if (playerChoice == Choice.RESTART){
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
        System.out.println("You have played " + (wins+loses+ties) + ((wins+loses+ties) == 1 ? " time" : " times"));
        System.out.println("Player " + user.getUsername() + " has won " + wins + (wins == 1 ? " time" : " times"));
        System.out.println("You have lost " + loses + (loses == 1 ? " time" : " times"));
        System.out.println("The tie was " + ties + (ties == 1 ? " time" : " times"));
    }

    private void stats(){
        if (result == Result.WIN)
            wins++;
        else if (result == Result.LOSE)
            loses++;
        else if (result == Result.TIE)
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

    private Result getResult(){
        if (playerChoice == computerChoice) return Result.TIE;
        switch (playerChoice){
            case ROCK:
                return rockAndScissorsCase(Choice.SCISSORS, Choice.PAPER);
            case PAPER:
                return paperCase();
            case SCISSORS:
                return rockAndScissorsCase(Choice.PAPER, Choice.ROCK);
            case SPOCK:
                return spockCase();
            case LIZARD:
                return lizardCase();
        }
        return null;
    }

    private Result lizardCase() {
        if (computerChoice == Choice.PAPER){
            playerWin++;
            return Result.WIN;
        }else if (computerChoice == Choice.ROCK){
            playerWin++;
            return Result.WIN;
        }else if (computerChoice == Choice.SCISSORS){
            computerWin++;
            return Result.LOSE;
        }else{
            computerWin++;
            return Result.LOSE;
        }
    }

    private Result spockCase() {
        if (computerChoice == Choice.PAPER){
            computerWin++;
            return Result.LOSE;
        }else if (computerChoice == Choice.ROCK){
            playerWin++;
            return Result.WIN;
        }else if (computerChoice == Choice.SCISSORS){
            playerWin++;
            return Result.WIN;
        }else{
            computerWin++;
            return Result.LOSE;
        }
    }

    private Result paperCase() {
        if (computerChoice == Choice.ROCK){
            playerWin++;
            return Result.WIN;
        }else if (computerChoice == Choice.SCISSORS){
            computerWin++;
            return Result.LOSE;
        }else if (computerChoice == Choice.SPOCK){
            playerWin++;
            return Result.WIN;
        }else {
            computerWin++;
            return Result.LOSE;
        }
    }

    private Result rockAndScissorsCase(Choice scissors, Choice paper) {
        if (computerChoice == scissors) {
            playerWin++;
            return Result.WIN;
        } else if (computerChoice == paper) {
            computerWin++;
            return Result.LOSE;
        } else if (computerChoice == Choice.SPOCK) {
            computerWin++;
            return Result.LOSE;
        } else {
            playerWin++;
            return Result.WIN;
        }
    }

    public boolean getWinner() {
        if (playerWin == winRounds)
            return true;
        else if (computerWin == winRounds)
            return true;
        else if (endGame)
            return true;
        else return false;
    }

    public boolean restartGame(){
        return restartGame;
    }
}
