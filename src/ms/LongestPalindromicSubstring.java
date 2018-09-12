package ms;

/*
    Return the longest palindromic substring.
*/
public class LongestPalindromicSubstring {
    int maxLen = 0;
    int substringStart = 0;

    private String findLongestPalindromicSubstring(String input) {
        maxLen = 0;
        substringStart = 0;
        if(input == null || input.length() <= 1){
            return input;
        }
        for(int i=0; i < input.length() - 1; i++){
            findPalindrome(input, i, i + 1);
            findPalindrome(input, i, i);
        }
        return input.substring(substringStart, substringStart + maxLen);
    }

    private void findPalindrome(String input, int start, int end){
        while(start >= 0 && end < input.length()){
            if(input.charAt(start) != input.charAt(end)){
                break;
            }
            start--;
            end++;
        }
        start++;
        if(end - start > maxLen){
            maxLen = end - start;
            substringStart = start;
        }
    }

    public static void main(String[] args) {
        LongestPalindromicSubstring lps = new LongestPalindromicSubstring();
        System.out.println(lps.findLongestPalindromicSubstring("abcdedcfa"));
        System.out.println(lps.findLongestPalindromicSubstring("abcde"));
        System.out.println(lps.findLongestPalindromicSubstring("abcdeedcb"));
        System.out.println(lps.findLongestPalindromicSubstring("aa"));
    }
}
