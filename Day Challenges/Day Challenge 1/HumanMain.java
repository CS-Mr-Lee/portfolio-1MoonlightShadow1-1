/**
Name: Christopher Park and Grace Sui
Date: February 25, 2022
Description: create two humans
             demonstrate using the accessors/mutators successfully
             demonstrate using the other methods successfully
*/

public class HumanMain {
   public static void main (String [] args) { 

      //create humanOne object with attributes of name Clair, weight 62kg, energyLevel 98%, gender Female and height 192cm.
      Human humanOne = new Human("Clair", 62, 98, "Female", 192);       
      System.out.println(humanOne.getName() + "'s height is " + humanOne.getHeight() + " and is " + humanOne.getGender()); //outputs humanOne name, height and gender
      System.out.println(humanOne.getName() + " is now " + humanOne.getWeight() + "kg and their energy level is at " + humanOne.getEnergyLevel() + "%."); //outputs the humanOne name, weight and energy level
      humanOne.run(5); //let humanOne run 5km, using method run(5).
      System.out.println(humanOne.getName() + " is now " + humanOne.getWeight() + "kg and their energy level is at " + humanOne.getEnergyLevel() + "%."); //outputs the humanOne name, weight and energy level
      humanOne.sleep(10); //let humanOne sleep 10 hours, using method sleep(10).
      System.out.println(humanOne.getName() + "'s energy level is at " + humanOne.getEnergyLevel() + "%."); //outputs the humanOne name and energy level
      
      humanOne.setHeight(200); //set humanOne height 200cm, using method setHeight(200)
      humanOne.setName("Tom"); //set humanOne name Tom, using method setName("Jenny")
      humanOne.setWeight(50); //set humanOne weight 50kg, using method setWeight(50)
      humanOne.setEnergyLevel(80); //set humanOne energy level 80%, using method setEnergyLevel(80)
      humanOne.setGender("Male"); //set humanOne Gender male, using method setGender("Male")
      System.out.println(humanOne.toString()); //perform humanOne method toString()
      System.out.println();

      //create humanTwo object with attributes of name Augustine, weight 72kg, energyLevel 50%, gender Male and height 154cm.
      Human humanTwo = new Human("Augustine", 72, 50, "Male", 154);       
      System.out.println(humanTwo.getName() + "'s height is " + humanTwo.getHeight() + " and is " + humanTwo.getGender()); // outputs humanTwo name, height and gender
      System.out.println(humanTwo.getName() + " is now " + humanTwo.getWeight() + "kg and their energy level is at " + humanTwo.getEnergyLevel() + "%."); //outputs the humanTwo name, weight and energy level
      humanTwo.run(4);  //let humanTwo run 4km, using method run(4).
      System.out.println(humanTwo.getName() + " is now " + humanTwo.getWeight() + "kg and their energy level is at " + humanTwo.getEnergyLevel() + "%."); //outputs the humanTwo name, weight and energy level
      humanTwo.sleep(8); //let humanTwo sleep 8 hours, using method sleep(8).
      System.out.println(humanTwo.getName() + "'s energy level is at " + humanTwo.getEnergyLevel() + "%."); // outputs the humanTwo name and energy level
     
      humanTwo.setHeight(160); //set humanTwo height 160cm, using method setHeight(160)
      humanTwo.setName("Jenny"); //set humanTwo name Jenny, using method setName("Jenny")
      humanTwo.setWeight(50); //set humanTwo weight 50kg, using method setWeight(50)
      humanTwo.setEnergyLevel(80); //set humanTwo energy level 80%, using method setEnergyLevel(80)
      humanTwo.setGender("Female"); //set humanTwo Gender Female, using method setGender("Female")

      System.out.println(humanTwo.toString()); //perform humanTwo method toString()

   }
}