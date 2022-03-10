/**
Name: Grace and Sophia
Date: 2022-03-03
Description: Amphibians class
*/

public class Amphibians extends Animal {

   /**
   genus of Mammal
   */
   protected String genus;

   /**
   species of Mammal
   */
   protected String species;

   /** 
   numOfEggs of Mammal
   */
   protected int numOfEggs;

   /**
   wild of Mammal
   */
   protected boolean wild;
   
   /**
   family of Mammal
   */
   protected String family;
    
   /**
   * Default Constructor a amphibians: call super class animal Constructor Sets name to "", weight to -1, habitat to "", endangered to false, alive to false and diet to "";  
   * Set genus = "", species = "", numOfEggs = -1, wild = false and family = ""
   */
   public Amphibians() {
      super();
      this.genus = "";
      this.species = "";
      this.numOfEggs = -1;
      this.wild = false;
      this.family = "";
   }
	 
   /**
   * Constructor an amphibians: Sets name, weight, habitat, endangered, alive, diet, genus, species, numOfEggs, wild and family from parameters   
   */
   public Amphibians(String name, double weight, String habitat, boolean endangered,  boolean alive, String diet, String genus, String species, int numOfEggs, boolean wild, String family) {
      super(name, weight, habitat, endangered, alive, diet);
      this.genus = genus;
      this.species = species;
      this.numOfEggs = numOfEggs;
      this.wild = wild;
      this.family = family;
   }
   /**
   gets genus
   @return genus of the amphibian
   */
   
   public String getGenus() {
      return genus;
   }
   
   /**
   changes the genus
   @param genus -- new genus to change to
   */
   public void setGenus(String genus) {
      this.genus = genus;
   }

   /**
   gets species
   @return species of the amphibian
   */
   public String getSpecies() {
      return species;
   }

   /**
   changes the species
   @param species -- new species to change to
   */
   public void setSpecies(String species) {
      this.species = species;
   }

   /**
   gets number of eggs
   @return number of eggs laid by amphibian
   */
   public int getNumOfEggs() {
      return numOfEggs;
   }
   /**
   changes the number of eggs
   @param numOfEggs -- new int number of eggs to change to
   */
   public void setNumOfEggs(int numOfEggs) {
      this.numOfEggs = numOfEggs;
   }
   
   /**
   gets if its wild or not
   @return boolean if its wild or not
   */
   public boolean isWild() {
      return wild;
   }
   /**
   changes whether its wild or not
   @param wild -- new boolean to change it to
   */
   public void setWild(boolean wild) {
      this.wild = wild;
   }
   
   /**
   gets family
   @return family of the amphibian
   */
   public String getFamily() {
      return family;
   }
   
   /**
   changes the family
   @param family -- new family to change to
   */
   public void setFamily(String family) {
      this.family = family;
   }

   /** 
   amphibian eats something and gains the same weight that was eaten
   @param grams -- the weight in grams of what is being eaten
   @return 0
   */
   public double eat(double grams) {
      this.weight += grams;
      return 0;
   }

   /**
   amphibian gets eaten, affecting whether or not it's alive
   @return false bc once it is eaten, its dead
   */
   public boolean eaten() {
      this.alive = false;
      return false;
   }

  /**
   decreses the weight of the amphibian based on how far it travels. per km it travels it looses a kg
   @param km -- a double of how far the creature has covered
   @return the new weight
   */
   public double move(double km) {
      this.weight = this.weight - km;
      return this.weight;
   }

  /**
   changes if the animal is wild to false
   @return the new weight
   */
   public boolean caught() {
      this.wild = false;
      return this.wild;
   }

  /** 
  prints all the attributes of the amphibian 
  */
   public String toString() {
      return "Name: " + this.name + "; habitat: " + this.habitat + "; endangered: " + this.endangered + "; alive: " + this.alive + "; diet: " + this.diet + "; genus: " + this.genus + "; species: " + this.species + "; number of eggs: " + this.numOfEggs + "; wild: " + this.wild + "; family: " + this.family;
   }
}
