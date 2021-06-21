package com.kodilla.rps;

import java.util.Scanner;

public class RpsRunner {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Please enter your name: ");
        String name = input.nextLine();
        System.out.print("How many rounds you want to play: ");
        int winRounds = input.nextInt();

        Game game = new Game(new User(name), winRounds);

        boolean end = false;

        while(!end){
            game.play();
            if (game.restartGame()) {
                System.out.print("Please enter your name: ");
                input.nextLine();
                name = input.nextLine();
                System.out.print("How many rounds you want to play: ");
                winRounds = input.nextInt();
                game = new Game(new User(name), winRounds);
                game.play();
            }
            if (game.getWinner()) end=true;
        }

        game.displayStats();
    }
}
