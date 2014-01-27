import java.io.Console;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Main {
	public int diff(int a, int b){
		return a-b;
	}
	public static void main(String args[]){
		int a = 10;
		System.out.println(a);
		Scanner scan = new Scanner(System.in);
		/*while(scan.hasNext()){
			System.out.println(scan.next());
		}*/
		
		/*Console console = System.console();
		if (console == null) {
            System.err.println("No console.");
            System.exit(1);
        }*/
		System.out.println(scan);
		//scan.reset();
		if(scan.hasNext()){
		Pattern pattern = Pattern.compile(scan.next());
		Matcher matcher = pattern.matcher(scan.nextLine());
		while(matcher.find()){
			System.out.format("Found text: %s, at position %d\n", matcher.group(), matcher.start());
		}
		}
	}
}
