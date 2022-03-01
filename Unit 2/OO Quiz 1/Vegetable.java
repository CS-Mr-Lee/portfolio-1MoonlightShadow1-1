/**
Name: Grace Sui
Date: March 1, 2022
Description: Vegetable class file, this file will create a vegetable (class)
*/

public class Vegetable {
   
   private String name;
   
   private double weight;
   
   private int calories;
   
   public Vegetable(String name, double weight, int calories) {
      this.name = "";
      this.weight = -1;
      this.calories = -1;
   }
   
   public int eaten(double weight) {
      
   }

   public String toString(){
      return "Name: " + name + ", Weight: " + weight + "kg, Calories: " + calories + "cal";
   }
}