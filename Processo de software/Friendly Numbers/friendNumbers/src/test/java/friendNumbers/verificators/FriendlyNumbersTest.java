package friendNumbers.verificators;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class FriendlyNumbersTest {
    @Test
    void shouldReturnSameValue() {
        FriendlyNumbers friendlyNumbers = new FriendlyNumbers();

        long value = 0;
        double expected = 0;

        double obtained = friendlyNumbers.incrementSumDivisorsOf(value);
        assertEquals(expected, obtained);

        value = 1;
        expected = 1;

        obtained = friendlyNumbers.incrementSumDivisorsOf(value);
        assertEquals(expected, obtained);
    }

    @Test
    void shouldReturnTheSumOfTheDivisorsOfNumber() {
        FriendlyNumbers friendlyNumbers = new FriendlyNumbers();

        long value = 12;
        double expected = 28.0;

        double obtained = friendlyNumbers.incrementSumDivisorsOf(value);
        assertEquals(expected, obtained);
    }

    @Test
    void shouldReturnTheAbundancyOfNumber() {
        FriendlyNumbers friendlyNumbers = new FriendlyNumbers();

        long value = 120;
        double expected = 3;

        double obtained = friendlyNumbers.abundancyNumberOf(value);
        assertEquals(expected, obtained);
    }

    @Test
    void shouldReturnTrueBecauseTheNumbersAreFriendly() {
        FriendlyNumbers friendlyNumbers = new FriendlyNumbers();

        boolean areFriendly = friendlyNumbers.areFriends(30, 140);

        assertTrue(areFriendly);
    }

    @Test
    void shouldReturnFalseBecauseTheNumbersAreNotFriendly() {
        FriendlyNumbers friendlyNumbers = new FriendlyNumbers();

        boolean areFriendly = friendlyNumbers.areFriends(145, 457);

        assertFalse(areFriendly);
    }
}
