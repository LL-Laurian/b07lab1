import java.io.File;
import java.io.FileNotFoundException;

public class Driver {
    public static void main(String [] args) throws FileNotFoundException {
        Polynomial p = new Polynomial();
        System.out.println(p.evaluate(3));
        double [] c1 = {6,5};
        int [] e1 = {0,3};
        Polynomial p1 = new Polynomial(c1,e1);
        double [] c2 = {-2,-9};
        int [] e2 = {1,4};
        Polynomial p2 = new Polynomial(c2,e2);


        Polynomial s = p1.add(p2);
        Polynomial m = p1.multiply(p2);
        m.saveToFile("cde");
        Polynomial p5 = new Polynomial(new File("cde"));


        System.out.println("m(0.1) = " + m.evaluate(0.1));
        System.out.println("s(0.1) = " + s.evaluate(0.1));
        if(s.hasRoot(1))
            System.out.println("1 is a root of s");
        else
            System.out.println("1 is not a root of s");



        double [] c3 = {-6,-5};
        Polynomial p3 = new Polynomial(c3,e1);
        Polynomial sum = p3.add(p1);
        sum.saveToFile("abc");
        Polynomial p4 = new Polynomial(new File("abc"));
        System.out.println("p4(0.1) = " + p4.evaluate(0.1));

        double [] c6 ={-9,6,-9,6};
        int[] e6 ={1,6,3,0};
        Polynomial p6 = new Polynomial(c6,e6);
        double [] c7 ={9,6,9,2};
        int[] e7 ={1,6,3,9};
        Polynomial p7 = new Polynomial(c7,e7);
        Polynomial sum2 = p6.add(p7);
        Polynomial multi2 = p6.multiply(p7);
        sum2.saveToFile("hij");
        multi2.saveToFile("efg");
        Polynomial p8 = new Polynomial(new File("efg"));
        System.out.println("p8(5.5) = " + p8.evaluate(5.5));
        System.out.println("sum2(5.5) = " + sum2.evaluate(5.5));

    }
}