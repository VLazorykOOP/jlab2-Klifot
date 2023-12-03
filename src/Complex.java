import java.util.Scanner;

public class Complex {
    private double real;
    private double imaginary;

    public Complex(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    public Complex add(Complex other) {
        return new Complex(this.real + other.real, this.imaginary + other.imaginary);
    }

    public Complex subtract(Complex other) {
        return new Complex(this.real - other.real, this.imaginary - other.imaginary);
    }

    public Complex multiply(Complex other) {
        double resultReal = this.real * other.real - this.imaginary * other.imaginary;
        double resultImaginary = this.real * other.imaginary + this.imaginary * other.real;
        return new Complex(resultReal, resultImaginary);
    }

    public Complex divide(Complex other) {
        double denominator = other.real * other.real + other.imaginary * other.imaginary;
        double resultReal = (this.real * other.real + this.imaginary * other.imaginary) / denominator;
        double resultImaginary = (this.imaginary * other.real - this.real * other.imaginary) / denominator;
        return new Complex(resultReal, resultImaginary);
    }

    public double modulus() {
        return Math.sqrt(real * real + imaginary * imaginary);
    }

    public double argument() {
        return Math.atan2(imaginary, real);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введіть дійсну та уявну частини першого комплексного числа:");
        double real1 = scanner.nextDouble();
        double imaginary1 = scanner.nextDouble();

        System.out.println("Введіть дійсну та уявну частини другого комплексного числа:");
        double real2 = scanner.nextDouble();
        double imaginary2 = scanner.nextDouble();

        Complex complex1 = new Complex(real1, imaginary1);
        Complex complex2 = new Complex(real2, imaginary2);

        Complex sum = complex1.add(complex2);
        Complex difference = complex1.subtract(complex2);
        Complex product = complex1.multiply(complex2);
        Complex quotient = complex1.divide(complex2);

        System.out.println("сума: " + sum.real + " + " + sum.imaginary + "i");
        System.out.println("Різниця: " + difference.real + " + " + difference.imaginary + "i");
        System.out.println("Продукт: " + product.real + " + " + product.imaginary + "i");
        System.out.println("Коефіцієнт: " + quotient.real + " + " + quotient.imaginary + "i");

        System.out.println("Модуль комплексу 1: " + complex1.modulus());
        System.out.println("Аргумент комплексу 1: " + complex1.argument() + " радіан");

        scanner.close();
    }
}
