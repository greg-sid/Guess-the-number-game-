/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guessnumber;

import java.util.Random;
import java.util.Scanner;
/**
 *
 * @author greg-sid
 */
public class GuessNumber {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Random random = new Random();
        try (Scanner scan = new Scanner(System.in)) {
  
            int attempts = 0; 
            int points = 10;
            int totalPoints = 0;  
            int maxNumber = 100;
            int minNumber = 1;
            int guessHigh = 0;
            int guessLow = 0;
            int rounds = 0;
            int guess = 0;
            int hiddenNumber = random.nextInt(100) + 1;
            String repeatAgain = null;
            System.out.println("====================================================");
            String newLine = System.getProperty("line.separator");
            String newLine4 = System.getProperty("line.separator");
            System.out.println("Follow the instructions of the program" + newLine +  "and try to guess the hidden number between 1 and 100");
            System.out.println(" ");
            System.out.println("You must find the number utill 10 unsuccessful guesses" + newLine4 + "(Invalid guesses do not count as attempts)");
            System.out.println(" ");
            System.out.println("For every failed attempt you lose 1 point!");
            System.out.println("Type 4 zeros to exit anytime!");
            System.out.println(" ");
            System.out.println("===================== Good Luck ====================");
            System.out.println(" ");
            
            System.out.println("Give a number between 1 and 100: ");
            
            while (guess != hiddenNumber){
               
                while (!scan.hasNextInt()){
                    System.out.println("Invalid prediction! The game accepts only integers!");
                    System.out.println("Give a number between " + minNumber + " and " + maxNumber + " :");
                    scan.next();  
                }
                guess = scan.nextInt();
                if (guess == 0000){
                    System.out.println("==================================================");
                    System.out.println("Thanks for your participation!");
                    System.out.println("You played " + rounds + " rounds and you won " + totalPoints + " points in total!");
                    System.out.println("=================  Good bye  =====================");
                    break;
                }
                if (guess < 1 || guess > 100){
                    System.out.println("Invalid prediction! The allowed limit is from 1 to 100!");
                    System.out.println("Give a number between " + minNumber + " and " + maxNumber + " :");
                    scan.nextLine();
                    continue;
                }  
                if (guess < minNumber || guess > maxNumber) {
                    System.out.println("Invalid prediction! Give a number between "
                            + minNumber + " and " + maxNumber + " :");
                    continue;
                }                
                if (guess == hiddenNumber){
                    totalPoints += points;
                    rounds++;
                    System.out.println("Congratulations!! You found the hidden number "+hiddenNumber+ " after " + attempts + " failed guesses Score: " + points);
                    System.out.println("Total score: " + totalPoints);
                    System.out.println(" ");
                    do{
                        System.out.println("Would you like to play again (y/n)? ");
                        repeatAgain = scan.next();
                        if ((repeatAgain.equalsIgnoreCase("y"))){                            
                            attempts = -1;
                            points = 11;
                            hiddenNumber = random.nextInt(100) + 1;
                            maxNumber = 100;
                            minNumber = 1;
                            guessHigh = 0;
                            guessLow = 0;
                            System.out.println("Give a number between 1 and 100: ");
                        }
                        else if ((repeatAgain.equalsIgnoreCase("n"))){
                            System.out.println("==================================================");
                            System.out.println("Thanks for your participation!");
                            System.out.println("You played " + rounds + " rounds and you won " + totalPoints + " points in total!");
                            System.out.println("=================  Good bye  =====================");
                            break;
                        }
                        else {
                            System.out.println("==============================================");
                            System.out.println("Your answer is invalid! ");
                            String newLine2 = System.getProperty("line.separator");
                            System.out.println("Type with upper or low case " + newLine2 + "y to play again or n to exit the game..");
                            System.out.println("==============================================");
                        }                             
                    }while((!"y".equalsIgnoreCase(repeatAgain)));                  
                }
                else if (guess < hiddenNumber){
                    guessLow = guess;
                    minNumber = guessLow + 1;
                    System.out.println(guess +" is low. Try again!");
                    System.out.println("Give a number between " + minNumber + " and " + maxNumber + ":");                       
                }
                else if (guess > hiddenNumber){
                    guessHigh = guess;
                    maxNumber = guessHigh - 1;
                    System.out.println(guess +" is high. Try again!");
                    System.out.println("Give a number between " + minNumber + " and " + maxNumber + ":");                        
                }               
                if (attempts < 10){
                    attempts += 1;
                    points -= 1;
                }
                else{
                    rounds++;
                    System.out.println("Sorry! After 10 unsuccessful attempts, you failed to find the hidden number: " +hiddenNumber+ " ! Score: 0");
                    System.out.println("Total score: " + totalPoints);
                    do{
                        System.out.println("Would you like to play again (y/n)? ");
                        repeatAgain = scan.next();
                        if ((repeatAgain.equalsIgnoreCase("y"))){
                            attempts = 0;
                            points = 10;
                            hiddenNumber = random.nextInt(100) + 1;
                            maxNumber = 100;
                            minNumber = 1;
                            guessHigh = 0;
                            guessLow = 0;
                            System.out.println("Give a number between 1 and 100: ");
                        }
                        else if ((repeatAgain.equalsIgnoreCase("n"))){
                            System.out.println("==================================================");
                            System.out.println("Thanks for your participation!");
                            System.out.println("You played " + rounds + " rounds and you won " + totalPoints + " points in total!");
                            System.out.println("=================  Good bye  =====================");
                            return;
                        }
                        else {
                            System.out.println("==============================================");
                           System.out.println("Your answer is invalid! ");
                            String newLine2 = System.getProperty("line.separator");
                            System.out.println("Type with upper or low case " + newLine2 + "y to play again or n to exit the game..");
                            System.out.println("==============================================");
                        }
                    }while((!"y".equalsIgnoreCase(repeatAgain)));                    
                }
            }               
        }			
    }
}
    

