import java.util.ArrayList;
import java.util.List;

public class Hailstone {
    Integer n;
    final List<Integer> sequence = new ArrayList<Integer>();

    // Initialize Class
    public Hailstone(Integer n) {
        this.n = n;
    }

    // Setter method for attribute n
    public void setN(final Integer value) {
        this.n = value;
    }

    // Getter method for attribute n
    public Integer getN() {
        return this.n;
    }

    // Create method for generating next sequence
    public void nextElement() {
        if (this.n % 2 == 0)
            this.setN(this.n / 2);
        else
            this.setN(3*this.n + 1);
    }

    // Create method for looping through sequence
    public void resolveSequence() {
       // this.sequence.add(this.n);
        while (this.n != 1) {
            this.nextElement();
            //System.out.println(this.n);
            this.sequence.add(this.n);
        }

        System.out.println("Sequence resolved!");
    }

    public static void main(String[] args) {
        System.out.println("Running Hailstone Sequence!");

        // Initialize Hailstone object
        Hailstone hs = new Hailstone(7);
        System.out.println("Initial value: " + hs.getN());
        hs.resolveSequence();
        System.out.println("Final sequence: " + hs.sequence.toString());
    }
}
