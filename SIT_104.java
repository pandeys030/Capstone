//cctv footage camera rotation
//A SECURITY OFFICE STORES THE LASR FEW CAMERA SNAPSHOTS IN AN ARRAY.
//K=3
//OUTPUT: {104,105,106,101,102,103 }
public class SIT_104 {
    public static void main(String[] args) {
        int arr[]= {101,102,103,104,105,106,107,108};
        int k=2;
        int n=arr.length;
        rotate(arr,k);
        System.out.println();
    }
    static void rotate(int []arr, int k){
        int n = arr.length;
        k = k % n;
        reverse(arr,0,n-1);
        reverse(arr,0,k-1);
        reverse(arr,k,n-1);
        for(int i=0;i<n;i++){
            System.out.print(arr[i]+" ");
        }
    }
    static void reverse(int []arr, int start, int end){
        while(start<end){
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

}