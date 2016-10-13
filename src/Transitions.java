import java.util.HashMap;

public class Transitions {
    private HashMap<String, HashMap<String, String>> transitionTable = new HashMap<>();

    public void set(String startState, String alphabet, String goalState) {
        transitionTable.putIfAbsent(startState, new HashMap<>());
        transitionTable.get(startState).put(alphabet, goalState);
    }

    public String getNextState(String startState, String alphabet) {
        return transitionTable.get(startState).get(alphabet);
    }
}
