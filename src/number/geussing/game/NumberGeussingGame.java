/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package number.geussing.game;
import java.util.*;
/**
 *
 * @author poons
 * Task 2
 */
public class NumberGeussingGame {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       // Deleverbales 
        int num;
        int num_attempts;
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        System.out.println("Welcome to Geuss The Number Game");
        System.out.println("********************************");
        System.out.println("Please enter how many rounds you would like to play");
        num_attempts = scanner.nextInt();
        
        //limt the rounds a user can play
        if (num_attempts < 5){
            
            playGame(num_attempts);
            
        } else if (num_attempts > 1) {
             System.out.println("Welcome to Geuss The Number Game");
             System.out.println("********************************");
             System.out.println("Please enter how many rounds you would like to play");
             num_attempts = scanner.nextInt();
        }
        
        //validates and output your score
        
    }
    
    public static void playGame(int num_attempts){
        // Deleverbales 
        int num;
        int totalScore = 0;
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
           //For loop 
       for (int i = 0; i <= num_attempts; i++)
        {
        //Input
        System.out.println("------------------------------------------------");
        System.out.println("Geuss the number");
        System.out.println("****************");
        System.out.println("Please enter a number from 1 - 100: " + (" Round " + i + 1));
        num = scanner.nextInt();
         System.out.println("----------------------------------------------");
        // Generate a random number between 1 and 100
        int random_number = random.nextInt(100) +1 ;
        
         //validates and output your score
        int score = gameScore(num, random_number);
            totalScore += score;
            System.out.println("You have scored: " + totalScore);
      }
           
    }
    
    public static int gameScore(int num,int  random_number){
        
         if (num == random_number){
            
            System.out.println("You gessued correctly " + num +" The radom number: " + random_number);
            return 1;
            
        }  else {
            if (num < random_number)
            {
              System.out.println("Youre number "+ num + " is lower than " + random_number);
            } else {
                
               System.out.println("Youre number "+ num + " is higher than " + random_number);
            } 
        
        }
        
        return 0;
        
    }
        
    }
 
