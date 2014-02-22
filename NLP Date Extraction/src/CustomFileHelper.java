

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;

public class CustomFileHelper {
	private String fileName;
	
	public CustomFileHelper(String fileName){
		this.fileName = fileName;
	}

	public ArrayList getFileContents(){
		ArrayList<String> contents = new ArrayList<String>();
        try {
		//Create object of FileReader
	    FileReader inputFile;
    	inputFile = new FileReader(fileName);

	    //Instantiate the BufferedReader Class
	    BufferedReader bufferReader = new BufferedReader(inputFile);

	    //Variable to hold the one line data
	    String line;
	    // Read file line by line and print on the console
	    while ((line = bufferReader.readLine()) != null)   {
	    		contents.add(line);
	    }
	    //Close the buffer reader
	    bufferReader.close();
        } catch (Exception e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
        }
	    return contents;
	}
	
	public void writeArrayListToFile(ArrayList contents){
		PrintWriter writer = null;
        try {
	        writer = new PrintWriter(fileName);
        } catch (FileNotFoundException e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
        }
		for(Object content: contents){
			writer.println(content.toString());
		}
		writer.close();
	}
	
	
	public String concatenateFileContents(ArrayList<String> contents){
		StringBuilder content = new StringBuilder();
		for(String line : contents){
			content.append(line);
		}
		return content.toString();
	}

}
