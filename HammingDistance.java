package BitManipulation;

/*
 * 461. Hamming Distance
 * https://leetcode.com/problems/hamming-distance/description/
 * The Hamming distance between two integers is the number of positions at which the corresponding bits are different.
 * Given two integers x and y, calculate the Hamming distance.
 * Note: 0 ≤ x, y < 231.
 * Example: Input: x = 1, y = 4, Output: 2
 * Explanation:
 * 1   (0 0 0 1)
 * 4   (0 1 0 0)
 *        ↑   ↑
 * The above arrows point to positions where the corresponding bits are different.
 * Explanation and Code from: https://leetcode.com/problems/hamming-distance/discuss/94698/Java-1-Line-Solution-:D and NumberOf1Bits.java
 * Facebook 
 * Easy
 */

public class HammingDistance {

	/*
	 * The Hamming distance (https://en.wikipedia.org/wiki/Hamming_distance) between two integers is the number of positions at which the corresponding bits
	 * are different. XOR can help you find out at what positions bits are different. i.e. 1001 ^ 0111 = 1110.
	 * Then things left is to count how many 1 in above result. Integer.bitCount() can help you do that. 
	 * Refer NumberOf1Bits.java to count number of 1 bits
	 */
	public static int hammingDistance(int x, int y) {
		int n = x ^ y;
        int count = 0;
        
        while(n != 0) {
        	n = n & (n - 1);
        	count++;
        }
        
        return count;
    }
	
	public static void main(String[] args) {
		int x = 1;
		int y = 4;
		
		System.out.println(hammingDistance(x, y));
	}

}
