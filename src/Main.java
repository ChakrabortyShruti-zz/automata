import DFA.Machine;
import DFA.Tuple;
import common.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;


public class Main {
    public static void main(String[] args) throws Exception {
        String jsonInput = "{\"name\":\"odd number of zeroes\",\"type\":\"dfa\",\"tuple\":{\"states\":[\"q1\",\"q2\"],\"alphabets\":[\"1\",\"0\"],\"delta\":{\"q1\":{\"0\":\"q2\",\"1\":\"q1\"},\"q2\":{\"0\":\"q1\",\"1\":\"q2\"}},\"start_state\":\"q1\",\"final_states\":[\"q2\"]},\"pass_cases\":[\"0\",\"000\",\"00000\",\"10\",\"101010\",\"010101\"],\"fail_cases\":[\"00\",\"0000\",\"1001\",\"1010\",\"001100\"]}";

        JSONParser jsonParser = new JSONParser();
        JSONObject parsedInput = (JSONObject) jsonParser.parse(jsonInput);

        InputModel inputModel = new InputModel((String) parsedInput.get("name"), (String) parsedInput.get("type"), (JSONObject) parsedInput.get("tuple"), (JSONArray) parsedInput.get("pass_cases"), (JSONArray) parsedInput.get("fail_cases"));

        MyParser parser = new MyParser();
        Tuple tuple = parser.toTuple(inputModel.getTuple());

        Machine dfa = new Machine(tuple.getStates(), tuple.getCharacterSet(), tuple.getDelta(), tuple.getFinalStates(), tuple.getStartState());
        dfa.CheckFailCases(inputModel.getFailCases(), dfa);
        dfa.CheckPassCases(inputModel.getPassCases(), dfa);
    }
}