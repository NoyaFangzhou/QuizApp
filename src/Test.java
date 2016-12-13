import java.io.*;
public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		readfile("src/questiondb.txt");
		write();
	}
	
	public static void readfile(String fileName) {
		// This will reference one line at a time
		String line = null;
		try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader = 
                new FileReader(fileName);

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader = 
                new BufferedReader(fileReader);

            int lineno = 0;
            while((line = bufferedReader.readLine()) != null) {
            	if(lineno == 0) {
            		System.out.println("seq: " + line.split("\\.")[0]);
            		System.out.println("question body: " + line.split("\\.")[1]);
            		lineno ++;
            	}
            	else if(lineno <= 4) {
            		System.out.println((char)('A'+lineno-1)+" "+line);
            		lineno ++;
            	}
            	else if(lineno == 5) {
            		System.out.println("correct answer: "+line);
            		lineno ++;
            	}
            	else if(lineno == 6) {
            		System.out.println("score: "+line);
            		lineno ++;
            	}
            	else {
            		System.out.println("FINISH");
            		lineno = 0;
            	}
            }   

            // Always close files.
            bufferedReader.close();         
        }
        catch(FileNotFoundException ex) {
            System.out.println(
                "Cannot find file '" + 
                fileName + "'");                
        }
        catch(IOException ex) {
            System.out.println(
                "Error reading file '" 
                + fileName + "'");                  
            // Or we could just do this: 
            // ex.printStackTrace();
        }

	}
	
	public static void write() {
		BufferedWriter bw = null;
		FileWriter fw = null;
		String FILENAME = "src/userdb.txt";
		try {

			File file = new File(FILENAME);

			// if file doesnt exists, then create it
			if (!file.exists()) {
				System.out.println("Create File!");
				file.createNewFile();
			}

			// true = append file
			fw = new FileWriter(file.getAbsoluteFile(), true);
			bw = new BufferedWriter(fw);

			bw.write("\nJerry 100");

			System.out.println("Done");
			bw.close();
			fw.close();

		} catch (IOException e) {

			e.printStackTrace();

		} 
	}

}
