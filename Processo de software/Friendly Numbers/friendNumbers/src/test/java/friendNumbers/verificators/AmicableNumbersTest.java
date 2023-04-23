package friendNumbers.verificators;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class AmicableNumbersTest {

    @Test
    void shouldReturnZero() {
        AmicableNumbers amicableNumbers = new AmicableNumbers();

        long value = 1;
        long expected = 0;

        long obtained = amicableNumbers.sumDivisorsOf(value);

        assertEquals(expected, obtained);
    }

    @Test
    void shouldReturnTheSumOfTheDivisorsOfNumber() {
        AmicableNumbers amicableNumbers = new AmicableNumbers();

        long value = 12;
        long expected = 16;

        long obtained = amicableNumbers.sumDivisorsOf(value);

        assertEquals(expected, obtained);
    }

    @Test
    void shouldReturnTrueBecauseTheNumbersAreAmicableFriends() {
        AmicableNumbers amicableNumbers = new AmicableNumbers();

        boolean areAmicable = amicableNumbers.areFriends(220, 284);

        assertTrue(areAmicable);
    }

    @Test
    void shouldReturnFalseBecauseTheNumbersAreNotAmicableFriends() {
        AmicableNumbers amicableNumbers = new AmicableNumbers();

        boolean areAmicable = amicableNumbers.areFriends(250, 800);

        assertFalse(areAmicable);
    }
}
