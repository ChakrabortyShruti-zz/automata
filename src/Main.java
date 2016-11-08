import DFA.Delta;
import DFA.Machine;
import common.AlphabetSet;
import common.InputModel;
import common.State;
import common.States;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.util.HashMap;


public class Main {
    public static void main(String[] args) throws Exception {
        JSONParser jsonParser = new JSONParser();
        String jsonInput = "{\"name\":\"odd number of zeroes\",\"type\":\"dfa\",\"tuple\":{\"states\":[\"q1\",\"q2\"],\"alphabets\":[\"1\",\"0\"],\"delta\":{\"q1\":{\"0\":\"q2\",\"1\":\"q1\"},\"q2\":{\"0\":\"q1\",\"1\":\"q2\"}},\"start_state\":\"q1\",\"final_states\":[\"q2\"]},\"pass_cases\":[\"0\",\"000\",\"00000\",\"10\",\"101010\",\"010101\"],\"fail_cases\":[\"00\",\"0000\",\"1001\",\"1010\",\"001100\"]}";
        JSONObject parsedInput = (JSONObject) jsonParser.parse(jsonInput);

        InputModel inputModel = new InputModel((String) parsedInput.get("name"), (String) parsedInput.get("type"), (JSONObject) parsedInput.get("tuple"), (JSONArray) parsedInput.get("pass_cases"), (JSONArray) parsedInput.get("fail_cases"));

        JSONObject tuple = inputModel.getTuple();

        String[] alphabets = convertJsonArrayToStringArray((JSONArray) tuple.get("alphabets"));

        States states = convertJsonArrayToStates((JSONArray) tuple.get("states"));
        AlphabetSet characterSet = new AlphabetSet(alphabets);
        Delta delta = convertJsonObjectToHashMap((JSONObject) tuple.get("delta"));
        State startState = new State((String) tuple.get("start_state"));
        States finalStates = convertJsonArrayToStates((JSONArray) tuple.get("final_states"));

        Machine dfa = new Machine(states, characterSet, delta, finalStates, startState);

        dfa.CheckFailCases(inputModel.getFailCases(), dfa);
        dfa.CheckPassCases(inputModel.getPassCases(), dfa);
    }

    private static Delta convertJsonObjectToHashMap(JSONObject transitions) {
        HashMap<State, HashMap<String, State>> transitionTable = new HashMap<>();
        for (Object presentState : transitions.keySet()) {
            State pState = new State((String) presentState);
            JSONObject alphabetStateValue = (JSONObject) transitions.get(presentState);

            for (Object character : alphabetStateValue.keySet()) {
                String alphabet = (String) character;
                State nState = new State((String) alphabetStateValue.get(alphabet));

                transitionTable.putIfAbsent(pState, new HashMap<>());
                transitionTable.get(pState).put(alphabet, nState);
            }
        }
        return new Delta(transitionTable);
    }

    private static String[] convertJsonArrayToStringArray(JSONArray alphabets) {
        String[] characterSet = new String[2];
        for (int i = 0; i < alphabets.size(); i++) {
            characterSet[i] = (String) alphabets.get(i);
        }
        return characterSet;
    }

    private static States convertJsonArrayToStates(JSONArray jsonArrayStates) {
        States states = new States();
        for (Object state : jsonArrayStates) {
            states.add(new State((String) state));
        }
        return states;
    }
}