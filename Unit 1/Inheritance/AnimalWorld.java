/**
 * Name: Grace and Sophia
 * Date: 2022-03-03
 * Description: AnimalWorld class
 */

public class AnimalWorld {

  public static void main(String[] args) {
    Mammal cattle = new Mammal("CoCo", 20, "pastures", false, true, "grasses", "Bos taurus", 5, true, true);
    cattle.eat(100);
    cattle.move();
    cattle.domesticated();
    Amphibians crocodile = new Amphibians("Killer", 20, "river", false, true, "fish", "Crocodylus", "acutus", 2, true,
        "family");
    crocodile.eat(200);
    crocodile.eaten();
    crocodile.move();
    crocodile.caught();
    System.out.println(crocodile.toString());

  }
}