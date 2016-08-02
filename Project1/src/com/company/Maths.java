package com.company;

/**
 * Created by Academy07 on 02/08/2016.
 */
public class Maths {
    public static int factorialFinder(int num) {
        if (num == 1) {
            return num;
        }

        int factorial = num * factorialFinder(num - 1);

        return factorial;
    }

    public static int binomialProbability(int n, int r) {
        // formula = n! / (r! * (n - r)!)
        // http://www.dummies.com/how-to/content/how-to-find-binomial-probabilities-using-a-statist.html

        int nFact = factorialFinder(n);
        int rFact = factorialFinder(r);
        int nrFact = factorialFinder(n - r);

        int probability = nFact / (rFact * nrFact);
        return probability;
    }
}
