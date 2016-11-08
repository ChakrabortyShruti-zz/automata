package DFA;

import common.States;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import common.State;
import common.AlphabetSet;

import java.util.HashMap;

public class DFATest {
    String[] characterSet = new String[2];
    AlphabetSet alphabets;

    @Before
    public void setUp() throws Exception {

        characterSet[0] = "0";
        characterSet[1] = "1";
        alphabets = new AlphabetSet(characterSet);
    }

    //All strings whose decimal representation is a power of two.
    @Test
    public void should_generate_dfa_for_string_whose_decimal_representation_is_power_of_two() throws Exception {
        State q1 = new State("q1");
        State q2 = new State("q2");
        State q3 = new State("q3");

        HashMap<State, HashMap<String, State>> transitions = new HashMap<>();

        transitions.putIfAbsent(q1, new HashMap<>());
        transitions.get(q1).put("1", q2);

        transitions.putIfAbsent(q1, new HashMap<>());
        transitions.get(q1).put("0", q1);

        transitions.putIfAbsent(q2, new HashMap<>());
        transitions.get(q2).put("1", q3);

        transitions.putIfAbsent(q2, new HashMap<>());
        transitions.get(q2).put("0", q2);

        transitions.putIfAbsent(q3, new HashMap<>());
        transitions.get(q3).put("1", q3);

        transitions.putIfAbsent(q3, new HashMap<>());
        transitions.get(q3).put("1", q3);

//        Transition t = new Transition();
//        t.set(q1, "1", q2);
//        t.set(q1, "0", q1);
//        t.set(q2, "1", q3);
//        t.set(q2, "0", q2);
//        t.set(q3, "1", q3);
//        t.set(q3, "0", q3);

        Delta delta = new Delta(transitions);

        States states = new States();
        states.add(q1);
        states.add(q2); //finalState
        states.add(q3);

        States finalState = new States();
        finalState.add(q2);

        State initialState = q1;

        Machine dfa = new Machine(states, alphabets, delta, finalState, initialState);
        Assert.assertEquals(false, dfa.canAccept("a"));
        Assert.assertEquals(true, dfa.canAccept("1"));
        Assert.assertEquals(true, dfa.canAccept("10"));
        Assert.assertEquals(true, dfa.canAccept("100"));
        Assert.assertEquals(true, dfa.canAccept("1000"));
        Assert.assertEquals(false, dfa.canAccept("0"));
        Assert.assertEquals(false, dfa.canAccept("1001"));
        Assert.assertEquals(false, dfa.canAccept("0111"));

    }
}