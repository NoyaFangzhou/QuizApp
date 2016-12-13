import java.io.*;
public class User extends QuizObject {

	String name;
	
	public User(String name) {
		this.name = name;
		this.score = 0;
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void read(String name, String filename) {
//		String fiename = "src/userdb.txt";
		// This will reference one line at a time
		String line = null;
		try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader = 
                new FileReader(filename);

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader = 
                new BufferedReader(fileReader);

            while((line = bufferedReader.readLine()) != null) {
            	if(name.equals(line.split(": ")[0])) {
            		score = Integer.parseInt(line.split(": ")[1]);
            		break;
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

	public void write(User user, String filename) {
		BufferedWriter bw = null;
		FileWriter fw = null;
//		String FILENAME = "src/userdb.txt";
		try {

			File file = new File(filename);

			// if file doesnt exists, then create it
			if (!file.exists()) {
				file.createNewFile();
			}

			// true = append file
			fw = new FileWriter(file.getAbsoluteFile(), true);
			bw = new BufferedWriter(fw);

			bw.write(user.toString());

			System.out.println("Done");
			bw.close();
			fw.close();

		} catch (IOException e) {

			e.printStackTrace();

		} 
	}
	
	public String toString() {
		return  "\n" + name + ": " + score;
	}

	
	
}
