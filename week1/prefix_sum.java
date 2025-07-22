package week1;

import java.util.LinkedList;
import java.util.Scanner;

public class prefix_sum{
    public static void main(String[] args) {
        LinkedList<Integer> prefix = new LinkedList<>();
        Scanner in = new Scanner(System.in);
        System.out.println("Enter First Element of the array");
        int sum = 0;
        while(true) {
            int n = in.nextInt();
            if(n==-1){
                break;
            }
            sum+=n;
            prefix.add(sum);
        }

        System.out.println(prefix);
        in.close();
    }
}