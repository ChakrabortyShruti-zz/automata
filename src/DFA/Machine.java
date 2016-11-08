package DFA;

import common.AlphabetSet;
import common.State;
import common.States;
import org.json.simple.JSONArray;
import org.junit.Assert;

public class Machine {
    private final States states;
    private final AlphabetSet alphabets;
    private final Delta delta;
    private final States final_states;
    private final State start_state;

    public Machine(States states, AlphabetSet alphabets, Delta delta, States final_states, State start_state) {
        this.states = states;
        this.alphabets = alphabets;
        this.delta = delta;
        this.final_states = final_states;
        this.start_state = start_state;
    }

    public boolean canAccept(String inputString) {
        String[] inputAlphabets = inputString.split("");
        if (!alphabets.isValidAlphabet(inputString)) {
            return false;
        }
        State presentState = start_state;
        for (String alphabet : inputAlphabets) {
            presentState = delta.getNextState(presentState, alphabet);
        }
        return final_states.contains(presentState);
    }

    public static void CheckFailCases(JSONArray failCases, Machine machine) {
        for (Object cases : failCases) {
            Assert.assertEquals(false, machine.canAccept((String) cases));
        }
    }

    public static void CheckPassCases(JSONArray PassCases, Machine machine) {
        for (Object cases : PassCases) {
            Assert.assertEquals(true, machine.canAccept((String) cases));
        }
    }
}
