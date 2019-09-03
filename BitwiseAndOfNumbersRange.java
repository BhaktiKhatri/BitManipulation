package BitManipulation;

/*
 * 201. Bitwise AND of Numbers Range
 * https://leetcode.com/problems/bitwise-and-of-numbers-range/description/
 * Given a range [m, n] where 0 <= m <= n <= 2147483647, return the bitwise AND of all numbers in this range, inclusive.
 * Example 1: Input: [5,7]; Output: 4
 * Example 2: Input: [0,1]; Output: 0
 * Explanation and Code from: https://leetcode.com/problems/bitwise-and-of-numbers-range/discuss/56729/Bit-operation-solution(JAVA)
 * https://www.programcreek.com/2014/04/leetcode-bitwise-and-of-numbers-range-java/
 * https://translate.google.com/translate?hl=en&sl=zh-CN&u=http://www.cnblogs.com/grandyang/p/4431646.html&prev=search
 * Medium
 */

public class BitwiseAndOfNumbersRange {

    public static int rangeBitwiseAnd(int m, int n) {
        if(m == 0) {
            return 0;
        }
        
        System.out.println("m: "+m+" n: "+n);
        
        int moveFactor = 1;
        while(m != n) {
            m = m >> 1;
            n = n >> 1;
            moveFactor = moveFactor << 1;
            System.out.println("m: "+m+" n: "+n+" moveFactor: "+moveFactor);
        }
        System.out.println("m: "+m+" n: "+n+" moveFactor: "+moveFactor);
        
        return m * moveFactor;
    }
	
	public static void main(String[] args) {
		int m = 5;
		int n = 7;
		System.out.println(rangeBitwiseAnd(m, n));
	}

}
