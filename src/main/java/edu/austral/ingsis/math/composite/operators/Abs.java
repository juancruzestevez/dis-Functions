package edu.austral.ingsis.math.composite.operators;

import edu.austral.ingsis.math.composite.Function;

import java.util.HashMap;
import java.util.List;

public class Abs implements Function{
    public final Function f1;

    public Abs(Function f1) {
        this.f1 = f1;
    }

    @Override
    public double calculate(HashMap<String, Double> results) {
        return Math.abs(f1.calculate(results));
    }

    @Override
    public double calculate() {
        return Math.abs(f1.calculate());
    }

    @Override
    public String print() {
        return "|" + f1.print() + "|";
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
