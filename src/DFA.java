import java.util.Arrays;

public class DFA {
    private final String[] states;
    private final AlphabetSet alphabets;
    private final Delta delta;
    private final String[] final_states;
    private final String start_state;

    public static DFA createMachine(Tuple dfa) {
        return new DFA(dfa.getStates(), new AlphabetSet(dfa.getAlphabets()), new Delta(dfa.getDelta()), dfa.getfinalStates(), dfa.getStartState());
    }

    private DFA(String[] states, AlphabetSet alphabets, Delta delta, String[] final_states, String start_state) {
        this.states = states;
        this.alphabets = alphabets;
        this.delta = delta;
        this.final_states = final_states;
        this.start_state = start_state;
    }

    public boolean canAccept(String inputString) {
        String[] inputAlphabets = inputString.split("");
        if (!alphabets.isValidAlphabet(inputAlphabets))
            return false;
        String presentState = start_state;
        for (String alphabet : inputAlphabets) {
            presentState = delta.getNextState(presentState, alphabet);
        }
        return Arrays.asList(final_states).contains(presentState);
    }

    @Override
    public String toString() {
        return "DFA{" +
                "states=" + Arrays.toString(states) +
                ", alphabets=" + alphabets +
                ", delta=" + delta +
                ", final_states=" + Arrays.toString(final_states) +
                ", start_state='" + start_state + '\'' +
                '}';
    }

    public boolean runAll() {
        return false;
    }
}
