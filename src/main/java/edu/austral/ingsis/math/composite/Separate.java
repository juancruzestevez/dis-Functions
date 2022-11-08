package edu.austral.ingsis.math.composite;

import java.util.HashMap;
import java.util.List;

public class Separate implements Function{
    public final Function f1;

    public Separate(Function f1) {
        this.f1 = f1;
    }

    @Override
    public double calculate(HashMap<String, Double> results) {
        return f1.calculate(results);
    }

    @Override
    public double calculate() {
        return f1.calculate();
    }

    @Override
    public String print() {
        return "(" + f1.print() + ")";
    }

    @Override
    public boolean isVariable() {
        return false;
    }

    @Override
    public void addToVars(List<String> vars) {
        f1.addToVars(vars);
    }
}
