import java.util.Arrays;

public class DFA {
    //TODO: give machine its present state
    //TODO: make alphabets a different class
    private final String[] states;
    private final AlphabetSet alphabets;
    private final Transitions transitions;
    private final String[] finalStates;
    private final String initialState;

    public DFA(String[] states, AlphabetSet alphabets, Transitions transitions, String[] finalStates, String initialState) {
        this.states = states;
        this.alphabets = alphabets;
        this.transitions = transitions;
        this.finalStates = finalStates;
        this.initialState = initialState;
    }

    public boolean canAccept(String inputString) {
        String[] inputAlphabets = inputString.split("");
        if (!alphabets.isValidAlphabet(inputAlphabets))
            return false;
        String presentState = initialState;
        for (String alphabet : inputAlphabets) {
            presentState = transitions.getNextState(presentState, alphabet);
        }
        return Arrays.asList(finalStates).contains(presentState);
    }
}
