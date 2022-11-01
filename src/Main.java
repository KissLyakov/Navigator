import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Car car = new Car(100.0, 40.0);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите длинну маршрута в километрах");

        Navigator navigator = new Navigator(scanner.nextDouble(), car);
        navigator.run();
    }

}