import java.io.ObjectInputStream.GetField;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;


public class DateExtracter {

	FiniteStateAutomata fsa;
	ArrayList<String> automataStructure;
	int noOfStates;
	String setOfInitialStates;
	String setOfFinalStates;
	String dictionary;
	
	public DateExtracter(String dictionary){
		this.dictionary = dictionary;
	}
	
	public List<String> getTokens(String fileName, String matchCriteria){
		CustomFileHelper inputFile = new CustomFileHelper(fileName);
		ArrayList<String> contents = inputFile.getFileContents();
		String content = inputFile.concatenateFileContents(contents);
		String[] tokens = content.split(matchCriteria);	
		return Arrays.asList(tokens);
	}
	
	public void createFSA(){
		fsa = new FiniteStateAutomata(noOfStates);
		fsa.createTransitionTable(automataStructure);
		fsa.createInitialStates(setOfInitialStates);
		fsa.createFinalStates(setOfFinalStates);		
	}
	
	
	public void setAutomataStates(){
		CustomFileHelper file = new CustomFileHelper(dictionary);
		automataStructure = file.getFileContents();		
		ListIterator<String> iterator = automataStructure.listIterator();
		noOfStates = Integer.parseInt(iterator.next());
		setOfInitialStates = iterator.next();
		setOfFinalStates = iterator.next();
	}
	
	public ArrayList<String> executeAutomata(List<String> tokensList){
		return fsa.executeAutomata(tokensList);
	}
	
	public static void main(String args[]){
		DateExtracter dateExtracter = new DateExtracter("src/dictionary.txt");
		dateExtracter.setAutomataStates();
		dateExtracter.createFSA();
		List<String> tokensList = dateExtracter.getTokens("Input/sampleInput.txt", "\\s+|\\.|,");
		ArrayList<String> extractedDates = dateExtracter.executeAutomata(tokensList);
		CustomFileHelper writeFile = new CustomFileHelper("output.txt");
		writeFile.writeArrayListToFile(extractedDates);
	}
}
