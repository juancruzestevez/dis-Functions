package edu.austral.ingsis.math.composite;

import edu.austral.ingsis.math.composite.operators.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.empty;


public class ListVariablesTest {

    /**
     * Case 1 + 6
     */
    @Test
    public void shouldListVariablesFunction1() {
        final List<String> result = new ArrayList<>();
        final Function f = new Add(new Value(1),new Value(6));
        f.addToVars(result);

        assertThat(result, empty());;
    }

    /**
     * Case 12 / div
     */
    @Test
    public void shouldListVariablesFunction2() {
        final List<String> result = new ArrayList<>();
        final Function f = new Div(new Value(1),new Variable("div"));
        f.addToVars(result);

        assertThat(result, containsInAnyOrder("div"));
    }

    /**
     * Case (9 / x) * y
     */
    @Test
    public void shouldListVariablesFunction3() {
        final List<String> result = new ArrayList<>();
        final Function f = new Mult(new Separate(new Div(new Value(9), new Variable("x"))),new Variable("y"));
        f.addToVars(result);

        assertThat(result, containsInAnyOrder("x", "y"));
    }

    /**
     * Case (27 / a) ^ b
     */
    @Test
    public void shouldListVariablesFunction4() {
        final List<String> result = new ArrayList<>();
        final Function f = new Pow(new Separate(new Div(new Value(27), new Variable("a"))),new Variable("b"));
        f.addToVars(result);

        assertThat(result, containsInAnyOrder("a", "b"));
    }

    /**
     * Case z ^ (1/2)
     */
    @Test
    public void shouldListVariablesFunction5() {
        final List<String> result = new ArrayList<>();
        final Function f = new Pow(new Variable("z"), new Separate(new Div(new Value(1), new Value(2))));
        f.addToVars(result);

        assertThat(result, containsInAnyOrder("z"));
    }

    /**
     * Case |value| - 8
     */
    @Test
    public void shouldListVariablesFunction6() {
        final List<String> result = new ArrayList<>();
        final Function f = new Subt(new Abs(new Variable("value")), new Value(8));
        f.addToVars(result);

        assertThat(result, containsInAnyOrder("value"));
    }

    /**
     * Case |value| - 8
     */
    @Test
    public void shouldListVariablesFunction7() {
        final List<String> result = new ArrayList<>();
        final Function f = new Subt(new Abs(new Variable("value")), new Value(8));
        f.addToVars(result);

        assertThat(result, containsInAnyOrder("value"));
    }

    /**
     * Case (5 - i) * 8
     */
    @Test
    public void shouldListVariablesFunction8() {
        final List<String> result = new ArrayList<>();
        final Function f = new Mult(new Separate(new Subt(new Value(5), new Variable("i"))), new Value(8));
        f.addToVars(result);

        assertThat(result, containsInAnyOrder("i"));
    }
}
