package common;

import DFA.Delta;
import DFA.Tuple;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.util.HashMap;

public class MyParser {
    public Tuple toTuple(JSONObject tuple) throws ParseException {
        String[] alphabets = convertToCharacterSet((JSONArray) tuple.get("alphabets"));

        States states = convertToStates((JSONArray) tuple.get("states"));
        AlphabetSet characterSet = new AlphabetSet(alphabets);
        Delta delta = convertToDelta((JSONObject) tuple.get("delta"));
        State startState = new State((String) tuple.get("start_state"));
        States finalStates = convertToStates((JSONArray) tuple.get("final_states"));

        return new Tuple(states, characterSet, delta, startState, finalStates);
    }

    private static Delta convertToDelta(JSONObject transitions) {
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

    private static String[] convertToCharacterSet(JSONArray alphabets) {
        String[] characterSet = new String[2];
        for (int i = 0; i < alphabets.size(); i++) {
            characterSet[i] = (String) alphabets.get(i);
        }
        return characterSet;
    }

    private static States convertToStates(JSONArray jsonArrayStates) {
        States states = new States();
        for (Object state : jsonArrayStates) {
            states.add(new State((String) state));
        }
        return states;
    }
}
