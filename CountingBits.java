package BitManipulation;

import java.util.Arrays;

/*
 * 338. Counting Bits
 * https://leetcode.com/problems/counting-bits/description/
 * Given a non negative integer number num. For every numbers i in the range 0 ≤ i ≤ num calculate the number of 1's in their binary representation and return 
 * them as an array. Example: For num = 5 you should return [0,1,1,2,1,2]
 * Explanation and Code from:https: Approach #4 //leetcode.com/problems/counting-bits/solution/
 * Time Complexity: O(n), Space Complexity: O(n)
 */

public class CountingBits {

	// Last set bit is the rightmost set bit. Setting that bit to zero with the bit trick, x &= x - 1, leads to the following transition function:
	// P(x) = P(x & (x−1)) + 1;
	public static int[] countBits(int num) {
	      int[] ans = new int[num + 1];
	      
	      for(int i=1; i <= num; i++) {
	    	System.out.println("i: "+i+" i-1: "+(i-1)+" i & (i-1): "+(i & (i-1))+" ans[i & (i - 1)]: "+ans[i & (i - 1)]);  
	        ans[i] = ans[i & (i - 1)] + 1;
	        System.out.println("ans[i]: "+ans[i]);
	      }
	      return ans;
	  }
	
	public static void main(String[] args) {
		int num = 5;
		System.out.println(Arrays.toString(countBits(num)));
	}

}
