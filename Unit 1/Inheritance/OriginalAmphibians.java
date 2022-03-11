/**
Name: Grace and Sophia
Date: 2022-03-03
Description: OriginalAmphibians class
*/

public class OriginalAmphibians {

   /** name of amphibians */
   private String name;

   /** weight of amphibians in kg */
   private double weight;

   /** habitat of amphibians */
   private String habitat;

   /** if amphibians endangered or not*/
   private boolean endangered;

   /** if amphibians alive or not*/
   private boolean alive;
  
   /** diet of amphibians */
   private String diet;
   
   /**genus of amphibians*/
   private String genus;

   /**species of amphibians*/
   private String species;

   /**numOfEggs of amphibians*/
   private int numOfEggs;

   /**wild of amphibians*/
   private boolean wild;

   /**family of amphibians*/
   private String family;
    
   /**
   * Default Constructor a amphibians: Sets name to "", weight to -1, habitat to "", endangered to false, alive to false and diet to "",  
   * Set genus = "", species = "", numOfEggs = -1, wild = false and family = ""
   */
   public OriginalAmphibians() {
      this.name = "";
      this.weight = -1;
      this.habitat = "";
      this.endangered = false;
      this.alive = false;
      this.diet = "";
      this.genus = "";
      this.species = "";
      this.numOfEggs = -1;
      this.wild = false;
      this.family = "";
   }
	 
   /**
   * Constructor an amphibians: Sets name, weight, habitat, endangered, alive, diet, genus, species, numOfEggs, wild and family from parameters   
   */
   public OriginalAmphibians(String name, double weight, String habitat, boolean endangered,  boolean alive, String diet, String genus, String species, int numOfEggs, boolean wild, String family) {
      this.name = name;
      this.weight = weight;
      this.habitat = habitat;
      this.endangered = endangered;
      this.alive = alive;
      this.diet = diet;
      this.genus = genus;
      this.species = species;
      this.numOfEggs = numOfEggs;
      this.wild = wild;
      this.family = family;
   }
    
   /**
   * Description: get amphibians name.
   * @return String, the name of animal 
   */
   public String getName() {
      return name;
   }

   /**
   * Description: set amphibians name.
   * @param String name, the new name of amphibians 
   */
   public void setName(String name) {
      this.name = name;
   }

   /**
   * Description: get amphibians weight.
   * @return double, the weight of amphibians in kg
   */
   public double getWeight() {
      return weight;
   }

   /**
   * Description: set amphibians weight.
   * @param double weight, the new weight of amphibians in kg
   */
   public void setWeight(double weight) {
      this.weight = weight;
   }

   /**
   * Description: get amphibians habitat.
   * @return String, the habitat of amphibians 
   */
   public String getHabitat() {
      return habitat;
   }

   /**
   * Description: set amphibians habitat.
   * @param String habitat, the new habitat of amphibians 
   */
   public void setHabitat(String habitat) {
      this.habitat = habitat;
   }

   /**
   * Description: get endangered of amphibians.
   * @return boolean, the endangered of amphibians, true or false 
   */
   public boolean isEndangered() {
      return endangered;
   }

   /**
   * Description: set amphibians endangered.
   * @param boolean endangered, the endangered of amphibians, true or false 
   */
   public void setEndangered(boolean endangered) {
      this.endangered = endangered;
   }

   /**
   * Description: get amphibians alive or not.
   * @return boolean, if amphibians alive or not, true is alive, false is not.
   */
   public boolean isAlive() {
      return alive;
   }

   /**
   * Description: set amphibians alive or not.
   * @param boolean alive, the alive of amphibians, true or false 
   */ 
   public void setAlive(boolean alive) {
      this.alive = alive;
   }

   /**
   * Description: get amphibians diet.
   * @return String, the diet of amphibians 
   */ 
   public String getDiet() {
      return diet;
   }

   /**
   * Description: set amphibians diet.
   * @param String diet, the new diet of amphibians 
   */
   public void setDiet(String diet) {
      this.diet = diet;
   }


   /**
   * Description: get amphibians genus.
   * @return String, the genus of amphibians 
   */ 
   public String getGenus() {
       return genus;
   }

   /**
   * Description: set amphibians genus.
   * @param String genus, the new genus of amphibians 
   */
   public void setGenus(String genus) {
      this.genus = genus;
   }

   /**
   * Description: get amphibians species.
   * @return String species, the species of amphibians 
   */ 
   public String getSpecies() {
      return species;
   }

   /**
   * Description: set amphibians species.
   * @param String species, the new species of amphibians 
   */
   public void setSpecies(String species) {
      this.species = species;
   }

   /**
   * Description: get amphibians numOfEggs.
   * @return int numOfEggs, the numOfEggs of amphibians 
   */ 
   public int getNumOfEggs() {
      return numOfEggs;
   }

   /**
   * Description: set amphibians numOfEggs.
   * @param int numOfEggs, the new numOfEggs of amphibians 
   */
   public void setNumOfEggs(int numOfEggs) {
      this.numOfEggs = numOfEggs;
   }

   /**
   * Description: get amphibians wild or not.
   * @return boolean, if amphibians wild or not, true is wild, false is not.
   */
   public boolean isWild() {
      return wild;
   }

   /**
   * Description: set amphibians wild or not.
   * @param boolean wild, the wild of amphibians, true or false 
   */
   public void setWild(boolean wild) {
      this.wild = wild;
   }

   /**
   * Description: get amphibians family.
   * @return String family, the family of amphibians.
   */
   public String getFamily() {
      return family;
   }
  
   /**
   * Description: changes the family of amphibians
   * @param String family -- new family to change to
   */
   public void setFamily(String family) {
      this.family = family;
   }
	
   /**
   * Description: amphibians eats something and gains the same weight that was eaten.
   * @param double grams, the weight in grams of what is being eaten
   * @return double, weight of the amphibians in kg.   
   */
   public double eat(double grams) {
      this.weight += grams/1000; //increase the weight by the weight of food, convert grams to kg.
      return this.weight;
   }
	
   /**
   * Description: amphibians gets eaten, affecting whether or not it's alive
   * @return false once it is eaten, its dead
   */  
   public boolean eaten() {
      this.alive = false;
      return this.alive;
   }
	
   /**
   * Description: decreses the weight of the amphibians based on how far it travels. per 2km it travels it looses a kg
   * @param double km -- a double of how far it travels
   * @return double, the new weight of amphibians in kg
   */    
   public double move(double km) {
      this.weight = this.weight - km/2; //decreses the weight 1 kg by 2km.
      return this.weight;
   }
     
   /**
   * Description: changes the amphibians wild to false when it is caught.
   * @return boolean, the wild of amphibians.
   */ 
   public boolean caught() {
      System.out.println("The amphibians is caught");
      this.wild = false;
      return this.wild;
   }
   
   /** 
   * Description: prints all the attributes of the amphibians 
   */
   public String toString() {
      return "Name: " + this.name + "; weight: " + this.weight + "; habitat: " + this.habitat + "; endangered: " + this.endangered + "; alive: " + this.alive + "; diet: " + this.diet + "; genus: " + this.genus + "; species: " + this.species + "; number of eggs: " + this.numOfEggs + "; wild: " + this.wild + "; family: " + this.family;
   }
}
