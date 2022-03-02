/**
* Name: Grace Sui
* Date: March 1, 2022
* Description:Create 1 humans
              Create 1 vegetable
              Create 3 cookies (use each of the constructors)
              One of the cookies should be packaged
              Person should try to eat packaged cookie
              Person should try to eat too much of a vegetable
              Person should eat a cookie and gain energy
*/

public class Sui_Grace_OOQuiz1 {
   public static void main (String [] args) { 
   
      Human human = new Human("Pi", 100.0, 70);
      Vegetable vegetable = new Vegetable("Potato", 20.0, 100);
      human.eat(vegetable, 25.0);
      System.out.println(human.toString());
      System.out.println(vegetable.toString());
      System.out.println();
      
      Cookie defaultCookie = new Cookie();
      System.out.println(defaultCookie.toString());
      System.out.println();
      
      Cookie packageCookie = new Cookie("Chocolate Chip", 50.0, 200, true);
      human.eat(packageCookie, 20.0);
      System.out.println(human.toString());
      System.out.println(packageCookie.toString());
      System.out.println();
      
      Cookie unPackageCookie = new Cookie("Caramel", 50.0, 150);
      human.eat(unPackageCookie, 20.0);
      System.out.println(human.toString());
      System.out.println(unPackageCookie.toString());
   }
}
