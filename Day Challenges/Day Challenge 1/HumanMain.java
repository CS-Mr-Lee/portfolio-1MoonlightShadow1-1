/**
Name: Christopher Park and Grace Sui
Date: February 25, 2022
Description: create two humans
             demonstrate using the accessors/mutators successfully
             demonstrate using the other methods successfully
*/

public class HumanMain {
   public static void main (String [] args) { 

      /**
      Human One attributes, energy levels and sleep
      */
     
      Human humanOne = new Human("Clair", 62, 98, "female", 192); // create humanOne object
      System.out.println(humanOne.getName() + "'s height is " + humanOne.getHeight() + " and is " + humanOne.getGender()); //outputs humanOne name, height and gender
      System.out.println(humanOne.getName() + " is now " + humanOne.getWeight() + "kg and their energy level is at " + humanOne.getEnergyLevel() + "%."); //outputs the humanOne name, weight and energy level
      humanOne.run(5); //perform humanOne method run() with 5km
      System.out.println(humanOne.getName() + " is now " + humanOne.getWeight() + "kg and their energy level is at " + humanOne.getEnergyLevel() + "%."); //outputs the humanOne name, weight and energy level
      humanOne.sleep(10); //perform humanOne method sleep() with 10 hours
      System.out.println(humanOne.getName() + "'s energy level is at " + humanOne.getEnergyLevel() + "%."); //outputs the humanOne name and energy level
      humanOne.setHeight(200); //perform humanOne method setHeight() with 200
      System.out.println(humanOne.toString()); //perform humanOne method toString()
      System.out.println();

      /**
      Human Two attributes, energy levels and sleep
      */
     
      Human humanTwo = new Human("Augustine", 72, 50, "male", 154); // create humanTwo object
      System.out.println(humanTwo.getName() + "'s height is " + humanTwo.getHeight() + " and is " + humanTwo.getGender()); // outputs humanTwo name, height and gender
      System.out.println(humanTwo.getName() + " is now " + humanTwo.getWeight() + "kg and their energy level is at " + humanTwo.getEnergyLevel() + "%."); //outputs the humanTwo name, weight and energy level
      humanTwo.run(4); // perform humanTwo method run() with 4km
      System.out.println(humanTwo.getName() + " is now " + humanTwo.getWeight() + "kg and their energy level is at " + humanTwo.getEnergyLevel() + "%."); //outputs the humanTwo name, weight and energy level
      humanTwo.sleep(8); // perform humanTwo method sleep() with 8 hours
      System.out.println(humanTwo.getName() + "'s energy level is at " + humanTwo.getEnergyLevel() + "%."); // outputs the humanTwo name and energy level
      humanTwo.setHeight(160); //perform humanTwo method setHeight() with 160
      System.out.println(humanTwo.toString()); //perform humanTwo method toString()

   }
}