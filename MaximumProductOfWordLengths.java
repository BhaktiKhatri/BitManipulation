package BitManipulation;

import java.util.Arrays;

/*
 * 318. Maximum Product of Word Lengths
 * https://leetcode.com/problems/maximum-product-of-word-lengths/description/
 * Given a string array words, find the maximum value of length(word[i]) * length(word[j]) where the two words do not share common letters. 
 * You may assume that each word will contain only lower case letters. If no such two words exist, return 0.
 * Example 1: Given ["abcw", "baz", "foo", "bar", "xtfn", "abcdef"]; Return 16; The two words can be "abcw", "xtfn"
 * Example 2: Given ["a", "ab", "abc", "d", "cd", "bcd", "abcd"]; Return 4; The two words can be "ab", "cd"
 * Example 3: Given ["a", "aa", "aaa", "aaaa"]; Return 0; No such pair of words
 * Explanation and Code from: https://leetcode.com/problems/maximum-product-of-word-lengths/discuss/76959/JAVA-Easy-Version-To-Understand!!!!!!!!!!!!!!!!!?page=1
 * Google
 * Medium
 * https://www.programiz.com/java-programming/bitwise-operators
 * https://www.vojtechruzicka.com/bit-manipulation-java-bitwise-bit-shift-operations/
 */

public class MaximumProductOfWordLengths {

	/*
	 @pei-heng Each integer in an array is of size 32 bits long(which is >26). So in short we are just setting every bit of an integer. 
	 So for example "abcw": set 0,1,2,23 bit. (1<<('a'-'a')) = 1<<0 which is 1, (1<<('w'-'a'))==2^23 and so on

	 ok,int has 32bits,but lower case letters only has 26 .we can use the lowest 26 bit of int indicates that the word has how many kinds of lower case letters .
	 If the lowest bit of int is 1,it indicates the word has lower case letter 'a'.......the order of lower case letter is from right to left,like zyx.....cba.
	 so value[i] indicates the condition of the word i having how many kinds of lower case letters .please vote me for this problem! If you have any question ,
	
	 The reason use 1<< is that let the value of 'a' to be 1?
	 Yes, otherwise, 'a' will be missed since 'a' - 'a' = 0.

	 */
	public static int maxProduct(String[] words) {
		if(words == null || words.length == 0)
			return 0;
		
		System.out.println(Arrays.toString(words));
		
		int len = words.length;
		int[] value = new int[len];
		
		for(int i=0; i < len; i++) {
			System.out.println("i: "+i+" words[i]: "+words[i]);
			String tmp = words[i];
			value[i] = 0;
			System.out.println("tmp: "+tmp);
			
			for(int j=0; j < tmp.length(); j++) {
				System.out.println("j: "+j+" tmp.charAt(j): "+tmp.charAt(j)+" 1 << (tmp.charAt(j) - 'a'): "+(1 << (tmp.charAt(j) - 'a')));
				value[i] |= 1 << (tmp.charAt(j) - 'a');
			}
		}
		
		System.out.println(Arrays.toString(value));
		
		int maxProduct = 0;
		
		for(int i = 0; i < len; i++)
			for (int j = i + 1; j < len; j++) {
				System.out.println("i: "+i+" value[i]: "+value[i]+" words[i]: "+words[i]+" j: "+j+" value[j]: "+value[j]+" words[j]: "+words[j]+" maxProduct: "+maxProduct);
				
				if ((value[i] & value[j]) == 0 && (words[i].length() * words[j].length() > maxProduct)) {
					maxProduct = words[i].length() * words[j].length();
				}
			}
		return maxProduct;
	}
	
	public static void main(String[] args) {
		String[] words= {"abcw", "baz", "foo", "bar", "xtfn", "abcdef"};
		System.out.println(maxProduct(words));
	}

}
