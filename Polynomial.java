
public class Polynomial {
    double[] coefficient;

    public Polynomial(){
        coefficient = new double[]{0};
    }

    public Polynomial(double[] coefficient) {
        this.coefficient = coefficient;
    }

    public Polynomial add (Polynomial src_polynomial) {
        int max_length = Math.max(coefficient.length, src_polynomial.coefficient.length);
        double[] result = new double[max_length];

        for (int i = 0; i < max_length; i++) {
            if (i >= coefficient.length) {
                result[i] = 0 + src_polynomial.coefficient[i];
            } else if (i >= src_polynomial.coefficient.length) {
                result[i] = 0 + coefficient[i];
            } else {
                result[i] = coefficient[i] + src_polynomial.coefficient[i];
            }
        }
        return new Polynomial(result);

    }

    public double evaluate (double x) {
        double result = 0;
        double x_result=1;

        for (int i = 0; i < coefficient.length; i++) {
            for (int t = i; t>0; t--) {
                    x_result = x_result * x;
                }

            result = coefficient[i] * x_result + result;
            x_result=1;
        }
        return result;
    }

    public boolean hasRoot (double x){
        if (evaluate(x) == 0){
            return true;
        }
        else{return false;}
    }
}


