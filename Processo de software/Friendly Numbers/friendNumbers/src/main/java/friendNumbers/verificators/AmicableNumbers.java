package friendNumbers.verificators;

import friendNumbers.FriendNumbersVerificator;

public class AmicableNumbers implements FriendNumbersVerificator {

    public long sumDivisorsOf(long number) {
        long sum = 0;

        for (long i = 1; i < number; i++)
            if (number % i == 0)
                sum += i;

        return sum;
    }

    @Override
    public boolean areFriends(long numberA, long numberB) {
        long divisorsOfNumberA = sumDivisorsOf(numberA);
        long divisorsOfNumberB = sumDivisorsOf(numberB);

        if ((divisorsOfNumberA == numberB) && (divisorsOfNumberB == numberA))
            return true;
        return false;
    }
}
