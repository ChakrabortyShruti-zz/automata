import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AlphabetSetTest {
    String[] characterSet = new String[2];
    AlphabetSet alphabets;

    @Before
    public void setUp() throws Exception {

        characterSet[0] = "0";
        characterSet[1] = "1";
        alphabets = new AlphabetSet(characterSet);
    }

    @Test
    public void when_given_an_invalid_string_should_return_false() throws Exception {
        String inputString = "a";
        Assert.assertEquals(false, alphabets.isValidAlphabet(inputString));
    }

    @Test
    public void when_given_a_valid_string_should_return_true() throws Exception {
        String inputString = "1";
        Assert.assertEquals(true, alphabets.isValidAlphabet(inputString));
    }
}
