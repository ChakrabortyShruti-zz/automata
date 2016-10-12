import org.junit.Assert;
import org.junit.Test;


public class TransitionsTest {
    @Test
     public void when_given_a_start_state_and_alphabet_should_return_next_state() throws Exception {
        Transitions transitions = new Transitions();
        transitions.Set("q1","1","q2");

        Assert.assertEquals("q2",transitions.getNextState("q1","1"));
    }
}