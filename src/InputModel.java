import java.util.Arrays;
import java.util.HashMap;

public class InputModel {
    private String name;
    private String type;
    private Tuple tuple;
    private String[] pass_cases;
    private String[] fail_cases;

    @Override
    public String toString() {
        return "InputModel{" +
                "name=" + name +
                ", type=" + type +
                ", tuple=" + tuple +
                ", pass_cases=" + pass_cases.toString() +
                ", fail_cases=" + fail_cases.toString() +
                '}';
    }

    public Tuple getTuple() {
        return tuple;
    }

    public String[] getPassCases() {
        return pass_cases;
    }

    public String[] getFailCases() {
        return fail_cases;
    }
}

