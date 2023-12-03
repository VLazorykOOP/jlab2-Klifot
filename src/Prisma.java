import java.util.Scanner;

public class Prisma {
    private double height;
    private double baseSide;

    // Конструктор класу, приймає висоту та сторону основи
    public Prisma(double height, double baseSide) {
        this.height = height;
        this.baseSide = baseSide;
    }

    // Метод для знаходження площі бічної поверхні призми
    public double lateralSurfaceArea() {
        // Формула для площі бічної поверхні прямокутної призми: 2 * висота * сторона_основи
        return 2 * height * baseSide;
    }

    // Метод для знаходження об'єму призми
    public double volume() {
        // Формула для об'єму прямокутної призми: висота * площа_основи
        return height * baseArea();
    }

    // Метод для знаходження площі основи призми (трикутника)
    private double baseArea() {
        // Формула для площі правильного трикутника: (сторона^2 * квадратний_корінь_з_3) / 4
        return (baseSide * baseSide * Math.sqrt(3)) / 4;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введіть висоту призми: ");
        double prismHeight = scanner.nextDouble();

        System.out.print("Введіть довжину сторони основи призми: ");
        double prismBaseSide = scanner.nextDouble();

        Prisma myPrism = new Prisma(prismHeight, prismBaseSide);

        System.out.println("Площа бічної поверхні: " + myPrism.lateralSurfaceArea());
        System.out.println("Об'єм: " + myPrism.volume());

        scanner.close();
    }
}
