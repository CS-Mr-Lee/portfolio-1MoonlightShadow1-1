/**
Name: Grace and Sophia
Date: 2022-03-03
Description: OriginalMammal class
*/

public class OriginalMammal {

   /** name of mammal */
   private String name;

   /** weight of mammal in kg */
   private double weight;

   /** habitat of mammal */
   private String habitat;

   /** if mammal endangered or not*/
   private boolean endangered;

   /** if mammal alive or not*/
   private boolean alive;
  
   /** diet of mammal */
   private String diet;
   
   /**genus of mammal*/	  
   private String genus;

   /**numOffspring of mammal*/
   private int numOffspring;
	  
   /**fur of mammal*/
   private boolean fur;
	  
   /**domesticated of mammal*/
   private boolean domesticated;
	        
   /**
   * Default Constructor a OriginalMammal: Sets name to "", weight to -1, habitat to "", endangered to false, alive to false and diet to "",  
   * Set genus = "", numOffspring = -1, fur = false and domesticated = false
   */
   public OriginalMammal() {
      this.name = "";
      this.weight = -1;
      this.habitat = "";
      this.endangered = false;
      this.alive = false;
      this.diet = "";
      this.genus = "";
      this.numOffspring = -1;
      this.fur = false;
      this.domesticated = false;
   }
	 
   /**
   * Constructor a OriginalMammal: Sets name, weight, habitat, endangered, alive, diet, genus, numOffspring, fur and domesticated from parameters   
   * @param String name, the name of OriginalMammal
   * @param double weight, the weight of OriginalMammal
   * @param String habitat, the habitat of OriginalMammal
   * @param boolean endangered, the endangered of OriginalMammal
   * @param boolean alive, the alive of OriginalMammal
   * @param String diet, the diet of OriginalMammal
   * @param String genus, the genus of OriginalMammal
   * @param int numOffspring, the numOffspring of OriginalMammal
   * @param boolean fur, the fur of OriginalMammal
   * @param boolean domesticated, the domesticated of Mammal
   */
   public OriginalMammal(String name, double weight, String habitat, boolean endangered,  boolean alive, String diet, String genus, int numOffspring, boolean fur, boolean domesticated){
      this.name = name;
      this.weight = weight;
      this.habitat = habitat;
      this.endangered = endangered;
      this.alive = alive;
      this.diet = diet;
      this.genus = genus;
      this.numOffspring = numOffspring;
      this.fur = fur;
      this.domesticated = domesticated;
   }
   
   /**
   * Description: get mammal name.
   * @return String, the name of mammal 
   */
   public String getName() {
      return name;
   }

   /**
   * Description: set mammal name.
   * @param String name, the new name of mammal 
   */
   public void setName(String name) {
      this.name = name;
   }

   /**
   * Description: get mammal weight.
   * @return double, the weight of mammal in kg
   */
   public double getWeight() {
      return weight;
   }

   /**
   * Description: set mammal weight.
   * @param double weight, the new weight of mammal in kg
   */
   public void setWeight(double weight) {
      this.weight = weight;
   }

   /**
   * Description: get mammal habitat.
   * @return String, the habitat of mammal 
   */
   public String getHabitat() {
      return habitat;
   }

   /**
   * Description: set mammal habitat.
   * @param String habitat, the new habitat of mammal 
   */
   public void setHabitat(String habitat) {
      this.habitat = habitat;
   }

   /**
   * Description: get endangered of mammal.
   * @return boolean, the endangered of mammal, true or false 
   */
   public boolean isEndangered() {
      return endangered;
   }

   /**
   * Description: set mammal endangered true or false.
   * @param boolean endangered, the new endangered of mammal 
   */
   public void setEndangered(boolean endangered) {
      this.endangered = endangered;
   }

   /**
   * Description: get alive of mammal, true or false.
   * @return boolean, the alive of mammal 
   */
   public boolean isAlive() {
      return alive;
   }

   /**
   * Description: set mammal alive, true or false.
   * @param boolean alive, the alive of mammal, true or false. 
   */ 
   public void setAlive(boolean alive) {
      this.alive = alive;
   }

   /**
   * Description: get mammal diet.
   * @param String, the diet of mammal 
   */ 
   public String getDiet() {
      return diet;
   }

   /**
   * Description: set mammal diet.
   * @param String diet, the new diet of mammal 
   */
   public void setDiet(String diet) {
      this.diet = diet;
   }

   /**
   * Description: gets genus of mammal
   * @return String genus of the mammal
   */
   public String getGenus() {
      return genus;
   }
   
   /**
   * Description: set mammal genus.
   * @param String genus, the new genus of mammal 
   */
   public void setGenus(String genus) {
      this.genus = genus;
   }

   /**
   * Description: gets numOffspring of mammal
   * @return int numOffspring of the mammal
   */
   public int getNumOffspring() {
      return numOffspring;
   }

   /**
   * Description: set mammal numOffspring.
   * @param String numOffspring, the new numOffspring of mammal 
   */
   public void setNumOffspring(int numOffspring) {
      this.numOffspring = numOffspring;
   }

   /**
   * Description: gets fur of mammal, true or false
   * @return boolean fur of the mammal, true or false.
   */
   public boolean isFur() {
      return fur;
   }

   /**
   * Description: set mammal fur, true or false.
   * @param booleab fur, the new fur of mammal, true or false.
   */
   public void setFur(boolean fur) {
      this.fur = fur;
   }

   /**
   * Description: gets domesticated of mammal, true or false
   * @return boolean domesticated of the mammal, true or false.
   */
   public boolean domesticated() {
      return domesticated;
   }

   /**
   * Description: set mammal domesticated, true or false.
   * @param booleab domesticated, the new domesticated of mammal, true or false.
   */
   public void setDomesticated(boolean domesticated) {
      this.domesticated = domesticated;
   }
	
   /**
   * Description: mammal eats something and gains the same weight that was eaten.
   * @param double grams, the weight in grams of what is being eaten
   * @return double, weight of the mammal in kg.   
   */
   public double eat(double grams) {
      this.weight += grams/1000; //increase the weight by the weight of food, convert grams to kg.
      return weight;
   }
	
   /**
   * Description: mammal gets eaten, affecting whether or not it's alive
   * @return false once it is eaten, its dead
   */  
   public boolean eaten() {
      this.alive = false;
      return this.alive;
   }
	
   /**
   * Description: decreses the weight of the mammal based on how far it travels. per 3km it travels it looses a kg
   * @param km -- a double of how far it travels
   * @return the new weight
   */  
   public double move(double km) {
      this.weight = this.weight - km/3;//decreses the weight 1 kg by 3km.
      return this.weight;
   }
   
   /**
   * Description: set domesticate to true.
   * @return true.
   */ 
   public boolean domesticate() {
      System.out.println("The domesticated is true");
      this.domesticated = true;
      return this.domesticated;
   }
   
   
   /** 
   * Description: prints all the attributes of the mammal 
   */
   public String toString() {
      return "Name: " + this.name + "; weight: " + this.weight + "; habitat: " + this.habitat + "; endangered: " + this.endangered + "; alive: " + this.alive + "; diet: " + this.diet + "; genus: " + this.genus + "; number of numOffspring: " + this.numOffspring + "; fur: " + this.fur + "; domesticated: " + this.domesticated;
   }

}