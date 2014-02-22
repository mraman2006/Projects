import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;

import junitx.framework.ListAssert;

import org.junit.Test;


public class DateExtracterTest {

	public ArrayList<String> getExpectedOutput(){
		ArrayList<String> expectedOutput = new ArrayList<String>();
		expectedOutput.add("Jun, 31");
		expectedOutput.add("Christmas");
		expectedOutput.add("Dec. 25");
		expectedOutput.add("January 21");
		expectedOutput.add("February 20");
		expectedOutput.add("7th of February");
		expectedOutput.add("5th of Feb");
		expectedOutput.add("Thanksgiving");
		//return expectedOutput;
		
		expectedOutput = new ArrayList<String>(Arrays.asList("12th of August", "November 21st", "11th of November", "April 14", 
		"July 24", "11th of April", "29th of March",
		 "May 20th", "7th of August", "15th of May", "christmas",
		 "15th of September", "May 2", "July 7th", "1st of August",
		 "September 14", "10th of November", "September 3rd",
		 "January 9th", "October 29th", "July 17", "4th of September"));
		return expectedOutput;
	}
	
	@Test
	public void test() {		
		
		CustomFileHelper regexFileObject = new CustomFileHelper("src/dictionary.txt");
		ArrayList<String> regexDatePatterns = regexFileObject.getFileContents();
		RegexParser rp = new RegexParser(regexDatePatterns);
		//System.out.println(regexDatePatterns.size());

		CustomFileHelper fileObject = new CustomFileHelper("Input/sampleInput.txt");
		ArrayList<String> contents = fileObject.getFileContents();
		String content = fileObject.concatenateFileContents(contents);

		ArrayList<String> extractedTexts = rp.getMatchingPatterns(content); 
		ArrayList<String> expectedOutput = getExpectedOutput();
		System.out.println(extractedTexts +"\n" + expectedOutput);	
		ListAssert.assertEquals(expectedOutput, extractedTexts);
	}

}
