package dsa.day1;

import java.util.Arrays;

public class Day2 {

	public static void main(String[] args) {
		// new Day2().rotate(new int[] {1,2,3,4,5,6,7},1);
		new Day2().maxArea(new int[] { 1, 8, 6, 2, 5, 4, 8, 3, 7 });

	}

	// n^2
	public void rotate(int[] nums, int k) {
		int length = nums.length;
		int[] rotate_nums = new int[length];
		for (int i = 0; i < k; i++) {
			for (int j = 0; j < nums.length; j++) {
				rotate_nums[j] = nums[Math.abs((j - 1 + length)) % nums.length];
			}

			for (int j = 0; j < nums.length; j++) {
				nums[j] = rotate_nums[j];
			}

			// System.out.println(Arrays.toString(rotate_nums));
		}

	}

	public void rotate_2(int[] nums, int k) {
		int length = nums.length;
		int next = -999999;
		int temp = -999999;

		int[] rotate_nums = new int[length];
		for (int i = 0; i < k; i++) {
			for (int j = 0; j < length; j++) {
				if (next == -999999) {
					next = nums[j];
					nums[j] = nums[Math.abs((j - 1 + length)) % nums.length];
				} else {
					temp = nums[j];
					nums[j] = next;
					next = temp;
				}

			}
			// System.out.println(Arrays.toString(nums));
			next = -999999;
			temp = -999999;
		}
	}

	public void rotate_3(int[] nums, int k) {
		int length = nums.length;

		int[] rotate_nums = new int[length];

		for (int j = 0; j < length; j++) {
			// System.out.println(Math.abs((j+k))%nums.length);
			rotate_nums[Math.abs((j + k)) % nums.length] = nums[j];
		}
		for (int j = 0; j < nums.length; j++) {
			nums[j] = rotate_nums[j];
		}
		// System.out.println(Arrays.toString(nums));

	}

	public void rotate_optimum(int[] nums, int k) {
		int n = nums.length;
		k = k % n;
		reverse(nums, 0, n - k - 1);
		reverse(nums, n - k, n - 1);
		reverse(nums, 0, n - 1);

	}

	void reverse(int[] nums, int start, int end) {
		while (start < end) {
			int temp = nums[end];
			nums[end] = nums[start];
			nums[start] = temp;
			start++;
			end--;

		}
	}

	// https://leetcode.com/problems/container-with-most-water/
	 public int maxArea(int[] height) {
	        int maxAmount=0;
	     int amount=0;
	     for(int i=0;i<height.length;i++){
	         for(int j=0;j<height.length;j++){
	             amount=Math.min(height[i],height[j])*(j-i);
	             //System.out.println(amount);
	             if(amount>maxAmount){maxAmount=amount;}
	     }
	         
	 }
	     return maxAmount;
	 }
	 
	 public int maxArea_optimum(int[] height) {
	        int start=0;
	        int end=height.length-1;
	        int maxArea=0;
	        int area=0;
	        
	        while(start<end){
	            area=Math.min(height[start],height[end]) * (end-start);
	            maxArea=Math.max(maxArea,area);
	            
	            if(height[start]>height[end]){end--;}
	            else{start++;}
	            
	        }
	        return maxArea;
	 }
	}
