import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;

public class Driver {
    public static void main(String [] args) throws FileNotFoundException {
/*
        Polynomial p = new Polynomial();

        System.out.println(p.evaluate(3));
        double [] c1 = {6,9,-8,5};
        int [] e1 = {0,1,4,3};
        Polynomial p1 = new Polynomial(c1,e1);
        p1.saveToFile("p1");
        Polynomial p5 = new Polynomial(new File("p1"));
        System.out.println("p5 coe"+Arrays.toString(p5.coefficient));
        System.out.println("p5 exp"+Arrays.toString(p5.exponents));

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

        */

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


        Polynomial p11 = new Polynomial();
        System.out.println(p11.evaluate(3));
        double [] c1_coe = {6,5,3};
        int[] c1_exp = {0,7,8};
        Polynomial p9 = new Polynomial(c1_coe, c1_exp);
        double [] c2_coe = {1,2,3,5};
        int[] c2_exp = {0,3,4,8};
        Polynomial p10 = new Polynomial(c2_coe, c2_exp);
        Polynomial muti = p10.multiply(p9);
        System.out.println("Multiply_coe"+ Arrays.toString(muti.coefficient));
        System.out.println("Multiply_exp: "+ Arrays.toString(muti.exponents));







        /*
        double [] c1_coe = {6,-2,5};
        int[] c1_exp = {0,1,8};
        Polynomial p1 = new Polynomial(c1_coe, c1_exp);
        double [] c2_coe = {7,8};
        int[] c2_exp = {1,8};
        Polynomial p2 = new Polynomial(c2_coe, c2_exp);
        Polynomial m = p1.multiply(p2);

*/

/*
        Polynomial p = new Polynomial(new File("abc"));
        System.out.println("Multiply_coe"+ Arrays.toString(p.coefficient));
        System.out.println("Multiply_exp: "+ Arrays.toString(p.exponents));
*/




        //Polynomial s = p1.add(p2);
        /*System.out.println("s(0.1) = " + s.evaluate(0.1));
        if(s.hasRoot(1))
            System.out.println("1 is a root of s");
        else
            System.out.println("1 is not a root of s");
        */

        /*
        Polynomial p = new Polynomial(new File("b07lab1/test.txt"));
        System.out.println(Arrays.toString(p.coe));
        System.out.println(Arrays.toString(p.exp));
        p.saveToFile("b07lab1/output.txt");




        double [] c1_coe = {2,1,3,4,9,8};
        int[] c1_exp = {3,4,5,1,6,7};
        Polynomial p1 = new Polynomial(c1_coe, c1_exp);
        double [] c2_coe = {2,3,-7,-2};
        int[] c2_exp = {5,4,8,1};
        Polynomial p2 = new Polynomial(c2_coe, c2_exp);
        System.out.println("p1 coe"+Arrays.toString(p1.coefficient));
        System.out.println("p1 exp"+Arrays.toString(p1.exponents));
        System.out.println("p2 coe"+Arrays.toString(p2.exponents));
        System.out.println("p2 exp"+Arrays.toString(p2.exponents));
        System.out.println("******************************************************8888");
        Polynomial n = p1.add(p2);
        Polynomial m = p1.multiply(p2);
        System.out.println("evaluate:"+p1.evaluate(0.1));
        System.out.println("add coe"+Arrays.toString(n.coefficient));
        System.out.println("add exp"+Arrays.toString(n.exponents));
        System.out.println("mul coe"+Arrays.toString(m.coefficient));
        System.out.println("mul exp"+Arrays.toString(m.exponents));

*/

    }
}