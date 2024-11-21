package application;

public class ComplexNumber {
    private double real;
    private double imaginary;

    public ComplexNumber(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    public ComplexNumber(){
        this.real = 0;
        this.imaginary = 0;
    }

    public double getModule(){
        return Math.sqrt(real*real+imaginary*imaginary);
    }

    public double getReal(){
        return real;
    }

    public void setReal(double real) {
        this.real = real;
    }

    public void setImaginary(double imaginary) {
        this.imaginary = imaginary;
    }

    public double getImaginary() {
        return imaginary;
    }

    public double getArgument() {
        return Math.atan2(imaginary, real);
    }



    @Override
    public String toString() {
        if (imaginary > 0 && real != 0) {
            return real + "+" + imaginary + "i";
        } else if (imaginary == 0 && real != 0) {
            return real + "";
        } else if (imaginary < 0 && real != 0) {
            return real + "-" + Math.abs(imaginary) + "i";
        } else if (imaginary == 0) {
            return real + "";
        } else {
            return imaginary + "i";
        }

    }
}
