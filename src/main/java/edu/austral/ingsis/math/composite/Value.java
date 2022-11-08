package edu.austral.ingsis.math.composite;

import java.util.HashMap;
import java.util.List;

public class Value implements Function{

    public final Double value;

    public Value(double value) {
        this.value = value;
    }

    @Override
    public double calculate(HashMap<String, Double> results) {
        return value;
    }

    @Override
    public double calculate() {
        return value;
    }

    @Override
    public String print() {
        return value.toString();
    }

    @Override
    public boolean isVariable() {
        return false;
    }

    @Override
    public void addToVars(List<String> vars) {

    }
}
