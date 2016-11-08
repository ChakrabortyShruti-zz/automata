package DFA;

import common.AlphabetSet;
import common.State;
import common.States;

public class Tuple {
    private final States states;
    private final AlphabetSet characterSet;
    private final Delta delta;
    private final State startState;
    private final States finalStates;

    public Tuple(States states, AlphabetSet characterSet, Delta delta, State startState, States finalStates) {
        this.states = states;
        this.characterSet = characterSet;
        this.delta = delta;
        this.startState = startState;
        this.finalStates = finalStates;
    }

    public States getStates() {
        return states;
    }

    public AlphabetSet getCharacterSet() {
        return characterSet;
    }

    public Delta getDelta() {
        return delta;
    }

    public State getStartState() {
        return startState;
    }

    public States getFinalStates() {
        return finalStates;
    }
}
