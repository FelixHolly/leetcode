package at.holly.twoPointer;

public class NeedleAndHaystack {

    public static void main(String[] args) {
        NeedleAndHaystack needleAndHaystack = new NeedleAndHaystack();
        System.out.println(needleAndHaystack.strStr("hello", "ll"));
        System.out.println(needleAndHaystack.strStr("leetcode", "ll"));
        System.out.println(needleAndHaystack.strStr("sadbutsad", "sad"));
        System.out.println(needleAndHaystack.strStr("saabutsad", "sad"));
        System.out.println(needleAndHaystack.strStr("aaa", "aaaa"));
        System.out.println(needleAndHaystack.strStr("mississippi", "issip"));
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

}
