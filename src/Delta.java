import java.util.HashMap;

public class Delta {
    private HashMap<String, HashMap<String, String>> delta;

    public Delta(HashMap<String, HashMap<String, String>> transitionTable) {
        this.delta = transitionTable;
    }


    public String getNextState(String state, String alphabet) {
        return delta.get(state).get(alphabet);
//        return delta.run(state,alphabet);
    }

    @Override
    public String toString() {
        return "Delta{" +
                "delta=" + delta +
                '}';
    }
}
