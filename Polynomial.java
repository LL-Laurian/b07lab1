import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

public class Polynomial {
    double[] coefficient;
    int[] exponents;

    public Polynomial(){
        coefficient = new double[]{0};
        exponents = new int[]{0};
    }

    public Polynomial(double[] coefficient, int[] exponents) {
        this.coefficient = coefficient;
        this.exponents = exponents;
    }

    /*
    public int findConstant (String a){
        int indexPlus = a.indexOf("+",1);
        int indexMinus = a.indexOf("-",1);
        if (indexPlus != -1 && indexMinus != -1){
            int preIndexpun = Math.min(indexPlus,indexMinus)-1;
        }

        if (a.charAt(preIndexpun) == 'x'){
            return -1;
        }
        return preIndexpun;
    }
*/

    public int countX (String a){
        char[] arr = a.toCharArray();
        int count=0;
        for (int i =0; i< arr.length; i++){
            if (arr [i] == 'x'){
                count++;
            }
        }
       return count;
    }
    public String updateFormat (String line){

        if (line.matches("\\d+")){
            return line + "x0";
        }

        if (line.isEmpty()){
            return "0x0";
        }

        line = line.replaceAll("-x", "-1x");
        line = line.replaceAll("\\+x", "+1x");
        line = line.replaceAll("x-", "x1-");
        line = line.replaceAll("x\\+", "x1+");

        int stop;
        int start =0;
        String combine="";
        for (int i=0; i<line.length(); i++){
            if (i!=0 && ((line.charAt(i) == '+') || (line.charAt(i) == '-'))){
                stop =i;
                while (start <=stop){
                    combine = combine + line.charAt(start);
                    start++;
                }

                start =stop;
                if (countX(combine) == 0){
                    line = line.replaceAll(combine, (combine.substring(0,(combine.length()-1))+"x0"+combine.charAt(combine.length()-1)));
                    break;
                }
                combine = "";
            }
        }

        return line.replaceAll("-","+-");
    }

    public Polynomial(File file) throws FileNotFoundException {
        Scanner scanner = new Scanner(file);
        String line = scanner.nextLine();
        line = updateFormat(line);


        int length = countX(line);
        double[] coe = new double[length];
        int[] exp = new int[length];
        String[] parts = line.split("[x,+]");

        int count = 1;
        int index = 0;

        for (int i = 0; i < parts.length; i++) {
            if (parts[i].equals("")){
                i++;
            }
            if (count % 2 != 0) {
                coe[index] = Double.parseDouble(parts[i]);
            } else {
                exp[index] = Integer.parseInt(parts[i]);
                index++;
            }

            count++;
        }

        this.coefficient = coe;
        this.exponents = exp;
    }

    /*
        String constant ="";
        int length = countX(line);
        double fir_num=0.0;
        int index=0;
        int preIndexpun = findIndex(line);

        if (preIndexpun != -1){
            length++;
            for (int i =0 ; i<= preIndexpun; i++){
                constant = constant + line.charAt(i);
            }
            fir_num=Double.parseDouble(constant);
        }

        double[] coe = new double[length];
        int[] exp = new int[length];

        if (length == 1){
            String coeficcient ="";
            String exponent= "";
            for (int i=0; i< line.length(); i++){
                if (x< line.indexOf('x')){
                    coeficcient = line.charAt(i) + coeficcient;
                }
                else if (x> line.indexOf('x')){
                    exponent = line.charAt(i) +coeficcient;
                }
            }
            coe[0]= Double.parseDouble(coeficcient);


        }

        if (fir_num != 0.0){
            coe[index] = fir_num;
            exp[index]=0;
            index++;
            line = line.substring(preIndexpun+1);
        }

        String[] coe_exp = line.split("x");
        int start =0;
        for(int end=0; end< coe_exp.length; end++) {
            while (coe_exp[end]!= "+")
            if (i % 2 != 0) {
                coe[index] = Double.parseDouble(coe_exp[i]);
            } else {
                exp[index] = Integer.parseInt(coe_exp[i]);
            }
        }
        this.coefficient = coe;
        this.exponents = exp;

    }

     */
    public int countDistinct (int[] temp_exp){
        int count = exponents.length + temp_exp.length;
        for(int i=0; i<temp_exp.length; i++){
            for (int d=0; d<exponents.length; d++){
                if (exponents[d] == temp_exp[i]){
                    count--;
                    break;
                }
            }
        }
        return count;
    }

    public int countNonzero (){
        int count = 0;
        for (int i=0; i< coefficient.length; i++){
            if( coefficient[i]!=0){
                count++;
            }
        }
        return count;
    }
    public Polynomial deleteZero (){
        int final_length = this.countNonzero();
        if (final_length ==0){
            return new Polynomial();
        }
        Polynomial result =new Polynomial(new double[final_length],new int[final_length]);
        int index =0;
        for (int i =0; i < coefficient.length; i++){
            if (coefficient[i] != 0){
                result.coefficient [index] = coefficient[i];
                result.exponents [index] = exponents [i];
                index++;
            }
        }
        return result;
    }

