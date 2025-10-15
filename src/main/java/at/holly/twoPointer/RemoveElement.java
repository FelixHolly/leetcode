package at.holly.twoPointer;

import java.util.Arrays;

//https://leetcode.com/problems/remove-element/?envType=problem-list-v2&envId=two-pointers
public class RemoveElement {

    public static void main(String[] args) {
        RemoveElement removeElement = new RemoveElement();
        int[] nums = {3, 2, 2, 3};
        System.out.println(removeElement.removeElement(nums, 3));
        System.out.println(Arrays.toString(nums));
        int[] nums1 = {0,1,2,2,3,0,4,2};
        //System.out.println(removeElement.removeElement(nums1, 2));
        System.out.println(removeElement.removeElementPointer(nums1, 2));
        System.out.println(Arrays.toString(nums1));

        System.out.println("---------------");
        int[] nums2 = {0,1,2,2,3,0,4,2};
        removeElement.moveValsToEnd(nums2, 2);
        System.out.println(Arrays.toString(nums2));
    }

    // in this example we dont care what comes after the index (we lose the 2 values)
    public int removeElement(int[] nums, int val) {
        int index = 0;
        for(int i = 0; i < nums.length; i++){
            if (nums[i] != val){
                nums[index] = nums[i];
                index++;
            }
        }
        return index;
    }

    // O(n²)
    public int removeElementPointer(int[] nums, int val){
        for (int i = 0; i < nums.length; i++) {
            int right = i+1;
            if(nums[i] == val && right < nums.length) {
                while (nums[right] == val && right < nums.length -1){
                    right++;
                }
                nums[i] = nums[right];
                nums[right] = val;
            }

        }
        return 1;
    }

    //O(n)
    public void moveValsToEnd(int[] nums, int val) {
        int k = 0; //left pointer
        for (int i = 0; i < nums.length; i++) { //right pointer
            if (nums[i] != val){
                int temp = nums[k];
                nums[k] = nums[i];
                nums[i] = temp;
                k++;
            }
        }
    }
}
