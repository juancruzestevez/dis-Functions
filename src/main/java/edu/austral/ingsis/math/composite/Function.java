package edu.austral.ingsis.math.composite;

import java.util.HashMap;
import java.util.List;

public interface Function {
    double calculate(HashMap<String, Double> results);
    String print();
    boolean isVariable();

    void addToVars(List<String> vars);
}
