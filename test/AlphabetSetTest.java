import org.junit.Assert;
import org.junit.Test;

public class AlphabetSetTest {
    @Test
    public void when_given_an_invalid_string_should_return_false() throws Exception {
        AlphabetSet alphabets = new AlphabetSet("0,1");

        String[] inputString = {"a"};
        Assert.assertEquals(false, alphabets.isValidAlphabet(inputString));
    }

    @Test
    public void when_given_a_valid_string_should_return_true() throws Exception {
        AlphabetSet alphabets = new AlphabetSet("0,1");

        String[] inputString = {"1"};
        Assert.assertEquals(true, alphabets.isValidAlphabet(inputString));
    }

    @Test
    public void when_given_a_set_of_string_should_say_whether_it_is_valid_or_not() throws Exception {
        AlphabetSet alphabets = new AlphabetSet("0,1");

        String[] inputString = {"1", "1", "1", "a"};
        Assert.assertEquals(false, alphabets.isValidAlphabet(inputString));
    }
}
