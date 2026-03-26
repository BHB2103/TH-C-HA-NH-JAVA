import java.util.Random;
import java.util.Scanner;

public class Bai2_Lab1_23520086 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.print("-- Nhap so lan thu (so lan thu cang lon thi PI cang chuan): ");
        int n = scanner.nextInt();

        int countInsideCircle = 0;

        for (int i = 0; i < n; i++) {
            // Random x, y trong [-1, 1]
            double x = -1 + 2 * random.nextDouble();
            double y = -1 + 2 * random.nextDouble();

            // Kiểm tra thuộc đường tròn đơn vị
            if (x * x + y * y <= 1) {
                countInsideCircle++;
            }
        }

        double piApprox = 4.0 * countInsideCircle / n;

        System.out.println("-> Gia tri xap xi cua PI = " + piApprox);

        scanner.close();
    }
}