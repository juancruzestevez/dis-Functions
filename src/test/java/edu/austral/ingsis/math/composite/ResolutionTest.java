package edu.austral.ingsis.math.composite;

import edu.austral.ingsis.math.composite.operators.*;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class ResolutionTest {

    /**
     * Case 1 + 6
     */
    @Test
    public void shouldResolveSimpleFunction1() {
        final Double result = new Add(new Value(1),new Value(6)).calculate();
        assertThat(result, equalTo(7d));
    }

    /**
     * Case 12 / 2
     */
    @Test
    public void shouldResolveSimpleFunction2() {
        final Double result = new Div(new Value(1),new Value(2)).calculate();

        assertThat(result, equalTo(6d));
    }

    /**
     * Case (9 / 2) * 3
     */
    @Test
    public void shouldResolveSimpleFunction3() {
        final Double result = new Mult(new Separate(new Div(new Value(9), new Value(2))),new Value(3)).calculate();

        assertThat(result, equalTo(13.5d));
    }

    /**
     * Case (27 / 6) ^ 2
     */
    @Test
    public void shouldResolveSimpleFunction4() {
        final Double result = new Pow(new Separate(new Div(new Value(27), new Value(6))),new Value(2)).calculate();

        assertThat(result, equalTo(20.25d));
    }

    /**
     * Case 36 ^ (1/2)
     */
    @Test
    public void shouldResolveSimpleFunction5() {
        final Double result = new Pow( new Value(36), new Separate(new Div(new Value(1),new Value(2)))).calculate();

        assertThat(result, equalTo(6d));
    }

    /**
     * Case |136|
     */
    @Test
    public void shouldResolveSimpleFunction6() {
        final Double result = new Abs(new Value(136)).calculate();

        assertThat(result, equalTo(136d));
    }

    /**
     * Case |-136|
     */
    @Test
    public void shouldResolveSimpleFunction7() {
        final Double result = new Abs(new Value(-136)).calculate();

        assertThat(result, equalTo(136d));
    }

    /**
     * Case (5 - 5) * 8
     */
    @Test
    public void shouldResolveSimpleFunction8() {
        final Double result = new Mult(new Separate(new Subt(new Value(5), new Value(5))),new Value(8)).calculate();

        assertThat(result, equalTo(0d));
    }
}
