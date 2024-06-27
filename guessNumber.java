 import java.util.Scanner ; 
 import java.util.Random ; 
public class guessNumber{

    public static void main(String[] args) {

        int computerMove;  
        int userInput ; 
        Scanner sc = new Scanner(System.in); 
        Random rand = new Random(); 
        computerMove = rand.nextInt(101); 
 
         game game = new game(); 
        System.out.println("\nWELCOME TO NUMBER GUESS GAME\n");

        while(true){
             System.out.println("Enter Your Move");
             userInput = sc.nextInt(); 
             game.inputs(computerMove , userInput);
             game.check();           
        }

    }
}

class game {

    private int userInput ; 
    private int computerMove ; 
    private int attempt ; 
     
    public void inputs(int computerMove , int userInput){
         this.computerMove = computerMove ; 
         this.userInput = userInput ; 
    }
    public void  check(){
        attempt++ ; 
         if(userInput> computerMove){
             System.out.println("Lower Value please");
         }
         else if (userInput< computerMove){
             System.out.println("Higher Value Please");
         }
         else{
             System.out.println("You Won in " + attempt + " Attemps");
             return; 
         }
    }



}