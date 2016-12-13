import java.io.*;
import java.util.*;
import java.text.*;
public class QuizApp {
	
	public static int QUESTION_NUM = 10;
	public static int TOTAL_QUESTION = 50;
	private static String USERDB = "src/userdb.txt";
	public static void main (String [] args) {
		System.out.println("-------------------------------------");
		System.out.println("Welcome to use iQuiz");
		System.out.println("User Name: " + args[0]);
		System.out.println("Time: " + new SimpleDateFormat("yyyy/MM/dd HH:mm:ss z").format(new Date()));
		System.out.println("\nDeveloper: XXX");
		System.out.println("           XXX");
		System.out.println("-------------------------------------");
//		System.out.println((char)('A'+2));
		launch(args[0]);
	}
	
	/**
	 * Start the URTorrent Client
	 * Take the user input as command, do operations according to the command
	 */
	public static void launch(String name) {
		User user = new User(name);
		int question = 1; //question being answered, up to 10
		int final_score = 0;
		Random rand = new Random();
		while(true) {
			//random question number
			int seq = rand.nextInt(TOTAL_QUESTION) + 1;
			//create new Question object
			Question q = new Question(seq);
			System.out.println("Please answer the questions by selecting A,B,C or D");
			System.out.println("Question "+question+":");
			System.out.println(q.toString());
			System.out.println("Your answer?");
			Scanner scan= new Scanner(System.in);
			//Get the input command
			String answer = scan.nextLine();
			while(!checkValidInput(answer.toUpperCase())) {
				System.out.println("ERROR, Please input A,B,C or D only");
				answer = scan.nextLine();
			}
			q.setAnswer(answer.toUpperCase());
			if(q.check()) {
				System.out.println("Correct!");
				final_score += q.getScore();
			}
			else {
				System.out.println("Error!");
			}	
			System.out.println("Would you like to continue?(Y/N)");
			//Get the input command
			scan= new Scanner(System.in);
			//Get the input command
			String cont = scan.nextLine();
			if(cont.toUpperCase().equals("Y")&& question < QUESTION_NUM) {
				question ++;
				continue;//Continue answer the question
			}
			else {
				break;
				//Quit the App
			}
		}
		user.setScore(final_score);
		compare(user);
		
		System.out.println("Your final score is " + final_score + "/100");
		System.out.println("Recording........");
		user.write(user, USERDB);
		System.out.println("Thank you for using our Quiz App!");
		
	}
	
	private static void compare(User curuser) {
		String filename = "src/userdb.txt";
		// This will reference one line at a time
		String line = null;
		int total_record = 0;
		int better_time = 0;
		try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader = 
                new FileReader(filename);

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader = 
                new BufferedReader(fileReader);

            while((line = bufferedReader.readLine()) != null) {
            	int score = Integer.parseInt(line.split(": ")[1]);
            	if(curuser.getScore() >= score) {
            		better_time++;
            	}
            	total_record++;
            }   
            // Always close files.
            bufferedReader.close();  
            fileReader.close();
		}
        catch(FileNotFoundException ex) {
            System.out.println(
                "Cannot find file '" + 
                		filename + "'");                
        }
        catch(IOException ex) {
            System.out.println(
                "Error reading file '" 
                + filename + "'");                  
            // Or we could just do this: 
            // ex.printStackTrace();
        }
		System.out.println("Congratuations! " + curuser.getName());
		System.out.println("Your score is "+curuser.getScore()+", which defeats "+ ((float)better_time/total_record)*100+ "% of the users!");
		
		
	}
	
	private static boolean checkValidInput(String input) {
//		System.out.println(input.charAt(0));
//		System.out.println(((input.charAt(0) <= 'D') && (input.charAt(0) >= 'A')));
		return ((input.charAt(0) <= 'D') && (input.charAt(0) >= 'A'));
	}

}
