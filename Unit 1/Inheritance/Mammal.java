/**
Name: Grace and Sophia
Date: 2022-03-03
Description: Mammal class
*/

public class Mammal extends Animal {

    /**
    genus of Mammal
    */	  
    protected String genus;

    /**
    numOffspring of Mammal
    */
    protected int numOffspring;
	  
    /**
    fur of Mammal
    */
    protected boolean fur;
	  
    /**
    domesticated of Mammal
    */
    protected boolean domesticated;
	        
    /**
    * Default Constructor a mammal: call super class animal Constructor Sets name to "", weight to -1, habitat to "", endangered to false, alive to false and diet to "";  
    * Set genus = "", numOffspring = -1, fur = false and domesticated = false
    */
    public Mammal() {
      super();
      this.genus = "";
      this.numOffspring = -1;
      this.fur = false;
      this.domesticated = false;
    }
	 
    /**
    * Constructor a mammal: Sets name, weight, habitat, endangered, alive, diet, genus, numOffspring, fur and domesticated from parameters   
    */
    public Mammal(String name, double weight, String habitat, boolean endangered,  boolean alive, String diet, String genus, int numOffspring, boolean fur, boolean domesticated){
      super(name, weight, habitat, endangered, alive, diet);
      this.genus = genus;
      this.numOffspring = numOffspring;
      this.fur = fur;
      this.domesticated = domesticated;
    }

    public String getGenus() {
      return genus;
    }

    public void setGenus(String genus) {
      this.genus = genus;
    }

    public int getNumOffspring() {
      return numOffspring;
    }

    public void setNumOffspring(int numOffspring) {
      this.numOffspring = numOffspring;
    }

    public boolean isFur() {
      return fur;
    }

    public void setFur(boolean fur) {
      this.fur = fur;
    }

    public boolean domesticated() {
      return domesticated;
    }

    public void setDomesticated(boolean domesticated) {
      this.domesticated = domesticated;
    }
	
    public double eat(double grams) {
      this.weight += grams;
      return weight;
    }
	  
    public boolean eaten() {
      this.alive = false;
      return this.alive;
    }
	  
    public double move() {
      return 2.0;
    }
  
  //ADD TO STRING **********
}