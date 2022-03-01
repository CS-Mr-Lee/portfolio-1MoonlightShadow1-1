/**
Name: Grace Sui
Date: March 1, 2022
Description: Human class file, this file will create a human (class)
*/

public class Human {

    //used to find the name of human
    private String name;

    //used to find the weight of human
    private double weight;

    //used to find the energy level of human
    private int energyLevel;

    /*
    Constructor of Human    
    */
    public Human(String name, double weight, int energyLevel){
      
      //initializing the attributes
      this.name = ""; 
      this.weight = -1;
      energyLevel = -1;    
    }

    /**
    Gets the name of human
    @return the name of human
    */
  
    public String getName(){
      return this.name;
    }

    /**
    Gets the weight of humam
    @return the weight of human
    */
  
    public double getWeight(){
      return this.weight;
    }

    /**
    Gets the energy level of human
    @return the energy level of human
    */
  
    public int getEnergyLevel(){
      return this.energyLevel;
    }

    /**
    Description:Raises energyLevel by hours * 10%
    @param int hours
    @return void
    */
  
    public void sleep(int hours){
      if (energyLevel + (10*hours) > 100){
        energyLevel = 100;
      } else {
        energyLevel += (10*hours);
      }
    }

    /**
    Description: Loses energy decreases energyLevel by 8 per km, decreases weight by 0.001 per km
    @param double km
    @return void
    */
  
    public void run(double km){
      if ((energyLevel - (3*km) < 0)){
        energyLevel = 0;
      } else {
        energyLevel -= (3*km);        
      }
      
      if (weight - (0.001*km) < 0){
        weight = 0;
      } else {
         weight -= (0.001*km);
      }
    }

    public void eat(Vegetable veg, double grams){
      if ((energyLevel + (calories/15) > 100)){
         energyLevel = 100;
      } else {
         energyLevel += calories/15;
      }
      
      weight += grams;
      
    }
    
    public void eat(Cookie food, double grams){
      if ((energyLevel + (calories/15) > 100)){
         energyLevel = 100;
      } else {
         energyLevel += calories/15;
      }
      
      weight += grams;
      
    }
    
    /**
    Description: Sets new name of human
    @param String newName
    @return void
    */
  
    public void setName(String newName){
      this.name = newName;      
    }

    /**
    Description: Sets new weight of human
    @param double newWeight
    @return void
    */
  
    public void setWeight(double newWeight){
      this.weight = newWeight;
    }

    /**
    Description: Sets human energy level and ensures that it does not exceed 100 or go below 0
    @param int newEnergyLevel
    @return void
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