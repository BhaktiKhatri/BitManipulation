package BitManipulation;

import java.util.Arrays;
//https://leetcode.com/problems/single-number-ii/discuss/43297/Java-O(n)-easy-to-understand-solution-easily-extended-to-any-times-of-occurance?page=1
//https://www.hackerearth.com/practice/notes/bit-manipulation/
//https://www.geeksforgeeks.org/find-the-element-that-appears-once/
//https://translate.google.com/translate?hl=en&sl=zh-CN&u=http://www.cnblogs.com/grandyang/p/4263927.html&prev=search
//https://translate.google.com/translate?hl=en&sl=zh-CN&u=http://bangbingsyb.blogspot.com/2014/11/leetcode-single-number-i-ii.html&prev=search
//https://www.tangjikai.com/algorithms/leetcode-137-single-number-ii
//https://www.ideserve.co.in/learn/find-the-element-that-appears-once-in-an-array

//Final: https://leetcode.com/problems/single-number-ii/discuss/43297/Java-O(n)-easy-to-understand-solution-easily-extended-to-any-times-of-occurance?page=1

/*
 * 137. Single Number II
 * https://leetcode.com/problems/single-number-ii/description/
 * Given an array of integers, every element appears three times except for one, which appears exactly once. Find that single one.
 * Note:Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 * Explanation and Code from: https://leetcode.com/problems/single-number-ii/discuss/43297/Java-O(n)-easy-to-understand-solution-easily-extended-to-any-times-of-occurance?page=1
 * The usual bit manipulation code is bit hard to get and replicate. I like to think about the number in 32 bits and just count how many 1s are there in each bit,
 * and sum %= 3 will clear it once it reaches 3. After running for all the numbers for each bit, if we have a 1, then that 1 belongs to the single number, we can
 * simply move it back to its spot by doing ans |= sum << i;
 * This has complexity of O(32n), which is essentially O(n) and very easy to think and implement.
 */
public class SingleNumber2 {

	public static final int INT_SIZE = 32;
    
    // Method to find the element that occur only once
    public static int singleNumber(int nums[])
    {
    	int res = 0;
        for(int i = 0; i < 32; i++) {
            int sum = 0;
            for(int n: nums) {
            	System.out.println("n: "+n+" i: "+i+" (n >> i): "+(n >> i)+" (n >> i & 1): "+(n >> i & 1));
                if((n >> i & 1) == 1) {
                    sum++;
                }
            }
            System.out.println("sim: "+sum+" res: "+res+" i: "+i);
            sum = sum % 3;
            res = res | sum << i;
            System.out.println("res: "+res);
        }
        return res;
    }
	
	public static void main(String[] args) {
		int[] arr = {3,3,7,3,5,5,5};
		System.out.println(singleNumber(arr));
	}

}
