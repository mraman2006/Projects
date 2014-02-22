import java.util.List;
import java.util.ListIterator;


public class CustomHelper {
	public String joinArrayList(List l, String delimiter){
			String output = "";
			ListIterator iterator = l.listIterator();
			while(iterator.hasNext()){
				String element = (String) iterator.next();
				output += element;
				if(iterator.hasNext())
					output += delimiter;
			}
			return output;
	}
}
