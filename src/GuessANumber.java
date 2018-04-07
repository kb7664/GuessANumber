//********************************************************************
// GuessANumber.java          Author: Karim Boyd
//
// guesses a user's chosen number and outputs the result. 
//********************************************************************

import java.util.Scanner;
import java.util.Random;

public class GuessANumber
{

   private static Scanner scan;

   public static void main(String[] args)
   {
      scan = new Scanner(System.in);
      Random rand = new Random();
      
      
      //Prompt the user to think of a number and take a value range.
      System.out.println("Think of a number but don't tell me what it is. Ready?");
      System.out.println("Give me a range to choose from. What is the lowest value?");
      int min = scan.nextInt();
      scan.nextLine();
      System.out.println("What is the highest value?");
      int max = scan.nextInt();
      scan.nextLine();
      
      //Check variables
      //System.out.println(min + " & " + max);
      
      //Pick a random value within the given range and ask the user for results. 
      int guessValue = rand.nextInt((max - min) + 1) + min;
      System.out.println("Is your number " + guessValue + "? (yes/no)");
      String ans = scan.nextLine();
      scan.reset();
      
      System.out.println(ans);
      
      //Retry until the correct number is guessed.
      String no = "no";
      String higher = "higher";
      String lower = "lower";
      
      while (ans.equals(no))
      {
         System.out.println("Is your number higher or lower?");
         String adj = scan.nextLine();
         if (adj.equals(higher)) 
         {
            min = guessValue + 1;
            guessValue = rand.nextInt((max - min) + 1) + min;
            System.out.println("Is your number " + guessValue + "? (yes/no)");
            ans = scan.nextLine();
         }
         
         if (adj.equals(lower))
         {
            max = guessValue - 1;
            guessValue = rand.nextInt((max - min) + 1) + min;
            System.out.println("Is your number " + guessValue + "? (yes/no)");
            ans = scan.nextLine();
         }
      }
      System.out.println("I did it! Tnanks for playing.");
   }
}