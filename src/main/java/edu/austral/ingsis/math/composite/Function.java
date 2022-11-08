package edu.austral.ingsis.math.composite;

import java.util.HashMap;
import java.util.List;

public interface Function {
    double calculate(HashMap<String, Double> results);
    double calculate();
    String print();
    boolean isVariable();

    void addToVars(List<String> vars);
}
