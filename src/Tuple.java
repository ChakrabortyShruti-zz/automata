import java.util.Arrays;
import java.util.HashMap;


public class Tuple {

    private final String[] states;
    private final String[] alphabets;
    private final HashMap<String, HashMap<String, String>> delta;
    private final String start_state;
    private final String[] final_states;

    public Tuple(String[] states, String[] alphabets, HashMap<String, HashMap<String, String>> delta,
                 String start_state, String[] finalStates) {
        this.states = states;
        this.alphabets = alphabets;
        this.delta = delta;
        this.start_state = start_state;
        this.final_states = finalStates;
    }

    public HashMap<String, HashMap<String, String>> getDelta() {
        return delta;
    }

    public String[] getAlphabets() {
        return alphabets;
    }

    public String[] getStates() {
        return states;
    }

    public String getStartState() {
        return start_state;
    }

    public String[] getfinalStates() {
        return final_states;
    }

    @Override
    public String toString() {
        return "Tuple{" +
                "states=" + Arrays.toString(states) +
                ", alphabets=" + Arrays.toString(alphabets) +
                ", delta=" + delta +
                ", start_state='" + start_state + '\'' +
                ", final_states=" + Arrays.toString(final_states) +
                '}';
    }
}
