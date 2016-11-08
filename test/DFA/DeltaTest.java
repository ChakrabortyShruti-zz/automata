package DFA;

import common.State;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;


public class DeltaTest {
    @Test
    public void when_given_a_start_state_and_alphabet_should_return_next_state() throws Exception {
        State q1 = new State("q1");
        State q2 = new State("q2");

        HashMap<State, HashMap<String, State>> transition = new HashMap<>();
        transition.putIfAbsent(q1, new HashMap<>());
        transition.get(q1).put("1", q2);
//        Transition transition = new Transition();
//        transition.set(q1,"1",q2);
        Delta delta = new Delta(transition);

        Assert.assertEquals(q2, delta.getNextState(q1, "1"));
    }

    @Test
    public void when_given_a_start_state_and_alphabet_should_return_next_state_if_present() throws Exception {
        State q1 = new State("q1");
        State q2 = new State("q2");

        HashMap<State, HashMap<String, State>> transition = new HashMap<>();
        transition.putIfAbsent(q1, new HashMap<>());
        transition.get(q1).put("1", q2);

        Delta delta = new Delta(transition);

        Assert.assertEquals(null, delta.getNextState(q1, "a"));
    }
}