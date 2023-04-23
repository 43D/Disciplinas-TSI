package friendNumbers.verificators;

import friendNumbers.FriendNumbersVerificator;

public class FriendlyNumbers implements FriendNumbersVerificator {

    public double incrementSumDivisorsOf(double number) {
        double sum = 0;

        for (double i = 1; i <= number; i++)
            if (number % i == 0)
                sum += i;

        return sum;
    }

    public double abundancyNumberOf(double number) {
        double abundancy = incrementSumDivisorsOf(number) / number;

        return abundancy;
    }

    @Override
    public boolean areFriends(long numberA, long numberB) {
        double abundancyNumberA = abundancyNumberOf(numberA);
        double abundancyNumberB = abundancyNumberOf(numberB);

        return (abundancyNumberA == abundancyNumberB);
    }

}
