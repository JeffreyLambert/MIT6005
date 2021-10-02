import java.util.ArrayList;
import java.lang.Math;

public class Optimizer {

    ArrayList<Double> data;
    double theta = 1.0;
    int n;

    // Optimizer object initializer
    public Optimizer(ArrayList<Double> data) {
        this.data = data;
        this.n = data.size();
    }

    // Add method for calculating sum of ArrayList
    public static double sum(ArrayList<Double> a) {
        double sum_of_elements = 0.0;
        for (Double element: a ) {
            sum_of_elements += element;
        }
        return sum_of_elements;
    }

    // Calculate the log likelihood of the exponential pdf function
    public double logLikelihood(double theta) {
        double ll = this.n * Math.log(theta) - theta * sum(this.data);
        return ll;
    }

    // Calculate the gradient of the exponential pdf function
    public double gradient(double theta) {
        double d = (this.n/theta) - sum(this.data);
        return d;
    }

    // Logic to implement the Newton Raphson optimization method
    public double optimize(double theta0, double epsilon, double learning_rate) {
        double theta = theta0;
        int iterations = 0;
        double step;

        while (Math.abs(gradient(theta) - 0) > epsilon) {
            iterations += 1;
            // Keep track of iterations through method
            if (iterations % 1000 == 0) System.out.println(iterations);

            step = (this.logLikelihood(theta) / this.gradient(theta));
            theta -= learning_rate * step;
        }

        return theta;

    }

    // Generate random draw from exponential distribution
    public static double randomExponentialDraw(double theta) {
        double draw = -1 * (Math.log(Math.random() / theta) / theta);
        return draw;
    }

    // Create ArrayList with draws from an exponential distribution
    public static ArrayList<Double> my_data = new ArrayList<Double>();
    static {
        for (int i = 0; i < 100; i++) {
            my_data.add(randomExponentialDraw(2.0));
        }
    }

    public static void main(String[] args) {
        System.out.println("Start of Output Log");
        Optimizer newton = new Optimizer(my_data);
        double best_theta = newton.optimize(0.001, 0.01, 0.0001);
        // Print actual theta for exponential based on data
        System.out.println(sum(newton.data) / newton.n);

        // Print theta of data as evaluated by the optimizer
        System.out.println(1 / best_theta);
    }
}