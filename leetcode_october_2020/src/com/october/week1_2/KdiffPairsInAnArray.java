package com.october.week1_2;
import java.util.HashMap;

public class KdiffPairsInAnArray {

	public static int findPairs(int[] nums, int k) {
		HashMap<Integer, Integer> pp = new HashMap<Integer, Integer>();
		HashMap<Integer, Integer> pm = new HashMap<Integer, Integer>();
		int c = 0; //counter
		
		// any number can only be in max 2 pairs (n, n+k) and (n-k, n)
		
		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				//System.out.println("i: " + nums[i] + "  j: " + nums[j]);
				if ((nums[i] - nums[j]) == k && !pp.containsKey(nums[j]) && !pm.containsKey(nums[j])) {
					pp.put(nums[j], nums[i]);	//found the (n , n+k) pair
					c++;
					//System.out.println("PairP: (" + nums[j] + ", " + nums[i] + ")");
				}
				else if ((nums[j] - nums[i]) == k && !pm.containsKey(nums[i]) && !pp.containsKey(nums[i])) {
					pm.put(nums[i], nums[j]); //found the (n-k , n) pair
					c++;
					//System.out.println("PairM: (" + nums[i] + ", " + nums[j] + ")");

				}
			}
		}
		return c;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//TEST
		int[] nums = {1,1,1,2,1};
		int k = 1;
		System.out.println(findPairs(nums,k));
	}

}
