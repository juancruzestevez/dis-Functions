package edu.austral.ingsis.math.composite;

import java.util.HashMap;
import java.util.List;

public class Variable implements Function{

    public final String variable;

    public Variable(String variable) {
        this.variable = variable;
    }

    @Override
    public double calculate(HashMap<String, Double> results) {
        return results.get(variable);
    }

    @Override
    public String print() {
        return variable;
    }

    @Override
    public boolean isVariable() {
        return true;
    }

    @Override
    public void addToVars(List<String> vars) {
        if (!vars.contains(variable)){
            vars.add(variable);
        }
    }
}
