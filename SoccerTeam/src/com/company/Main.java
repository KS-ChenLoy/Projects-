package com.company;
import java.awt.*;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
    int n = 6;
    int [] myPlayersJersey = new int[n];
    int [] playRatings = new int[n];
    //Used these input variables for manipulating the ratings and jersey numbers
    Scanner input = new Scanner(System.in);
    Scanner input1 = new Scanner(System.in);

    //Storing the players and their ratings
        for (int i = 1; i < n; i++) {
            System.out.println("Enter player " + i +"'s jersey number:");
            myPlayersJersey[i] = input.nextInt();
            System.out.println("Enter player " + i + "'s rating:");
            playRatings[i] = input1.nextInt();
            System.out.print("\n");
        }
        System.out.print("\n");

        //Menu for options
        Menu();

        Scanner menuI = new Scanner(System.in);
        String str = menuI.next();

        int temp;
        Scanner tempIn = new Scanner(System.in);

        boolean found = false;

        switch (str) {
            //Update Player Rating
            case "u" -> {
                int uRate;
                System.out.println("Enter a jersey number: ");
                temp = tempIn.nextInt();
                //Need to loop through array to find jersey number. If match found change the rating 
                for (int i = 1; i < myPlayersJersey.length; i++) {
                    if (temp == myPlayersJersey[i]) {
                        found = true;
                        break;
                    }
                }
                if (found) {
                    System.out.println("Enter a new rating for player: ");
                    uRate = input1.nextInt();
                } else {
                    System.out.println("Jersey number not found");
                }
            }
            //Output players above a rating
            case "a" -> {
                System.out.println("Enter a rating: ");
                System.out.print("\n"); //skip a line
                temp = tempIn.nextInt();
                System.out.println("ABOVE " + temp);
                AboveRate(temp, myPlayersJersey, playRatings);
            }
            //Replace player
            case "r" -> {
                int newR, newP;
                System.out.println("Enter a jersey Number: ");
                temp = tempIn.nextInt();
                //Need to loop through array to find jersey number. If match found change the jersey number and rating
                for (int i = 1; i < myPlayersJersey.length; i++) {
                    if (temp == myPlayersJersey[i]) {
                        found = true;
                        break;
                    }
                }
                if (found) {
                    System.out.println("Enter a new jersey number: ");
                    newP = input.nextInt();
                    System.out.println("Enter a rating for new player: ");
                    newR = input1.nextInt();

                } else {
                    System.out.println("Jersey number not found");
                }
            }
            //Output Roster
            case "o" -> {
                System.out.println("ROSTER");
                PrintRoster(myPlayersJersey, playRatings);
            }
            //Quit
            case "q" -> System.exit(0);
        }
    }

    public static void Menu() {
        System.out.println("MENU\n" + "u - Update player rating\n" + "a - Output player above a rating\n" + "r - Replace player\n" + "o - Output Roster\n" + "q - quit\n");
    }

    public static void PrintRoster(int[] arr1, int[] arr2){
        for (int i = 1; i < arr1.length ; i++) {
            for (int j = 1; j < 2 ; j++) {
                System.out.println("Player " + i + " -- Jersey Number: " + arr1[i] + ", Rating: " + arr2[i]);
            }

        }
    }

    public static void AboveRate(int num , int [] arr1, int [] arr2){
        for (int i = 1; i < arr2.length ; i++) {
            for (int j = 1; j < 2 ; j++) {
                if (num < arr2[i]){
                    System.out.println("Player " + i + " -- Jersey Number: " + arr1[i] + ", Rating: " + arr2[i]);
                }
            }
        }
    }

}
