package warmup;

import java.util.HashSet;
import java.util.Set;

public class Quadratic {

    /**
     * Find the integer roots of a quadratic equation, ax^2 + bx + c = 0.
     * @param a coefficient of x^2
     * @param b coefficient of x
     * @param c constant term.  Requires that a, b, and c are not ALL zero.
     * @return all integers x such that ax^2 + bx + c = 0.
     */
    public static Set<Integer> roots(int a, int b, int c) {
        //throw new RuntimeException("not implemented yet;"); // TODO: delete this line when you implement it
        assert !(a == 0 && b == 0 && c == 0) : "a, b, and c may not ALL be zero";
        Set<Integer> root_set = new HashSet<>();
        double term1 = (double) -b;
        double term2 = Math.sqrt(Math.pow(b, 2.0) - 4.0*a*c);
        double term3 = (double) 2.0*a;

        int root1 = (int) ((int) (term1 - term2) / term3);
        int root2 = (int) ((int) (term1 + term2) / term3);
        root_set.add(root1);
        root_set.add(root2);
        return root_set;
    }

    
    /**
     * Main function of program.
     * @param args command-line arguments
     */
    public static void main(String[] args) {
        System.out.println("For the equation x^2 - 4x + 3 = 0, the possible solutions are:");
        Set<Integer> result = roots(1, -4, 3);
        System.out.println(result);
    }

    /* Copyright (c) 2016 MIT 6.005 course staff, all rights reserved.
     * Redistribution of original or derived work requires explicit permission.
     * Don't post any of this code on the web or to a public Github repository.
     */
}
