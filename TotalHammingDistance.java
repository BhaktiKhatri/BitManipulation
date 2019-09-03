package BitManipulation;

public class TotalHammingDistance {

	public static int totalHammingDistance(int[] nums) {
		int count = 0;
		for(int i=0; i<nums.length-1; i++) {
			int n = nums[i] ^ nums[i+1];
	        
	        while(n != 0) {
	        	n = n & (n - 1);
	        	count++;
	        }
		}
        return count;
    }
	
	public static void main(String[] args) {

	}

}
