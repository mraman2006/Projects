import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DateExtracter {
		
	public static void main(String args[]) {		
		CustomFileHelper regexFileObject = new CustomFileHelper("dictionary.txt");
		ArrayList<String> regexDatePatterns = regexFileObject.getFileContents();
		RegexParser rp = new RegexParser(regexDatePatterns);

		CustomFileHelper fileObject = new CustomFileHelper(args[0]);
		ArrayList<String> contents = fileObject.getFileContents();
		String content = fileObject.concatenateFileContents(contents);
		ArrayList<String> extractedTexts = rp.getMatchingPatterns(content);
		//System.out.println(extractedTexts.toString());
		
		CustomFileHelper writeFile = new CustomFileHelper("output.txt");
		writeFile.writeArrayListToFile(extractedTexts);
		
	}
	
}