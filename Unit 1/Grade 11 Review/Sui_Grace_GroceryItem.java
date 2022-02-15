/**
Name: Grace
Date: 2022-02-10
Description: Create a program that asks for two grocery items and their price.
*/

import java.util.Scanner;

public class Sui_Grace_GroceryItem {
    public static void main(String[] args) {
       Scanner in = new Scanner(System.in);
       int maxGroceryNameLength = 20;
       double maxGroceryPrice = 99.99;
       int spcaceAfterGroceryName = 10;
       System.out.println("Please enter the first grocery name(cannot exceed " + maxGroceryNameLength +" characters): ");
       //get grocery name
       String firstGroceryName = in.next();
       if (firstGroceryName.length() > maxGroceryNameLength) {
          //print error message and quit if grocery name is longer than maxGroceryNameLength
          System.out.println("The grocery name cannot exceed " + maxGroceryNameLength + " characters");
       } else {
          System.out.println("Please enter the first grocery price(cannot exceed "+ maxGroceryPrice + "): ");
          //get grocery price
          double firstGroceryPrice = in.nextDouble();
          if (firstGroceryPrice > maxGroceryPrice) {
             //print error message and quit if price is bigger than maxGroceryPrice
             System.out.println("The grocery price cannot exceed "+ maxGroceryPrice);
          } else {
             System.out.println("Please enter the second grocery name(cannot exceed " + maxGroceryNameLength +" characters): ");
             //get grocery name
             String secondGroceryName = in.next();
             if (secondGroceryName.length() > maxGroceryNameLength) {
                //print error message and quit if grocery name longer than maxGroceryNameLength
                System.out.println("The grocery name cannot exceed " + maxGroceryNameLength + " characters");
             } else {
                System.out.println("Please enter the second grocery price(cannot exceed "+ maxGroceryPrice + "): ");
                //get grocery price
                double secondGroceryPrice = in.nextDouble();
                if (secondGroceryPrice > maxGroceryPrice) {
                   //print error message and quit if price bigger than maxGroceryPrice
                   System.out.println("The grocery price cannot exceed "+ maxGroceryPrice);
                } else {
                   System.out.println("-----------------------------------------------------");
                   System.out.print("Grocery " + firstGroceryName);
                   //print spcaceAfterGroceryName + maxGroceryNameLength - firstGroceryName.length() space so that align the price
                   for (int i = 0; i < (maxGroceryNameLength - firstGroceryName.length()) + spcaceAfterGroceryName; i++) {
                      System.out.print(" ");
                   }
                       
                   //convert double price to string
                   String strPrice = String.valueOf(firstGroceryPrice);
                   int indexOfDot = strPrice.indexOf("."); //get position of dot in the double value
                   if (indexOfDot == 1) {
                       //if there are 1 digit number in front of dot.
                       System.out.print(" $");
                   } else {
                       //if there are 2 digit numbers in front of dot.
                       System.out.print("$");
                   }
                   System.out.printf("%3.2f%n", firstGroceryPrice);
                   System.out.print("Grocery " + secondGroceryName);
                   //print spcaceAfterGroceryName + maxGroceryNameLength - secondGroceryName.length() space so that align the price
                   for (int i = 0; i < (maxGroceryNameLength - secondGroceryName.length()) + spcaceAfterGroceryName; i++) {
                       System.out.print(" ");
                   }
                   //convert double price to string
                   strPrice = String.valueOf(secondGroceryPrice);
                   indexOfDot = strPrice.indexOf("."); //get position of dot in the double value
                   if (indexOfDot == 1) {
                       //if there are 1 digit number in front of dot.
                       System.out.print(" $");
                   } else {
                       //if there are 2 digit number2 in front of dot.
                       System.out.print("$");
                   }
                   System.out.printf("%3.2f%n", secondGroceryPrice);
                   System.out.println("-----------------------------------------------------");
               } 
            }
         }
      }
   }
}