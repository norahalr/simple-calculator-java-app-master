package nl.ordina;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {

    @Test
    public void testAdd() {
        assertThat(Calculator.add(2, 3)).isEqualTo(5);
    }

    @Test
    public void testMultiply() {
        assertThat(Calculator.multiply(2, 3)).isEqualTo(6);
    }
}