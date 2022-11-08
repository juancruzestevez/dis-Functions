package edu.austral.ingsis.math.composite;

import edu.austral.ingsis.math.composite.operators.*;
import org.junit.Test;

import java.util.HashMap;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class ResolutionWithVariablesTest {

    /**
     * Case 1 + x where x = 3
     */
    @Test
    public void shouldResolveFunction1() {
        HashMap<String, Double> map = new HashMap<>();
        map.put("x", 3d);
        final Double result = new Add(new Value(1), new Variable("x")).calculate(map);

        assertThat(result, equalTo(4d));
    }

    /**
     * Case 12 / div where div = 4
     */
    @Test
    public void shouldResolveFunction2() {
        HashMap<String, Double> map = new HashMap<>();
        map.put("div", 4d);
        final Double result = new Div(new Value(12), new Variable("div")).calculate(map);

        assertThat(result, equalTo(3d));
    }

    /**
     * Case (9 / x) * y where x = 3 and y = 4
     */
    @Test
    public void shouldResolveFunction3() {
        HashMap<String, Double> map = new HashMap<>();
        map.put("x", 3d);
        map.put("y", 4d);
        final Double result = new Mult(new Separate(new Div(new Value(9), new Variable("x"))),new Variable("y")).calculate(map);

        assertThat(result, equalTo(12d));
    }

    /**
     * Case (27 / a) ^ b where a = 9 and b = 3
     */
    @Test
    public void shouldResolveFunction4() {
        HashMap<String, Double> map = new HashMap<>();
        map.put("a", 9d);
        map.put("b", 3d);
        final Double result = new Pow(new Separate(new Div(new Value(27), new Variable("a"))),new Variable("b")).calculate(map);

        assertThat(result, equalTo(27d));
    }

    /**
     * Case z ^ (1/2) where z = 36
     */
    @Test
    public void shouldResolveFunction5() {
        HashMap<String, Double> map = new HashMap<>();
        map.put("z", 36d);
        final Double result = new Pow(new Variable("z"), new Separate(new Div(new Value(1), new Value(2)))).calculate(map);

        assertThat(result, equalTo(6d));
    }

    /**
     * Case |value| - 8 where value = 8
     */
    @Test
    public void shouldResolveFunction6() {
        HashMap<String, Double> map = new HashMap<>();
        map.put("value", 8d);
        final Double result = new Subt(new Abs(new Variable("value")), new Value(8)).calculate(map);

        assertThat(result, equalTo(0d));
    }

    /**
     * Case |value| - 8 where value = 8
     */
    @Test
    public void shouldResolveFunction7() {
        HashMap<String, Double> map = new HashMap<>();
        map.put("value", 8d);
        final Double result = new Subt(new Abs(new Variable("value")), new Value(8)).calculate(map);

        assertThat(result, equalTo(0d));
    }

    /**
     * Case (5 - i) * 8 where i = 2
     */
    @Test
    public void shouldResolveFunction8() {
        HashMap<String, Double> map = new HashMap<>();
        map.put("i", 5d);
        final Double result = new Mult(new Separate(new Subt(new Value(5), new Variable("i"))), new Value(8)).calculate(map);

        assertThat(result, equalTo(24d));
    }
}
