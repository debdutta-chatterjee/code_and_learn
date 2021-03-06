package dsa.day1;

import java.util.Arrays;

public class Day1 {

	public static void main(String[] args) {
		new Day1().sortedSquares_2(new int[] {-4,-1,0,3,10});

	}
	
	//https://leetcode.com/problems/squares-of-a-sorted-array/submissions/
	public int[] sortedSquares(int[] nums) {
		for(int index=0;index<nums.length;index++){
            nums[index]= nums[index]*nums[index];
        }
        Arrays.sort(nums);
        return nums;
	}
	
	
	public int[] sortedSquares_2(int[] nums) {
        int end= nums.length-1;
        int start=0;
        int pointer=end;
        int[] sortedNums=new int[nums.length];
        
        while(pointer>=0 && start<=end){
            
            if (nums[start]*nums[start] > nums[end]*nums[end]){
                sortedNums[pointer--]=nums[start]*nums[start];
                start++;
            }
            else{
                sortedNums[pointer--]=nums[end]*nums[end];
                end--;
            }
            
                
        }
        return sortedNums;
    }
	
	
	
	//https://leetcode.com/problems/monotonic-array/
	public boolean isMonotonic(int[] nums) {
        int increment= 0;
        boolean flag=true;
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]==nums[i+1]){}
            else if(nums[i]>nums[i+1] && increment<=0){increment=-1;}
            else if(nums[i]<nums[i+1] && increment>=0){increment=1;}
            else{
                flag=false;
                break;
            }
            
        }
        return flag;
    }
    
    
    
    public boolean isMonotonic_2(int[] nums) {
        if(nums[0]==nums[nums.length-1]){
            for(int i=0;i<nums.length-1;i++){
                if(nums[i]!=nums[i+1]){return false;}
            }
        }
        
        if(nums[0]>nums[nums.length-1]){
            for(int i=0;i<nums.length-1;i++){
                if(!(nums[i]>=nums[i+1])){return false;}
            }
        }
        
        if(nums[0]<nums[nums.length-1]){
            for(int i=0;i<nums.length-1;i++){
                if(!(nums[i]<=nums[i+1])){return false;}
            }
        }
        return true;
    }
    
}
