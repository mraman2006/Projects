import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class RegexParser {
	ArrayList<Pattern> regexDatePatterns;
	public RegexParser(ArrayList<String> regexDatePatterns){
		for(String regexDatePattern : regexDatePatterns){
			Pattern pattern = Pattern.compile(regexDatePattern, Pattern.CASE_INSENSITIVE);
			this.regexDatePatterns.add(pattern);
		}
	}
	
	public ArrayList<String> getMatchingPatterns(String inputText) {
		ArrayList<String> extractedTexts = new ArrayList<String>();
		for(Pattern pattern : regexDatePatterns){
			Matcher matcher = pattern.matcher(inputText);
			while (matcher.find()) {
				//System.out.println(matcher.group());
				extractedTexts.add(matcher.group());
			}
		}
		return extractedTexts;
	}
}
