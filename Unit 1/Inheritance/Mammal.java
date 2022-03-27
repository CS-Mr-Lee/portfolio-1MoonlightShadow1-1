/**
Name: Grace and Sophia
Date: 2022-03-03
Description: Mammal class
*/

public class Mammal extends Animal {

    /**genus of Mammal*/	  
    private String genus;

    /**numOffspring of Mammal*/
    private int numOffspring;
	  
    /**fur of Mammal*/
    private boolean fur;
	  
    /**domesticated of Mammal*/
    private boolean domesticated;
	        
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
    * @param String name, the name of Mammal
    * @param double weight, the weight of Mammal
    * @param String habitat, the habitat of Mammal
    * @param boolean endangered, the endangered of Mammal
    * @param boolean alive, the alive of Mammal
    * @param String diet, the diet of Mammal
    * @param String genus, the genus of Mammal
    * @param int numOffspring, the numOffspring of Mammal
    * @param boolean fur, the fur of Mammal
    * @param boolean domesticated, the domesticated of Mammal
    */
    public Mammal(String name, double weight, String habitat, boolean endangered,  boolean alive, String diet, String genus, int numOffspring, boolean fur, boolean domesticated){
        super(name, weight, habitat, endangered, alive, diet);
        this.genus = genus;
        this.numOffspring = numOffspring;
        this.fur = fur;
        this.domesticated = domesticated;
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
    * Description: decreses the weight of the mammal based on how far it travels. per 3km it travels it looses a kg
    * @param km -- a double of how far it travels
    * @return the new weight
    */
    public double move(double km) {
        setWeight(getWeight()- km/3); //decreses the weight 1 kg by 3km
        return getWeight();
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
        return super.toString() + "; genus: " + this.genus + "; number of numOffspring: " + this.numOffspring + "; fur: " + this.fur + "; domesticated: " + this.domesticated;
    }
}