package BitManipulation;

import java.util.Arrays;

/*
 * 136. Single Number
 * https://leetcode.com/problems/single-number/description/
 * Given an array of integers, every element appears twice except for one. Find that single one.
 * Note: Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 * Explanation and Code from: https://leetcode.com/problems/single-number/discuss/42997/My-O(n)-solution-using-XOR
 * Time complexity : O(n), We only iterate through nums, so the time complexity is the number of elements in nums.
 * Space complexity : O(1)
 * Airbnb, Palantir
 * Easy
 */

public class SingleNumber {
	
	/*
	 * 

		In a bit wise XOR operation:
		
		a   b   a^b
		-----------
		0   0    0
		0   1    1
		1   0    1
		1   1    0 
		
		XOR sum refers to successive XOR operations on integers.
		Suppose you have numbers from 1 to N and you have to find their XOR sum then for N = 6, XOR sum will be 1^2^3^4^5^6 = 7.
		
		1 = 001,  2 = 010,   3 = 011,   4 = 100,   5 = 101,   6 = 110  
		
		 1^2          = 1^2  = 001^010 = 011 = 3  
		(1^2)^3       = 3^3  = 011^011 = 000 = 0
		(1^2^3)^4     = 0^4  = 000^100 = 100 = 4
		(1^2^3^4)^5   = 4^5  = 100^101 = 001 = 1
		(1^2^3^4^5)^6 = 1^6  = 001^110 = 111 = 7 --> XOR sum

		https://stackoverflow.com/questions/17284337/what-is-an-xor-sum
	 */
	
	/*
	 	This XOR operation works because it’s like XORing all the numbers by itself. So if the array is {2,1,4,5,2,4,1} then it will be like we are performing this
	 	operation.
	 	((2^2)^(1^1)^(4^4)^(5)) => (0^0^0^5) => 5. Hence picking the odd one out ( 5 in this case).
	 */
	public static int singleNumber(int[] nums) {
		int result = 0;
		System.out.println("nums: "+Arrays.toString(nums));
		
		for(int i=0; i<nums.length; i++) {
		
			System.out.println("result: "+result+" nums[i]: "+nums[i]);
			result = result ^ nums[i];
		}
		System.out.println("result: "+result);
		
		return result;
	}
	
	public static void main(String[] args) {
		int[] nums = {2,1,4,5,2,4,1};
		System.out.println(singleNumber(nums));
	}

}
