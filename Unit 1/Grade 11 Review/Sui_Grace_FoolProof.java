/**
Name: Grace
Date: 2022-02-10
Description: Write a program that repeatedly asked for the numerator and divisor. 
            For each set of data, the program prints out the result (quotient), 
            or an informative error message if there is a problem (division by zero 
            or poor input data). The program continues looping, even if there is a problem. 
            Exit the loop when data entered for the numerator start with characters 
            “q” or “Q”. Don’t print out an error message in this case. 
            Don’t ask for the divisor if the user just asked to quit..
*/
import java.util.Scanner;

public class Sui_Grace_FoolProof {

   public static void main(String[] args) {
      Scanner in = new Scanner(System.in);
      //keep asking user input numerator and divisor until entered for the numerator start with characters “q” or “Q”
      while (true) {
         System.out.print("Enter the numerator: ");
         String input = in.next();
         //will quit application if user input word start with "Q" or "q"
         if (input.startsWith("Q") || input.startsWith("q")) {
            break;
         }
         try {
            //save user input as double value to numerator
            double numerator = Double.valueOf(input);

            System.out.print("Enter the divisor: ");
            input = in.next();
            //print You can't divide by 0 if user input is 0
            if (input.equals("0")) {
               System.out.println("You can't divide " + numerator + " by 0");
            } else {
               //save user input as double value to divisor
               double divisor = Double.valueOf(input);
               //show the result
               System.out.println(numerator + "/" + divisor + " is " + numerator / divisor);
            }
         } catch (Exception e) {
            //show you entered bad data, Please try again, if user input is not number 
            System.out.println("You entered bad data, Please try again.");
            in.nextLine();
         }
      }
      in.close();
   }
}