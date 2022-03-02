/**
Name: Grace Sui
Date: March 1, 2022
Description: Human class file.
*/

public class Human {

   /**
   Description: name of the human.
   */
   private String name;

   /**
   Description: weight of the human.
   */
   private double weight;

   /**
   Description: energyLevel of the human.
   */
   private int energyLevel;

   /**
   Constructor of Human, Initializes the attributes name, weight and energyLevel    
   */
   public Human(){
      //initializing the attributes
      this.name = ""; 
      this.weight = -1;
      this.energyLevel = -1;    
   }
    
   /**
   Constructor of Human    
   */
   public Human(String name, double weight, int energyLevel){
      //initializing the attributes
      this.name = name; 
      this.weight = weight;
      this.energyLevel = energyLevel;
   }

   /**
   Description: Gets the name of human
   @return the name of human
   */
   public String getName(){
      return this.name;
   }

   /**
   Description: Gets the weight of humam
   @return the weight of human
   */
   public double getWeight(){
      return this.weight;
   }

   /**
   Description: Gets the energy level of human
   @return the energy level of human
   */
   public int getEnergyLevel(){
      return this.energyLevel;
   }

   /**
   Description:Raises energyLevel by hours * 10%
   @param int hours --> hours of sleep
   */
   public void sleep(int hours){
      if (energyLevel + 10*hours > 100){
         energyLevel = 100;
      } else {
         energyLevel += 10*hours;
      }
   }

   /**
   Description: Loses energy decreases energyLevel 1km = 3%, decreases weight by 0.001 per km
   @param double km --> kms of running
   */
   public void run(double km){
      if (energyLevel - 3*km < 0){
         energyLevel = 0;
      } else {
         energyLevel -= 3*km;        
      }
      
      if (weight - 0.001*km < 0){
         weight = 0;
      } else {
         weight -= 0.001*km;
      }
   }

   /**
   Description: 
   @param Vegetable veg --> the eaten vegetable, double grams --> grams of vegetable that will be eaten
   */
   public void eat(Vegetable veg, double grams){
      int calories = veg.eaten(grams);
      if (calories == -1) {
         System.out.println("I don't have that much food");
      } else {
         if (energyLevel + calories/15 > 100){
            energyLevel = 100;
         } else {
            energyLevel += calories/15;
         }
          
         weight += grams/1000;
      }
   }
   
   /**
   Description: 
   @param Cookie food --> the eaten cookie, double grams --> grams of cookie that will be eaten
   */
   public void eat(Cookie food, double grams){
      int calories = food.eaten(grams);
      if (calories == -1) {
         System.out.println("I don't have that much food");
      } else if (calories == -2) {
         System.out.println("I can't eat the bag");
      } else {
         if (energyLevel + calories/15 > 100){
            energyLevel = 100;
         } else {
            energyLevel += calories/15;
         }
          
         weight += grams/1000;
      }
   }
    
   /**
   Description: Sets new name of human
   @param String newName --> sets name of human
   */
   public void setName(String newName){
      this.name = newName;      
   }

   /**
   Description: Sets new weight of human
   @param double newWeight --> sets weight of human
   */
   public void setWeight(double newWeight){
      this.weight = newWeight;
   }

   /**
   Description: Sets human energy level and ensures that it does not exceed 100 or go below 0
   @param int newEnergyLevel --> sets energyLevel of human
   */
   public void setEnergyLevel(int newEnergyLevel){
      //energyLevel from 0 - 100
      if (newEnergyLevel > 100){
         this.energyLevel = 100;
      } else if (newEnergyLevel < 0){
         this.energyLevel = 0;
      } else {
         this.energyLevel = newEnergyLevel;
      }
   }
   
   /**
   Returns all the attributes of the human in a String
   */
   public String toString(){
      return "Name: " + name + ", Weight: " + weight + "kg, EnergyLevel: " + energyLevel + "%";
   }
}