package DFA;

import common.State;

import java.util.HashMap;

public class Delta {
    private HashMap<State, HashMap<String, State>> transtions;

    public Delta(HashMap<State, HashMap<String, State>> t) {
        this.transtions = t;
    }


    public State getNextState(State state, String alphabet) {
        return this.transtions.get(state).get(alphabet);
    }

    @Override
    public String toString() {
        return "Machine.Machine.Delta{" +
                "transtions=" + transtions +
                '}';
    }
}
