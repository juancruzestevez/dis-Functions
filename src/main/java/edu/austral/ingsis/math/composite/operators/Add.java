package edu.austral.ingsis.math.composite.operators;

import edu.austral.ingsis.math.composite.Function;

import java.util.HashMap;
import java.util.List;

public class Add implements Function {

    public final Function f1;
    public final Function f2;

    public Add(Function f1, Function f2) {
        this.f1 = f1;
        this.f2 = f2;
    }

    @Override
    public double calculate(HashMap<String, Double> results) {
        return f1.calculate(results) + f2.calculate(results);
    }

    @Override
    public String print() {
        return f1.print() + " + " + f2.print();
    }

    @Override
    public boolean isVariable() {
        return false;
    }

    @Override
    public void addToVars(List<String> vars) {
        f1.addToVars(vars);
        f2.addToVars(vars);
    }
}
