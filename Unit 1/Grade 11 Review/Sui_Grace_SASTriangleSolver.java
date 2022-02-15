/**
Name: Grace
Date: 2022-02-10
Description: Create a method that returns the smallest angle in a triangle in degrees given two sides and an angle in between them. The sides and angles can have decimals, and the angle is given in radians.
*/

import java.lang.*;
import java.util.Scanner;

public class Sui_Grace_SASTriangleSolver {
   public static void main (String [] args) {
   
      Scanner in = new Scanner(System.in);
      
      System.out.print("Please enter side 1: ");
      //read user input as the one side in triangle
      double side1 = in.nextDouble();
      
      System.out.print("Please enter side 2: ");
      //read user input as the one side in triangle
      double side2 = in.nextDouble();
      
      System.out.print("Please enter the angle in between the sides: ");
      //read user input as the angle value in triangle
      double angle3 = in.nextDouble();
      
      System.out.print("Is the angle value in radians or degree, r/d? ");
      String unit = in.next();
      //convert user input to radian if user input is degree.
      if (unit.equalsIgnoreCase("d")||unit.equalsIgnoreCase("degree")) {
         angle3 = (Math.PI*angle3)/180;
      } else if (unit.equalsIgnoreCase("r")||unit.equalsIgnoreCase("radians")) {
         angle3 = angle3;
      }
      //get the smallest angle from the triangle by two sides and angle in between
      double smallestAngle = calculateSmallestAngle(side1, side2, angle3);
      System.out.println(smallestAngle);
      in.close();   
   }
   
   /**
   Description: creates method calculateSmallestAngle --> returns the smallest angle in a triangle in degrees given two sides and an angle in between them. The sides and angles can have decimals, and the angle is given in radians.
   @param double side1: the double value of one side in the triangle
          double side2: the double value of other side in the triangle
          double angle3: angle in between the two sides in radians.         
   return: double value of the smallest angle in degree in the triangle.
   */   
   public static double calculateSmallestAngle (double side1, double side2, double angle3) {
   
      double smallestAngle = 0;
      //calculate the third side value in the triangle by cos law
      double side3 = Math.sqrt((side1*side1)+(side2*side2)-(2*side1*side2*Math.cos(angle3)));
      //calculate the angle1 of opposite side1 by sin law
      double angle1 = Math.asin((side1*(Math.sin(angle3))/side3)); 
      //calculate the the other angle2 
      double angle2 = Math.PI - (angle1 + angle3);
      //get the smaller angle between angle1 and angle2.
      smallestAngle = Math.min(angle1, angle2);
      //get the smaller angle between smallestAngle and angle3
      smallestAngle = Math.min(smallestAngle, angle3);
      //convet the smallestAngle to degree
      smallestAngle = (180*smallestAngle)/Math.PI;
      return smallestAngle;      
   }   
}