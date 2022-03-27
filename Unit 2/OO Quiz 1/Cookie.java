/**
Name: Grace Sui
Date: March 1, 2022
Description: Cookie class file.
*/

public class Cookie {

   /**
   Description: Name of the cookie
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
   Description: Whether the cookie is packaged or not
   */
   private boolean isPackaged;
   
   /**
   Description: Constructing a cookie with default attributes
   */
   public Cookie() {
      this.name = "";
      this.weight = -1;
      this.calories = -1;
      this.isPackaged = false;
   }
  
   /**
   Description: Constructing a cookie
   @param String name, Name of the cookie
   @param double weight, Weight of the cookie in grams
   @param int calories, Number calories of the cookie
   */
   public Cookie(String name, double weight, int calories) {
      this.name = name;
      this.weight = weight;
      this.calories = calories;
      this.isPackaged = false;
   }
   
   /**
   Description: Constructing a cookie
   @param String name, Name of the cookie
   @param double weight, Weight of the cookie in grams
   @param int calories, Number calories of the cookie
   @param boolean isPackaged, packaged of the cookie
   */
   public Cookie(String name, double weight, int calories, boolean isPackaged) {
      this.name = name;
      this.weight = weight;
      this.calories = calories;
      this.isPackaged = isPackaged;
   }
   
   /**
   Description: Gets the name of cookies
   @return the name of cookies
   */
   public String getName(){
      return this.name;
   }

   /**
   Description: Gets the weight of cookies
   @return the weight of cookies
   */
   public double getWeight(){
      return this.weight;
   }

   /**
   Description: Gets the calories of cookies
   @return the calories of cookies
   */
   public int getCalories(){
      return this.calories;
   }
   
   /**
   Description: Gets the boolean isPackaged
   @return isPackaged
   */
   public boolean isPackaged() {
      return isPackaged;
   }
      
   /**
   Description:Remove the packaging, if it has one. Sets isPackaged to false
   */
   public void open(){
      isPackaged = false;
   }
   
   /**
   Description: Cookie gets eaten, if it is not packaged. The amount of cookie removed is taken as a parameter. The calories removed is calculated as a percentage of the weight removed
   @param double weight --> weight that is eaten
   @return removeCalories --> the amount of calories it gives, if eaten weight > the cookie current weight, will return -1; if the current cookie is packaged will retrun -2;
   */
   public int eaten(double weight){
      if (weight > this.weight) {
         return -1;   //if eaten weight > the cookie current weight, will return -1;
      } else if (isPackaged) {
         return -2;   //if the current cookie is packaged, will retrun -2
      } else {
         int removeCalories = (int) (calories*(weight/this.weight));
         this.weight -= weight;
         this.calories -= removeCalories;
         return removeCalories;  //return the calories that is removed, it is calculated as a percentage of the weight removed
      }
   }
    
   /**
   Description: Sets new name of cookie
   @param String newName --> sets name of cookie
   */
   public void setName(String newName){
      this.name = newName;      
   }

   /**
   Description: Sets new weight of cookie
   @param double newWeight --> sets weight of cookie
   */
   public void setWeight(double newWeight){
      this.weight = newWeight;
   }

   /**
   Description: Sets new calories of cookie
   @param int calories --> sets calories of cookie
   */
   public void setCalories(int newCalories){
      this.calories = newCalories;      
   }
   
   /**
   Description: Sets isPackaged of cookie
   @param boolean isPackaged --> sets isPackaged of cookie
   */
   public void setPackaged(boolean isPackaged) {
      this.isPackaged = isPackaged;
   }
   
   /**
   Returns all the attributes of the cookie in a String
   */
   public String toString(){
      return "Name: " + name + ", Weight: " + weight + "g, Calories: " + calories + "cal, isPackaged: " + isPackaged;
   }
}