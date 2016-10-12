import java.lang.reflect.Array;
import java.util.Arrays;

public class DFA {

    private final String[] states;
    private final String[] alphabets;
    private final Transitions transitions;
    private final String[] finalStates;
    private final String initialState;

    public DFA(String[] states, String[] alphabets, Transitions transitions ,String[] finalStates, String initialState) {
        this.states = states;
        this.alphabets = alphabets;
        this.transitions = transitions;
        this.finalStates = finalStates;
        this.initialState = initialState;
    }

    public boolean accept(String inputString) {
        String[] inputAlphabets = inputString.split("");
        if(!HasValidAlphabets(inputAlphabets))
            return false;
        String nextState = initialState;
        for (String alphabet : inputAlphabets) {
            nextState = transitions.getNextState(nextState,alphabet);
        }
        return Arrays.asList(finalStates).contains(nextState);
    }

    private boolean HasValidAlphabets(String[] inputAlphabets) {
        for (String inputAlphabet : inputAlphabets) {
            if(!Arrays.asList(alphabets).contains(inputAlphabet))
                return false;
        }
        return true;
    }
}
