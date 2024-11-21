package application;

import java.util.Objects;
import java.util.Scanner;

public class Number extends ComplexNumber {

    public Number(double real, double imaginary) {
        super(real, imaginary);
    }

    public Number() {
        super();
    }

    public Number numberSum(Number value1, Number value2){
        return new Number(value1.getReal() + value2.getReal(), value1.getImaginary() + value2.getImaginary());
    }

    public Number numberDiv(Number value1,int value2){
        return new Number(value1.getReal()/value2,value1.getImaginary()/value2);
    }

    public Number numberDif(Number value1,Number value2){
        return new Number(value1.getReal() - value2.getReal(),value1.getImaginary()-value2.getImaginary());
    }

    public Number numberSquare(Number value1){
        return new Number(value1.getReal()*value1.getReal() + value1.getImaginary()*value1.getImaginary(),2*value1.getReal()*value1.getImaginary());
    }

    public Number numberSqrt(Number value1) {
        Number result = new Number();
        double module = value1.getModule();
        double fi = value1.getImaginary()/value1.getReal();
        result.setReal(Math.sqrt(module)*Math.cos(fi/2));
        result.setImaginary(Math.sqrt(module)*Math.sin(fi/2));
        return result;

    }

    public Number numberMul(Number value1, Number value2){
        return new Number(value1.getReal()*value2.getReal()-value1.getImaginary()*value2.getImaginary(),
                value1.getReal()*value2.getImaginary()+value1.getImaginary()*value2.getReal());
    }

    public Number scannerNumber(){
        Number number = new Number();
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        input = input.replaceAll(" ","");
        input = input.replace("i","");
        String[] parts = input.split("[+-]");

        int index = input.indexOf("+");
        int index1 = input.indexOf("-");
        if(index == -1) {
            int index2 = input.indexOf("-", index1+1);
            if (index1 == 0 && index2 != -1) {
                number.setReal(-1 * Double.parseDouble(parts[1]));
                number.setImaginary(-1 * Double.parseDouble(parts[2]));
            } else if (index1 !=-1 && index2==-1) {
                number.setReal(Double.parseDouble(parts[0]));
                if (!Objects.equals(parts[1], "0")) {
                    number.setImaginary(-1 * Double.parseDouble(parts[1]));
                }
                else {
                    number.setImaginary(-Double.parseDouble(parts[1]));
                }
            }
        }
        else {
            if(index1 == 0) {
                number.setReal(-1 * Double.parseDouble(parts[1]));
                number.setImaginary(Double.parseDouble(parts[2]));
            }
            else {
                number.setReal(Double.parseDouble(parts[0]));
                number.setImaginary(Double.parseDouble(parts[1]));
            }
        }
        return number;
    }

    public int comparisonNumber(Number value1,Number value2){
        if(value1.getModule() > value2.getModule()){
            return 1;
        }
        else if (value1.getModule()<value2.getModule()){
            return -1;
        }
        else {
            return Double.compare(value1.getArgument(),value2.getArgument());
        }
    }


    public Number scannerNumber(String input){
        Number number = new Number();
        input = input.replaceAll(" ","");
        input = input.replace("i","");
        String[] parts = input.split("[+-]");

        int index = input.indexOf("+");
        int index1 = input.indexOf("-");
        if(index == -1) {
            int index2 = input.indexOf("-", index1+1);
            if (index1 == 0 && index2 != -1) {
                number.setReal(-1 * Double.parseDouble(parts[1]));
                number.setImaginary(-1 * Double.parseDouble(parts[2]));
            } else if (index1 !=-1 && index2==-1) {
                number.setReal(Double.parseDouble(parts[0]));
                if (!Objects.equals(parts[1], "0")) {
                    number.setImaginary(-1 * Double.parseDouble(parts[1]));
                }
                else {
                    number.setImaginary(-Double.parseDouble(parts[1]));
                }
            }

        }
        else {
            if(index1 == 0) {
                number.setReal(-1 * Double.parseDouble(parts[1]));
                number.setImaginary(Double.parseDouble(parts[2]));
            }
            else {
                number.setReal(Double.parseDouble(parts[0]));
                number.setImaginary(Double.parseDouble(parts[1]));
            }
        }
        return number;

    }

}

