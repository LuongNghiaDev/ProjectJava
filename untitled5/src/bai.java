import java.util.Scanner;

public class bai {
    public static void main(String[] args) {
        public static Scanner scanner = new Scanner(System.in);

        public static void main(String[] args) {
            System.out.print("Nhập số phần tử của mảng: ");
            int n = scanner.nextInt();
            // khởi tạo mảng arr
            int[] arr = new int[n];
            System.out.print("Nhập các phần tử của mảng: \n");
            for (int i = 0; i < n; i++) {
                System.out.printf("a[%d] = ", i);
                arr[i] = scanner.nextInt();
            }
            System.out.print("Các phần tử của mảng: ");
            show(arr);
        }

        public static void show (int[] arr) {
            for (int i = 0; i < arr.length; i++) {
                System.out.print(arr[i] + " ");
            }
        }
    }
}
