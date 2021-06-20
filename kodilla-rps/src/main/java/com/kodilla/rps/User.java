package com.kodilla.rps;

import java.util.Objects;
import java.util.Scanner;

public class User extends GameState {

    private String username;

    public User(final String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username){
        this.username = username;
    }

    public CHOICES getChoice(){
        Scanner input = new Scanner(System.in);
        System.out.print("Choose your figure:\n[1] ROCK | [2] PAPER | [3] SCISSORS | [4] SPOCK | [5] LIZARD" +
                "\n[x] END GAME | [n] RESTART GAME ");
        char choice = input.nextLine().toUpperCase().charAt(0);
        switch (choice){
            case '1':
                return CHOICES.ROCK;
            case '2':
                return CHOICES.PAPER;
            case '3':
                return CHOICES.SCISSORS;
            case '4':
                return CHOICES.SPOCK;
            case '5':
                return CHOICES.LIZARD;
            case 'X':
                System.out.print("Are you sure you want to end the game ? [y] yes | [n] no: ");
                choice = input.nextLine().charAt(0);
                if (choice == 'y') return CHOICES.END;
                break;
            case 'N':
                System.out.print("Are you sure you want to restart the game ? [y] yes | [n] no: ");
                choice = input.nextLine().charAt(0);
                if (choice == 'y') return CHOICES.RESTART;
                break;
        }

        return getChoice();
    }
}
