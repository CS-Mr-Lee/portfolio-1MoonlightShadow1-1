/**
Name: Christopher Park and Grace Sui
Date: February 25, 2022
Description: Human class file, this file will create a human (class)
*/

public class Human {

    //used to find the name of human
    private String name;

    //used to find the weight of human
    private double weight;

    //used to find the energy level of human
    private int energyLevel;

    //used to find the gender of human
    private String gender;

    //used to find the height of human
    private double height;
    
    /*
    Constructor of Human    
    */
    public Human(String name, double weight, int energyLevel, String gender, double height){
      
      //initializing the attributes
      this.name = name; 
      this.weight = weight;
      //energyLevel from 0 - 100
      if (energyLevel > 100){
         this.energyLevel = 100;
      } else if (energyLevel < 0){
         this.energyLevel = 0;
      } else {
         this.energyLevel = energyLevel;
      }
      this.gender = gender;
      this.height = height;
      
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
    Gets the gender of human
    @return the gender of human
    */
  
    public String getGender(){
      return this.gender;
    }

    /**
    Gets the height of human
    @return the height of human
    */
  
    public double getHeight(){
      return this.height;
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
      if ((energyLevel - (8*km) < 0)){
        energyLevel = 0;
      } else {
        energyLevel -= (8*km);        
      }
      
      if (weight - (0.001*km) < 0){
        weight = 0;
      } else {
         weight -= (0.001*km);
      }
    }

    /**
    Returns all the attributes of the human in a String
    */
  
    public String toString(){
      return "Name: " + name + ", Weight: " + weight + "kg, EnergyLevel: " + energyLevel + "%,  Gender: " + gender + ", Height: " + height + "m";
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
    Description: Sets new gender of human
    @param String newGender
    @return void
    */
  
    public void setGender(String newGender){
      this.gender = newGender;
    }

    /**
    Description: Sets new height of human
    @param double newHeight
    @return void
    */
  
    public void setHeight(double newHeight){
      this.height = newHeight;
    }
}