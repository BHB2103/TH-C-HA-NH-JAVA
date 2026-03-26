import java.util.*;

public class Bai3_Lab1_23520086 {

    static class Point {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    // Tích có hướng (cross product)
    static long cross(Point O, Point A, Point B) {
        return (long)(A.x - O.x) * (B.y - O.y)
             - (long)(A.y - O.y) * (B.x - O.x);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        List<Point> points = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            points.add(new Point(sc.nextInt(), sc.nextInt()));
        }

        // Sắp xếp theo x, nếu bằng thì theo y
        points.sort((a, b) -> {
            if (a.x != b.x) return a.x - b.x;
            return a.y - b.y;
        });

        List<Point> lower = new ArrayList<>();
        for (Point p : points) {
            while (lower.size() >= 2 &&
                   cross(lower.get(lower.size() - 2),
                         lower.get(lower.size() - 1), p) <= 0) {
                lower.remove(lower.size() - 1);
            }
            lower.add(p);
        }

        List<Point> upper = new ArrayList<>();
        for (int i = points.size() - 1; i >= 0; i--) {
            Point p = points.get(i);
            while (upper.size() >= 2 &&
                   cross(upper.get(upper.size() - 2),
                         upper.get(upper.size() - 1), p) <= 0) {
                upper.remove(upper.size() - 1);
            }
            upper.add(p);
        }

        // Gộp lại (bỏ điểm trùng đầu/cuối)
        lower.remove(lower.size() - 1);
        upper.remove(upper.size() - 1);

        List<Point> hull = new ArrayList<>();
        hull.addAll(lower);
        hull.addAll(upper);

        // In kết quả
        System.out.println("======");
        for (Point p : hull) {
            System.out.println(p.x + " " + p.y);
        }

        sc.close();
    }
}