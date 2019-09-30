package leetcode;

/**
 * Created by Cookies
 *
 * Reverse Interger
 * Reverse digits of an integer
 *
 * Example: x = 123, return 321
 * Example: x = -123, return -321
 */


public class Reverse_Integer_07 {
 /** int:
  * -2^31 ~ 2^31 - 1 (-2147483648 ~ 2147483647)
  *
  * Corner case : 越界
  *
  * Time: O(n)
  * Space: O(1)
  *
  */
    public static int reverse(int x){
         long res = 0;
         while(x != 0){
             res = res * 10 + x % 10;
             x /= 10;
             if(res > Integer.MAX_VALUE || res < Integer.MIN_VALUE) return 0;
         }
         return (int)res;
    }

    public static void main(String[] args) {
        int i = -3456;
        int j = -2147483648;
        int res = reverse(i);
        System.out.println(res);
        int res1= reverse(j);
        System.out.println(res1);
    }
}
