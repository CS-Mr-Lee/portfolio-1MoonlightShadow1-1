/**
Name: Grace Sui
Date: March 1, 2022
Description: Cookie class file, this file will create a cookie (class)
*/

public class Cookie {

   private String name;
   
   private double weight;
   
   private int calories;
   
   private boolean isPackaged;
   
   public Cookie(String name, double weight, int calories, boolean isPackaged) {
      this.name = "";
      this.weight = -1;
      this.calories = -1;
      this.isPackaged = false;
      this.name = name;
      this.weight = weight;
      this.calories = calories;
      this.isPackaged = isPackaged;
   }
   
   public void open(){
      isPackaged = false;
   }
   
   public int eaten(double weight){
      
   }
   
   public String toString(){
      return "Name: " + name + ", Weight: " + weight + "kg, Calories: " + calories + "cal, isPackaged: " + isPackaged;
   }
}