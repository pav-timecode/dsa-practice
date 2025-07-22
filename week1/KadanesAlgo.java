package week1;
public class KadanesAlgo {
    static int maxSubarray(int[] arr) {
        int res = arr[0];
        for (int i = 0; i < arr.length; i++) {
            int sum = 0;
            for (int j = i; j < arr.length; j++) {
                sum += arr[j];
                res = Math.max(res, sum);
            }
        }
        return res;
    }
    public static void main(String[] args) {
        int[] arr = { 2, 3, -8, 7, -1, 2, 3 };
        System.out.println(maxSubarray(arr));
    }
}
