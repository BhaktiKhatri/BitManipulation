package BitManipulation;

/*
 * 191. Number of 1 Bits
 * https://leetcode.com/problems/number-of-1-bits/description/
 * Write a function that takes an unsigned integer and returns the number of ’1' bits it has (also known as the Hamming weight).
 * For example, the 32-bit integer ’11' has binary representation 00000000000000000000000000001011, so the function should return 3.
 * Explanation and Code from: https://www.geeksforgeeks.org/count-set-bits-in-an-integer/ https://www.youtube.com/watch?v=KJnhAUkxAho https://leetcode.com/problems/number-of-1-bits/solution/
 * The run time depends on the number of 11-bits in n. In the worst case, all bits in n are 11-bits. In case of a 32-bit integer, the run time is O(1).
 * The space complexity is O(1), since no additional space is allocated.
 * Microsoft, Apple
 * Easy
 */

public class NumberOf1Bits {
	
	/*	Brian Kernighan’s Algorithm:
	 	Upon subtracting 1 from any integer, we observe:
	 		1. The rightmost set bit becomes unset
	 		2. All bits on the right of the rightmost set bits are flipped
	 	Bitwise And (&) operation:
	 		1 & 1 = 1 and 0 otherwise 
	*/

	public static int hammingWeight(int n) {
		int count = 0;
		
		while(n != 0) {
			n = n & (n - 1);
			count++;
		}
		
		return count;
	}
	
	public static void main(String[] args) {
		int n = 9;
		System.out.println(hammingWeight(n));
	}

}
