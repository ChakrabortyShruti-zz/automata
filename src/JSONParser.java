import com.google.gson.*;
import org.junit.Assert;
import org.junit.Test;

public class JSONParser {
    public void parse() throws Exception {
        String jsonInput = "{\"name\":\"odd number of zeroes\",\"type\":\"dfa\",\"tuple\":{\"states\":[\"q1\",\"q2\"],\"alphabets\":[\"1\",\"0\"],\"delta\":{\"q1\":{\"0\":\"q2\",\"1\":\"q1\"},\"q2\":{\"0\":\"q1\",\"1\":\"q2\"}},\"start_state\":\"q1\",\"final_states\":[\"q2\"]},\"pass_cases\":[\"0\",\"000\",\"00000\",\"10\",\"101010\",\"010101\"],\"fail_cases\":[\"00\",\"0000\",\"1001\",\"1010\",\"001100\"]}";

        Gson gson = new Gson();
        InputModel parseJson = gson.fromJson(jsonInput, InputModel.class);
        DFA machine = DFA.createMachine(parseJson.getTuple());
        System.out.println(parseJson.getTuple().getDelta());
        CheckFailCases(parseJson.getFailCases(), machine);
        CheckPassCases(parseJson.getPassCases(), machine);
    }

    private void CheckFailCases(String[] failCases, DFA machine) {
        for (String cases : failCases) {
            Assert.assertEquals(false, machine.canAccept(cases));
        }
    }

    private void CheckPassCases(String[] PassCases, DFA machine) {
        for (String cases : PassCases) {
            System.out.println(machine.canAccept(cases));
            Assert.assertEquals(true, machine.canAccept(cases));
        }
    }

}