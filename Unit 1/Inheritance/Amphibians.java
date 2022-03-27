/**
Name: Grace and Sophia
Date: 2022-03-03
Description: Amphibians class
*/

public class Amphibians extends Animal {

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
    * @param String name, the name of Amphibians
    * @param double weight, the weight of Amphibians
    * @param String habitat, the habitat of Amphibians
    * @param boolean endangered, the endangered of Amphibians
    * @param boolean alive, the alive of Amphibians
    * @param String diet, the diet of Amphibians
    * @param String genus, the genus of Amphibians
    * @param String species, the species of Amphibians
    * @param int numOfEggs, the numOfEggs of Amphibians
    * @param boolean wild, the wild of Amphibians
    * @param String family, the family of Amphibians
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
    * Description: decreses the weight of the amphibians based on how far it travels. per 2km it travels it looses a kg
    * @param double km -- a double of how far it travels
    * @return double, the new weight of amphibians in kg
    */
    public double move(double km) {
        setWeight(getWeight()- km/2); //decreses the weight 1 kg by 2km
        return getWeight();
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
        return super.toString() + "; genus: " + this.genus + "; species: " + this.species + "; number of eggs: " + this.numOfEggs + "; wild: " + this.wild + "; family: " + this.family;
    }

}
