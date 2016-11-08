package common;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class InputModel {
    private String name;
    private String type;
    private JSONObject tuple;
    private JSONArray pass_cases;
    private JSONArray fail_cases;

    public InputModel(String name, String type, JSONObject tuple, JSONArray pass_cases, JSONArray fail_cases) {
        this.name = name;
        this.type = type;
        this.tuple = tuple;
        this.pass_cases = pass_cases;
        this.fail_cases = fail_cases;
    }

    @Override
    public String toString() {
        return "common.InputModel{" +
                "name=" + name +
                ", type=" + type +
                ", tuple=" + tuple +
                ", pass_cases=" + pass_cases.toString() +
                ", fail_cases=" + fail_cases.toString() +
                '}';
    }

    public JSONObject getTuple() {
        return tuple;
    }

    public JSONArray getPassCases() {
        return pass_cases;
    }

    public JSONArray getFailCases() {
        return fail_cases;
    }
}

