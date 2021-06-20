package com.kodilla.rps;

import java.util.Scanner;

public class RpsRunner {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Please enter your name: ");
        String name = input.nextLine();
        System.out.println("How many rounds you want to play: ");
        int winRounds = input.nextInt();

        Game game = new Game(new User(name), winRounds);

        boolean end = false;
        boolean restart;

        while(!end){
            game.play();
            restart = game.restartGame();
            if (restart) {
                System.out.print("Please enter your name: ");
                input.nextLine();
                name = input.nextLine();
                System.out.print("How many rounds you want to play: ");
                winRounds = input.nextInt();
                game = new Game(new User(name), winRounds);
                game.play();
            }
            if (game.endGame()) end = true;
            else if (game.getWinner() == winRounds){
                end=true;
                System.out.println("The winning rounds have been reached");
            }
        }

        game.displayStats();
    }
}
