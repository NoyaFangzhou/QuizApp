
public class User extends QuizObject {


	String name;
	
	public User(String name) {
		this.name = name;
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void read() {
		
	}

	public void write(User user) {
		
	}
	
	public String toString() {
		return name + ": " + score;
	}

	
	
}
