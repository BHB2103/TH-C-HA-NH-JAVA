import java.util.Random;
import java.util.Scanner;

public class Bai1_Lab1_23520086 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("-- Nhap ban kinh r: ");
        double r = sc.nextDouble();

        int n = 1000000; // số lần thử (càng lớn càng chính xác)
        int count = 0;

        Random rand = new Random();

        for (int i = 0; i < n; i++) {
            // random điểm trong hình vuông [-r, r]
            double x = -r + 2 * r * rand.nextDouble();
            double y = -r + 2 * r * rand.nextDouble();

            // kiểm tra điểm có nằm trong hình tròn không
            if (x * x + y * y <= r * r) {
                count++;
            }
        }

        // diện tích hình vuông là (2r)^2 = 4r^2
        double area = (double) count / n * (4 * r * r);

        System.out.println("-> Dien tich xap xi cua hinh tron: S = " + area);
    }
}