import java.io.*;
import java.util.*;
import java.text.*;
public class QuizApp {
	
	public static int QUESTION_NUM = 10;
	public static int TOTAL_QUESTION = 50;
	
	public static void main (String [] args) {
		System.out.println("-------------------------------------");
		System.out.println("Welcome to use iQuiz");
		System.out.println("User Name: " + args[0]);
		System.out.println("Time: " + new SimpleDateFormat("yyyy/MM/dd HH:mm:ss z").format(new Date()));
		System.out.println("\nDeveloper: XXX");
		System.out.println("           XXX");
		System.out.println("-------------------------------------");
		System.out.println((char)('A'+2));
		launch(args[0]);
	}
	
	/**
	 * Start the URTorrent Client
	 * Take the user input as command, do operations according to the command
	 */
	public static void launch(String name) {
		User user = new User(name);
		int question = 1;
		Random rand = new Random(TOTAL_QUESTION);
		while(true) {
			int seq = rand.nextInt();
			//create new Question object
			Question q = new Question(seq);
			
			
			
			
			
			
			System.out.println("Would you like to continue?(Y/N)");
			//Get the input command
			Scanner scan= new Scanner(System.in);
			//Get the input command
			String answer= scan.nextLine();
			if(answer.toUpperCase().equals("Y")&& question < QUESTION_NUM) {
				question ++;
				continue;//Continue answer the question
			}
			else {
				break;
				//Quit the App
			}
		}
		System.out.println("Your final score is 100/100");
		System.out.println("Recording........");
		System.out.println("Thank you for using our Quiz App!");
		
	}

}