    public int sameExponent (int exponent, int[] src) {
        for (int i=0; i<src.length; i++) {
            if (exponent == src[i]) {
                return i;
            }
        }
        return -1;
    }


    public Polynomial add (Polynomial src_polynomial) {
        int object_length = coefficient.length;
        int src_length = src_polynomial.coefficient.length;

        if (src_polynomial.countNonzero() == 0){
            return this;
        }
        else if (this.countNonzero() == 0){
            return src_polynomial;
        }

        int arr_length = this.countDistinct(src_polynomial.exponents);
        int [] result_exp = new int[arr_length];
        double[] result_coe = new double[arr_length];
        //int max_exp = Math.max(exponents[exponents.length-1],src_polynomial.exponents[src_polynomial.exponents.length-1]);
        int index = 0;

            for (int i = 0; i < object_length; i++) {
                int indexSame = sameExponent(exponents[i], src_polynomial.exponents);
                if (indexSame != -1) {
                    result_coe[index] = coefficient[i] + src_polynomial.coefficient[indexSame];
                    result_exp[index] = exponents[i];
                } else {
                    result_coe[index] = coefficient[i];
                    result_exp[index] = exponents[i];
                }
                index++;
            }

            for (int q = 0; q < src_length; q++){
                int indexSame = sameExponent(src_polynomial.exponents[q],exponents);
                if(indexSame==-1){
                    result_coe[index] = src_polynomial.coefficient[q];
                    result_exp[index] = src_polynomial.exponents[q];
                    index++;
                }
            }

        return (new Polynomial(result_coe, result_exp)).deleteZero();

    }

    public Polynomial addSingle (double coe, int exp) {
        double [] coeffienct1 = new double[1];
        coeffienct1[0] =coe;
        int [] exponent1 = new int[1];
        exponent1[0] = exp;

        Polynomial src_polynomial = new Polynomial(coeffienct1,exponent1);

        if (src_polynomial.countNonzero() == 0){
            return this;
        }
        else if (this.countNonzero() == 0){
            return src_polynomial;
        }

        int arr_length = this.countDistinct(src_polynomial.exponents);
        int [] result_exp = new int[arr_length];
        double[] result_coe = new double[arr_length];
        //int max_exp = Math.max(exponents[exponents.length-1],src_polynomial.exponents[src_polynomial.exponents.length-1]);
        int index = 0;

        for (int i = 0; i < this.coefficient.length; i++) {
            if (exponents[i] == exp) {
                result_coe[index] = coefficient[i] + coe;
                result_exp[index] = exp;
            } else {
                result_coe[index] = coefficient[i];
                result_exp[index] = exponents[i];
            }
            index++;
        }

        if( index == arr_length-1){
            result_coe[index] =coe;
            result_exp[index]=exp;
        }
        return (new Polynomial(result_coe, result_exp)).deleteZero();

    }

    public Polynomial multiply (Polynomial src_polynomial){
        int object_length = coefficient.length;
        int src_length = src_polynomial.coefficient.length;
        //int longer_length = (coefficient.length >= src_polynomial.coefficient.length)? coefficient.length : src_polynomial.coefficient.length;
        double[] temp_coe = new double[1];
        int[] temp_exp = new int[1];
        Polynomial result = new Polynomial();

        for (int i = 0; i < object_length; i++){
            for (int d = 0; d < src_length; d++) {
                /*
                Polynomial temp =new Polynomial(temp_coe, temp_exp);
                temp_coe[0] = coefficient[i] * src_polynomial.coefficient[d];
                temp_exp[0] = exponents[i] + src_polynomial.exponents[d];

                 */
                result = result.addSingle(coefficient[i] * src_polynomial.coefficient[d], exponents[i] + src_polynomial.exponents[d]);
            }
        }
        return result;
    }



    public double evaluate (double x) {
        double result = 0;
        for (int i = 0; i < coefficient.length; i++) {
            result = coefficient[i] * Math.pow(x,exponents[i]) + result;
        }
        return result;
    }

    public boolean hasRoot (double x){
        if (evaluate(x) == 0){
            return true;
        }
        else{return false;}
    }

    public void saveToFile(String fileName) throws FileNotFoundException {
        String content ="";
        for (int i=0; i<coefficient.length; i++){
            if (coefficient[i] == 0){
                content =content + '0';
            }
            else if (coefficient[i] !=1 ){
                content =content + coefficient[i];
            }
            else if (coefficient[i] ==1){
                content =content;
            }
            if( exponents[i] != 0){
                content = content + "x";
            }


            if (exponents[i] != 0){
                content =content + exponents[i];
            }
            if (i!=coefficient.length-1){
                content =content +'+';
            }

        }
        content = content.replaceAll("\\+-", "-");
        content = content.replaceAll("x1\\+","x+");
        content = content.replaceAll("x1-","x-");
        PrintStream ps = new PrintStream(fileName);
        ps.print(content);
        ps.close();
    }
}


