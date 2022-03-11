/**
Name: Grace and Sophia
Date: 2022-03-03
Description: AnimalWorld class
*/

public class AnimalWorld {

    public static void main(String[] args) {
        //define three Animals
        Animal [] myAnimals = new Animal[3];
        //create first animial from Mammal. 
        myAnimals[0] = new Mammal("Cattle", 220, "pastures", false, true, "grasses", "Bos taurus", 5, true, true);
        //create second animial from Amphibians.
        myAnimals[1] = new Amphibians("Crocodile", 180, "river", false, true, "fish", "genus", "species", 2, true, "family");
        //create third animial from Animal.
        myAnimals[2] = new Animal("Bird", 20, "forest", false, true, "bug");

        for (int i = 0; i < myAnimals.length; i++) {
           System.out.println("\n" + i);
         
           //inheritance method eat(), all the three animals will gains the same weight that was eaten.
           myAnimals[i].eat(10);
           System.out.println(myAnimals[i]);
           
           //polymorphism method move(), Mammal will decreses the weight 1 kg by 3km, Amphibians will decreses the weight 1 kg by 2km and Animal will decreses the weight 1 kg by 1km.
           myAnimals[i].move(12);
           System.out.println(myAnimals[i]);
         
           if (myAnimals[i] instanceof Amphibians) {
               ((Amphibians)myAnimals[i]).caught(); //casting myAnimals[i] to Amphibians and call method caught();
           } else if (myAnimals[i] instanceof Mammal) {
               ((Mammal)myAnimals[i]).domesticate(); //casting myAnimals[i] to Mammal and call method domesticate();
           } 
        } 
    }
}