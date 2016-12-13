import java.util.*;
public class Question extends QuizObject {
	
	String questionBody;
	
	ArrayList<String> options;
	
	int answer;//0-3 INDICATE A-D
	
	int correct;//the correct answer
	
	public Question(int seq) {
		
	}
	
	public void read() {
		
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

	public int getAnswer() {
		return answer;
	}

	public int getCorrect() {
		return correct;
	}

	public void setCorrect(int correct) {
		this.correct = correct;
	}

	public void setAnswer(int answer) {
		this.answer = answer;
	}
	
	public String toString() {
		String opts = "";
		for(int i = 0; i< options.size(); i++) {
			opts += (char)('A'+i) + ": " + options.get(i) + "\n";
			i++;
		}
		return questionBody + "\n" + opts + "\n";
	}
	
	

}
