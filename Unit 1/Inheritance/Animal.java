/**
Name: Grace and Sophia
Date: 2022-03-03
Description: Animal class
*/

public class Animal {

   /** name of animal */
   private String name;

   /** weight of animal in kg */
   private double weight;

   /** habitat of animal */
   private String habitat;

   /** if animal endangered or not*/
   private boolean endangered;

   /** if animal alive or not*/
   private boolean alive;
  
   /** diet of animal */
   private String diet;
   
   /**
   * Default Constructor an animal: Sets name to "", weight to -1, habitat to "", endangered to false, alive to false and diet to ""   
   */
   public Animal() {
      this.name = "";
      this.weight = -1;
      this.habitat = "";
      this.endangered = false;
      this.alive = false;
      this.diet = "";
   }
  
   /**
   * Constructor an animal: Sets name, weight, habitat, endangered, alive and diet from parameters
   * @param String name, the name of Animal
   * @param double weight, the weight of Animal
   * @param String habitat, the habitat of Animal
   * @param boolean endangered, the endangered of Animal
   * @param boolean alive, the alive of Animal
   * @param String diet, the diet of Animal   
   */
   public Animal(String name, double weight, String habitat, boolean endangered,  boolean alive, String diet) {
      this.name = name;
      this.weight = weight;
      this.habitat = habitat;
      this.endangered = endangered;
      this.alive = alive;
      this.diet = diet;
   }
   
   /**
   * Description: animal eats something and gains the same weight that was eaten.
   * @param double grams, the weight in grams of what is being eaten
   * @return double, weight of the animal in kg.   
   */
   public double eat(double grams) {
      this.weight += grams/1000; //increase the weight by the weight of food, convert grams to kg.
      return this.weight;
   }
  
   /**
   * Description: animal gets eaten, affecting whether or not it's alive
   * @return false once it is eaten, its dead
   */  
   public boolean eaten() {
      this.alive = false;
      return this.alive;
   }
      
   /**
   * Description: decreses the weight of the animal based on how far it travels. per km it travels it looses a kg
   * @param double km -- a double of how far it travels
   * @return double, the new weight of animal in kg
   */ 
   public double move(double km) {
      this.weight = this.weight - km;//decreses the weight 1 kg by 1km
      return this.weight;
   }

   /**
   * Description: get animal name.
   * @return String, the name of animal 
   */
   public String getName() {
      return name;
   }

   /**
   * Description: set animal name.
   * @param String name, the new name of animal 
   */
   public void setName(String name) {
      this.name = name;
   }

   /**
   * Description: get animal weight.
   * @return double, the weight of animal in kg
   */
   public double getWeight() {
      return weight;
   }

   /**
   * Description: set animal weight.
   * @param double weight, the new weight of animal in kg
   */
   public void setWeight(double weight) {
      this.weight = weight;
   }

   /**
   * Description: get animal habitat.
   * @return String, the habitat of animal 
   */
   public String getHabitat() {
      return habitat;
   }

   /**
   * Description: set animal habitat.
   * @param String habitat, the new habitat of animal 
   */
   public void setHabitat(String habitat) {
      this.habitat = habitat;
   }

   /**
   * Description: get endangered of animal.
   * @return boolean, the endangered of animal, true or false 
   */
   public boolean isEndangered() {
      return endangered;
   }

   /**
   * Description: set animal endangered.
   * @param boolean endangered, the endangered of animal, true or false 
   */
   public void setEndangered(boolean endangered) {
      this.endangered = endangered;
   }

   /**
   * Description: get alive of animal.
   * @return boolean, the alive of animal, true or false 
   */
   public boolean isAlive() {
      return alive;
   }

   /**
   * Description: set animal alive or not.
   * @param boolean alive, the alive of animal, true or false 
   */ 
   public void setAlive(boolean alive) {
      this.alive = alive;
   }

   /**
   * Description: get animal diet.
   * @return String, the diet of animal 
   */ 
   public String getDiet() {
      return diet;
   }

   /**
   * Description: set animal diet.
   * @param String diet, the new diet of animal 
   */
   public void setDiet(String diet) {
      this.diet = diet;
   }
   
   /** 
   * Description: prints all the attributes of the animal 
   */
   public String toString() {
      return "Name: " + this.name + "; weight: " + this.weight + "; habitat: " + this.habitat + "; endangered: " + this.endangered + "; alive: " + this.alive + "; diet: " + this.diet;
   }

}
