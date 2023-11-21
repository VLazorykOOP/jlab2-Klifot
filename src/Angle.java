import java.util.Objects;
import java.util.Scanner;

public class Angle {
    private double degrees;

    public Angle(double degrees) {
        this.degrees = degrees;
        normalize();
    }

    public double toRadians() {
        return Math.toRadians(degrees);
    }

    private void normalize() {
        degrees = (degrees % 360 + 360) % 360;
    }

    public void increase(double amount) {
        degrees += amount;
        normalize();
    }

    public void decrease(double amount) {
        degrees -= amount;
        normalize();
    }

    public double sin() {
        return Math.sin(toRadians());
    }

    public boolean equals(Angle other) {
        return other != null && Double.compare(this.degrees, other.degrees) == 0;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Angle angle = (Angle) obj;
        return Double.compare(angle.degrees, degrees) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(degrees);
    }

    @Override
    public String toString() {
        return String.format("%.2f degrees", degrees);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the angle in degrees: ");
        double userAngle = scanner.nextDouble();

        Angle angle1 = new Angle(userAngle);
        System.out.println("Angle 1: " + angle1);

        System.out.print("Enter the amount to increase Angle 1: ");
        double increaseAmount = scanner.nextDouble();
        angle1.increase(increaseAmount);
        System.out.println("Increased Angle 1 by " + increaseAmount + " degrees: " + angle1);

        System.out.print("Enter the angle in degrees for Angle 2: ");
        double userAngle2 = scanner.nextDouble();
        Angle angle2 = new Angle(userAngle2);
        System.out.println("Angle 2: " + angle2);

        System.out.println("Sin of Angle 2: " + angle2.sin());

        System.out.println("Are Angle 1 and Angle 2 equal? " + angle1.equals(angle2));

        scanner.close();
    }
}
