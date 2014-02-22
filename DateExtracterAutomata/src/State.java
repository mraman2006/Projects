import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class State {
	private boolean initialState;
	private boolean finalState;
	private HashMap<Pattern, State> transitionTable;
	
	public State(boolean initialState, boolean finalState, HashMap<Pattern, State> transitionTable){
		this.initialState = initialState;
		this.finalState = finalState;
		if(transitionTable == null){
			this.transitionTable = new HashMap<Pattern, State>();
		}
		else{
			this.transitionTable = transitionTable;
		}
	}
	
	public State getNextState(String input){
		Iterator iterator = transitionTable.entrySet().iterator();
		while(iterator.hasNext()){
			Map.Entry<Pattern, State> transition = (Map.Entry<Pattern, State>)iterator.next();
			Matcher matcher = transition.getKey().matcher(input); 
			if(matcher.find()){
				return transition.getValue();
			}
		}
		return null;
	}
	
	public boolean isFinalState(){
		return finalState;
	}
	
	public boolean isInitialState(){
		return initialState;
	}

	public void setFinalState(){
		finalState = true;
	}
	
	public void setInitialState(){
		initialState = true;
	}
	
	public void addToTransitionTable(String input, State state) {
	    // TODO Auto-generated method stub
		//input corresponds to the regex pattern
		Pattern pattern = Pattern.compile(input, Pattern.CASE_INSENSITIVE);
		transitionTable.put(pattern, state);
    }
}
