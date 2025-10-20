package at.holly.twoPointer;

import java.util.Arrays;

//https://leetcode.com/problems/merge-sorted-array/?envType=problem-list-v2&envId=two-pointers
public class MergeSortedArray {

    public static void main(String[] args) {
        MergeSortedArray mergeSortedArray = new MergeSortedArray();
        mergeSortedArray.mergePointer(new int[]{1,2,3,0,0,0}, 3, new int[]{2,5,6}, 3);
        mergeSortedArray.merge(new int[]{1}, 1, new int[]{}, 0);
        mergeSortedArray.merge(new int[]{0}, 0, new int[]{1}, 1);
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if(nums2.length == 0) return;

        //combine arrays
        for(int i = m; i < nums1.length; i++){
            nums1[i] = nums2[i-m];
        }

        Arrays.sort(nums1);
    }


    public void mergePointer(int[] nums1, int m, int[] nums2, int n) {
        //we create a pointer at the end of each array and a pointer to know at what position in nums1 we are
        int tailP1 = m - 1;
        int tailP2 = n - 1;
        int indexPointer = n + m - 1;


        while(tailP1 >= 0 && tailP2 >= 0){
            if (nums1[tailP1] >= nums2[tailP2]){
                nums1[indexPointer] = nums1[tailP1];
                tailP1--;
            }
            else{
                nums1[indexPointer] = nums2[tailP2];
                tailP2--;
            }
            indexPointer--;
        }

        while (tailP2 >= 0) {
            nums1[indexPointer] = nums2[tailP2];
            tailP2--;
            indexPointer--;
        }

        System.out.println(Arrays.toString(nums1));

    }

}
