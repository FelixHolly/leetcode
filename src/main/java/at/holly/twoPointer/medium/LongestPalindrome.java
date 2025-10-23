package at.holly.twoPointer.medium;


//https://leetcode.com/problems/longest-palindromic-substring/?envType=problem-list-v2&envId=two-pointers
// Best solution with Manacher’s Algorithm
public class LongestPalindrome {

    public static void main(String[] args) {
        LongestPalindrome longestPalindrome = new LongestPalindrome();
        System.out.println(longestPalindrome.longestPalindrome("babad"));
        System.out.println(longestPalindrome.longestPalindrome("xabax"));
        System.out.println(longestPalindrome.longestPalindrome("xabaxxabax"));
        System.out.println(longestPalindrome.longestPalindrome("xabay"));
    }

    public String longestPalindrome(String s) {
        return "";
    }

}
