package at.holly.twoPointer.easy;

//https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/?envType=problem-list-v2&envId=two-pointers
public class NeedleAndHaystack {

    public static void main(String[] args) {
        NeedleAndHaystack needleAndHaystack = new NeedleAndHaystack();
        System.out.println(needleAndHaystack.strStr("hello", "ll"));
        System.out.println(needleAndHaystack.strStr("leetcode", "ll"));
        System.out.println(needleAndHaystack.strStr("sadbutsad", "sad"));
        System.out.println(needleAndHaystack.strStr("saabutsad", "sad"));
        System.out.println(needleAndHaystack.strStr("aaa", "aaaa"));
        System.out.println(needleAndHaystack.strStr("mississippi", "issip"));
        System.out.println(needleAndHaystack.strStr2("mississippi", "issip"));
    }

    public int strStr(String haystack, String needle) {
        int needleLength = needle.length();
        int hayLength = haystack.length();

        if (needleLength > hayLength) return -1;

        // we need to loop through the string until we reach haystack length - needle length to avoid index out of bound
        for (int hayPointer = 0; hayPointer <= hayLength - needleLength; hayPointer++) {
            int needlePointer = 0;
            // we loop through as long as the needle length to check if we have a match
            while (needlePointer < needleLength && haystack.charAt(hayPointer + needlePointer) == needle.charAt(needlePointer)){
                needlePointer++;
            }
            if (needlePointer == needleLength) return hayPointer;
        }
        return -1;
    }

    public int strStr1(String haystack, String needle) {
        return haystack.indexOf(needle);
    }

    public int strStr2(String haystack, String needle) {
        if (needle.length() > haystack.length()) return -1;

        for (int i = 0; i < haystack.length() - needle.length(); i++) {
            if (haystack.startsWith(needle, i)){
                return i;
            }
        }
        return -1;
    }

}
