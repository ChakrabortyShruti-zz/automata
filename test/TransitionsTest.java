import org.junit.Assert;
import org.junit.Test;


public class TransitionsTest {
    @Test
    public void when_given_a_start_state_and_alphabet_should_return_next_state() throws Exception {
        Transitions transitions = new Transitions();
        transitions.set("q1", "1", "q2");

        Assert.assertEquals("q2", transitions.getNextState("q1", "1"));
    }

    @Test
    public void when_given_a_start_state_and_alphabet_should_return_next_state_if_present() throws Exception {
        Transitions transitions = new Transitions();
        transitions.set("q1", "1", "q2");

        Assert.assertEquals(null, transitions.getNextState("q1", "a"));
    }
}