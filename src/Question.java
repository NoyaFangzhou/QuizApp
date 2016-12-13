import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
public class Question extends QuizObject {
	private static String DBNAME = "src/questiondb.txt";
	
	int seq;
	
	String questionBody;
	
	ArrayList<String> options;
	
	String answer;//A-D
	
	String correct;//the correct answer

	public Question(int seq) {
		this.seq = seq;
		this.options = new ArrayList<String>();
		this.questionBody = "";
		this.answer = "";
		this.correct = "";
		read(DBNAME);
	}
	
	public void read(String filename) {
//		String FILENAME = "src/questiondb.txt";
//		System.out.println("q_seq: " + seq);
		// This will reference one line at a time
		String line = null;
		try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader = 
                new FileReader(filename);

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader = 
                new BufferedReader(fileReader);

            int lineno = 0;
        	int q_seq = 0;
            while((line = bufferedReader.readLine()) != null) {
            	if(lineno == 0) {
            		q_seq = Integer.parseInt(line.split("\\.")[0]);
//            		System.out.println("seq: " + q_seq);
//            		System.out.println("question body: " + line.split("\\.")[1]);
            		questionBody = line.split("\\. ")[1];
            		lineno ++;
            	}
            	else if(lineno <= 4) {
            		options.add(line);
//            		System.out.println((char)('A'+lineno-1)+" "+line);
            		lineno ++;
            	}
            	else if(lineno == 5) {
            		correct = line;
//            		System.out.println("correct answer: "+line);
            		lineno ++;
            	}
            	else if(lineno == 6) {
            		score = Integer.parseInt(line);
//            		System.out.println("score: "+line);
            		lineno ++;
            	}
            	else {
//            		System.out.println("seq: " + q_seq);
            		if(q_seq == seq) {
            			break;
            		};
            		lineno = 0;
            		options.clear();
            	}
            }   

            // Always close files.
            bufferedReader.close();         
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
		
	}
	
	public boolean check() {
		return answer.equals(correct);
	}


	public String getQuestionBody() {
		return questionBody;
	}

	public void setQuestionBody(String questionBody) {
		this.questionBody = questionBody;
	}

	public ArrayList<String> getOptions() {
		return options;
	}

	public void setOptions(ArrayList<String> options) {
		this.options = options;
	}
	
	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public String getCorrect() {
		return correct;
	}

	public void setCorrect(String correct) {
		this.correct = correct;
	}
	
	public String toString() {
		String opts = "";
		for(int i = 0; i< options.size(); i++) {
			opts += (char)('A'+i) + ": " + options.get(i) + "\n";
		}
		return questionBody + "\n" + opts + "\n";
	}
	
	

}
