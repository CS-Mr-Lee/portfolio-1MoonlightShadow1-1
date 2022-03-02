/**
Name: Grace Sui
Date: March 1, 2022
Description: Vegetable class file.
*/

public class Vegetable {
   
   /**
   Description: Name of the vegetable
   */
   private String name;
   
   /**
   Description: Weight in grams
   */
   private double weight;
   
   /**
   Description: Number of calories
   */
   private int calories;
   
   /**
   Description: Default constructor --> Sets name to “”, weight to -1, calories to -1
   */
   public Vegetable() {
      this.name = "";
      this.weight = -1;
      this.calories = -1;
   }
   
   /**
   Description: Constructing a vegetable
   @param String name --> name of vegetable, double weight --> weight of vegetable, int calories --> number of calories
   */
   public Vegetable(String name, double weight, int calories) {
      this.name = name;
      this.weight = weight;
      this.calories = calories;
   }
   
   /**
   Description: Gets the name of vegetable
   @return the name of vegetable
   */
   public String getName(){
      return this.name;
   }

   /**
   Description: Gets the weight of vegetable
   @return the weight of vegetable
   */
   public double getWeight(){
      return this.weight;
   }

   /**
   Description: Gets the calories of vegetable
   @return the calories of vegetables
   */
   public int getCalories(){
      return this.calories;
   }

   /**
   Description: Vegetable gets eaten. The calories removed is calculated as a percentage of the weight removed.
   @param double weight --> The amount of vegetable removed
   @return removeCalories --> the amount of calories it gives
   */
   public int eaten(double weight) {
      if (weight > this.weight) {
         return -1;
      } else {
         int removeCalories = (int) (calories*(weight/this.weight));
         this.weight -= weight;
         this.calories -= removeCalories;
         return removeCalories;
      }
   }
   
   /**
   Description: Sets new name of vegetable
   @param String newName --> sets name of vegetable
   */
   public void setName(String newName){
      this.name = newName;      
   }

   /**
   Description: Sets new weight of vegetable
   @param double newWeight --> sets weight of vegetable
   */
   public void setWeight(double newWeight){
      this.weight = newWeight;
   }

   /**
   Description: Sets new calories of vegetable
   @param int calories --> sets calories of vegetable
   */
   public void setCalories(int newCalories){
      this.calories = newCalories;      
   }

   /**
   Returns all the attributes of the Vegetable in a String
   */
   public String toString(){
      return "Name: " + name + ", Weight: " + weight + "g, Calories: " + calories + "cal";
   }
}