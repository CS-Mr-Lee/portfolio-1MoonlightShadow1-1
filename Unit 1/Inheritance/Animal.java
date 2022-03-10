/**
Name: Grace and Sophia
Date: 2022-03-03
Description: Animal class
*/

public class Animal {

   /** 
   name of animal
   */
   protected String name;

   /**
   weight of animal in kg 
   */
   protected double weight;

   /**
   habitat of animal
   */
   protected String habitat;

   /** 
   if animal endangered or not
   */
   protected boolean endangered;

   /** 
   if animal alive or not
   */
   protected boolean alive;
  
   /** 
   diet of animal 
   */
   protected String diet;
   
   /**
   if animal already eat food or not
   */
   protected boolean eaten;
  
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
      this.eaten = false;
   }
  
   /**
   * Constructor an animal: Sets name, weight, habitat, endangered, alive and diet from parameters   
   */
   public Animal(String name, double weight, String habitat, boolean endangered,  boolean alive, String diet) {
      this.name = name;
      this.weight = weight;
      this.habitat = habitat;
      this.endangered = endangered;
      this.alive = alive;
      this.diet = diet;
      this.eaten = false;
   }
   
   /**
   * Description: animal eats food, 90% increase the weight, 10% is lost.
   * @param double grams, the amount of food
   * @return double, the lost of food in gram  
   */
   public double eat(double grams) {
      this.weight += 0.9*grams/1000;
      return 0.1*grams/1000;
   }
  
   /**
   * Description: return if animal got eaten.
   * @return boolean, animal got eaten or not 
   */
   public boolean eaten() {
      return this.eaten;
   }
   
   /**
   * Description: set animal if eaten or not.
   * @param boolean eaten, set whether animal has already been eaten already.
   */
   public void setEaten(boolean eaten) {
      this.eaten = eaten;
   }
  
   /**
   * Description: let animal move 1 meter.
   * @return double, let animal move 1 meter 
   */
   public double move() {
      return 1.0;
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
   * @return boolean, the endangered of animal 
   */
   public boolean isEndangered() {
      return endangered;
   }

   /**
   * Description: set animal endangered.
   * @param boolean endangered, the endangered of animal 
   */
   public void setEndangered(boolean endangered) {
      this.endangered = endangered;
   }

   /**
   * Description: get alive of animal.
   * @return boolean, the alive of animal 
   */
   public boolean isAlive() {
      return alive;
   }

   /**
   * Description: set animal alive or not.
   * @param boolean alive, the alive of animal 
   */ 
   public void setAlive(boolean alive) {
      this.alive = alive;
   }

   /**
   * Description: get animal diet.
   * @param String, the diet of animal 
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
}
