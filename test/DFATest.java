import org.junit.Test;
import org.junit.Assert;

public class DFATest {

    //All strings whose decimal representation is a power of two.
    @Test
    public void should_generate_dfa_for_string_whose_decimal_representation_is_power_of_two() throws Exception {
        Transitions transitions = new Transitions();
        transitions.Set("q1","1","q2");
        transitions.Set("q1","0","q1");
        transitions.Set("q2","1","q3");
        transitions.Set("q2","0","q2");
        transitions.Set("q3","1","q3");
        transitions.Set("q3","0","q3");

        String[] states = new String[3];
        states[0] = "q1"; //initial state
        states[1] = "q2"; //final state
        states[2] = "q3"; //dead state

        String[] alphabets = {"0","1"};

        String[] finalState = new String[1];
        finalState[0] = "q2";

        String initialState = new String("q1");

        DFA dfa = new DFA(states, alphabets, transitions, finalState, initialState);

        Assert.assertEquals(false,dfa.accept("a"));
        Assert.assertEquals(true, dfa.accept("1"));
        Assert.assertEquals(true, dfa.accept("10"));
        Assert.assertEquals(true, dfa.accept("100"));
        Assert.assertEquals(true, dfa.accept("1000"));

        Assert.assertEquals(false, dfa.accept("0"));
        Assert.assertEquals(false, dfa.accept("1001"));
        Assert.assertEquals(false, dfa.accept("0111"));
    }

    // All strings that begin with 1 and contain the string 001
    @Test
    public void should_generate_dfa_for_string_that_begin_with_one_and_contain_string_001() {
        Transitions transitions = new Transitions();
        transitions.Set("q1","1","q2");
        transitions.Set("q1","0","q6");
        transitions.Set("q2","1","q2");
        transitions.Set("q2","0","q3");
        transitions.Set("q3","1","q3");
        transitions.Set("q3","0","q4");
        transitions.Set("q4","1","q5");
        transitions.Set("q4","0","q4");
        transitions.Set("q5","1","q5");
        transitions.Set("q5","0","q5");
        transitions.Set("q6","1","q6");
        transitions.Set("q6","0","q6");

        String[] states = new String[6];
        states[0] = "q1"; //initial state
        states[1] = "q2";
        states[2] = "q3";
        states[3] = "q4";
        states[4] = "q5"; //final state
        states[5] = "q6"; //dead state

        String[] alphabets = new String[2];
        alphabets[0] = new String("0");
        alphabets[1] = new String("1");

        String initialState = "q1";

        String[] finalState = new String[1];
        finalState[0] = "q5";

        DFA dfa = new DFA(states, alphabets, transitions, finalState, initialState);

        Assert.assertEquals(true,dfa.accept("101001"));
        Assert.assertEquals(true,dfa.accept("1001"));
        Assert.assertEquals(false,dfa.accept("001"));
    }


    // All strings other than the strings "11" and "111"
    @Test
    public void should_generate_a_dfa_for_strings_other_than_string_11_and_111() throws Exception {
        Transitions transitions = new Transitions();
        transitions.Set("q1","1","q2");
        transitions.Set("q1","0","q5");
        transitions.Set("q2","1","q3");
        transitions.Set("q2","0","q5");
        transitions.Set("q3","1","q4");
        transitions.Set("q3","0","q5");
        transitions.Set("q4","1","q5");
        transitions.Set("q4","0","q5");
        transitions.Set("q5","1","q5");
        transitions.Set("q5","0","q5");

        String[] states = new String[6];
        states[0] = "q1"; //initial state
        states[1] = "q2"; //final state
        states[2] = "q3";
        states[3] = "q4";
        states[4] = "q5"; //final state

        String[] alphabets = new String[2];
        alphabets[0] = "0";
        alphabets[1] = "1";

        String initialState = "q1";

        String[] finalState = new String[2];
        finalState[0] = "q2";
        finalState[1] = "q5";

        DFA dfa = new DFA(states, alphabets, transitions, finalState, initialState);

        Assert.assertEquals(false,dfa.accept("a"));
        Assert.assertEquals(true,dfa.accept("100"));
        Assert.assertEquals(false,dfa.accept("111"));
    }
}
