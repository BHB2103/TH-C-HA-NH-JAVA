import java.util.*;

public class Bai4_Lab1_23520086 {

    static int n, k;
    static int[] a;

    static List<Integer> best = new ArrayList<>();

    public static void backtrack(int index, int sum, List<Integer> current) {
        // Nếu sum đúng k → cập nhật
        if (sum == k) {
            if (current.size() > best.size()) {
                best = new ArrayList<>(current);
            }
            return;
        }

        // Nếu vượt k hoặc hết mảng
        if (sum > k || index == n) return;

        // Chọn a[index]
        current.add(a[index]);
        backtrack(index + 1, sum + a[index], current);

        // Bỏ chọn
        current.remove(current.size() - 1);
        backtrack(index + 1, sum, current);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        k = sc.nextInt();

        a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        backtrack(0, 0, new ArrayList<>());

        if (best.isEmpty()) {
            System.out.println("-> Khong co day con nao");
        } else {
            for (int i = 0; i < best.size(); i++) {
                System.out.print(best.get(i));
                if (i < best.size() - 1) System.out.print(" ");
            }
        }

        sc.close();
    }
}