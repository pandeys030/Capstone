import java.util.*;
public class SIT_105 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of array:");
        int n = sc.nextInt();
        int[] A = new int[n];
        System.out.println("Enter the elements of array:");
        for(int i=0;i<n;i++){
            System.out.print("Enter " + (i+1) + "element:");
            A[i] = sc.nextInt();
        }
        System.out.println("Enter total queries:");
        int query = sc.nextInt();
        int totalSum = 0;

        for (int q = 1; q <= query; q++) {
            System.out.println("\nEnter the type of " + q + " query:");
            int type = sc.nextInt();
            System.out.println("Enter the starting index of the " + q + " query:");
            int l = sc.nextInt();
            System.out.println("Enter the ending index of the " + q + " query:");
            int r = sc.nextInt();

            if (type == 1) {
                for (int j = l; j <= r; j++) {
                    A[j] = (j - l + 1) * A[l];
                }
            } else if (type == 2) {
                int sum = 0;
                for (int j = l; j <= r; j++) {
                    sum += A[j];
                }
                totalSum += sum;
            } else {
                System.out.println("Invalid query type. Please enter 1 for update and 2 for sum.");
            }

            System.out.println("Total sum after " + q + " query: " + totalSum);
        }

        sc.close();
    }
}


