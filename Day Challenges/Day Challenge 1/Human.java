/**
Name: Christopher Park and Grace Sui
Date: February 25, 2022
Description: Human class file
*/

public class Human {

    /**
    Name of the human    
    */
    private String name;

    /**
    weight of the human    
    */
    private double weight;

    /**
    energyLevel of the human    
    */
    private int energyLevel;

    /**
    gender of the human    
    */
    private String gender;

    /**
    height of the human    
    */
    private double height;
    
    /**
    Constructing a human Sets name, weight, energyLevel, gender and height from parameters    
    */
    public Human(String name, double weight, int energyLevel, String gender, double height){
      
        //initializing the attributes
        this.name = name; 
        this.weight = weight;
        //energyLevel from 0 - 100, if energyLevel > 100, set to 100; if energyLevel < 0 set to 0
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
    @return String, the name of human
    */
    public String getName(){
        return this.name;
    }

    /**
    Gets the weight of humam
    @return double, the weight of human
    */  
    public double getWeight(){
        return this.weight;
    }

    /**
    Gets the energy level of human
    @return int, the energy level of human
    */  
    public int getEnergyLevel(){
        return this.energyLevel;
    }

    /**
    Gets the gender of human
    @return String, the gender of human
    */  
    public String getGender(){
        return this.gender;
    }

    /**
    Gets the height of human
    @return double, the height of human
    */  
    public double getHeight(){
        return this.height;
    }

    /**
    Description:Raises energyLevel by hours * 10%
    @param int, hours to sleep
    */  
    public void sleep(int hours){
        //Raises energyLevel by hours * 10%. if the raised energyLevel > 100, set to 100. if the raised energyLevel < 0, set to 0 
        if (energyLevel + (10*hours) > 100){
            energyLevel = 100;
        } else {
            energyLevel += (10*hours);
        }
    }

    /**
    Description: Loses energy decreases energyLevel by 8 per km, decreases weight by 0.001 per km
    @param double, km to run
    */  
    public void run(double km){
        //decreases energyLevel by 8% per km. set energyLevel = 0, if energyLevel - 8*km < 0
        if ((energyLevel - (8*km) < 0)){
            energyLevel = 0;
        } else {
            energyLevel -= (8*km);        
        }
        //decreases weight by 0.001 per km, set weight = 0, if weight - 0.001*km < 0
        if (weight - (0.001*km) < 0){
            weight = 0;
        } else {
            weight -= (0.001*km);
        }
    }

    /**
    @return String, all the attributes of the human in a String
    */  
    public String toString(){
        return "Name: " + name + ", Weight: " + weight + "kg, EnergyLevel: " + energyLevel + "%,  Gender: " + gender + ", Height: " + height + "m";
    }

    /**
    Description: Sets new name of human
    @param String newName, new Name of human
    */  
    public void setName(String newName){
        this.name = newName;      
    }

    /**
    Description: Sets new weight of human
    @param double newWeight, new Weight of human
    */  
    public void setWeight(double newWeight){
        this.weight = newWeight;
    }

    /**
    Description: Sets human energy level and ensures that it does not exceed 100 or go below 0
    @param int newEnergyLevel, new Energy Level  of human
    */  
    public void setEnergyLevel(int newEnergyLevel){
        //energyLevel from 0 - 100, if the new energyLevel > 100, set to 100. if the new energyLevel < 0, set to 0 
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
    @param String newGender, new gender of human
    */  
    public void setGender(String newGender){
        this.gender = newGender;
    }

    /**
    Description: Sets new height of human
    @param double newHeight, new height of human
    */  
    public void setHeight(double newHeight){
        this.height = newHeight;
    }
}